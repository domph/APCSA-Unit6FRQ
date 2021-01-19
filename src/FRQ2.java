class Payroll {
	private int[] itemsSold; // number of items sold by each employee
	private double[] wages; // wages to be computed in part (b)

	/** part (a)
	 * Returns the bonus threshold as described in part (a).
	 */

	public double computeBonusThreshold() {
		// Assign initial max/min values
		int Min = Integer.MAX_VALUE;
		int Max = Integer.MIN_VALUE;

		// Sum up values while tracking min/max
		int Total = 0;
		for (int i = 0; i < itemsSold.length; ++i) {
			Total += itemsSold[i];
			if (itemsSold[i] > Max) {
				Max = itemsSold[i];
			} else if (itemsSold[i] < Min) {
				Min = itemsSold[i];
			}
		}

		// Remove min/max and calculate average of remaining values
		Total -= (Min + Max);
		return ((double)Total / (itemsSold.length - 2));
	}

	/** Computes employee wages as described in part (b)
	 * and stores them in wages.
	 * The parameter fixedWage represents the fixed amount each employee
	 * is paid per day.
	 * The parameter perItemWage represents the amount each employee
	 * is paid per item sold.
	 */

	public void computeWages(double fixedWage, double perItemWage) {
		double BonusThreshold = computeBonusThreshold();
		for (int EmployeeNumber = 0; EmployeeNumber < itemsSold.length; ++EmployeeNumber) {
			wages[EmployeeNumber] = (fixedWage + (itemsSold[EmployeeNumber] * perItemWage)) * (itemsSold[EmployeeNumber] > BonusThreshold ? 1.1 : 1);
		}
	}

	// Other instance variables, constructors, and methods not shown.
	// Testing functions
	public Payroll(int[] ItemsSold) {
		itemsSold = ItemsSold;
		wages = new double[itemsSold.length];
	}

	public double[] GetWages() {
		return wages;
	}
}

public class FRQ2 {
	public static void main(String[] args) {
		// Test
		Payroll TestPayroll = new Payroll(new int[]{48, 50, 37, 62, 38, 70, 55, 37, 64, 60});
		System.out.println(TestPayroll.computeBonusThreshold());

		TestPayroll.computeWages(10, 1.5);
		for (double Wage : TestPayroll.GetWages()) {
			System.out.println(Wage);
		}
	}
}
