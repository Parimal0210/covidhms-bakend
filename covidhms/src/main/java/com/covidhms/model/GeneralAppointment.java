package com.covidhms.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class GeneralAppointment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	
	private int patientId;
	
	private String userName;
	
	private String appointmentDate;
	
	private String headache;
	
	private String fever;
	
	private String cold;
	
	private String bp;
	
	private String diabetes;
	
	private String prescription;
	
	private String medicalHistory;
	
	private String respiratoryProblems;
	
	private String foreignTravelling;

	
	
	
	
	public GeneralAppointment() {
		super();
		// TODO Auto-generated constructor stub
	}





	public GeneralAppointment(int id, int patientId,String userName, String appointmentDate, String headache, String fever, String cold,
			String bp, String diabetes, String prescription, String medicalHistory, String respiratoryProblems,
			String foreignTravelling) {
		super();
		this.id = id;
		this.patientId = patientId;
		this.userName = userName;
		this.appointmentDate = appointmentDate;
		this.headache = headache;
		this.fever = fever;
		this.cold = cold;
		this.bp = bp;
		this.diabetes = diabetes;
		this.prescription = prescription;
		this.medicalHistory = medicalHistory;
		this.respiratoryProblems = respiratoryProblems;
		this.foreignTravelling = foreignTravelling;
	}





	public int getId() {
		return id;
	}





	public void setId(int id) {
		this.id = id;
	}





	public int getPatientId() {
		return patientId;
	}





	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}



	public String getUserName() {
		return userName;
	}





	public void setUserName(String userName) {
		this.userName = userName;
	}
	


	public String getAppointmentDate() {
		return appointmentDate;
	}





	public void setAppointmentDate(String appointmentDate) {
		this.appointmentDate = appointmentDate;
	}





	public String getHeadache() {
		return headache;
	}





	public void setHeadache(String headache) {
		this.headache = headache;
	}





	public String getFever() {
		return fever;
	}





	public void setFever(String fever) {
		this.fever = fever;
	}





	public String getCold() {
		return cold;
	}





	public void setCold(String cold) {
		this.cold = cold;
	}





	public String getBp() {
		return bp;
	}





	public void setBp(String bp) {
		this.bp = bp;
	}





	public String getDiabetes() {
		return diabetes;
	}





	public void setDiabetes(String diabetes) {
		this.diabetes = diabetes;
	}





	public String getPrescription() {
		return prescription;
	}





	public void setPrescription(String prescription) {
		this.prescription = prescription;
	}





	public String getMedicalHistory() {
		return medicalHistory;
	}





	public void setMedicalHistory(String medicalHistory) {
		this.medicalHistory = medicalHistory;
	}





	public String getRespiratoryProblems() {
		return respiratoryProblems;
	}





	public void setRespiratoryProblems(String respiratoryProblems) {
		this.respiratoryProblems = respiratoryProblems;
	}





	public String getForeignTravelling() {
		return foreignTravelling;
	}





	public void setForeignTravelling(String foreignTravelling) {
		this.foreignTravelling = foreignTravelling;
	}





	@Override
	public String toString() {
		return "GeneralAppointment [id=" + id + ", patientId=" + patientId + ", UserName=" + userName + ", appointmentDate=" + appointmentDate
				+ ", headache=" + headache + ", fever=" + fever + ", cold=" + cold + ", bp=" + bp + ", diabetes="
				+ diabetes + ", prescription=" + prescription + ", medicalHistory=" + medicalHistory
				+ ", respiratoryProblems=" + respiratoryProblems + ", foreignTravelling=" + foreignTravelling + "]";
	}
	
	
	
	
	
	
}
