package com.example.hospital.patient.wx.api.controller.form;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * @author : wuxiao
 * @date : 12:46 2024-01-14
 */
@Data
public class SearchDoctorWorkPlanScheduleForm {
    @NotNull(message = "doctorId不能为空")
    @Min(value = 1, message = "doctorId不能小于1")
    private Integer doctorId;
    @NotBlank(message = "date不能为空")
//    @Pattern(regexp = "^((((1[6-9]|[2-9]\\d)\\d{2})-(0?[13578]|1[02])-(0?[1-9]|[12]\\d|3
//            message = "date内容不正确")
    private String date;
}
