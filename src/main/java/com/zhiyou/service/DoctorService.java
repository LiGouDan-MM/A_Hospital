package com.zhiyou.service;

import java.util.List;

import com.zhiyou.model.CertificateType;
import com.zhiyou.model.Doctor;
import com.zhiyou.model.Doctor_CS;
import com.zhiyou.model.Section;
import com.zhiyou.modelAccept.DoctorAccept;

public interface DoctorService {

	List<Doctor_CS> findAll(DoctorAccept dAccept);

	Doctor_CS fingById(int id);

	List<CertificateType> findCertificateType();

	List<Section> findSection();

	int addDoctor(Doctor doctor);

	int updateDoctor(Doctor doctor);

	int delete(int a);

}
