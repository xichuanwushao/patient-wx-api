package com.example.hospital.patient.wx.api.db.dao;

import com.example.hospital.patient.wx.api.db.pojo.MedicalRegistrationEntity;
import org.apache.hadoop.util.hash.Hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public interface MedicalRegistrationDao {

    public long searchRegistrationCountInToday(Map param);
    public Integer hasRegisterRecordInDay(Map param);

}




