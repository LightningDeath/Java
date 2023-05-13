package Lesson_4;


import java.util.Deque;
import java.util.LinkedList;
import java.util.Random;

public class Task_1 {
    public static void main(String[] args){
        System.out.print("\033[H\033[J");
        LinkedList<Integer> intList = new LinkedList<>();
        Random randomInt = new Random();
        for (int i = 1; i <= randomInt.nextInt(3, 10); i++) {
            intList.add(randomInt.nextInt(0, 20));
        }
        System.out.println("Оригинальный список: ");
        System.out.println(intList);
        System.out.println("Перевернутый список: ");
        System.out.println(revers(intList));
    }
    public static LinkedList<Integer> revers(LinkedList<Integer> args){
        Deque<Integer> intList_new = new LinkedList<>();
        for (int i = 0; i <= args.size()-1; i++) {
            intList_new.push(args.get(i));
        }
        args.clear();
        while(!intList_new.isEmpty()) {
            args.add(intList_new.pop());
        }
        return args;
    }
}
