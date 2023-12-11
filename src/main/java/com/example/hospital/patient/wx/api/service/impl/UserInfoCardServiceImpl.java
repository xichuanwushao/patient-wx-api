package com.example.hospital.patient.wx.api.service.impl;

import com.example.hospital.patient.wx.api.db.dao.UserInfoCardDao;
import com.example.hospital.patient.wx.api.db.pojo.UserInfoCardEntity;
import com.example.hospital.patient.wx.api.service.UserInfoCardService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author : wuxiao
 * @date : 16:50 2023-12-11
 */
@Service
public class UserInfoCardServiceImpl implements UserInfoCardService {
    @Resource
    private UserInfoCardDao userInfoCardDao;

    @Override
    @Transactional
    public void insert(UserInfoCardEntity entity) {
        userInfoCardDao.insert(entity);
    }
}
