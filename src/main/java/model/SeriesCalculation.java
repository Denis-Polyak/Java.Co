package model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SeriesCalculation {
    private double x;
    private int n;
    private double epsilon;
    private double sum;
    private double exactValue;

    public SeriesCalculation(double x, int n, double epsilon) {
        this.x = x;
        this.n = n;
        this.epsilon = epsilon;
    }

}


