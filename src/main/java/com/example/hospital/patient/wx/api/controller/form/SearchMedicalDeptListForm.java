package com.example.hospital.patient.wx.api.controller.form;

import lombok.Data;

/**
 * @author : wuxiao
 * @date : 14:30 2024-01-04
 */
@Data
public class SearchMedicalDeptListForm {
    private Boolean recommended;
    private Boolean outpatient;
}
