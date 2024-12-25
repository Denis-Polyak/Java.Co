package model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

public class TabulationResult {
    @Setter
    @Getter
    private double a;
    private double b;
    private double h;
    private List<Double> xValues = new ArrayList<>();
    private List<Double> yValues = new ArrayList<>();

    public double getB() { return b; }
    public void setB(double b) { this.b = b; }

    public double getH() { return h; }
    public void setH(double h) { this.h = h; }

    public List<Double> getXValues() { return xValues; }
    public List<Double> getYValues() { return yValues; }

    public void addResult(double x, double y) {
        this.xValues.add(x);
        this.yValues.add(y);
    }
}

