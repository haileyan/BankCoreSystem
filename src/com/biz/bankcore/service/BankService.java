package com.biz.bankcore.service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.biz.bankcore.vo.BankVO;

public class BankService {

	List<BankVO> bankList;
	String strFileName;

	public BankService(String strFileName) {
		bankList = new ArrayList();
		this.strFileName = strFileName;
	}

	public void readFile() {
		FileReader fr;
		BufferedReader buffer;

		try {
			fr = new FileReader(strFileName);
			buffer = new BufferedReader(fr);
			while (true) {
				String read = buffer.readLine();
				if (read == null)
					break;
				String[] arrLine = read.split(":");
				BankVO vo = new BankVO();
				vo.setStrId(arrLine[0]);
				vo.setIntBalance(Integer.valueOf(arrLine[1]));
				vo.setStrLastDate(arrLine[2]);
				bankList.add(vo);
			}
			buffer.close();
			fr.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void bankInput() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("계좌번호를 입력하세요 >>");
		String strId = scanner.nextLine();
		BankVO bankVO = null;
		for (BankVO vo : bankList) {
			if (strId.equals(vo.getStrId())) {
				bankVO = vo;
				break;
			}
		}
		if (bankVO == null) {
			System.out.println("없다");
			return;
		}
		int intBalance = bankVO.getIntBalance();
		System.out.println("입금 하실 금액을 입력해주세요 >>");
		String strInput = scanner.nextLine();
		
		int intAfterBalance = intBalance + Integer.valueOf(strInput);
		bankVO.setIntBalance(intAfterBalance);
		String strDate = LocalDate.now().toString();
		bankVO.setStrLastDate(strDate);
		
		System.out.println("=======================================");
		System.out.println("입금이 완료 되었습니다");
		System.out.println("---------------------------------------");
		System.out.println("원잔액 : " + intBalance);
		System.out.println("입금액 : " + strInput);
		System.out.println("현잔액 : " + bankVO.getIntBalance());
		
	}

	public void bankOutput() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("계좌번호를 입력하세요 >>");
		String strId = scanner.nextLine();
		BankVO bankVO = null;
		for(BankVO vo : bankList) {
			if(strId.equals(vo.getStrId())) {
				bankVO = vo;
				break;
			}
		}
			if(bankVO == null) {
				System.out.println("입력하신 계좌 번호를 찾을 수 없습니다");
				return;
			}
		int intBalance = bankVO.getIntBalance();
		System.out.print("출금하실 금액을 입력 해주세요 >>");
		String strOut = scanner.nextLine();
		for(BankVO vo : bankList) {
			if(Integer.valueOf(strOut) > intBalance) {
				System.out.println("잔액이 부족합니다");
			} 
				int intAfterBalance = intBalance - Integer.valueOf(strOut);
				bankVO.setIntBalance(intAfterBalance);
				String strDate = LocalDate.now().toString();
				bankVO.setStrLastDate(strDate);
			
		}
			System.out.println("============================================");
			System.out.println("출금이 완료 되었습니다");
			System.out.println("--------------------------------------------");
			System.out.println("원잔액 : " + intBalance);
			System.out.println("출금액 : " + Integer.valueOf(strOut));
			System.out.println("현잔액 : " + bankVO.getIntBalance());
			
			
	}
	
	public void bankCheck() {
		System.out.println("--------------------------------------");
		System.out.println("계좌번호\t잔액\t최종거래일");
		for(BankVO vo : bankList) {
			System.out.printf("%8s\t%5d\t%10s\n", 
					vo.getStrId(), vo.getIntBalance(), vo.getStrLastDate());	
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
