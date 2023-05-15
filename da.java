import java.util.Scanner;

public class da {
    //citire de la tastatura
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] v = new int[n];
        for(int i=0;i<n;i++)
            v[i] = sc.nextInt();
        sc.close();
        for(int i=0;i<n;i++)
            System.out.print(v[i] + " ");
            //scanner to string
        Scanner sce = new Scanner(System.in);
        String s = sce.nextLine();
        sce.close();
        System.out.println(s);
        //new line in java
        System.out.println();
        

    }
    
}
