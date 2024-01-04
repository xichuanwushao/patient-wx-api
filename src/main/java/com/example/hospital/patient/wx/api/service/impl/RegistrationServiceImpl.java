package com.example.hospital.patient.wx.api.service.impl;

import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DateRange;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.map.MapUtil;
import com.example.hospital.patient.wx.api.db.dao.DoctorWorkPlanDao;
import com.example.hospital.patient.wx.api.service.RegistrationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author : wuxiao
 * @date : 15:41 2024-01-04
 */
@Service
public class RegistrationServiceImpl implements RegistrationService {

    @Resource
    private DoctorWorkPlanDao doctorWorkPlanDao;
    @Override
    public ArrayList<String> searchCanRegisterInDateRange(Map param) {
        ArrayList<String> list = doctorWorkPlanDao.searchCanRegisterInDateRange(param);
        DateTime startDate = DateUtil.parse(MapUtil.getStr(param, "startDate"));
        DateTime endDate = DateUtil.parse(MapUtil.getStr(param, "endDate"));
        DateRange range = DateUtil.range(startDate, endDate, DateField.DAY_OF_MONTH);
        ArrayList result = new ArrayList();
        while (range.hasNext()) {
            String date = range.next().toDateStr();
            if (list.contains(date)) {
                result.add(new HashMap() {{
                    put("date", date);
                    put("status", "出诊");
                }});
            } else {
                result.add(new HashMap() {{
                    put("date", date);
                    put("status", "无号");
                }});
            }
        }
        return result;
    }
    @Override
    public ArrayList<HashMap> searchDeptSubDoctorPlanInDay(Map param) {
        ArrayList<HashMap> list = doctorWorkPlanDao.searchDeptSubDoctorPlanInDay(param);
        return list;
    }
}
