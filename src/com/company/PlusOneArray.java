package com.company;

import java.util.ArrayList;
import java.util.Arrays;

public class PlusOneArray {
    public int[] plusOne(int[] digits) {
        ArrayList<Integer> a = new ArrayList<>();
        for (int i = 0; i < digits.length; i++) {
            a.add(digits[i]);
        }
        for (int j = a.size() - 1; j >= 0; j--) {
            if (a.get(j) == 9 && j == a.size() - 1) {
                a.set(j, 0);
                a.add(j, 1);
            } else if (a.get(j) == 9 && j != a.size() - 1) {
                a.set(j, 1);
                a.set(j + 1, 0);
            } else if (a.get(j) != 9 && j != a.size() - 1) {
                a.set(j, a.get(j) + 1);
                a.set(j + 1, 0);
                a.remove(j + 2);
                break;
            } else {
                a.set(j, a.get(j) + 1);
                break;
            }
        }
        int[] arr = new int[a.size()];
        for (int k = 0; k < a.size(); k++) {
            arr[k] = a.get(k);
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] d = {9};
        PlusOneArray po = new PlusOneArray();
        po.plusOne(d);
        System.out.println("The plus one array is: " + Arrays.toString(po.plusOne(d)));
    }
}
