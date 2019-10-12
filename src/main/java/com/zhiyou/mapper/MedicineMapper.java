package com.zhiyou.mapper;

import java.util.List;

import com.zhiyou.model.Drug;

public interface MedicineMapper {

	List<Drug> findAllMedicine(Drug drug);

	int addDrug(Drug drug);

	Drug destail(String drug_num);

	int update(Drug drug);

}
