import java.util.Random;
import java.util.Scanner;

public class Tema_ex5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        int n = rand.nextInt(20);
        System.out.println("Numarul generat aleatoriu este: " + n);
        int a = 0, b = 1, c = 1;
        while (c < n) {
            a = b;
            b = c;
            c = a + b;
        }
        if (c == n) {
            System.out.println("Numarul apartine sirului lui Fibonacci");
        } else {
            System.out.println("Numarul nu apartine sirului lui Fibonacci");
        }
        sc.close();
    }
    
}
