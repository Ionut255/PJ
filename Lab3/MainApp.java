package Lab3;
import java.util.ArrayList;
import java.util.List;
class Punct {
    private int x;
    private int y;
    public Punct(int x, int y) {
    this.x=x;
    this.y=y;
    }
    public int getX() {
    return x;
    }
    public int getY() {
    return y;
    }
    public void setX(int x) {
    this.x=x;
    }
    public void setY(int y) {
    this.y=y;
    }
    public String toString() {
    return "("+x+","+y+")";
    }
    }
    public
class MainApp {
    public static void main(String[] args) {
    List<Punct> puncte=new ArrayList<Punct>();
    puncte.add(new Punct(1,2));
    puncte.add(new Punct(3,4));
    puncte.add(new Punct(5,6));

    System.out.println("Lista contine punctele:");
    for(Punct p:puncte) {
    System.out.println(p);
    }

    puncte.remove(0);

    System.out.println("Dupa stergerea primului element "
    +"lista contine punctele:");
    for (int i=0;i<puncte.size();i++)
    System.out.println(puncte.get(i));
    }
    } 