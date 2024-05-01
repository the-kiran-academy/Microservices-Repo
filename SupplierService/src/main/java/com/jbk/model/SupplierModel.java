package com.jbk.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class SupplierModel {
	@Min(value = 1, message = "Invalid Supplier Id")
	private long supplierId;
	
	@NotBlank(message = "Supplier Name Should Not be Blank")
	@Pattern(regexp = "^[a-zA-Z ]+$", message = "Supplier name should only contain alphabets and spaces")
	private String supplierName;
	
	@NotBlank(message = "City Name Should Not be Blank")
	@Pattern(regexp = "^[a-zA-Z ]+$", message = "City name should only contain alphabets and spaces")
	private String city;
	
	//411052
	@Min(value = 100000,message = "Invalid Postal Code")
	@Max(value = 999999, message = "Invalid Postal Code")
	private int postalCode;
	
	@NotBlank(message = "Country Name Should Not be Blank")
	@Pattern(regexp = "^[a-zA-Z ]+$", message = "Country name should only contain alphabets and spaces")

	private String country;
	
	@Pattern(regexp = "^[1-9][0-9]{9}$", message = "Mobile number should only contain digits, not start with 0, and be 10 digits long")
	private String mobile;
	
	public SupplierModel() {
		// TODO Auto-generated constructor stub
	}

	public SupplierModel(long supplierId, String supplierName, String city, int postalCode, String country,
			String mobile) {
		super();
		this.supplierId = supplierId;
		this.supplierName = supplierName;
		this.city = city;
		this.postalCode = postalCode;
		this.country = country;
		this.mobile = mobile;
	}

	public long getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(long supplierId) {
		this.supplierId = supplierId;
	}

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(int postalCode) {
		this.postalCode = postalCode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	@Override
	public String toString() {
		return "SupplierModel [supplierId=" + supplierId + ", supplierName=" + supplierName + ", city=" + city
				+ ", postalCode=" + postalCode + ", country=" + country + ", mobile=" + mobile + "]";
	}
	
	

}
