package com.zhiyou.model;

import java.util.Date;

public class emp {

	private Integer EMPNO;
	private String ENAME;
	private String JOB;
	private Integer MGR;
	private Date HIREDATE;
	private Integer SAL;
	private Integer COMM;
	private Integer DEPTNO;

	public Integer getEMPNO() {
		return EMPNO;
	}

	public void setEMPNO(Integer eMPNO) {
		EMPNO = eMPNO;
	}

	public String getENAME() {
		return ENAME;
	}

	public void setENAME(String eNAME) {
		ENAME = eNAME;
	}

	public String getJOB() {
		return JOB;
	}

	public void setJOB(String jOB) {
		JOB = jOB;
	}

	public Integer getMGR() {
		return MGR;
	}

	public void setMGR(Integer mGR) {
		MGR = mGR;
	}

	public Date getHIREDATE() {
		return HIREDATE;
	}

	public void setHIREDATE(Date hIREDATE) {
		HIREDATE = hIREDATE;
	}

	public Integer getSAL() {
		return SAL;
	}

	public void setSAL(Integer sAL) {
		SAL = sAL;
	}

	public Integer getCOMM() {
		return COMM;
	}

	public void setCOMM(Integer cOMM) {
		COMM = cOMM;
	}

	public Integer getDEPTON() {
		return DEPTNO;
	}

	public void setDEPTON(Integer dEPTON) {
		DEPTNO = dEPTON;
	}

	@Override
	public String toString() {
		return "emp [EMPNO=" + EMPNO + ", ENAME=" + ENAME + ", JOB=" + JOB + ", MGR=" + MGR + ", HIREDATE=" + HIREDATE
				+ ", SAL=" + SAL + ", COMM=" + COMM + ", DEPTON=" + DEPTNO + "]";
	}

}
