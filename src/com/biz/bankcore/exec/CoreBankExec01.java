package com.biz.bankcore.exec;

import com.biz.bankcore.service.CoreBankService;

public class CoreBankExec01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CoreBankService cb = new CoreBankService();
		// cb.readfile(strNameFile);
		cb.process();
		
	}

}
