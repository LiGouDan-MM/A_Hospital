package com.zhiyou.mapper;

import java.util.List;
import java.util.Map;

import com.zhiyou.modelAssocation.HospitalClearRegistration_inforAssocation;
import com.zhiyou.modelAssocation.Registration_InforPay_ItemsCharge_ManagerAssocation;

public interface HospitalClearMapper {

	List<HospitalClearRegistration_inforAssocation> find(Map<String,String> map);

	List<Registration_InforPay_ItemsCharge_ManagerAssocation> detail(Registration_InforPay_ItemsCharge_ManagerAssocation rIIMA);

	int colse(int id);
   
}
