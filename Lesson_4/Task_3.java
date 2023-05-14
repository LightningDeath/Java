package Lesson_4;


import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

import static java.lang.System.exit;

public class Task_3 {
    public static void main(String[] args) {
        Deque<Integer> q = new LinkedList<>();
        System.out.println("Для выхода введите 'Выход' в поле 'Введите операцию', " +
                "для отмены последней операции 'Отмена'");
        first_enter(q);
    }


    public static void first_enter(Deque<Integer> q) {
        Scanner input = new Scanner(System.in);
        try {
            System.out.print("Введите число: ");
            int number_1 = input.nextInt();
            q.add(number_1);
            System.out.print("Введите операцию: ");
            String operator = input.next();
            if (!operator.equals("+") && !operator.equals("-") && !operator.equals("*") && !operator.equals("/") &&
                    !operator.equalsIgnoreCase("Отмена") && !operator.equalsIgnoreCase("Выход")) {
                System.out.println("Введены некорректные данные! Попробуйте еще раз!");
                enter(number_1, 0, q);
            } else if (operator.equalsIgnoreCase("Выход")) {
                System.out.println("Завершение работы! Всего доброго!");
                exit(0);
            } else if (operator.equalsIgnoreCase("Отмена")) {
                System.out.println("Пока нет результата для отмены. Продолжайте ввод.");
                enter(number_1, 0, q);
            }
            System.out.print("Введите число: ");
            int number_2 = input.nextInt();
            calc(number_1, number_2, operator, q);
        } catch (Exception e) {
            System.out.println("Введены некорректные данные! Попробуйте ещё раз!");
            first_enter(q);
        }
        input.close();
    }

    public static void enter(int numb_1, int flag, Deque<Integer> q) {
        Scanner input = new Scanner(System.in);
        if (flag == 0) {
            try {
                System.out.print("Введите операцию: ");
                String operator = input.next();
                if (!operator.equals("+") && !operator.equals("-") && !operator.equals("*") && !operator.equals("/") &&
                        !operator.equalsIgnoreCase("Отмена") && !operator.equalsIgnoreCase("Выход")) {
                    System.out.println("Введены некорректные данные! Попробуйте еще раз!");
                    enter(numb_1, 0, q);
                } else if (operator.equalsIgnoreCase("Выход")) {
                    System.out.println("Завершение работы! Всего доброго!");
                    exit(0);
                } else if (operator.equalsIgnoreCase("Отмена")) {
                    System.out.println("Пока нет результата для отмены. Продолжайте ввод.");
                    enter(numb_1, 0, q);
                }
                System.out.print("Введите число: ");
                int number_2 = input.nextInt();
                calc(numb_1, number_2, operator, q);
            } catch (Exception e) {
                System.out.println("Введены некорректные данные! Попробуйте ещё раз!");
                enter(numb_1, 0, q);
            }
            input.close();
        } else if (flag == 1) {
            try {
                System.out.print("Введите операцию: ");
                String operator = input.next();
                if (!operator.equals("+") & !operator.equals("-") & !operator.equals("*") & !operator.equals("/") &
                        !operator.equalsIgnoreCase("Отмена") & !operator.equalsIgnoreCase("Выход")) {
                    System.out.println("Введены некорректные данные! Попробуйте еще раз!");
                    enter(numb_1, 0, q);
                } else if (operator.equalsIgnoreCase("Выход")) {
                    System.out.println("Завершение работы! Всего доброго!");
                    exit(0);
                } else if (operator.equalsIgnoreCase("Отмена")) {
                    calc(numb_1, 0, operator, q);
                }
                System.out.print("Введите число: ");
                int number_2 = input.nextInt();
                calc(numb_1, number_2, operator, q);
            } catch (Exception e) {
                System.out.println("Введены некорректные данные! Попробуйте ещё раз!");
                enter(numb_1, 1, q);
            }
            input.close();
        }
    }

    public static void calc(int vol_1, int vol_2, String operator, Deque<Integer> q) {
        if (operator.equalsIgnoreCase("Отмена") && !q.isEmpty()) {
            int rem = q.getLast();
            q.removeLast();
            vol_1 = q.getLast();
            System.out.printf("Отмена-> %d\n", rem);
            System.out.println(q);
            enter(vol_1, 1, q);
        } else {
            int result = switch (operator) {
                case "+" -> vol_1 + vol_2;
                case "-" -> vol_1 - vol_2;
                case "*" -> vol_1 * vol_2;
                case "/" -> vol_1 / vol_2;
                default -> 0;
            };
            q.add(result);
            System.out.println(q);
            System.out.println("Ответ:");
            System.out.println(result);
            enter(result, 1, q);
        }
    }
}

