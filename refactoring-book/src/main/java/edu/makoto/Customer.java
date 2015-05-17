package edu.makoto;

import java.util.Enumeration;
import java.util.Vector;

public class Customer {
	private String _name;
	private Vector<Rental> _rentals = new Vector<>();

	public Customer(String name) {
		_name = name;
	}

	public void addRental(Rental arg) {
		_rentals.add(arg);
	}

	public String getName() {
		return _name;
	}

	public String statement() {

		double totalAmount = 0;
		int frequentRenterPoint = 0;
		Enumeration<Rental> rentals = _rentals.elements();

		String result = "Rental Record for " + getName() + "\n";

		while (rentals.hasMoreElements()) {
			
			double thisAmount = 0;
			
			Rental each = (Rental) rentals.nextElement();

			thisAmount = each.getCharge();
			frequentRenterPoint++;

			if (each.getMovie().getPriceCode() == Movie.NEW_RELEASE && each.getDaysRented() > 1)
				frequentRenterPoint++;

			result += "\t" + each.getMovie().getTitle() + "\t" + String.valueOf(thisAmount) + "\n";
			totalAmount += thisAmount;
		}

		result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
		result += "You earned " + String.valueOf(frequentRenterPoint) + " frequent renter points";
		return result;
	}

}
