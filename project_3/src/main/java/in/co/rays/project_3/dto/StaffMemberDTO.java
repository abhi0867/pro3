package in.co.rays.project_3.dto;

import java.util.Date;

public class StaffMemberDTO extends BaseDTO {
	
  private Integer Identifier;
  private String fullName;
  private Date Joiningdate;
  private String Division;
  private String PreviousEmployer;

  public Integer getIdentifier() {
	return Identifier;
}
public void setIdentifier(Integer identifier) {
	Identifier = identifier;
}
public String getFullName() {
	return fullName;
}
public void setFullName(String fullName) {
	this.fullName = fullName;
}
public Date getJoiningdate() {
	return Joiningdate;
}
public void setJoiningdate(Date joiningdate) {
	Joiningdate = joiningdate;
}
public String getDivision() {
	return Division;
}
public void setDivision(String division) {
	Division = division;
}
public String getPreviousEmployer() {
	return PreviousEmployer;
}
public void setPreviousEmployer(String previousEmployer) {
	PreviousEmployer = previousEmployer;
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
