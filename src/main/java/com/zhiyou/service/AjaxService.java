package com.zhiyou.service;

import com.zhiyou.controller.ResponseObject;

public interface AjaxService {

	String checkedUser(String usernameJosn);

	ResponseObject checkedUser2(String usernameJosn);

	ResponseObject findUserById(String id);

	ResponseObject findDoctorBySectionID(String sectionId);

}
