package com.example.hospital.patient.wx.api.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.bean.BeanUtil;
import com.example.hospital.patient.wx.api.common.R;
import com.example.hospital.patient.wx.api.controller.form.CheckRegisterConditionForm;
import com.example.hospital.patient.wx.api.controller.form.SearchCanRegisterInDateRangeForm;
import com.example.hospital.patient.wx.api.controller.form.SearchDeptSubDoctorPlanInDayForm;
import com.example.hospital.patient.wx.api.controller.form.SearchDoctorWorkPlanScheduleForm;
import com.example.hospital.patient.wx.api.service.RegistrationService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author : wuxiao
 * @date : 15:48 2024-01-04
 */
@RestController
@RequestMapping("/registration")
public class RegistrationController {
    @Resource
    private RegistrationService registrationService;

    @PostMapping("/searchCanRegisterInDateRange")
    @SaCheckLogin
    public R searchCanRegisterInDateRange(@RequestBody @Valid SearchCanRegisterInDateRangeForm form) {
        Map<String, Object> param = BeanUtil.beanToMap(form);
        ArrayList<String> list = registrationService.searchCanRegisterInDateRange(param);
        return R.ok().put("result", list);
    }

    @PostMapping("/searchDeptSubDoctorPlanInDay")
    @SaCheckLogin
    public R searchDeptSubDoctorPlanInDay(@RequestBody @Valid SearchDeptSubDoctorPlanInDayForm form) {
        Map param = BeanUtil.beanToMap(form);
        ArrayList<HashMap> list = registrationService.searchDeptSubDoctorPlanInDay(param);
        return R.ok().put("result", list);
    }

    @PostMapping("/checkRegisterCondition")
    @SaCheckLogin
    public R checkRegisterCondition(@RequestBody @Valid CheckRegisterConditionForm form) {
        int userId = StpUtil.getLoginIdAsInt();
        form.setUserId(userId);
        Map param = BeanUtil.beanToMap(form);
        String result = registrationService.checkRegisterCondition(param);
        return R.ok().put("result", result);
    }


    @PostMapping("/searchDoctorWorkPlanSchedule")
    @SaCheckLogin
    public R searchDoctorWorkPlanSchedule(@RequestBody @Valid SearchDoctorWorkPlanScheduleForm form){
        Map param = BeanUtil.beanToMap(form);
        ArrayList<HashMap> list = registrationService.searchDoctorWorkPlanSchedule(param);
        return R.ok().put("result", list);
    }

}
