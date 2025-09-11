package org.example.basicmath;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class BasicMaths {
    public static int countDigit(int n) {
        int count = 1;
        while(n/10 != 0) {
            n/=10;
            count++;
        }
        return count;
    }

    public static int reverseNumber1(int n) {

        StringBuilder ans = new StringBuilder();
        while (n/10 != 0) {
            ans.append(n % 10);
            n/=10;
        }

        ans.append(n);

        return Integer.parseInt(ans.toString());


    }
    public static int reverseNumber(int n) {

        long ans = 0;
        while (n != 0) {

            ans = ans * 10 + n%10;
            n/=10;

        }

        if (Integer.MAX_VALUE < ans || Integer.MIN_VALUE > ans) {
            return 0;
        }

        return (int) ans;


    }

    public static boolean isPalindrome(int n) {


         return reverseNumber(n) == n;

    }

    public static int GCD(int n1, int n2) {
        AtomicInteger a = new AtomicInteger(n1);

        List<Integer> l1 = Stream.generate(a::getAndDecrement).limit(n1).filter(d->n1%d == 0).toList();
        a.set(n2);
        List<Integer> l2 = Stream.generate(a::getAndDecrement).limit(n2).filter(d->n2%d == 0).toList();
        System.out.println(l1);
        System.out.println(l2);

        Optional<Integer> first = l1.stream().filter(s -> l2.stream().anyMatch(m -> Objects.equals(s, m))).findFirst();


        return first.get();


    }

    public static int GCD1(int a, int b) {

        int min = Math.min(a, b);

        for (int i = min; i>1; i--) {
            if (a%i == 0 && b%i==0) {
                return i;
            }
        }

        return 1;

    }

    public static int eclidAlgoGCD (int a, int b) {


        while (a > 0 && b> 0) {
            if (a>b) a = a%b;
            else b=b%a;
        }

        if (a == 0) return b;
        else return a;
    }

    public static boolean isArmstrong(int n) {

        int sum = 0;

        int num = n;

        int count = 0;

        List<Integer> list = new ArrayList<>();

        while (n > 0) {
            int d = n%10;
            list.add(d);
            n/=10;
            count++;
        }

        int finalCount = count;
        Integer reduce = list.stream().map(a -> {
            int p = 1;
            for (int i = 1; i <= finalCount; i++) {
                p *= a;
            }
            return p;
        }).reduce(0, Integer::sum);


        if (num == reduce) {
            return true;
        }

        return false;
    }


    public static boolean isPrime(int n) {

        for (int i = 2; i< n-1; i++) {
            if (n%i == 0) return true;
        }


        return false;
    }

    public static boolean isPrime1(int n) {

        for (int i = 2; i< Math.sqrt(n); i++) {
            if (n%i == 0) return true;
        }


        return false;
    }

    public static void printAllDivisor(int n) {

        for (int i = 1; i<=Math.sqrt(n); i++) {
            if (n%i == 0) {
                System.out.println(i);

                if (n/i != i) System.out.println(n/i);
            }

        }

    }

    public static void main(String[] args) {
//        System.out.println(countDigit(419999));

//        System.out.println(eclidAlgoGCD(10, 20));


//        System.out.println(isArmstrong(12));

//        System.out.println(isPrime1(3));
        printAllDivisor(36);
    }


}
