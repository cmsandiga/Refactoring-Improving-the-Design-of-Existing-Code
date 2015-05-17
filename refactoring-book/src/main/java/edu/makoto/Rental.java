package edu.makoto;

public class Rental {
	private Movie _movie;
	private int _daysRented;

	public Rental(Movie movie, int daysRented) {
		_movie = movie;
		_daysRented = daysRented;
	}

	public int getDaysRented() {
		return _daysRented;
	}

	public Movie getMovie() {
		return _movie;
	}

	public double getCharge() {

		double result = 0.0;

		switch (getMovie().getPriceCode()) {

			case Movie.REGULAR:
				result += 2;

				if (getDaysRented() > 2)
					result += (getDaysRented() - 2);
				break;

			case Movie.NEW_RELEASE:
				result += getDaysRented() * 3;

			case Movie.CHILDRENS:
				result += 1.5;

				if (getDaysRented() > 3)
					result += (getDaysRented() - 3);

			default:
				break;
		}

		return result;
	}
}
