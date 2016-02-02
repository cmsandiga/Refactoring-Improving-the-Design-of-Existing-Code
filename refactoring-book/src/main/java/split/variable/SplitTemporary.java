package split.variable;

public class SplitTemporary {

	double _primaryForce;
	double _secondaryForce;
	double _mass;
	int _delay;

	public double getDistanceTravelled_initial(int time) {
		double result = 0;

		double acc = _primaryForce / _mass;
		int primaryTime = Math.min(time, _delay);
		result = 0.5 * acc * primaryTime * primaryTime;
		int secondaryTime = time - _delay;

		if (secondaryTime > 0) {
			double primaryVel = acc * _delay;
			acc = (_primaryForce + _secondaryForce) / _mass;
			result += primaryVel * secondaryTime + 0.5 * acc * secondaryTime * secondaryTime;
		}

		return result;
	}

	public double getDistanceTravelled_refactored(int time) {
		double result = 0.5 * primaryAcc() * (primaryTime(time) * 2);

		if (secondaryTime(time) > 0) {
			result += primaryVelocity() * secondaryTime(time) + 0.5 * secondaryAcc() * (secondaryTime(time) * 2);
		}

		return result;
	}

	public double primaryAcc() {
		return _primaryForce / _mass;
	}

	public double secondaryAcc() {
		return  (_primaryForce + _secondaryForce) / _mass;
	}
	
	public double primaryTime(int time) {
		return Math.min(time, _delay);
	}
	
	public double secondaryTime(int time) {
		return time - _delay;
	}

	public double primaryVelocity() {
		return primaryAcc() * _delay;
	}
	
}
