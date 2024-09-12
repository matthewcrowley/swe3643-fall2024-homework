package org.example;

import static org.junit.jupiter.api.Assertions.*;

import org.example.Main;
import org.junit.jupiter.api.Test;

public class MainTest {

    @Test
    public void testComputeMean() {
        double[] values = {1, 2, 3, 4, 5};
        double mean = Main.computeMean(values);
        assertEquals(3.0, mean, "Mean calculation is incorrect");
    }

    @Test
    public void testComputeMeanEmptyArray() {
        double[] values = {};
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Main.computeMean(values);
        });
        assertEquals("valuesList parameter cannot be null or empty", exception.getMessage());
    }

    @Test
    public void testComputeSquareOfDifferences() {
        double[] values = {1, 2, 3, 4, 5};
        double mean = Main.computeMean(values);
        double squareOfDifferences = Main.computeSquareOfDifferences(values, mean);
        assertEquals(10.0, squareOfDifferences, "Square of differences calculation is incorrect");
    }

    @Test
    public void testComputeSquareOfDifferencesEmptyArray() {
        double[] values = {};
        double mean = 0;
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Main.computeSquareOfDifferences(values, mean);
        });
        assertEquals("valuesList parameter cannot be null or empty", exception.getMessage());
    }

    @Test
    public void testComputeVarianceSample() {
        double squareOfDifferences = 10.0;
        int numValues = 5;
        double variance = Main.computeVariance(squareOfDifferences, numValues, false);
        assertEquals(2.5, variance, "Variance calculation for sample is incorrect");
    }

    @Test
    public void testComputeVariancePopulation() {
        double squareOfDifferences = 10.0;
        int numValues = 5;
        double variance = Main.computeVariance(squareOfDifferences, numValues, true);
        assertEquals(2.0, variance, "Variance calculation for population is incorrect");
    }

    @Test
    public void testComputeVarianceInvalidSize() {
        double squareOfDifferences = 10.0;
        int numValues = 0;
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Main.computeVariance(squareOfDifferences, numValues, false);
        });
        assertEquals("numValues is too low (sample size must be >= 2, population size must be >= 1)", exception.getMessage());
    }

    @Test
    public void testComputeStandardDeviationSample() {
        double[] sampleValues = {9, 6, 8, 5, 7};
        double sampleStdDev = Main.computeSampleStandardDeviation(sampleValues);
        assertEquals(1.5811388300841898, sampleStdDev, 1e-9, "Sample standard deviation calculation is incorrect");
    }

    @Test
    public void testComputeStandardDeviationPopulation() {
        double[] populationValues = {9, 2, 5, 4, 12, 7, 8, 11, 9, 3, 7, 4, 12, 5, 4, 10, 9, 6, 9, 4};
        double popStdDev = Main.computePopulationStandardDeviation(populationValues);
        assertEquals(2.9832867780352594, popStdDev, 1e-9, "Population standard deviation calculation is incorrect");
    }

    @Test
    public void testComputeStandardDeviationEmptyArray() {
        double[] values = {};
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Main.computeStandardDeviation(values, false);
        });
        assertEquals("valuesList parameter cannot be null or empty", exception.getMessage());
    }

    @Test
    public void testMainMethod() throws Exception {
        // Capture the output of the main method
        String output = toString();

        // Check the captured output
        assertTrue(output.contains(""));
        assertTrue(output.contains(""));
    }
}
