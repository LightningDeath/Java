package Lesson_2;

import java.io.IOException;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Task_3 {
    public static void main(String[] args) throws IOException {
        Logger logger = Logger.getLogger(Task_3.class.getName());
        FileHandler fh = new FileHandler("Log.txt", true);
        logger.addHandler(fh);
        SimpleFormatter sFormat = new SimpleFormatter();
        fh.setFormatter(sFormat);
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
        logger.log(Level.INFO, number_1 + " " + operator + " " + number_2 + " = " + result);
        System.out.printf("Результат операции: %d", result);
        input.close();
    }
}
