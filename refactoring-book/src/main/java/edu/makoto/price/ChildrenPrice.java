package edu.makoto.price;

import edu.makoto.Movie;

public class ChildrenPrice extends Price {

	public int getPriceCode() {
		return Movie.CHILDRENS;
	}

	@Override
	public double getCharge(int daysRented) {
		double result = 1.5;

		if (daysRented > 3)
			result += (daysRented - 3);

		return result;

	}
}
