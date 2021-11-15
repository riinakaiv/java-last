package ee.bcs.java;

public class Demo {
    public static void main(String[] args) {
        String qwerty = "Hello väärtus";
        //sellega defineerid muutuja, mis toimib ainult selles koodiblokis
        System.out.println(qwerty);
        qwerty = "midagi muud";
        System.out.println(qwerty);
        //midagi mida ignoreeritakse
        System.out.println("Tere veel");
    }
}

