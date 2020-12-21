package com.company;

public class Fraction {
    private int numerator = 0;
    private int denominator = 1;

    public Fraction(int numerator, int denominator) {
        if (denominator == 0) {
            System.out.println("Denominator can't be zero. Choose another one.");
            return;
        }
        this.numerator = numerator * (denominator < 0 ? -1 : 1);
        this.denominator = Math.abs(denominator);
        normalization();
    }

    public int getNumerator() {
        return this.numerator;
    }

    public int getDenominator() {
        return this.denominator;
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    public void setDenominator(int denominator) {
        if (denominator == 0) {
            System.out.println("Denominator can't be zero. Choose another one.");
            return;
        }
        if (denominator < 0) {
            this.numerator *= -1;
        }
        this.denominator = Math.abs(denominator);
    }

    private int gcd(int numerator, int denominator) { // алгоритм Евклиида (рекусия)
        if (numerator == denominator) {
            return numerator;
        }
        while (numerator != 0 && denominator != 0) {
            if (numerator > denominator) {
                numerator %= denominator;
            } else {
                denominator %= numerator;
            }
            gcd(numerator, denominator);
        }
        if (numerator == 0) {
            return denominator;
        } else {
            return numerator;
        }
    }

    private void normalization() { //сокращение дроби
        int divider = gcd(Math.abs(numerator), Math.abs(denominator));
        numerator /= divider;
        denominator /= divider;
    }

    public boolean properFraction(){ //проверка правильности дроби
        return (Math.abs(numerator) < denominator ? true : false);
    }

    public int getIntegerPart() { // выделение целой части
        return (numerator / denominator);
    }

    public Fraction fractionalPart(){ // выделение дробной части
        return new Fraction(numerator % denominator, denominator);
    }

    public double toDecimalFractions(){ // результат деления в виде десятичной дроби
        return (double) numerator / denominator;
    }

    public String toString(){ // вывод дроби на печать
        return new String(numerator + " / " + denominator);
    }

    public Fraction sumFractionTo(Fraction obj){ // сумма с одним аргументом
        return new Fraction(this.numerator * obj.denominator + obj.numerator * this.denominator, this.denominator * obj.denominator);
    }

    public static Fraction sumFractionTo(Fraction obj1, Fraction obj2){ // сумма с двумя аргументами
        return new Fraction(obj1.numerator * obj2.denominator + obj2.numerator * obj1.denominator, obj1.denominator * obj2.denominator);
    }

    public Fraction subtractionFractionTo(Fraction obj) { // вычитание с одним аргументом
        return new Fraction(this.numerator * obj.denominator - obj.numerator * this.denominator, this.denominator * obj.denominator);
    }

    public static Fraction subtractionFractionTo(Fraction obj1, Fraction obj2) { // вычитание с двумя аргументами
        return new Fraction(obj1.numerator * obj2.denominator - obj2.numerator * obj1.denominator, obj1.denominator * obj2.denominator);
    }

    public Fraction multiplicationFractionTo(Fraction obj) { // умножение с одним аргументом
        return new Fraction(this.numerator * obj.numerator, this.denominator * obj.denominator);
    }

    public static Fraction multiplicationFractionTo(Fraction obj1, Fraction obj2) { // умножение с двумя аргументами
        return new Fraction(obj1.numerator * obj2.numerator, obj1.denominator * obj2.denominator);
    }

    public Fraction segmentationFractionTo(Fraction obj){ // деление с одним аргументом
        return new Fraction(this.numerator * obj.denominator, obj.numerator * this.denominator);
    }

    public static Fraction segmentationFractionTo(Fraction obj1, Fraction obj2){ // деление с двумя аргументами
        return new Fraction(obj1.numerator * obj2.denominator, obj2.numerator * obj1.denominator);
    }
}
