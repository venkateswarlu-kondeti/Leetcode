package com.company;

public class MountainArray {
    public boolean validMountainArray(int[] arr) {
        boolean vldMntupslope = false, vldMntdownslope = false;
        int H = 0;
        int j = 0;
        if (arr.length >= 3) {
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] > H) {
                    H = arr[i];
                    j = i;
                }
            }
            System.out.println(j);
            if ((arr[j] != arr[0]) && (arr[j] != arr[arr.length - 1])) {
                for (int m = 1; m <= j; m++) {
                    if ((arr[m - 1] < arr[m])) {
                        vldMntupslope = true;
                    } else {
                        vldMntupslope = false;
                        break;
                    }
                }
                for (int n = j + 1; n <= arr.length - 1; n++) {
                    if ((arr[n - 1] > arr[n])) {
                        vldMntdownslope = true;
                    } else {
                        vldMntdownslope = false;
                        break;
                    }
                }
            }
        }
        boolean vldMount = vldMntupslope & vldMntdownslope;
        return vldMount;
    }

    public static void main(String[] args) {
        MountainArray m = new MountainArray();
        int[] arr = {3, 6, 5, 6, 7, 6, 5, 3, 0};
        System.out.println(m.validMountainArray(arr));
    }
}
