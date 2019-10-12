package com.zhiyou.modelAssocation;

public class DispensingTotal {
    private String  medical_record;  // 病历号  --------------
    private Integer dispens_num;     // 发药数量-------------
    private Integer alread_send_num; // 已发数量-------------
    private Integer not_send_num ;   // 未发数量-------------
    private String  time ;           // 发药时间
    private String  name;             // 姓名  ----------------
    private String  certificate_type;  //证件类型
    private String  ID_num;           // 证件号
    private String  social_safe_num;  // 社保号
    private String  phone;            // 联系电话
    private Integer self_paying;      // 是否自费
    private Integer sex;               //性别
    private String  career;            //职业
    private String  early_appointment; //初复诊
    private Integer doctor_id;        // 医生表id
    private Integer section_id;       // 科室表id
    private Integer age;               //年龄
    private Double  registration_fee;  //挂号费
    private String caregiver;        // 护理人-------------------
    private String bed_id;           // 床位号
    private Double pay_the_deposit;   //缴费押金
    private String state_illness;     //病情
    private String   drug_num;        // 药品编号 
    private String   drug_url;        // 药品图片地址
    private Double   purchas_price;   // 药品进价
    private Double   sale_price;       //药品售价
    private String   drug_name;       // 药品名称---------------------
    private Integer  drug_type;        //药品类型
    private String   simple_detail;   // 简单描述
    private String   prodeced_date;    //生产日期
    private String   expiration_date; // 过期日期
    private Integer  quality_date;     //保质期
    private String   detail;           //详细描述
    private String   manufacture;     // 生产厂商
    private String   use_infor;        //使用说明
    private Integer  total_stock;     // 总的进货量
    private Integer  surplus;          //剩余量
    private Integer  status;         // 状态
    private String   noted;           //备注
	public String getMedical_record() {
		return medical_record;
	}
	public void setMedical_record(String medical_record) {
		this.medical_record = medical_record;
	}
	public Integer getDispens_num() {
		return dispens_num;
	}
	public void setDispens_num(Integer dispens_num) {
		this.dispens_num = dispens_num;
	}
	public Integer getAlread_send_num() {
		return alread_send_num;
	}
	public void setAlread_send_num(Integer alread_send_num) {
		this.alread_send_num = alread_send_num;
	}
	public Integer getNot_send_num() {
		return not_send_num;
	}
	public void setNot_send_num(Integer not_send_num) {
		this.not_send_num = not_send_num;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
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
	public Integer getDoctor_id() {
		return doctor_id;
	}
	public void setDoctor_id(Integer doctor_id) {
		this.doctor_id = doctor_id;
	}
	public Integer getSection_id() {
		return section_id;
	}
	public void setSection_id(Integer section_id) {
		this.section_id = section_id;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Double getRegistration_fee() {
		return registration_fee;
	}
	public void setRegistration_fee(Double registration_fee) {
		this.registration_fee = registration_fee;
	}
	public String getCaregiver() {
		return caregiver;
	}
	public void setCaregiver(String caregiver) {
		this.caregiver = caregiver;
	}
	public String getBed_id() {
		return bed_id;
	}
	public void setBed_id(String bed_id) {
		this.bed_id = bed_id;
	}
	public Double getPay_the_deposit() {
		return pay_the_deposit;
	}
	public void setPay_the_deposit(Double pay_the_deposit) {
		this.pay_the_deposit = pay_the_deposit;
	}
	public String getState_illness() {
		return state_illness;
	}
	public void setState_illness(String state_illness) {
		this.state_illness = state_illness;
	}
	public String getDrug_num() {
		return drug_num;
	}
	public void setDrug_num(String drug_num) {
		this.drug_num = drug_num;
	}
	public String getDrug_url() {
		return drug_url;
	}
	public void setDrug_url(String drug_url) {
		this.drug_url = drug_url;
	}
	public Double getPurchas_price() {
		return purchas_price;
	}
	public void setPurchas_price(Double purchas_price) {
		this.purchas_price = purchas_price;
	}
	public Double getSale_price() {
		return sale_price;
	}
	public void setSale_price(Double sale_price) {
		this.sale_price = sale_price;
	}
	public String getDrug_name() {
		return drug_name;
	}
	public void setDrug_name(String drug_name) {
		this.drug_name = drug_name;
	}
	public Integer getDrug_type() {
		return drug_type;
	}
	public void setDrug_type(Integer drug_type) {
		this.drug_type = drug_type;
	}
	public String getSimple_detail() {
		return simple_detail;
	}
	public void setSimple_detail(String simple_detail) {
		this.simple_detail = simple_detail;
	}
	public String getProdeced_date() {
		return prodeced_date;
	}
	public void setProdeced_date(String prodeced_date) {
		this.prodeced_date = prodeced_date;
	}
	public String getExpiration_date() {
		return expiration_date;
	}
	public void setExpiration_date(String expiration_date) {
		this.expiration_date = expiration_date;
	}
	public Integer getQuality_date() {
		return quality_date;
	}
	public void setQuality_date(Integer quality_date) {
		this.quality_date = quality_date;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public String getManufacture() {
		return manufacture;
	}
	public void setManufacture(String manufacture) {
		this.manufacture = manufacture;
	}
	public String getUse_infor() {
		return use_infor;
	}
	public void setUse_infor(String use_infor) {
		this.use_infor = use_infor;
	}
	public Integer getTotal_stock() {
		return total_stock;
	}
	public void setTotal_stock(Integer total_stock) {
		this.total_stock = total_stock;
	}
	public Integer getSurplus() {
		return surplus;
	}
	public void setSurplus(Integer surplus) {
		this.surplus = surplus;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getNoted() {
		return noted;
	}
	public void setNoted(String noted) {
		this.noted = noted;
	}
	@Override
	public String toString() {
		return "DispensingTotal [medical_record=" + medical_record + ", dispens_num=" + dispens_num
				+ ", alread_send_num=" + alread_send_num + ", not_send_num=" + not_send_num + ", time=" + time
				+ ", name=" + name + ", certificate_type=" + certificate_type + ", ID_num=" + ID_num
				+ ", social_safe_num=" + social_safe_num + ", phone=" + phone + ", self_paying=" + self_paying
				+ ", sex=" + sex + ", career=" + career + ", early_appointment=" + early_appointment + ", doctor_id="
				+ doctor_id + ", section_id=" + section_id + ", age=" + age + ", registration_fee=" + registration_fee
				+ ", caregiver=" + caregiver + ", bed_id=" + bed_id + ", pay_the_deposit=" + pay_the_deposit
				+ ", state_illness=" + state_illness + ", drug_num=" + drug_num + ", drug_url=" + drug_url
				+ ", purchas_price=" + purchas_price + ", sale_price=" + sale_price + ", drug_name=" + drug_name
				+ ", drug_type=" + drug_type + ", simple_detail=" + simple_detail + ", prodeced_date=" + prodeced_date
				+ ", expiration_date=" + expiration_date + ", quality_date=" + quality_date + ", detail=" + detail
				+ ", manufacture=" + manufacture + ", use_infor=" + use_infor + ", total_stock=" + total_stock
				+ ", surplus=" + surplus + ", status=" + status + ", noted=" + noted + "]";
	}
    
    

}
