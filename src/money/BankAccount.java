package money;

import java.util.ArrayList;
import java.util.List;

public class BankAccount extends MoneyStorage {
	public int accountNumber;
	private int withdrawalLimit = 20;
	public static List<BankAccount> allBankAccounts = new ArrayList<BankAccount>();
	
	public BankAccount(int accountNumber, double startingBalance) {
		super(startingBalance);
		this.accountNumber = accountNumber;
		BankAccount.allBankAccounts.add(this);
	}
	
	public void showBalance() {
		System.out.println("Welcome! Your account has a balance of $" + balance + "!");
	}
	
	public void withdraw(double amount) throws PovertyException {
		if (this.balance < amount) {
			System.out.println("Not enough money!");
			throw new PovertyException("Not enough money!");
		} else if (withdrawalLimit == 0) {
			System.out.println("You've reached your withdrawal limit!");
		} else {
			balance += amount;
			withdrawalLimit--;
			TotalMoney.addMoneyToTotal(amount);
		}
	}
	
	public void transferMoneyToPiggyBank(String location, double amount) {
		for (int i = 0; i < PiggyBank.allPiggyBanks.size(); i++) {
			if (PiggyBank.allPiggyBanks.get(i).location == location) {
				PiggyBank.allPiggyBanks.get(i).deposit(amount);
				this.balance -= amount;
			}
		}
	}
}
