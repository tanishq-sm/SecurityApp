package com.univ.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "registration")
public class RegModel {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
int cid;

String cname;
String cadd;
String coname;
String location;
String unm;
String pw;
public int getCid() {
	return cid;
}
public void setCid(int cid) {
	this.cid = cid;
}
public String getCname() {
	return cname;
}
public void setCname(String cname) {
	this.cname = cname;
}
public String getCadd() {
	return cadd;
}
public void setCadd(String cadd) {
	this.cadd = cadd;
}
public String getConame() {
	return coname;
}
public void setConame(String coname) {
	this.coname = coname;
}
public String getLocation() {
	return location;
}
public void setLocation(String location) {
	this.location = location;
}
public RegModel() {
	super();
	// TODO Auto-generated constructor stub
}
public String getUnm() {
	return unm;
}
public void setUnm(String unm) {
	this.unm = unm;
}
public String getPw() {
	return pw;
}
public void setPw(String pw) {
	this.pw = pw;
}
public RegModel(int cid, String cname, String cadd, String coname, String location, String unm, String pw) {
	super();
	this.cid = cid;
	this.cname = cname;
	this.cadd = cadd;
	this.coname = coname;
	this.location = location;
	this.unm = unm;
	this.pw = pw;
}
@Override
public String toString() {
	return "RegModel [cid=" + cid + ", cname=" + cname + ", cadd=" + cadd + ", coname=" + coname + ", location="
			+ location + ", unm=" + unm + ", pw=" + pw + "]";
}



}
