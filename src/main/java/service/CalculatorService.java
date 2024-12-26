package service;

public class CalculatorService {
    private static final CalculatorService INSTANCE = new CalculatorService();

    private CalculatorService() {}

    public static CalculatorService getInstance() {
        return INSTANCE;
    }

    public double calculateNTermSum(double x, int n) {
        double sum = 0;
        for (int i = 0; i < n; i++) {
            sum += Math.pow(-1, i) * Math.pow(x, i) / (i + 1);
        }
        return sum;
    }

    public double calculateEpsilonSum(double x, double epsilon, int n) {
        double sum = 0;
        double term;
        int i = 0;
        do {
            term = Math.pow(-1, i) * Math.pow(x, i) / (i + 1);
            if (Math.abs(term) > epsilon) {
                sum += term;
            }
            i++;
        } while (i < n);
        return sum;
    }

    public double calculateExactValue(double x) {
        return Math.log(1 + x);
    }
}