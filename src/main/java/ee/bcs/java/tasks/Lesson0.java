package ee.bcs.java.tasks;

import java.util.Scanner;

public class Lesson0 {
    public static void main(String[] args) {
        Scanner todo = new Scanner(System.in);
        System.out.println("Millist tehet soovite järgmisena teha");
        System.out.println("1 - Korrutada");
        System.out.println("2 - Jagada");
        System.out.println("3 - Liita");
        System.out.println("4 - Lahutada");
        System.out.println("5 - Leida jagatist");
        String choise = todo.next();
        if (choise.equals("1")) {
            System.out.println("Soovin korrutada");
            System.out.println("Sisesta esimene arv");
            int a = todo.nextInt();
            System.out.println("Sisesta teine arv");
            int b = todo.nextInt();
            System.out.println("Korrutise vastus on " + (a * b));
        } else if (choise.equals("2")) {
            System.out.println("Soovin jagada");
            System.out.println("Sisesta esimene arv");
            int a = todo.nextInt();
            System.out.println("Sisesta teine arv");
            int b = todo.nextInt();
            System.out.println("Jagatise vastus on " + (a / b));
        } else if (choise.equals("3")) {
            System.out.println("Soovin liita");
            System.out.println("Sisesta esimene arv");
            int a = todo.nextInt();
            System.out.println("Sisesta teine arv");
            int b = todo.nextInt();
            System.out.println("Jagatise vastus on " + (a + b));
        } else if (choise.equals("4")) {
            System.out.println("Soovin lahutada");
            System.out.println("Sisesta esimene arv");
            int a = todo.nextInt();
            System.out.println("Sisesta teine arv");
            int b = todo.nextInt();
            System.out.println("Jagatise vastus on " + (a - b));
        } else if (choise.equals("5")) {
            System.out.println("Soovin leida jagatist");
            System.out.println("Sisesta esimene arv");
            int a = todo.nextInt();
            System.out.println("Sisesta teine arv");
            int b = todo.nextInt();
            System.out.println("Jagatise vastus on " + (a % b));
        }
    }

    // TODO
    //  defineeri 3 muutujat a = 1, b = 1, c = 3
    //  Prindi välja a==b
    //  Prindi välja a==c
    //  Lisa rida a = c
    //  Prindi välja a==b
    //  Prindi välja a==c, mis muutus???
    public static void excersie1() {
        int a = 1;
        int b = 1;
        int c = 3;
        System.out.println(a == b);
        System.out.println(a == c);
        a = c; // a = 3; b = 1; c = 3
        System.out.println(a == b);
        System.out.println(a == c);

    }

    // TODO
    //  Loo muutujad x1 = 10 ja x2 = 20, vali sobiv andmetüüp
    //  Tekita muutuja y1 = ++x1, trüki välja nii x1 kui y1
    //  Tekita muutuja y2 = x2++, trüki välja nii x2 ja y2
    //  Analüüsi tulemusi
    public static void excersie2() {
        int x1 = 10;
        int x2 = 20;
        int y1 = ++x1; //++x1  - x = x +1
        int y2 = x2++;
        // 1) x1 = x1 + 1
        // 2) x2 = x2 + 1
        System.out.println("x1: " + x1);
        System.out.println("y1: " + y1);
        System.out.println("x2: " + x2);
        System.out.println("y2: " + y2);
    }

    // TODO
    //  Loo arvulised muutujad
    //  a = 18 % 3
    //  b = 19 % 3
    //  c = 20 % 3
    //  d = 21 % 3
    //  Prindi välja kõigi muutujate väärtused
    public static void excersie3() {
        int a = 18 % 3;
        int b = 19 % 3;
        int c = 20 % 3;
        int d = 21 % 3;
        System.out.println("a: " + a);
        System.out.println("b: " + b);
        System.out.println("c: " + c);
        System.out.println("d: " + d);
    }
}
