package com.example.demo.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="candidate")
public class canModel 
{
	@Id
	private int cid;
	private String cfname;
	private String clname;
	private String cini;
	private String cdob;
	private String cqua;
	private String cmajor;
	private int cexp;
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCfname() {
		return cfname;
	}
	public void setCfname(String cfname) {
		this.cfname = cfname;
	}
	public String getClname() {
		return clname;
	}
	public void setClname(String clname) {
		this.clname = clname;
	}
	public String getCini() {
		return cini;
	}
	public void setCini(String cini) {
		this.cini = cini;
	}
	public String getCdob() {
		return cdob;
	}
	public void setCdob(String cdob) {
		this.cdob = cdob;
	}
	public String getCqua() {
		return cqua;
	}
	public void setCqua(String cqua) {
		this.cqua = cqua;
	}
	public String getCmajor() {
		return cmajor;
	}
	public void setCmajor(String cmajor) {
		this.cmajor = cmajor;
	}
	public int getCexp() {
		return cexp;
	}
	public void setCexp(int cexp) {
		this.cexp = cexp;
	}

}
