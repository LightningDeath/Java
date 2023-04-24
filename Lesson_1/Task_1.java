package Lesson_1;

import java.util.Scanner;

/**
 * task
 */
public class Task_1 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Введите число: ");
        int n = input.nextInt();

        System.out.printf("\nТреугольное число %d: ", n);
        int res = (n * (n+1)) / 2;
        System.out.printf("%d ", res);

        int res_1 = 1;
        for (int i = 2; i <= n; i++){
            res_1 = res_1 * i;
        }
        System.out.printf("\n\nПроизведение чисел от 1 до %d: \n", n);
        System.out.println(res_1);
    }
}