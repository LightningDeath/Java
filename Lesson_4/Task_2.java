package Lesson_4;

import java.util.LinkedList;
//import java.util.Queue;
import java.util.Queue;
import java.util.Random;
import java.util.Scanner;

public class Task_2 {
    Scanner in = new Scanner(System.in);
    LinkedList<Integer> list = new LinkedList<>();
    Task_2() {
        Random randomInt = new Random();
        for (int i = 1; i <= randomInt.nextInt(3, 10); i++) {
            list.add(randomInt.nextInt(0, 20));
        }
    }
    void enqueue(){
        int num;
        System.out.println("\nВведите число которое хотите добавить в очередь:");
        num = in.nextInt();
        list.add(num);
        System.out.println("Новая очередь:");
        System.out.println(list);
    }
    void first(){
        System.out.println("\nПервый элемент очереди:");
        System.out.println(list.get(0));
    }
    void denqueue(){
        System.out.print("\nУдаление первого элемента очереди: ");
        System.out.println(list.get(0));
        list.remove(0);
        System.out.println("Новая очередь:");
        System.out.println(list);
    }
    void print(){
        System.out.println("\nТекущая очередь:");
        System.out.println(list);
    }

    public static void main(String[] args) {
        System.out.print("\033[H\033[J");
        Task_2 q = new Task_2();
        q.print();
        q.enqueue();
        q.denqueue();
        q.first();
    }

}
