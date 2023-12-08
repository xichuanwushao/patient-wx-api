package com.example.hospital.patient.wx.api.db.dao;

import com.example.hospital.patient.wx.api.db.pojo.UserEntity;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;

public interface UserDao {
    public int insert(UserEntity entity);

    public Integer searchAlreadyRegistered(String openId);
}
