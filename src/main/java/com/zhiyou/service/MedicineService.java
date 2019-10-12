package com.zhiyou.service;

import java.util.List;

import com.zhiyou.model.Drug;

public interface MedicineService {

	List<Drug> findAllMedicine(Drug drug);

	int addDrug(Drug drug);

	Drug destail(String drug_num);

	int update(Drug drug);

}
