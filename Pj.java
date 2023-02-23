
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.io.IOException;
public class Pj {

    public static void main(String[] args)throws IOException {
    
        System.out.println("a=");
        Scanner scanner = new Scanner(System.in);
        int a=scanner.nextInt();
        System.out.println("Ati introdus valoarea = "+a);
        scanner.close();
        
        BufferedReader flux_in = new BufferedReader(new InputStreamReader (System.in));
        System.out.println("Introduceti linia: ");
        String s = flux_in.readLine();
        System.out.println("Ati introdus linia: "+s);
        flux_in.close();
    }

}