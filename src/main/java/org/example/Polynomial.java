package org.example;

import org.example.Monomial;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.Integer.parseInt;

public class Polynomial {
    public ArrayList<Monomial> monomials = new ArrayList<Monomial>();

    public ArrayList<Monomial> getPolynomial( )
    {
        return monomials;
    }

    public ArrayList<Monomial> parsePolynomial(String polynomial) {
        Pattern pattern = Pattern.compile("(?:\\h*)([-+]?\\d*)(?:\\h*)[xX](\\^(\\d+))?|(?:\\h*)([-+]?\\d+)");
        Matcher matcher = pattern.matcher(polynomial);
        ArrayList<Monomial> monomials = new ArrayList<Monomial>();

        int coefficient = 0, exponent;

        while (matcher.find()) {
            if (matcher.group(1) != null) {
                if (matcher.group(1).equals(""))
                    coefficient = 1;
                else if (matcher.group(1).equals("-"))
                    coefficient = -1;
                else
                    coefficient = Integer.parseInt(matcher.group(1));
            }

            if (matcher.group(2) == null)
                exponent = 1;
            else
                exponent = Integer.parseInt(matcher.group(3));

            if (matcher.group(4) != null) {
                coefficient = Integer.parseInt(matcher.group(4));
                exponent = 0;
            }

            monomials.add(new Monomial(coefficient, exponent));
            //System.out.println(coefficient);
            //System.out.println(exponent);
        }
        return monomials;
    }
}