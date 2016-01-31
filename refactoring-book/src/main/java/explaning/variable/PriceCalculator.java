package explaning.variable;

public class PriceCalculator {

	double _quantity;
	double _itemPrice;

	public double price_initial() {
		// price is base_price - quantity discount + shipping
		return _quantity * _itemPrice - Math.max(0, _quantity - 500) * _itemPrice * 0.05
				+ Math.min(_quantity * _itemPrice, 100.0);
	}

	public double price_refactored() {
		double basePrice = _quantity * _itemPrice;
		double discount = Math.max(0, _quantity - 500) * _itemPrice * 0.05;
		double shipping = Math.min(basePrice, 100.0);
		
		return basePrice - discount + shipping;
	}
}
