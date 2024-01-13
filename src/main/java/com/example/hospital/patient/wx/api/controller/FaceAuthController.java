package com.example.hospital.patient.wx.api.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.stp.StpUtil;
import com.example.hospital.patient.wx.api.common.R;
import com.example.hospital.patient.wx.api.controller.form.VerifyFaceModelForm;
import com.example.hospital.patient.wx.api.service.FaceAuthService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * @author : wuxiao
 * @date : 16:25 2024-01-13
 */
@RestController
@RequestMapping("/face/auth")
public class FaceAuthController {
    @Resource
    private FaceAuthService faceAuthService;

    @PostMapping("/verifyFaceModel")
    @SaCheckLogin
    public R verifyFaceModel(@RequestBody @Valid VerifyFaceModelForm form) {
        int userId = StpUtil.getLoginIdAsInt();
        boolean bool = faceAuthService.verifyFaceModel(userId, form.getPhoto());
        return R.ok().put("result", bool);
    }
}
