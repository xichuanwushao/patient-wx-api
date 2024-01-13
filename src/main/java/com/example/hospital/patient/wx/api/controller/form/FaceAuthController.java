package com.example.hospital.patient.wx.api.controller.form;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.bean.BeanUtil;
import com.example.hospital.patient.wx.api.common.R;
import com.example.hospital.patient.wx.api.service.FaceAuthService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.Map;

/**
 * @author : wuxiao
 * @date : 11:47 2024-01-13
 */
@RestController
@RequestMapping("/face/auth")
public class FaceAuthController {
    @Resource
    private FaceAuthService faceAuthService;
    @PostMapping("/createFaceModel")
    @SaCheckLogin
    public R createFaceModel(@RequestBody @Valid CreateFaceModelForm form) {
        int userId = StpUtil.getLoginIdAsInt();
        form.setUserId(userId);
        Map param = BeanUtil.beanToMap(form);
        faceAuthService.createFaceModel(param);
        return R.ok();
    }
}

