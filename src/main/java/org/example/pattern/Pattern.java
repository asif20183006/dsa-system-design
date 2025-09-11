package org.example.pattern;

public class Pattern {

    public static void printSquareN(int n) {
        // print square n = 4
     /* 4444
        4444
        4444
        4444 */

        for(int i=0;i<n;i++){
            for (int j=0;j<n;j++){
                System.out.print(n);
            }
            System.out.println();
        }

    }


    public static void printSquareNCount(int n) {
        // print square n = 4
     /* 1234
        1234
        1234
        1234 */

        for(int i=1;i<=n;i++){
            for (int j=1;j<=n;j++){
                System.out.print(j);
            }
            System.out.println();
        }

    }


    public static void main(String[] args) {

//        printSquareN(5);

        printSquareNCount(4);
    }
}
