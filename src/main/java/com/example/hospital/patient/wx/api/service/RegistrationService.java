package com.example.hospital.patient.wx.api.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author : wuxiao
 * @date : 15:41 2024-01-04
 */
public interface RegistrationService {
    public ArrayList<String> searchCanRegisterInDateRange(Map param);
    public ArrayList<HashMap> searchDeptSubDoctorPlanInDay(Map param);

    public String checkRegisterCondition(Map param);

    public ArrayList<HashMap> searchDoctorWorkPlanSchedule(Map param);
}
