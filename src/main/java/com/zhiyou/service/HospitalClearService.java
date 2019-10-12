package com.zhiyou.service;

import java.util.List;

import com.zhiyou.modelAssocation.HospitalClearRegistration_inforAssocation;
import com.zhiyou.modelAssocation.Registration_InforPay_ItemsCharge_ManagerAssocation;

public interface HospitalClearService {

	List<HospitalClearRegistration_inforAssocation> find(String name,String medical_record);

	List<Registration_InforPay_ItemsCharge_ManagerAssocation> detail(Registration_InforPay_ItemsCharge_ManagerAssocation rIIMA);

	int colse(int id);

}
