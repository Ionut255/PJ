package Random;
import java.io.*;
import java.util.Scanner;


public class Team_ex3 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduceti un numar natural: ");
        int n = sc.nextInt();
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                System.out.println(i);
                count++;
            }
        }
        if (count == 2) {
            System.out.println("Numarul este prim");
        }
        sc.close();
    }
}