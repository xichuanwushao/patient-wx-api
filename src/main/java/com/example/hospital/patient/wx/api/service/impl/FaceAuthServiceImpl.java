package com.example.hospital.patient.wx.api.service.impl;

import com.example.hospital.patient.wx.api.db.dao.FaceAuthDao;
import com.example.hospital.patient.wx.api.service.FaceAuthService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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
    @Override
    public boolean hasFaceAuthInDay(Map param) {
        Integer id = faceAuthDao.hasFaceAuthInDay(param);
        boolean bool = (id != null);
        return bool;
    }
}
