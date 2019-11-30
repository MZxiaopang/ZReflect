package com.zhiyou.model;

public class dept {

	private Integer DEPTION;
	private String DNAME;
	private String LOC;

	public Integer getDEPTION() {
		return DEPTION;
	}

	public void setDEPTION(Integer dEPTION) {
		DEPTION = dEPTION;
	}

	public String getDNAME() {
		return DNAME;
	}

	public void setDNAME(String dNAME) {
		DNAME = dNAME;
	}

	public String getLOC() {
		return LOC;
	}

	public void setLOC(String lOC) {
		LOC = lOC;
	}

	@Override
	public String toString() {
		return "dept [DEPTION=" + DEPTION + ", DNAME=" + DNAME + ", LOC=" + LOC + "]";
	}

}
