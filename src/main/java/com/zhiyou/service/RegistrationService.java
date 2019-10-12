package com.zhiyou.service;

import java.util.List;

import com.zhiyou.model.Doctor;
import com.zhiyou.model.RegistrationInfor;
import com.zhiyou.model.Registration_Infor;
import com.zhiyou.model.Section;
import com.zhiyou.modelAccept.RegistrationAccept;

public interface RegistrationService {

	List<Registration_Infor> queryall(RegistrationAccept rAccept);

	List<Section> getSection();

	List<Doctor> getDoctor();

	int addRegistrationInfor(RegistrationInfor rInf);

	int updateRegistration_Infor(RegistrationInfor rInf);

	int getCount(RegistrationAccept rAccept);

	int back(int id);

	int Delete(int a);


}
