package org.bank;

public class AxisBank extends BankInfo {
	public  void deposit() {
		System.out.println("deposit account");

	}
public static void main(String[] args) {
	AxisBank ac1 = new AxisBank();
	ac1.saving();
	ac1.fixed();
	
	ac1.deposit();
}
}
