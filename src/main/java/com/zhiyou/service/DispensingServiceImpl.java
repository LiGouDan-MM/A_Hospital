package com.zhiyou.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou.mapper.DispensingMapper;
import com.zhiyou.modelAssocation.DispensingTotal;
@Service
public class DispensingServiceImpl implements DispensingService {
    @Autowired
    private DispensingMapper mapper;
    
	@Override
	public List<DispensingTotal> find() {
		return mapper.find();
	}

}
