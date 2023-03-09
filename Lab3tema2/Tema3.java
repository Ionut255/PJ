/*2. Să se scrie un program care citește din fișierul produse.csv informații referitoare la
produsele dintr-un magazin. Pe fiecare linie se află: denumirea produsului, preţul (număr real)
cantitatea (număr întreg), data expirării (LocalDate). Cele patru elemente sunt separate prin
caracterul "," (zahar, 1.5, 50, 2024-02-25). Pentru fiecare rând citit se va crea un obiect de tip
Produs care se va adăuga unei colecții de obiecte de tip List. Se va defini o clasă Produs care
va conține: variabile membre private corespunzătoare celor trei elemente care descriu un produs,
cel puţin un constructor, gettere si settere în funcție de necesități şi redefinirea metodei toString()
din clasa Object, metodă care va fi utilizată pentru afișarea produselor.
Să se realizeze un program care va dispune de un meniu și va implementa următoarele
cerințe:
a) afișarea tuturor produselor din colecția List
b) afișarea produselor expirate
c) vânzarea unui produs, care se poate realiza doar dacă există suficientă cantitate pe stoc.
Daca produsul ajunge la cantitate zero, se elimina din listă. În clasa Produs se va declara
o variabilă statica încasări care se va actualiza la fiecare vânzare a unui produs, luând în
considerare prețul produsului vândut şi cantitatea vândută .
d) afișarea produselor cu prețul minim (pot fi mai multe cu același preț)
e) salvarea produselor care au o cantitate mai mică decât o valoare citită de la tastatură
într-un fișier de ieșire. */
package Lab3tema2;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors; 


public class Tema3{
    public static void main(String[] args) throws IOException {
        List<Produs> produse = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("C:/Users/Ionut255/Documents/GitHub/PJ/Lab3tema2/produse.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                produse.add(new Produs(values[0], Double.parseDouble(values[1]), Integer.parseInt(values[2]), LocalDate.parse(values[3])));
            }
        }
        Scanner sc = new Scanner(System.in);
        int optiune = 0;
        while (optiune != 6) {
            System.out.println("1. Afisare produse");
            System.out.println("2. Afisare produse expirate");
            System.out.println("3. Vanzare produs");
            System.out.println("4. Afisare produse cu pret minim");
            System.out.println("5. Salvare produse cu cantitate mai mica decat o valoare citita de la tastatura");
            System.out.println("6. Iesire");
            System.out.print("Optiune: ");
            optiune = sc.nextInt();
            switch (optiune) {
                case 1:
                    produse.forEach(System.out::println);
                    break;
                case 2:
                    produse.stream().filter(p -> p.getDataExpirare().isBefore(LocalDate.now())).forEach(System.out::println);
                    break;
                case 3:
                    System.out.print("Denumire produs: ");
                    String denumire = sc.next();
                    System.out.print("Cantitate: ");
                    int cantitate = sc.nextInt();
                    Produs produs = produse.stream().filter(p -> p.getDenumire().equals(denumire)).findFirst().orElse(null);
                    if (produs != null) {
                        if (produs.getCantitate() >= cantitate) {
                            produs.setCantitate(produs.getCantitate() - cantitate);
                            Produs.setIncasari(Produs.getIncasari() + produs.getPret() * cantitate);
                            if (produs.getCantitate() == 0) {
                                produse.remove(produs);
                            }
                        } else {
                            System.out.println("Nu exista suficienta cantitate");
                        }
                    } else {
                        System.out.println("Nu exista produsul");
                    }
                    break;
                case 4:
                    double pretMinim = produse.stream().mapToDouble(Produs::getPret).min().orElse(0);
                    produse.stream().filter(p -> p.getPret() == pretMinim).forEach(System.out::println);
                    break;
                case 5:
                    System.out.print("Valoare: ");
                    int valoare = sc.nextInt();
                    List<Produs> produseFiltrate = produse.stream().filter(p -> p.getCantitate() < valoare).collect(Collectors.toList());
                    produseFiltrate.forEach(System.out::println);
                    break;
                case 6:
                    break;
                default:
                    System.out.println("Optiune invalida");
                    break;
                }
            }
            sc.close();
        }
    }
