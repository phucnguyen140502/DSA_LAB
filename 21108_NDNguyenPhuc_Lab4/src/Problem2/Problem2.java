package Problem2;

import java.util.Scanner;

public class Problem2 {
    static double sum(int n){
        if (n <= 2) {
            return 1;
        } else{
            return (double) 1/(n-1) + sum(n-1);
        }
    }

    public static void main(String[] args) {
        System.out.print("Enter the number n, (n >= 1): ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.format("The sum(%d): " + sum(n),n);
    }
}
