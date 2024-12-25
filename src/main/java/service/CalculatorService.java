package service;

public class CalculatorService {
    private static CalculatorService instance;

    private CalculatorService() {}

    public static CalculatorService getInstance() {
        if (instance == null) {
            instance = new CalculatorService();
        }
        return instance;
    }

    public double calculateNTermSum(double x, int n) {
        double sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += calculateTerm(x, i);
        }
        return sum;
    }

    public double calculateEpsilonSum(double x, double epsilon, int maxTerms) {
        double sum = 0;
        int count = 0;

        for (int i = 1; i <= maxTerms; i++) {
            double term = calculateTerm(x, i);
            if (Math.abs(term) > epsilon) {
                sum += term;
                count++;
            }
        }
        return sum;
    }

    private double calculateTerm(double x, int i) {
        return (i % 2 == 1 ? 1 : -1) * Math.pow(x, i) / i;
    }

    public double calculateExactValue(double x) {
        return Math.log(1 + x);
    }
}
