package com.example.hospital.patient.wx.api.service;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author : wuxiao
 * @date : 14:22 2024-01-04
 */
public interface MedicalDeptSubService {
    public ArrayList<HashMap> searchMedicalDeptSubList(int deptId);
}
