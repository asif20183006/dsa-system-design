package org.example.recursion;

public class BasicRecursion {


    public static void printNameTimesBackTracking(int i, int n) {
        if (i < 1) return;

        printNameTimesBackTracking(i-1, n);
        System.out.println("Asif" + i);
    }

    public static void printNameNTimes(int i, int n) {
        if (i>n) {
            return;
        }
        System.out.println("Asif" +i);
        printNameNTimes(i+1, n);
    }

    public static void printNameNTimes(int n) {
        if(n == 0) {
            return;
        }

        System.out.println("Asif" + n);

        printNameNTimes(n-1);

    }


    public static int NnumbersSum(int N) {
        //your code goes here

        if(N<0) return 0;

        return N + NnumbersSum(N-1);

    }

    public static int NnumbersSum(int N, int i) {
        //your code goes here

        if(i>N) return 0;

        return i + NnumbersSum(N, i+1);

    }

    public static void reverse(int[] arr, int n) {
        if(n < 0 ) {
            return;
        }
        System.out.println(arr[n]);
        reverse(arr, n-1);

    }


    public static int[] reverse(int i, int j, int[] arr) {

        if(i>=j) {
            return arr;
        }

        int temp = arr[i];
        arr[i]=arr[j];
        arr[j] = temp;
         return reverse(i+1, j-1, arr);

    }

    public static int[] reverse(int i, int[] arr, int n) {

        if(i>=n/2) {
            return arr;
        }

        int temp = arr[i];
        arr[i]=arr[n-i-1];
        arr[n-i-1] = temp;
        return reverse(i+1, arr, n);

    }

    public static boolean palindromeCheck(int i, String s, int n) {

        if (i>=n/2) {
            return true;
        }
        if (s.charAt(i) != s.charAt(n-i-1)) {
            return false;
        }

        return palindromeCheck(i+1, s, n);


    }

    public static boolean isPalindrome(String s) {

        s = s.toLowerCase();

        int i=0, j = s.length()-1;

        while (i<=j){

            int ic = s.charAt(i);

            if ((ic < 48 || ic > 122) || (ic < 97 && ic > 57)) {
                i++;
                continue;
            }

            int jc = s.charAt(j);
            if((jc < 48 || jc > 122) || (jc < 97 && jc>57)) {
                j--;
                continue;
            }

            if (s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;j--;
        }

        return true;

    }

    public static void main(String[] args) {

//        printNameNTimes(10);
//        printNameNTimes(1, 10);
//        printNameTimesBackTracking(3, 3);
//        System.out.println(NnumbersSum(4));
//        System.out.println(NnumbersSum(4, 1));
//        reverse(new int[]{1,2,3}, 2);
//        for (int i : reverse(0, 2, new int[]{1, 2, 3})) {
//            System.out.println(i);
//        }
//        for (int i : reverse(0,new int[]{1, 2, 3}, 3)) {
//            System.out.println(i);
//        }
//        System.out.println(palindromeCheck(0, "asifisaa", 8));

//        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(isPalindrome("ab_a"));

        String a = "0123456789abcdefghijklmnopqrstuvwxvz";

        for (int i = 0; i< a.length(); i++) {
            System.out.print((int) a.charAt(i) + " ");
        }
    }
}
