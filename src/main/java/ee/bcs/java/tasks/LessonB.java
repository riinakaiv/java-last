package ee.bcs.java.tasks;

import java.util.Scanner;

public class LessonB {

    public static void main(String[] args) {
        // TODO kasuta scannerit nii, et mainist oleks võimalik kõiki meetodeid välja kutsuda
        // Täpselt nii nagu Lesson 1 main meetod

    }

    public String checkOrder(int a, int b, int c) {
        if (c > b && b > a) {
            return "increasing";
        } else if (c < b && b < a) {
            return "decreasing";
        } else {
            return "neither";

            // Print "increasing" if c > b > a
            // Print "decreasing" if c < b < a
            // Print "neither" if none of them is true
        }
    }

    public boolean checkEqual(int a, int b, int c) {
        // return true if all 3 parameters are the same
        if (a == b && b == c) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isSamll(int a) {
        // return true if the absolute number of a is smaller than 1000

        if (a < 1000 && a > -1000) {
            return true;
        } else {
            return false;
        }
    }

}
