import java.io.*;
import java.util.Scanner;



public class Tema_ex2 {
        public static void main(String[] args)throws IOException {
            Scanner sc = new Scanner(new File("in.txt"));
            PrintWriter pw = new PrintWriter(new FileWriter("out.txt"));
            int min = 0, max = 0, sum = 0, count = 0;
            double avg = 0;
            while (sc.hasNextInt()) {
                int x = sc.nextInt();
                if (count == 0) {
                    min = x;
                    max = x;
                }
                if (x < min) {
                    min = x;
                }
                if (x > max) {
                    max = x;
                }
                sum += x;
                count++;
            }
            avg = (double) sum / count;
            System.out.println("Suma este: " + sum);
            System.out.println("Media aritmetica este: " + avg);
            System.out.println("Minimul este: " + min);
            System.out.println("Maximul este: " + max);
            pw.println("Suma este: " + sum);
            pw.println("Media aritmetica este: " + avg);
            pw.println("Minimul este: " + min);
            pw.println("Maximul este: " + max);
            pw.close();
        }

    }