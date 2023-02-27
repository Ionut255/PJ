import java.util.Random;
import java.util.Scanner;


public class Tema_ex4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        int a = rand.nextInt(30);
        int b = rand.nextInt(30);
        System.out.println("Numerele generate aleatoriu sunt: " + a + " si " + b);
        int cmmdc = 0;
        for (int i = 1; i <= a && i <= b; i++) {
            if (a % i == 0 && b % i == 0) {
                cmmdc = i;
            }
        }
        System.out.println("Cmmdc este: " + cmmdc);
        sc.close();
    }
}