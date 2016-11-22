package money;

public class MoneyStorage {
	protected double balance;
	
	public MoneyStorage(double startingBalance) {
		this.balance = startingBalance;
	}
	
	public void deposit(double amount) throws PovertyException{
		if (TotalMoney.getTotalMoney() < amount) {
			System.out.println("Not enough money!");
			throw new PovertyException("Not enough money!");
		} else {
			balance += amount;
			TotalMoney.removeMoneyFromTotal(amount);
		}
	}
	
	public void withdraw(double amount) throws PovertyException {
		if (balance < amount) {
			System.out.println("Not enough money!");
			throw new PovertyException("Not enough money!");
		} else {
			balance += amount;
			TotalMoney.addMoneyToTotal(amount);
		}
	}
	
	public static void main(String [] args) {
		PiggyBank pig1 = new PiggyBank("bedroom", 50.45);
		PiggyBank pig2 = new PiggyBank("behind the painting", 144.96);
		BankAccount bank1 = new BankAccount(1234, 3340.43);
		BankAccount bank2 = new BankAccount(5678, 0.48);
		System.out.println(TotalMoney.getTotalMoney());
		pig2.smashPiggyBank();
		System.out.println(TotalMoney.getTotalMoney());
		bank2.transferMoneyToPiggyBank("bedroom", 20);
		pig1.oinkBalance();
		pig1.deposit(100);
//		throw exceptions
//		pig2.transferMoneyToBankAccount(5678,  300);
//		bank2.transferMoneyToPiggyBank("behind the painting", 300);
	}
	
}
