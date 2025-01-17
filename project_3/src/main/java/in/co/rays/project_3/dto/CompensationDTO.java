package in.co.rays.project_3.dto;

import java.util.Date;

public class CompensationDTO extends BaseDTO {
	
	private String staffMember;
	private String paymentAmount;
	private Date  DateApplied;
	private String State;
	
	public String getStaffMember() {
		return staffMember;
	}
	public void setStaffMember(String staffMember) {
		this.staffMember = staffMember;
	}
	public String getPaymentAmount() {
		return paymentAmount;
	}
	public void setPaymentAmount(String paymentAmount) {
		this.paymentAmount = paymentAmount;
	}
	public Date getDateApplied() {
		return DateApplied;
	}
	public void setDateApplied(Date dateApplied) {
		DateApplied = dateApplied;
	}
	public String getState() {
		return State;
	}
	public void setState(String state) {
		State = state;
	}
	@Override
	public String getKey() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
