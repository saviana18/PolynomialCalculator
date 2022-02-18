package org.example;

public class Monomial {
    private int coefficient;
    private int exponent;
    private boolean addedToOperation;

    public Monomial(int coefficient, int exponent) {
        super();
        this.coefficient = coefficient;
        this.exponent = exponent;
    }

    public Monomial() {

    }

    public int getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(int coefficient) {
        this.coefficient = coefficient;
    }

    public int getExponent() {
        return exponent;
    }

    public void setExponent(int exponent) {
        this.exponent = exponent;
    }

    public boolean isAddedToOperation() {
        return addedToOperation;
    }

    public void setAddedToOperation(boolean addedToOperation) {
        this.addedToOperation = addedToOperation;
    }

    public String toString() {
        if(coefficient == 0 && exponent == 0)
            return "";

        if(coefficient == 0)
            return "";

        if(exponent == 0) {
            if(coefficient > 0)
                return "+" + coefficient;
            else
                return coefficient + "";
        }

        if(coefficient == 1 && exponent == 1)
            return "+x";

        if(exponent > 0 && coefficient > 0)
            return "+" + coefficient + "x^" + exponent;

        return "" + coefficient + "x^" + exponent + "";
    }
}
