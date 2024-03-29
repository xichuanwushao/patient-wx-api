package com.example.hospital.patient.wx.api.service.impl;

import com.example.hospital.patient.wx.api.db.dao.DoctorDao;
import com.example.hospital.patient.wx.api.service.DoctorService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;

/**
 * @author : wuxiao
 * @date : 12:41 2024-01-14
 */
@Service
public class DoctorServiceImpl implements DoctorService {
    @Resource
    private DoctorDao doctorDao;

    @Override
    public HashMap searchDoctorInfoById(int id) {
        HashMap map = doctorDao.searchDoctorInfoById(id);
        return map;
    }
}

