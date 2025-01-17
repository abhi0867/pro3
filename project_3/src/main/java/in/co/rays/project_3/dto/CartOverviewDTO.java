package in.co.rays.project_3.dto;

import java.util.Date;

public class CartOverviewDTO extends BaseDTO {
	
	 private String Customername;
	 private String product;
	 private Date Transactiondate;
	 private String quantity;
	 
	 
	 public String getCustomername() {
		return Customername;
	}
	public void setCustomername(String customername) {
		Customername = customername;
	}
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public Date getTransactiondate() {
		return Transactiondate;
	}
	public void setTransactiondate(Date transactiondate) {
		Transactiondate = transactiondate;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
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
