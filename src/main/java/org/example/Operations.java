package org.example;


public class Operations {
    public static Polynomial additionOperation(Polynomial first, Polynomial second) {
        Polynomial sumPolynomial = new Polynomial();

        for(Monomial monomialFirst : first.monomials) {
            for(Monomial monomialSecond: second.monomials) {
                if(monomialFirst.getExponent() == monomialSecond.getExponent()) {
                    monomialFirst.setAddedToOperation(true);
                    monomialSecond.setAddedToOperation(true);
                    Monomial sumMonomial = new Monomial(monomialFirst.getCoefficient() +
                            monomialSecond.getCoefficient(), monomialFirst.getExponent());
                    sumPolynomial.monomials.add(sumMonomial);
                }
            }
        }

        for(Monomial monomial1 : first.monomials) {
            if(!monomial1.isAddedToOperation())
                sumPolynomial.monomials.add(monomial1);
        }

        for(Monomial monomial2 : second.monomials) {
            if(!monomial2.isAddedToOperation())
                sumPolynomial.monomials.add(monomial2);
        }
        return sumPolynomial;
    }

    public static Polynomial subtractionOperation(Polynomial first, Polynomial second) {
        Polynomial difPolynomial = new Polynomial();

        for(Monomial monomialFirst : first.monomials) {
            for(Monomial monomialSecond: second.monomials) {
                if(monomialFirst.getExponent() == monomialSecond.getExponent()) {
                    monomialFirst.setAddedToOperation(true);
                    monomialSecond.setAddedToOperation(true);
                    Monomial sumMonomial = new Monomial(monomialFirst.getCoefficient() -
                            monomialSecond.getCoefficient(), monomialFirst.getExponent());
                    difPolynomial.monomials.add(sumMonomial);
                }
            }
        }

        for(Monomial monomial1 : first.monomials) {
            if(!monomial1.isAddedToOperation())
                difPolynomial.monomials.add(monomial1);
        }

        for(Monomial monomial2 : second.monomials) {
            if(!monomial2.isAddedToOperation()) {
                monomial2.setCoefficient(-monomial2.getCoefficient());
                difPolynomial.monomials.add(monomial2);
            }
        }
        return difPolynomial;
    }

    public static Polynomial derivativeOperation(Polynomial first) {
        Polynomial derivativeResult = new Polynomial();

        for(Monomial monomial : first.monomials) {
            Monomial derMonomial = new Monomial(monomial.getCoefficient() * monomial.getExponent(),
                    monomial.getExponent() - 1);
            derivativeResult.monomials.add(derMonomial);
        }
        return derivativeResult;
    }

    public static Polynomial multiplicationOperation(Polynomial first, Polynomial second) {
        Polynomial multiplyResult = new Polynomial();

        for(Monomial monomial : first.monomials) {
            for(Monomial monomial1 : second.monomials) {
                Monomial multiplyMonomial = new Monomial(monomial.getCoefficient()*monomial1.getCoefficient(),
                        monomial.getExponent()+monomial1.getExponent());
                multiplyResult.monomials.add(multiplyMonomial);
            }
        }
        return multiplyResult;
    }

    public static void sortPolynomial(Polynomial polynomial) {
        boolean monomialParsed = false;
        while(!monomialParsed) {
            monomialParsed = true;
            for (int i = 0; i < polynomial.monomials.size() - 1; i++) {
                if (polynomial.monomials.get(i).getExponent() < polynomial.monomials.get(i + 1).getExponent()) {
                    Monomial auxMonomial = polynomial.monomials.get(i);
                    polynomial.monomials.set(i, polynomial.monomials.get(i + 1));
                    polynomial.monomials.set(i + 1, auxMonomial);
                    monomialParsed = false;
                }
            }
        }
    }
}
