package money;

import java.util.ArrayList;
import java.util.List;

public class PiggyBank extends MoneyStorage{
	public String location;
	private double capacity = 150.00;
	public static List<PiggyBank> allPiggyBanks = new ArrayList<PiggyBank>();
	
	public PiggyBank(String location, double startingBalance) {
		super(startingBalance);
		this.location = location;
		PiggyBank.allPiggyBanks.add(this);
	}
	
	public void oinkBalance() {
		System.out.println("Oink! I have $" + balance + " left in me! Oink!");
	}
	
	public void deposit(double amount) throws PovertyException{
		if (TotalMoney.getTotalMoney() < amount) {
			System.out.println("Not enough money!");
			throw new PovertyException("Not enough money!");
		} else if (balance + amount > capacity) {
			System.out.println("I'm stuffed! Oink! No more room!");
		} else {
			balance += amount;
			TotalMoney.removeMoneyFromTotal(amount);
		}
	}
	
	public void smashPiggyBank() {
		TotalMoney.addMoneyToTotal(balance);
		this.balance = 0;
	}
	
	public void transferMoneyToBankAccount(int accountNumber, double amount) {
		for (int i = 0; i < BankAccount.allBankAccounts.size(); i++) {
			if (BankAccount.allBankAccounts.get(i).accountNumber == accountNumber) {
				BankAccount.allBankAccounts.get(i).deposit(amount);
				this.balance -= amount;
			}
		}
	}
}
