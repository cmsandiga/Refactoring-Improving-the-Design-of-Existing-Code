package tempbyquery;

public class BasePriceWithDiscount {

	double _quantity;
	double _itemPrice;

	double getPrice_initial() {
		final double basePrice = _quantity * _itemPrice;

		final double discountFactor;
		if (basePrice > 1000)
			discountFactor = 0.95;
		else
			discountFactor = 0.98;

		return basePrice * discountFactor;
	}
	
	
	double getPrice_refactored() {
		return basePrice() * discountFactor();
	}
	
	private double discountFactor() {
		if (basePrice() > 1000)
			return 0.95;
		else
			return 0.98;
	}
	
	
	private double basePrice(){
		return _quantity * _itemPrice;
	}
}
