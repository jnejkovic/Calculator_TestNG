package itbootcamp.zadaci;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CalcultatorTest {
	Calculator calc;
	double oldValue;
	double expectedValue;

	@BeforeMethod
	public void createObject() {
		calc = new Calculator();
	}

	@Test
	public void setValueTest() {
		calc.setValue(123.2);
		Assert.assertEquals(calc.getValue(), 123.2);
	}

	@Test
	public void getValueTest() {
		Assert.assertEquals(calc.getValue(), 0d);
	}

	@Test
	public void addTest() {
		oldValue = calc.getValue();
		calc.add(123.45);
		double newValue = calc.getValue();
		Assert.assertEquals(newValue, oldValue + 123.45);

	}

	@DataProvider(name = "Search Provider")
	private Object[][] getDataFromDataProvider() {
		return new Object[][] { { 0d, 1.23d }, { 1000d, 1.23 }, { 123.5d, 0d } };
	}

	@Test(dataProvider = "Search Provider")
	public void divTest(double a, double b) {
		SoftAssert sa = new SoftAssert();
		calc.setValue(a);
		calc.div(b);
		if (b == 0)
			expectedValue = a;
		else
			expectedValue = a / b;
		sa.assertEquals(calc.getValue(), expectedValue);
		sa.assertAll();
	}

}
