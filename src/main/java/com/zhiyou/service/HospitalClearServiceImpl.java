package com.zhiyou.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou.mapper.HospitalClearMapper;
import com.zhiyou.modelAssocation.HospitalClearRegistration_inforAssocation;
import com.zhiyou.modelAssocation.Registration_InforPay_ItemsCharge_ManagerAssocation;

@Service
public class HospitalClearServiceImpl implements HospitalClearService {
    @Autowired
    private HospitalClearMapper mapper;
	@Override
	public List<HospitalClearRegistration_inforAssocation> find(String name,String medical_record) {
		Map<String,String> map = new  HashMap<String,String>();
		map.put("name",name );
		map.put("medical_record",medical_record );
		return mapper.find(map);
	}
	@Override
	public List<Registration_InforPay_ItemsCharge_ManagerAssocation> detail(Registration_InforPay_ItemsCharge_ManagerAssocation rIIMA) {
		return mapper.detail(rIIMA);
	}
	@Override
	public int colse(int id) {
		return mapper.colse(id);
	}

}
