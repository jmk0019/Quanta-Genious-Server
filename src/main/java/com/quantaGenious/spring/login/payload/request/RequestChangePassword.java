package com.quantaGenious.spring.login.payload.request;


public class RequestChangePassword {
	
	 private int tutorId;
	 private String oldPassword;
	 private String newPassword;
	 
	public int getTutorId() {
		return tutorId;
	}
	public void setTutorId(int tutorId) {
		this.tutorId = tutorId;
	}
	public String getOldPassword() {
		return oldPassword;
	}
	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}
	public String getNewPassword() {
		return newPassword;
	}
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	
	
	@Override
	public String toString() {
		return "RequestChangePassword [tutorId=" + tutorId + ", oldPassword=" + oldPassword + ", newPassword="
				+ newPassword + "]";
	}
	 
	 

}
