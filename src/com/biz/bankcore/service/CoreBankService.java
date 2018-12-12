package com.biz.bankcore.service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.biz.bankcore.vo.CoreBankVO;

public class CoreBankService {

	List<CoreBankVO> bankList;
	String strNameFile;

	public CoreBankService(String strNameFile) {
		bankList = new ArrayList();
		this.strNameFile = strNameFile;
	}

	public void readfile(String strNameFile) {

		FileReader fr;
		BufferedReader buffer;

		try {
			fr = new FileReader(strNameFile);
			buffer = new BufferedReader(fr);
			while (true) {
				String read = buffer.readLine();
				if (read == null)
					break;
				String[] arrLine = read.split(":");
				CoreBankVO cb = new CoreBankVO();
				cb.setStrAccout(arrLine[0]);
				cb.setIntBalance(Integer.valueOf(arrLine[1]));
				cb.setStrDate(arrLine[2]);
				bankList.add(cb);
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

	public void process() {
		Scanner scanner = new Scanner(System.in);
		String strAccount1 = "";
		int intDe1 = 0;
		int intWi1 = 0;
		int intBalance1 = 0;

		while (true) {
			CoreBankVO cb = new CoreBankVO();
			System.out.println("입금(01)/출금(02)/종료(03)>> ");
			String strnum = scanner.nextLine();
			if (strnum.equals("01")) { // 입금
				System.out.println("계좌번호를 입력해주세요");
				strAccount1 = scanner.nextLine();
				System.out.println("입금 하실 금액을 입력해주세요");
				intDe1 = Integer.valueOf(scanner.nextLine());
				intBalance1 += intDe1;
				cb.setIntBalance(intBalance1);
				bankList.add(cb);

			} else if (strnum.equals("02")) { // 출금
				System.out.println("계좌번호를 입력해주세요");
				strAccount1 = scanner.nextLine();
				System.out.println("출금 하실 금액을 입력해주세요");
				intWi1 = Integer.valueOf(scanner.nextLine());
				if (intWi1 > cb.getIntBalance()) {
					intBalance1 -= intWi1;
					cb.setIntBalance(intBalance1);
					bankList.add(cb);
				} else {
					System.out.println("잔액이 부족합니다");
					continue;
				}

			} else { // 종료
				System.out.println("이용 해주셔서 감사합니다");
				break;
			}
		}

	}

}
