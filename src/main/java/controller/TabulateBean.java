package controller;

import jakarta.faces.bean.ManagedBean;
import jakarta.faces.bean.RequestScoped;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@ManagedBean(name = "tabulateBean")
@RequestScoped
public class TabulateBean {

    private double xStart;

    private double xEnd;

    private double step;

    private List<TabulationResult> tabulation;

    private String errorMessage;

    public void tabulate() {
        if (xEnd <= xStart || step <= 0) {
            errorMessage = "Invalid input values";
            return;
        }

        tabulation = generateTabulation(xStart, xEnd, step);
        errorMessage = null;
    }

    private List<TabulationResult> generateTabulation(double xStart, double xEnd, double step) {
        List<TabulationResult> results = new ArrayList<>();
        for (double x = xStart; x <= xEnd; x += step) {
            double fx = calculateFunction(x);
            results.add(new TabulationResult(x, fx));
        }
        return results;
    }

    private double calculateFunction(double x) {
        return x * x;
    }


    @Getter @Setter
    public static class TabulationResult {
        private double x;
        private double fx;

        public TabulationResult(double x, double fx) {
            this.x = x;
            this.fx = fx;
        }
    }
}





