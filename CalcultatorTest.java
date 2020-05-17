package itbootcamp.zadaci;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CalcultatorTest {
	Calculator calc;

	@BeforeMethod
	public void createObject() {
		calc = new Calculator();
	}

	@Test()
	public void addTest() {
		double currentValue = calc.getValue();
		calc.add(123.45);
		double newValue = calc.getValue();
		Assert.assertEquals(newValue, currentValue + 123.45);

	}

	@Test
	public void divTest1() {
		double currentValue = calc.getValue();
		calc.div(1.23);
		Assert.assertEquals(calc.getValue(), currentValue);
	}

	@Test
	public void divTest2() {
		calc.setValue(1000);
		calc.div(1.23);
		Assert.assertEquals(calc.getValue(), 1000 / 1.23);

	}

	@Test
	public void divTest3() {
		double currentValue = calc.getValue();
		calc.div(0);
		Assert.assertEquals(calc.getValue(), currentValue);
	}
}
