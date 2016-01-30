package extractmethod;

import java.util.Enumeration;
import java.util.Vector;

public class PrintOwning {

	public String _name = "Cristian";

	double previousAmount = 0;
	
	void printOwning() {
		printBanner();
		double outstanding = getOutStanding(previousAmount * 1.2);
		printDetails(outstanding);
	}

	public double getOutStanding(double initialValue) {
		double result = initialValue;

		Enumeration<Order> e = new Vector<Order>().elements();

		while (e.hasMoreElements()) {
			Order each = (Order) e.nextElement();
			result += each.getAmount();
		}
		return result;
	}

	public void printBanner() {
		System.out.println("**********************");
		System.out.println("*** Customer Owes ****");
		System.out.println("**********************");
	}

	public void printDetails(double outstanding) {
		System.out.println("name:" + _name);
		System.out.println("amount:" + outstanding);
	}

	class Order {
		private int amount;

		public int getAmount() {
			return amount;
		}
	}
}
