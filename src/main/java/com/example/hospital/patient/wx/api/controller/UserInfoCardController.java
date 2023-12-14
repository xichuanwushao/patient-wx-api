package com.example.hospital.patient.wx.api.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.map.MapUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.json.JSONUtil;
import com.example.hospital.patient.wx.api.common.R;
import com.example.hospital.patient.wx.api.db.pojo.UserInfoCardEntity;
import com.example.hospital.patient.wx.api.form.InsertUserInfoCardForm;
import com.example.hospital.patient.wx.api.form.UpdateUserInfoCardForm;
import com.example.hospital.patient.wx.api.service.UserInfoCardService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.HashMap;

/**
 * @author : wuxiao
 * @date : 16:56 2023-12-11
 */
@RestController
@RequestMapping("/user/info/card")
public class UserInfoCardController {
    @Resource
    public UserInfoCardService userInfoCardService;
    @PostMapping("/insert")
    @SaCheckLogin
    public R insert(@RequestBody @Valid InsertUserInfoCardForm form) {
        UserInfoCardEntity entity = BeanUtil.toBean(form, UserInfoCardEntity.class);
        int userId = StpUtil.getLoginIdAsInt();
        entity.setUserId(userId);
        entity.setUuid(IdUtil.simpleUUID());
        String json = JSONUtil.parseArray(form.getMedicalHistory()).toString();
        entity.setMedicalHistory(json);
        userInfoCardService.insert(entity);
        return R.ok();
    }

    @SaCheckLogin
    @GetMapping("/searchUserInfoCard")
    public R searchUserInfoCard() {
        int userId = StpUtil.getLoginIdAsInt();
        HashMap map = userInfoCardService.searchUserInfoCard(userId);
        if (MapUtil.isEmpty(map)) {
            return R.ok("没有查询到数据");
        }
        return R.ok(map);
    }

    @PostMapping("/update")
    @SaCheckLogin
    public R update(@RequestBody @Valid UpdateUserInfoCardForm form) {
        UserInfoCardEntity entity = BeanUtil.toBean(form, UserInfoCardEntity.class);
        String json = JSONUtil.parseArray(form.getMedicalHistory()).toString();
        entity.setMedicalHistory(json);
        userInfoCardService.update(entity);
        return R.ok();
    }

}
