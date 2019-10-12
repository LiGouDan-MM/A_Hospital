package com.zhiyou.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou.mapper.DoctorMapper;
import com.zhiyou.model.CertificateType;
import com.zhiyou.model.Doctor;
import com.zhiyou.model.Doctor_CS;
import com.zhiyou.model.Section;
import com.zhiyou.modelAccept.DoctorAccept;
@Service
public class DoctorServiceImpl implements DoctorService {
    @Autowired
    private DoctorMapper mapper;
    
	@Override
	public List<Doctor_CS> findAll(DoctorAccept dAccept) {
		return mapper.findAll(dAccept);
	}

	@Override
	public Doctor_CS fingById(int id) {
		return mapper.fingById(id);
	}

	@Override
	public List<CertificateType> findCertificateType() {
		return mapper.findCertificateType();
	}

	@Override
	public List<Section> findSection() {
		return mapper.findSection();
	}

	@Override
	public int addDoctor(Doctor doctor) {
		return mapper.addDoctor(doctor);
	}

	@Override
	public int updateDoctor(Doctor doctor) {
		return mapper.updateDoctor(doctor);
	}

	@Override
	public int delete(int a) {
		return mapper.delete(a);
	}

}
