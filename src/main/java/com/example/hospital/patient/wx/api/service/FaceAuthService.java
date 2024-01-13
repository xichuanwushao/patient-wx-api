package com.example.hospital.patient.wx.api.service;

import java.util.Map;

/**
 * @author : wuxiao
 * @date : 9:40 2024-01-13
 */
public interface FaceAuthService {
    public boolean hasFaceAuthInDay(Map param);

    public void createFaceModel(Map param);

    public boolean verifyFaceModel(int userId, String photo);

}
