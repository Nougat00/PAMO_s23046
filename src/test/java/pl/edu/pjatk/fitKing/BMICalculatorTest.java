package pl.edu.pjatk.fitKing;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class BMICalculatorTest {

    private BMICalculator.BmiLabelAndColor bmiLabelAndColor;

    @Before
    public void setUp() {
        bmiLabelAndColor = new BMICalculator.BmiLabelAndColor("", 0);
    }

    @Test
    public void testUnderweightBmiLabelAndColor() {
        bmiLabelAndColor = BMICalculator.BmiLabelAndColor.getBmiLabelAndColor(17.5f);
        assertEquals("17.5\nUnderweight", bmiLabelAndColor.label);
        assertEquals(0xFF0000FF, bmiLabelAndColor.color);
    }

    @Test
    public void testNormalBmiLabelAndColor() {
        bmiLabelAndColor = BMICalculator.BmiLabelAndColor.getBmiLabelAndColor(22.0f);
        assertEquals("22.0\nNormal", bmiLabelAndColor.label);
    }

    @Test
    public void testOverweightBmiLabelAndColor() {
        bmiLabelAndColor = BMICalculator.BmiLabelAndColor.getBmiLabelAndColor(28.0f);
        assertEquals("28.0\nOverweight", bmiLabelAndColor.label);
    }


    @Test
    public void testExtremelyObeseBmiLabelAndColor() {
        bmiLabelAndColor = BMICalculator.BmiLabelAndColor.getBmiLabelAndColor(40.0f);
        assertEquals("40.0\nExtremely obese", bmiLabelAndColor.label);
        assertEquals(0xFFFF0000, bmiLabelAndColor.color);
    }
}
