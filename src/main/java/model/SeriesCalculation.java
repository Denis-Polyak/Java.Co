package model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SeriesCalculation {
    private double x;
    private int n;
    private double epsilon;
    private double sum;
    private double exactValue;
    private int termsAboveEpsilon;

    public SeriesCalculation(double x, int n, double epsilon) {
        this.x = x;
        this.n = n;
        this.epsilon = epsilon;
    }
}

