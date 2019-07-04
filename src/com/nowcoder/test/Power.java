package com.nowcoder.test;

/**
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方
 */
public class Power {
    public  double Power(double base, int exponent) {
        double result = 1.0;
        if (exponent == 0) {
            result = 1.0;
        }
        if (exponent > 0) {
            double a[] = new double[exponent];
            for (int i = 0; i <= a.length - 1; i++) {
                a[i] = base;
                result = result * a[i];
            }
        }
        if (exponent < 0) {
            double b[] = new double[0 - exponent];
            for (int i = 0; i <= b.length - 1; i++) {
                b[i] = base;
                result = result / b[i];
            }
        }
        return result;
    }
}
