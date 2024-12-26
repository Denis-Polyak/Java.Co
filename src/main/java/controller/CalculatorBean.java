package controller;

import jakarta.faces.bean.ManagedBean;
import jakarta.faces.bean.RequestScoped;
import lombok.Getter;
import lombok.Setter;
import service.CalculatorService;
import model.SeriesCalculation;

@ManagedBean(name = "calculatorBean")
@RequestScoped
public class CalculatorBean {

    @Getter @Setter
    private double x;

    @Getter @Setter
    private int n;

    @Getter @Setter
    private double epsilon1;

    @Getter
    private SeriesCalculation calculation;

    @Getter
    private double sumEpsilon1;

    @Getter
    private double sumEpsilon2;

    @Getter
    private String errorMessage;

    private final CalculatorService calculatorService = CalculatorService.getInstance();

    public void calculate() {
        try {
            if (n <= 0 || epsilon1 <= 0) {
                throw new IllegalArgumentException("n та epsilon повинні бути більшими за нуль.");
            }

            double epsilon2 = epsilon1 * 0.1;

            calculation = new SeriesCalculation(x, n, epsilon1);
            calculation.setSum(calculatorService.calculateNTermSum(x, n));
            sumEpsilon1 = calculatorService.calculateEpsilonSum(x, epsilon1, n);
            sumEpsilon2 = calculatorService.calculateEpsilonSum(x, epsilon2, n);
            calculation.setExactValue(calculatorService.calculateExactValue(x));

            errorMessage = null;

        } catch (IllegalArgumentException e) {
            errorMessage = "Помилка: " + e.getMessage();
            sumEpsilon1 = sumEpsilon2 = 0;
            calculation.setExactValue(0);
        } catch (Exception e) {
            errorMessage = "Невідома помилка: " + e.getMessage();
        }
    }
}



