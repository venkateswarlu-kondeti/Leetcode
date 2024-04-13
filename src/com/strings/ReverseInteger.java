package com.strings;

public class ReverseInteger {
    public int reverse(int x) {
        double rev = 0;
        int a;
        int val;
        if (x > 0) {
            while (x > 0) {
                int d = x % 10;
                rev = rev * 10 + d;
                x = x / 10;
            }
        } else {
            a = Math.abs(x);
            while (a > 0) {
                int d = a % 10;
                rev = rev * 10 + d;
                a = a / 10;
            }
            rev = -rev;
        }
        if (rev < -Math.pow(2, 31) || rev > (Math.pow(2, 31) - 1)) {
            rev = 0;
        }
        val = (int) rev;
        return val;
    }

    public static void main(String[] args) {
        int n = -123;
        ReverseInteger r = new ReverseInteger();
        r.reverse(n);
        System.out.println(r.reverse(n));
    }
}
