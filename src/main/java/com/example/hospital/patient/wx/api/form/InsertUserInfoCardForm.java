package com.example.hospital.patient.wx.api.form;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

/**
 * @author : wuxiao
 * @date : 16:54 2023-12-11
 */
@Data
public class InsertUserInfoCardForm {

    @Pattern(regexp = "^[\\u4e00-\\u9fa5]{2,15}$", message = "name内容不正确")
    private String name;

    @NotBlank(message = "sex不能为空")
    @Pattern(regexp = "^男$|^女$", message = "性别内容不正确")
    private String sex;

    @NotBlank(message = "pid不能为空")
//    @Pattern(regexp = "^[1-9]\\d{5}(18|19|([23]\\d))\\d{2}((0[1-9])|(10|11|12))(([0-2][1
            private String pid;

    @NotBlank(message = "tel不能为空")
//    @Pattern(regexp = "^1[0-9]{10}$", message = "tel内容不正确")
    private String tel;

    @NotBlank(message = "birthday不能为空")
//    @Pattern(regexp = "^((((1[6-9]|[2-9]\\d)\\d{2})-(0?[13578]|1[02])-(0?[1-9]|[12]\\d|3
//            message = "birthday内容不正确")
    private String birthday;

    @NotEmpty(message = "medicalHistory不能为空")
    private String[] medicalHistory;

    @NotBlank(message = "insuranceType不能为空")
    private String insuranceType;

}
