package com.coffee.entity;

public class address extends IdAbstract {
  private String city;
  private String country;
  private Long userId;
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}
public String getCountry() {
	return country;
}
public void setCountry(String country) {
	this.country = country;
}
public Long getUserId() {
	return userId;
}
public void setUserId(Long userId) {
	this.userId = userId;
}
@Override
public String toString() {
	return "address [city=" + city + ", country=" + country + ", userId="
			+ userId + "]";
}
 
}
