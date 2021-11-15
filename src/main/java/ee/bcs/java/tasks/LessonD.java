package ee.bcs.java.tasks;

import java.util.Scanner;

public class LessonD {
    public static void main(String[] args) {

    }

    // Kõiki alljärgnevaid ülesandeid lahenda kasutades tsükleid
    // TODO trüki numbrid 1 -> 10
    public static void yl1() {
        int i = 1;
        while (i <= 10) {
            System.out.print(i);
            i++;
        }
    }

    // TODO trüki numbrid 10 -> 1
    public static void yl2() {
        for (int i = 11; i >= 1; i--) {
            System.out.println(i);
        }
    }

    // TODO trüki paaris numberid 2->20
    public static void yl3() {
        for (int i = 2; i <= 20; i++) {
            if (i % 2 != 0) {
                continue;
            }
            System.out.println(i);
        }
    }

    // TODO trüki numbrid 1 -> n
    public static void yl4(int n) {
        int i = 1;
        while (i <= n) {
            System.out.println(i);
            i++;
        }

    }

    // TODO trüki numbrid n -> 1
    public static void yl5(int n) {
        int i = n;
        while (i >= 1) {
            System.out.println(i);
            i--;
        }

    }

    // TODO trüki paaris numberid 2->n
    public static void yl6(int n) {
        for (int i = 2; i <= n; i++) {
            if (i % 2 != 0) {
                continue;
            }
            System.out.println(i);
        }

    }

    // TODO kasutades Scannerit loe sisse üks number, korruta see 2-ga ja trüki välja
    // TODO2 kasutades while loopi, tee seda nii kaua kuni kasutaja sisestab 0-i
    public static void yl7() {
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.println("Sisesta number");
            int a = in.nextInt();
            System.out.println("Korrutise vastus on " + (a * 2));
            if (a == 0) {
                break;
            }
        }

    }

    // TODO täienda yl1 main meetodit
    // TODO tee nii, et kasutaja saaks lõputult valida uusi valikuid
    // TODO lisa uus käsklus (exit) valikusse
    // TODO kui kasutaja valib exit käsu siis lõpeta programmi töö
    public static void yl8() {

    }

    // TODO jätka Lesson3Hard
}
