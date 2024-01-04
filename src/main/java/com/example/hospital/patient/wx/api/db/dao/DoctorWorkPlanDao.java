package com.example.hospital.patient.wx.api.db.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public interface DoctorWorkPlanDao {
    public ArrayList<String> searchCanRegisterInDateRange(Map param);
    public ArrayList<HashMap> searchDeptSubDoctorPlanInDay(Map param);
}




