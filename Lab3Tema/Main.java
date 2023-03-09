package Lab3Tema;
/* 
 * 1. Funcţia f x = ax + bx + c
2
)( are ca grafic o parabolă cu vârful de coordonate
Se cere să se definească o clasă Parabola ai cărei membri vor fi:
• 3 variabile de tip int care reprezintă coeficienţii a, b şi c
• un constructor cu 3 parametrii de tip int
• se va redefini metoda toString() din clasa Object, astfel încât să returneze un String de
forma f(x) = a x^2 + b x + c. Caracteristicile a, b și c ale parabolei se vor înlocui cu
valorile efective. Metoda va fi utilizată pentru afișarea parabolei sub forma unei funcții
• o metodă care primește ca și parametru de intrare o parabolă și returneză coordonatele
mijlocului segmentului de dreptă care uneşte vârful parabolei curente cu varful
parabolei transmisă ca și parametru de intrare
• o metodă statică ce primeşte ca parametri de intrare două parabole şi calculează
coordonatele mijlocului segmentului de dreptă care uneşte vârfurile celor două parabole.
• o metodă care primește ca și parametru de intrare o parabolă și returneză lungimea
segmentului de dreptă care unește vârful parabolei curente cu varful parabolei transmisă
ca și parametru de intrare. Se va utiliza metoda statică Math.hypot
• o metodă statică care primește ca și parametri de intrare două parabole și calculează
lungimea segmentului de dreapta ce unește vârfurile celor două parabole. Se va utiliza
metoda statică Math.hypot
Coordonatele mijlocului segmentului de drepta care uneste varfurile a două parabole se
calculează în felul următor:
x y sunt coordonatele vârfului
primei parabole, iar ( , ) 2 2
x y descriu vârful celei de a doua parabole.
Lungimea segmentului care unește vârfurile a două parabole se calculează în felul
următor: ( − )
 + (	 − 	)

Fișierul de intrare in.txt conține mai multe linii, pe fiecare linie aflându-se coeficienții
unei parabole. Să se citească informația din fișierul de intrare și pentru fiecare linie să se creeze
câte un obiect de tip Parabola care se va adăuga unei colecții de tip List. Colecția va fi apoi
traversată și pentru fiecare element se va afișa parabola sub forma unei funcții și apoi vârful
parabolei. Pentru două parabole din colecție se va afișa mijlocul segmentului care le unește
vârfurile și lungimea segmentului care le unește vârfurile apelând metodele dezvoltate în clasa
Parabola.
*/
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static Lab3Tema.Parabola.lengthSegm;
import static Lab3Tema.Parabola.mijlSegmDreapta;

public class Main {
    public static List<Parabola> parabolaList = new ArrayList<>();
    public static void main(String[] args) throws FileNotFoundException {
        readFile();
        for (Parabola par:parabolaList) {
            Punct p = new Punct(par.getX(),par.getY());
            System.out.println(par + "\tVarf: " + p);
        }
        System.out.println("Parabola 0 si 1:\nMijlocul segmentului: " + mijlSegmDreapta(parabolaList.get(0),parabolaList.get(1)) + "\nLungimea segmentului: " + lengthSegm(parabolaList.get(0),parabolaList.get(1)));
        System.out.println("Parabola 2 si 3:\nMijlocul segmentului: " + parabolaList.get(2).getMijlSegmDreapta(parabolaList.get(3)) + "\nLungimea segmentului: " + parabolaList.get(2).getLengthSegm(parabolaList.get(3)));
    }


    private static void readFile() throws FileNotFoundException{
        String fileName = "C:/Users/Ionut255/Documents/GitHub/PJ/Lab3Tema/in.txt";
        Scanner input=new Scanner(new File(fileName));
        while(input.hasNextLine())
        {
            int a = input.nextInt();
            int b = input.nextInt();
            int c = input.nextInt();
            Parabola p = new Parabola(a, b, c);
            parabolaList.add(p);
        }

    }


    
}
