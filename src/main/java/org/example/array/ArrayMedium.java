package org.example.array;

public class ArrayMedium {
    public static void sortZeroOneTwo1(int[] nums) {

        // count all the zeros, ones, twos
        // insert into same error


        int zeroCount = 0;
        int oneCount = 0;
        int twoCount = 0;


        for (int i=0; i< nums.length; i++) {
            if(nums[i] == 1) oneCount++;
            if(nums[i] == 2) twoCount++;
            if(nums[i] == 0) zeroCount++;
        }

        int i =0;

        while (i< nums.length && zeroCount > 0) {

            nums[i] = 0;
            i++;
            zeroCount--;
        }
        while (i< nums.length && oneCount > 0) {

            nums[i] = 1;
            i++;
            oneCount--;
        }

        while (i< nums.length && twoCount > 0) {

            nums[i] = 2;
            i++;
            twoCount--;
        }

    }
    public static void main(String[] args) {
        int []arr = new int[]{0, 0, 1, 1, 1};

        sortZeroOneTwo1(arr);

        for(int i: arr) {
            System.out.println(i);
        }
    }
}
