package com.example.hospital.patient.wx.api.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author : wuxiao
 * @date : 14:19 2024-01-04
 */
public interface MedicalDeptService {
    public ArrayList<HashMap> searchMedicalDeptList(Map param);
}
