package com.example.hospital.patient.wx.api.service;

import java.util.HashMap;

/**
 * @author : wuxiao
 * @date : 16:49 2023-12-08
 */
public interface UserService {
    public HashMap loginOrRegister(String code, String nickname, String photo, String sex);
    public HashMap searchUserInfo( int userId);

}
