package com.biz.bankcore.exec;

import java.util.List;
import java.util.Scanner;

import com.biz.bankcore.service.BankService;
import com.biz.bankcore.vo.BankVO;

public class BankExec01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		String strFileName = "src/com/biz/bankcore/bankBalance.txt";
		BankService bs = new BankService(strFileName);

		bs.readFile();

		// 업무 선택 메뉴를 보여주고
		// 선택 업무에 따라서 ...를 실행한다.

		while (true) {
			System.out.println("===========================================");
			System.out.println("광한루 은행 차세대 시스템 1.0");
			System.out.println("-------------------------------------------");
			System.out.println("1. 임금 / 2. 출금 / 3. 계좌조회 / -9. 종료");
			System.out.println("-------------------------------------------");
			System.out.println("업무를 선택하세요 >>");
			String strSelect = scanner.nextLine();
			int intSelect = Integer.valueOf(strSelect);
			if (intSelect == -9) {
				System.out.println("이용해주셔서 감사합니다");
				break;
			}
			if (intSelect == 3) {
				bs.bankCheck();
			} else {
				bs.bankCheck();
				if (intSelect == 1) {
					bs.bankInput();
				
				} else if (intSelect == 2) {
					bs.bankOutput();
					
				}
			}
		}

	}

}
