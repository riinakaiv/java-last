package ee.bcs.java.tasks;

public class LessonC {
    public static void main(String[] args) {

    }

    // TODO korruta omavahel x ja z ning liida sellele y ja z korrutis
    public static int testMath(int x, int y, int z) {
        return (x * z) + (y * z);
    }

    // TODO kui mitu paaris arvu on sisendites
    public static int testStuff(int a, int b, int c, int d, int e, int f, int g) {
        int count = 0;
        if (a % 2 == 0) {
            count++;
        }
        if (b % 2 == 0) {
            count++;
        }
        if (c % 2 == 0) {
            count++;
        }
        if (d % 2 == 0) {
            count++;
        }
        if (e % 2 == 0) {
            count++;
        }
        if (f % 2 == 0) {
            count++;
        }
        if (g % 2 == 0) {
            count++;
        }
        return count;
    }

    public static boolean userValidation(boolean emailValid, boolean telephoneValid, boolean addressValid) {
        // tagasta true, kui muutuja addressValid on tõene ja vähemalt üks (emailValid või telephoneValid) on tõene
        return addressValid && (emailValid || emailValid);
    }
}
