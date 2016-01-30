package tempbyquery;

public class BasePrice {

	double _quantity;
	double _itemPrice;

	public double initial() {
		double basePrice = _quantity * _itemPrice;

		if (basePrice > 1000)
			return basePrice * 0.95;
		else
			return basePrice * 0.98;

	}

	public double refactored() {
		if (basePrice() > 1000)
			return basePrice() * 0.95;
		else
			return basePrice() * 0.98;

	}

	private double basePrice() {
		return _quantity * _itemPrice;
	}
}
