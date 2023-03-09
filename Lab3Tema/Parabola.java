package Lab3Tema;



public class Parabola {
    private int a,b,c;

    public Parabola(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    public float getX(){
        return (float) (-b/(2*a));
    }
    public float getY(){
        return (float) (a*Math.pow(getX(), 2)+b*getX()+c);
    }
    public Punct getMijlSegmDreapta(Parabola par){
        return new Punct((this.getX() + par.getX())/2,(this.getY() + par.getY())/2);
    }
    public static Punct mijlSegmDreapta(Parabola par1, Parabola par2){
        return new Punct((par1.getX() + par2.getX())/2,(par1.getY() + par2.getY())/2);
    }

    public double getLengthSegm(Parabola par){
        return Math.hypot((par.getX()-this.getX()),(par.getY()-this.getY()));
    }

    public static double lengthSegm(Parabola par1, Parabola par2){
        return Math.hypot((par2.getX()-par1.getX()),(par2.getY()-par1.getY()));
    }
    @Override
    public String toString(){
        return "f(x)=" + a + "x^2+" + b + "x+" + c;
    }
}
