package Lesson_3;

import java.util.ArrayList;
import java.util.Random;

public class Task_3 {
    public static void main(String[] args) {
        System.out.print("\033[H\033[J");
        ArrayList<Integer> intList = new ArrayList<>();
        Random randomInt = new Random();
        for (int i = 1; i <= randomInt.nextInt(5, 20); i++) {
            intList.add(randomInt.nextInt(0, 20));
        }
        intList.sort(null);
        System.out.println(intList);
        int result = 0;
        int average;
        for (int j = 0; j <= intList.size() - 1; j++) {
            result += intList.get(j);
        }
        average = result / intList.size();
        System.out.printf("""
                Минимальное значение: %d
                Максимальное значение: %d
                Среднее значение: %d""", intList.get(0), intList.get(intList.size() - 1), average);
    }
}
