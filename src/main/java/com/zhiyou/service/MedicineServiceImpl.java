package com.zhiyou.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou.mapper.MedicineMapper;
import com.zhiyou.model.Drug;

@Service
public class MedicineServiceImpl implements MedicineService {
    
	@Autowired
	private MedicineMapper mapper;
	
	@Override
	public List<Drug> findAllMedicine(Drug drug) {
		return mapper.findAllMedicine(drug);
	}

	@Override
	public int addDrug(Drug drug) {
		// 生产日期2019-09-25+保质期50天=过期日期 
		String prodeced_date = drug.getProdeced_date();// 生产日期
		Integer quality = drug.getQuality_date();// 保质期
		long quality_date = quality*(24*60*60*1000);// 保质期的毫秒值
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date parse = sdf.parse(prodeced_date);
			long time = parse.getTime();// 将生产日期转换成毫秒值
			long totalTime = quality_date + time;// 过期的毫秒值
			Date date = new Date(totalTime);// 过期日期  
			String format = sdf.format(date);
			drug.setExpiration_date(format);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return mapper.addDrug(drug);
	}

	@Override
	public Drug destail(String drug_num) {
		return mapper.destail(drug_num);
	}

	@Override
	public int update(Drug drug) {
		// 生产日期2019-09-25+保质期50天=过期日期 
		String prodeced_date = drug.getProdeced_date();// 生产日期
		System.out.println(prodeced_date);
		Integer quality = drug.getQuality_date();// 保质期
		long quality_date = quality*(24*60*60*1000);// 保质期的毫秒值
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date parse = sdf.parse(prodeced_date);
			long time = parse.getTime();// 将生产日期转换成毫秒值
			long totalTime = quality_date + time;// 过期的毫秒值
			Date date = new Date(totalTime);// 过期日期  
			String format = sdf.format(date);
			drug.setExpiration_date(format);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mapper.update(drug);
	}

}
