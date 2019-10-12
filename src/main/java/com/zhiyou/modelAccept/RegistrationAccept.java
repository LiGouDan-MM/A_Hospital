package com.zhiyou.modelAccept;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class RegistrationAccept {
	
	private  int     pageSize;// 每页查询的数量
	private  int     preIndex;// 分页查询的开始索引
	private  String  medical_record;// 病例号
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private  Date    time;// 挂号时间
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private  Date    time1;// 起始时间
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private  Date    time2;// 结束时间
	private  String  name; //患者姓名
	private  String  certificate_type;// 证件类型
	private  String  ID_num;  // 证件号
	private  Double  registration_fee; // 挂号费
	private  String  social_safe_num; // 社保号
	private  String  phone; // 练习电话
	private  Integer self_paying; // 是否自费
	private  Integer sex; // 患者性别
	private  Integer age;// 患者年龄
	private  String  career;// 患者职业
	private  String  early_appointment;// 初复诊
	private  String  secco_name;// 科室名称
	private  String  docName;// 医生姓名
	private  String  noted;// 备注
	
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getPreIndex() {
		return preIndex;
	}
	public void setPreIndex(int preIndex) {
		this.preIndex = preIndex;
	}
	public Date getTime1() {
		return time1;
	}
	public void setTime1(Date time1) {
		this.time1 = time1;
	}
	public Date getTime2() {
		return time2;
	}
	public void setTime2(Date time2) {
		this.time2 = time2;
	}
	public String getMedical_record() {
		return medical_record;
	}
	public void setMedical_record(String medical_record) {
		this.medical_record = medical_record;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCertificate_type() {
		return certificate_type;
	}
	public void setCertificate_type(String certificate_type) {
		this.certificate_type = certificate_type;
	}
	public String getID_num() {
		return ID_num;
	}
	public void setID_num(String iD_num) {
		ID_num = iD_num;
	}
	public Double getRegistration_fee() {
		return registration_fee;
	}
	public void setRegistration_fee(Double registration_fee) {
		this.registration_fee = registration_fee;
	}
	public String getSocial_safe_num() {
		return social_safe_num;
	}
	public void setSocial_safe_num(String social_safe_num) {
		this.social_safe_num = social_safe_num;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Integer getSelf_paying() {
		return self_paying;
	}
	public void setSelf_paying(Integer self_paying) {
		this.self_paying = self_paying;
	}
	public Integer getSex() {
		return sex;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getCareer() {
		return career;
	}
	public void setCareer(String career) {
		this.career = career;
	}
	public String getEarly_appointment() {
		return early_appointment;
	}
	public void setEarly_appointment(String early_appointment) {
		this.early_appointment = early_appointment;
	}
	public String getSecco_name() {
		return secco_name;
	}
	public void setSecco_name(String secco_name) {
		this.secco_name = secco_name;
	}
	public String getDocName() {
		return docName;
	}
	public void setDocName(String docName) {
		this.docName = docName;
	}
	public String getNoted() {
		return noted;
	}
	public void setNoted(String noted) {
		this.noted = noted;
	}
	@Override
	public String toString() {
		return "RegistrationAccept [pageSize=" + pageSize + ", preIndex=" + preIndex + ", medical_record="
				+ medical_record + ", time=" + time + ", time1=" + time1 + ", time2=" + time2 + ", name=" + name
				+ ", certificate_type=" + certificate_type + ", ID_num=" + ID_num + ", registration_fee="
				+ registration_fee + ", social_safe_num=" + social_safe_num + ", phone=" + phone + ", self_paying="
				+ self_paying + ", sex=" + sex + ", age=" + age + ", career=" + career + ", early_appointment="
				+ early_appointment + ", secco_name=" + secco_name + ", docName=" + docName + ", noted=" + noted + "]";
	}
	
    
	
	
	
	

}
