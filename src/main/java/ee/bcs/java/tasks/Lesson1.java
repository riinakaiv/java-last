package ee.bcs.java.tasks;


import java.util.Scanner;

// TODO kasuta if/else. Ära kasuta Math librarit
public class Lesson1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.println("Sisesta number millisest funktsioonist tahad käivitada");
            System.out.println("1 - min");
            System.out.println("2 - max");
            System.out.println("3 - abs");
            System.out.println("4 - isEven");
            System.out.println("5 - min3");
            System.out.println("6 - max3");
            System.out.println("7 - someString");
            System.out.println("8 - exit");
            int choise = in.nextInt();
            if (choise == 1) {
                System.out.println("Min:");
                System.out.println("Sisesta a");
                int a = in.nextInt();
                System.out.println("Sisesta b");
                int b = in.nextInt();
                System.out.println("Miinimun a-st ja b-st: on " + min(a, b));
            } else if (choise == 2) {
                System.out.println("Max:");
                System.out.println("Sisesta a");
                int a = in.nextInt();
                System.out.println("Sisesta b");
                int b = in.nextInt();
                System.out.println("Maksimum a-st ja b-st: on " + max(a, b));
            } else if (choise == 3) {
                System.out.println("Abs:");
                System.out.println("Sisesta arv");
                int a = in.nextInt();
                System.out.println("Absoluutarv on " + abs(a));
            } else if (choise == 4) {
                System.out.println("isEvan:");
                System.out.println("Sisesta arv");
                int a = in.nextInt();
                if (isEven(a)) {
                    System.out.println("Arv on paaris");
                } else {
                    System.out.println("Arv on paaritu");
                }
            } else if (choise == 5) {
                System.out.println("Min3:");
                System.out.println("Sisesta a");
                int a = in.nextInt();
                System.out.println("Sisesta b");
                int b = in.nextInt();
                System.out.println("Sisesta c");
                int c = in.nextInt();
                System.out.println("Miinimum a-st, b-st ja c-st: on " + min3(a, b, c));
            } else if (choise == 6) {
                System.out.println("Max3:");
                System.out.println("Sisesta a");
                int a = in.nextInt();
                System.out.println("Sisesta b");
                int b = in.nextInt();
                System.out.println("Sisesta c");
                int c = in.nextInt();
                System.out.println("Maksimum a-st, b-st ja c-st: on " + max3(a, b, c));
            } else if (choise == 7) {
                System.out.println(someString());
            } else if (choise == 8) {
                break;
            } else {
                System.out.println("Tundmatu käsklus");
            }

        }
    }


    // TODO tagasta a ja b väikseim väärtus
    public static int min(int a, int b) {
        if (a < b) {
            return a;
        } else {
            return b;
        }
    }

    // TODO tagasta a ja b suurim väärtus
    public static int max(int a, int b) {
        if (a > b) {
            return a;
        } else {
            return b;
        }
    }

    // TODO tagasta a absoluut arv
    public static int abs(int a) {
        if (a < 0) {
            return -a;
        } else {
            return a;
        }
    }

    // TODO tagasta true, kui a on paaris arv
    // tagasta false kui a on paaritu arv
    public static boolean isEven(int a) {
        if (a % 2 == 0) {
            return true;
        } else {
            return false;
        }
    }

    // TODO tagasta kolmest arvust kõige väiksem
    public static int min3(int a, int b, int c) {
        if (a <= b && a <= c) {
            return a;
        } else if (b <= a && b <= c) {
            return b;
        } else {
            return c;
        }
    }

    // TODO tagasta kolmest arvust kõige suurem
    public static int max3(int a, int b, int c) {
        return max(a, max(b, c));
    }

    // TODO
    //  Tagasta string mille väärtus oleks "\"\\""
    //  Trüki muutuja sisu välja
    public static String someString() {
        return "\"\\\"\\\\\"\"";
    }

}
