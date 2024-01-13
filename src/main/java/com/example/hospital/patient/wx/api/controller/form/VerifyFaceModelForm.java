package com.example.hospital.patient.wx.api.controller.form;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author : wuxiao
 * @date : 16:24 2024-01-13
 */
@Data
public class VerifyFaceModelForm {
    @NotBlank(message = "photo不能为空")
    private String photo;
}
