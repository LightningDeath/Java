package Lesson_1;
import java.util.Scanner;
public class Task_3 {
public static void main(String[] args){
    Scanner input = new Scanner(System.in);
    System.out.print("Введите первое число: ");
    int number_1 = input.nextInt();
    System.out.print("Введите операцию: ");
    String operator = input.next();
    System.out.print("Введите второе число: ");
    int number_2 = input.nextInt();
    int result = switch (operator) {
        case "+" -> number_1 + number_2;
        case "-" -> number_1 - number_2;
        case "*" -> number_1 * number_2;
        case "/" -> number_1 / number_2;
        default -> 0;
    };
    System.out.printf("Результат операции: %d", result);
}
}
