package br.pucrs;

public class Element {
    double value;
    double average;

    public Element() {
        average = 0;
        fillRandom();
    }

    public double getAverage() {
        return average;
    }

    public void setAverage(double value) {

        average = value;
    }

    private void fillRandom() {
        double random = Math.random() * 9;
        value = (int) random;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
