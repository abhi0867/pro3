package in.co.rays.project_3.dto;

import java.util.Date;

public class CarDTO extends BaseDTO{
	
	
	private String CarName;
	private String CarModel;
	private Date Carpurchasedate;
	private Integer CarPrice;
	
	

	public String getCarName() {
		return CarName;
	}

	public void setCarName(String carName) {
		CarName = carName;
	}

	public String getCarModel() {
		return CarModel;
	}

	public void setCarModel(String carModel) {
		CarModel = carModel;
	}

	public Date getCarpurchasedate() {
		return Carpurchasedate;
	}

	public void setCarpurchasedate(Date carpurchasedate) {
		Carpurchasedate = carpurchasedate;
	}

	public Integer getCarPrice() {
		return CarPrice;
	}

	public void setCarPrice(Integer carPrice) {
		CarPrice = carPrice;
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
