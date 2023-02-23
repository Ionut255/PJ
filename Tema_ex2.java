import java.io.*;
import java.util.Scanner;

public class Tema_ex2 {

    /**
     * @param args
     * @throws IOException
     */
    public static void main(String[] args)throws IOException {
        
        File inf = new File("in.txt");
        FileInputStream inputStream = new FileInputStream(inf);
        Scanner sc = new Scanner(inputStream);
        StringBuffer buffer = new StringBuffer();
        while (sc.hasNextLine()) {
            buffer.append(""+sc.nextLine());
        }
        System.out.println("Continutu fisierului este: "+buffer);
        File outf = new File("out.txt");
        FileWriter = new FileWriter(outf);
        Writer.write(buffer.toString());
        Writer.close();
        sc.close();
        inputStream.close();

        

    }