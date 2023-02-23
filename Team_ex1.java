import java.util.Scanner;


public class Team_ex1 {

    public static void main(String[] args) {
        System.out.println("L=");
        Scanner scanner = new Scanner(System.in);
        int L=scanner.nextInt();
        System.out.println("l=");
        Scanner scanner1 = new Scanner(System.in);
        int l=scanner1.nextInt();
       
        int A=L*l;
        int P=2*(L+l);
        System.out.println("Aria este = "+A);
        System.out.println("Perimetru este = "+P);
        scanner.close();
        scanner1.close();
    }




    

}