package money;

public class TotalMoney {
	private static double totalMoney;
	
	public static void addMoneyToTotal(double amount) {
		TotalMoney.totalMoney = totalMoney + amount;
	}
	
	public static void removeMoneyFromTotal(double amount) {
		TotalMoney.totalMoney = totalMoney - amount;
	}
	
	public static double getTotalMoney() {
		return TotalMoney.totalMoney;
	}
}
