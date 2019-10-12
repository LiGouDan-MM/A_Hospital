package com.zhiyou.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou.mapper.RegistrationMapper;
import com.zhiyou.model.Doctor;
import com.zhiyou.model.RegistrationInfor;
import com.zhiyou.model.Registration_Infor;
import com.zhiyou.model.Section;
import com.zhiyou.modelAccept.RegistrationAccept;

@Service
public class RegistrationServiceImpl implements RegistrationService {

	@Autowired
	private RegistrationMapper mapper;
	
	@Override
	public List<Registration_Infor> queryall(RegistrationAccept rAccept) {
		return mapper.queryall(rAccept);
	}

	@Override
	public List<Section> getSection() {
		return mapper.getSection();
	}

	@Override
	public List<Doctor> getDoctor() {
		return mapper.getDoctor();
	}

	@Override
	public int addRegistrationInfor(RegistrationInfor rInf) {
		return mapper.addRegistrationInfor(rInf);
	}

	@Override
	public int updateRegistration_Infor(RegistrationInfor rInf) {
		return mapper.updateRegistration_Infor(rInf) ;
	}

	@Override
	public int getCount(RegistrationAccept rAccept) {
		return mapper.getCount(rAccept);
	}

	@Override
	public int back(int id) {
		return mapper.back(id);
	}

	@Override
	public int Delete(int a) {
		return mapper.Delete(a);
	}

	

}
