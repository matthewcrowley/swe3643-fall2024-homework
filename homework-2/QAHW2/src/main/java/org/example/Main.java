package org.example;

public class Main {

    public static void main(String[] args) {
        // Sample standard deviation calculation
        double[] sampleValuesList = {9, 6, 8, 5, 7};
        double sampleStdDev = computeSampleStandardDeviation(sampleValuesList);
        System.out.println("Sample StdDev = " + sampleStdDev);
        // Expected: "Sample StdDev = 1.5811388300841898"

        // Population standard deviation calculation
        double[] populationValuesList = {9, 2, 5, 4, 12, 7, 8, 11, 9, 3, 7, 4, 12, 5, 4, 10, 9, 6, 9, 4};
        double popStdDev = computePopulationStandardDeviation(populationValuesList);
        System.out.println("Population StdDev = " + popStdDev);
        // Expected: "Population StdDev = 2.9832867780352594"
    }

    // Function to compute the mean (average) of a list of values
    public static double computeMean(double[] valuesList) {
        if (valuesList == null || valuesList.length == 0) {
            throw new IllegalArgumentException("valuesList parameter cannot be null or empty");
        }

        double sumAccumulator = 0;
        for (double value : valuesList) {
            sumAccumulator += value;
        }

        return sumAccumulator / valuesList.length;
    }

    // Function to compute the sum of squared differences from the mean
    public static double computeSquareOfDifferences(double[] valuesList, double mean) {
        if (valuesList == null || valuesList.length == 0) {
            throw new IllegalArgumentException("valuesList parameter cannot be null or empty");
        }

        double squareAccumulator = 0;
        for (double value : valuesList) {
            double difference = value - mean;
            double squareOfDifference = difference * difference;
            squareAccumulator += squareOfDifference;
        }

        return squareAccumulator;
    }

    // Function to compute the variance based on squared differences
    public static double computeVariance(double squareOfDifferences, int numValues, boolean isPopulation) {
        if (numValues < 1) {
            throw new IllegalArgumentException("numValues is too low (sample size must be >= 2, population size must be >= 1)");
        }

        if (!isPopulation) {
            numValues = numValues - 1; // Adjust for sample
        }

        return squareOfDifferences / numValues;
    }

    // Function to compute the population or sample standard deviation from a list of values
    public static double computeStandardDeviation(double[] valuesList, boolean isPopulation) {
        if (valuesList == null || valuesList.length == 0) {
            throw new IllegalArgumentException("valuesList parameter cannot be null or empty");
        }

        double mean = computeMean(valuesList);
        double squareOfDifferences = computeSquareOfDifferences(valuesList, mean);
        double variance = computeVariance(squareOfDifferences, valuesList.length, isPopulation);

        return Math.sqrt(variance); // Compute the square root of the variance
    }

    // Function to compute the sample standard deviation from a list of values
    public static double computeSampleStandardDeviation(double[] valuesList) {
        return computeStandardDeviation(valuesList, false); // false indicates sample
    }

    // Function to compute the population standard deviation from a list of values
    public static double computePopulationStandardDeviation(double[] valuesList) {
        return computeStandardDeviation(valuesList, true); // true indicates population
    }
}
