/*
1. Afișarea listei de angajați folosind referințe la metode.
2. Afișarea angajaților care au salariul peste 2500 RON. Rezolvarea va utiliza stream-uri.
Interfața funcțională Predicate, care este parametrul metodei de filtrare va fi
implementată printr-o expresie Lambda.
3. Crearea unei liste cu angajații din luna aprilie, a anului trecut, care au funcție de
conducere (postul conține unul din cuvintele sef sau director). Pentru crearea unei liste
dintr-un stream se va utiliza operația terminală collect (Collectors.toList()). Se vor
utiliza steram-uri şi expresii lambda. Noua listă va fi apoi afișată. Anul curent se va citi
din sistem.
*/
/*
package Main;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.File;
import java.io.IOException;
import java.util.List;
public class Main {
    public static void scriere(List<Angajat> lista) {
        try {
            ObjectMapper mapper=new ObjectMapper();
            mapper.registerModule(new JavaTimeModule());
            File file = new File("src/main/resources/angajati.json");
            mapper.writeValue(file, lista);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Angajat> citire() {
        try {
            File file = new File("src/main/resources/angajati.json");
            ObjectMapper mapper=new ObjectMapper();
            mapper.registerModule(new JavaTimeModule());
            List<Angajat> angajats = mapper
                    .readValue(file, new TypeReference<List<Angajat>>() {
                    });
            return angajats;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
        public static void main(String[] args){
            List<Angajat> angajats = citire();
            System.out.println(angajats);
            for (Angajat a : angajats) {
                System.out.println(a);
            }

    }
}
 */

package lab5;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Angajat {
    private String nume;
    private String post;
    private LocalDate dataAngajarii;
    private double salariu;

    public Angajat(String nume, String post, LocalDate dataAngajarii, double salariu) {
        this.nume = nume;
        this.post = post;
        this.dataAngajarii = dataAngajarii;
        this.salariu = salariu;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public LocalDate getDataAngajarii() {
        return dataAngajarii;
    }

    public void setDataAngajarii(LocalDate dataAngajarii) {
        this.dataAngajarii = dataAngajarii;
    }

    public double getSalariu() {
        return salariu;
    }

    public void setSalariu(double salariu) {
        this.salariu = salariu;
    }

    @Override
    public String toString() {
        return "Angajat{" +
                "nume='" + nume + '\'' +
                ", post='" + post + '\'' +
                ", dataAngajarii=" + dataAngajarii +
                ", salariu=" + salariu +
                '}';
    }

    public static void main(String[] args) {
        List<Angajat> angajats = new ArrayList<>();
        angajats.add(new Angajat("Ion", "Sef", LocalDate.of(2019, 1, 1), 3000));
        angajats.add(new Angajat("Maria", "Director", LocalDate.of(2019, 1, 1), 4000));
        angajats.add(new Angajat("Gheorghe", "Sef", LocalDate.of(2019, 1, 1), 3000));
        angajats.add(new Angajat("Ana", "Director", LocalDate.of(2019, 1, 1), 4000));
        angajats.add(new Angajat("Mihai", "Sef", LocalDate.of(2019, 1, 1), 3000));
        angajats.add(new Angajat("Ioana", "Director", LocalDate.of(2019, 1, 1), 4000));
        angajats.add(new Angajat("Vasile", "Sef", LocalDate.of(2019, 1, 1), 3000));
        angajats.add(new Angajat("Andreea", "Director", LocalDate.of(2019, 1, 1), 4000));
        angajats.add(new Angajat("Gheorghe", "Sef", LocalDate.of(2019, 1, 1), 3000));

        angajats.forEach(System.out::println);
        System.out.println("Angajatii cu salariu peste 2500 RON:");
        Predicate<Angajat> p = a -> a.getSalariu() > 2500;
        angajats.stream().filter(p).forEach(System.out::println);
        System.out.println("Angajatii din luna aprilie, a anului trecut, care au functie de conducere:");
        Predicate<Angajat> p1 = a -> a.getPost().contains("sef") || a.getPost().contains("director");
        angajats.stream().filter(p1).collect(Collectors.toList()).forEach(System.out::println);


    }
}
