package com.biz.bankcore.vo;

public class CoreBankVO {

	String strAccout;
	int intBalance;
	String strDate;
	int intDe;
	int intWi;
	
	public String getStrAccout() {
		return strAccout;
	}
	public void setStrAccout(String strAccout) {
		this.strAccout = strAccout;
	}
	public int getIntBalance() {
		return intBalance;
	}
	public void setIntBalance(int intBalance) {
		this.intBalance = intBalance;
	}
	public String getStrDate() {
		return strDate;
	}
	public void setStrDate(String strDate) {
		this.strDate = strDate;
	}
	public int getIntDe() {
		return intDe;
	}
	public void setIntDe(int intDe) {
		this.intDe = intDe;
	}
	public int getIntWi() {
		return intWi;
	}
	public void setIntWi(int intWi) {
		this.intWi = intWi;
	}
	@Override
	public String toString() {
		return "CoreBankVO [strAccout=" + strAccout + ", intBalance=" + intBalance + ", strDate=" + strDate + ", intDe="
				+ intDe + ", intWi=" + intWi + "]";
	}
	
	
}
