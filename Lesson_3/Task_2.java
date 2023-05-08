package Lesson_3;

import java.util.ArrayList;
import java.util.Random;

public class Task_2 {
    public static void main(String[] args) {
        System.out.print("\033[H\033[J");
        ArrayList<Integer> intList = new ArrayList<>();
        Random randomInt = new Random();
        for (int i = 0; i <= 10; i++) {
            intList.add(randomInt.nextInt(0, 20));
        }
        System.out.println(intList);
        for (int i = intList.size()-1; i >= 0; i--) {
            if (intList.get(i) % 2 == 0) {
                intList.remove(i);
            }
        }
        System.out.println(intList);
        }

    }

