package com.example.hospital.patient.wx.api.service.impl;

import cn.hutool.core.map.MapUtil;
import cn.hutool.core.util.StrUtil;
import com.example.hospital.patient.wx.api.db.dao.FaceAuthDao;
import com.example.hospital.patient.wx.api.db.dao.UserInfoCardDao;
import com.example.hospital.patient.wx.api.exception.HospitalException;
import com.example.hospital.patient.wx.api.service.FaceAuthService;
import com.tencentcloudapi.common.Credential;
import com.tencentcloudapi.common.exception.TencentCloudSDKException;
import com.tencentcloudapi.iai.v20180301.IaiClient;
import com.tencentcloudapi.iai.v20180301.models.CreatePersonRequest;
import com.tencentcloudapi.iai.v20180301.models.CreatePersonResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author : wuxiao
 * @date : 9:40 2024-01-13
 */
@Service
@Slf4j
public class FaceAuthServiceImpl implements FaceAuthService {
    @Resource
    private FaceAuthDao faceAuthDao;

    @Value("${tencent.cloud.secretId}")
    private String secretId;
    @Value("${tencent.cloud.secretKey}")
    private String secretKey;
    @Value("${tencent.cloud.face.groupName}")
    private String groupName;
    @Value("${tencent.cloud.face.region}")
    private String region;
    @Resource
    private UserInfoCardDao userInfoCardDao;

    @Override
    public boolean hasFaceAuthInDay(Map param) {
        Integer id = faceAuthDao.hasFaceAuthInDay(param);
        boolean bool = (id != null);
        return bool;
    }

    @Override
    @Transactional
    public void createFaceModel(Map param) {
        int userId = MapUtil.getInt(param, "userId");
        String photo = MapUtil.getStr(param, "photo");
        Credential cred = new Credential(secretId, secretKey);
        IaiClient client = new IaiClient(cred, region);
        //查询用户姓名和性别
        HashMap map = userInfoCardDao.searchUserInfoCard(userId);
        String name = MapUtil.getStr(map, "name");
        String sex = MapUtil.getStr(map, "sex");
        CreatePersonRequest req = new CreatePersonRequest();
        req.setGroupId(groupName);
        req.setPersonId(userId + "");
        long gender = sex.equals("男") ? 1L : 2L;
        req.setGender(gender);
        req.setQualityControl(4L);
        req.setUniquePersonControl(4L);
        req.setPersonName(name);
        req.setImage(photo);
        try {
            CreatePersonResponse resp = client.CreatePerson(req);
            if (StrUtil.isNotBlank(resp.getFaceId())) {
                //更新数据表，用户已经录入人脸模型
                userInfoCardDao.updateExistFaceModel(new HashMap() {{
                    put("userId", userId);
                    put("existFaceModel", true);
                }});
            }
        }
        catch (TencentCloudSDKException e) {
            throw new HospitalException(e);
        }
    }
}
