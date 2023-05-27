package Lesson_5;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.exit;

public class Task_1 {
    public static void main(String[] args) {
        System.out.println("1 - Добавление номера, 2 - Вывод справочника, 3 - Выход");
        HashMap<String, LinkedList<Integer>> db = new HashMap<>();
        choice(db);
    }

    public static void choice(HashMap<String, LinkedList<Integer>> db) {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите параметр: ");
        try {
            int user_ch = in.nextInt();
            if (user_ch != 1 && user_ch != 2 && user_ch != 3) {
                System.out.println("Введен некорректный параметр! Попробуйте ещё раз!");
                choice(db);
            } else {
                enter(user_ch, db);
            }
        } catch (Exception e) {
            System.out.println("Введен некорректный параметр! Попробуйте ещё раз!");
            choice(db);
        }
    }

    public static void enter(int ch, HashMap<String, LinkedList<Integer>> db) {
        Scanner in = new Scanner(System.in);
        if (ch == 1) {
            System.out.print("Введите фамилию: ");
            String first_n = in.nextLine();
            if (!first_name(first_n)) {
                System.out.println("Проверьте правильность ввода фамилии! Должны быть только буквы!");
                enter(ch, db);
            }
            int number = number();
            append(first_n, number, db);
        } else if (ch == 2) {
            display(db);
        } else if (ch == 3) {
            System.out.print("Завершение работы!");
            exit(0);
        }
    }

    public static void append(String f_n, int numb, HashMap<String, LinkedList<Integer>> db) {
        //метод для добавления номера
        LinkedList<Integer> list = new LinkedList<Integer>();
        if (db.containsKey(f_n)) {
            list.addAll(db.get(f_n));
        }
        list.add(numb);
        db.put(f_n, list);
        System.out.println("Добавлено!");
        choice(db);
    }

    public static void display(HashMap<String, LinkedList<Integer>> db) {
        //метед вывода справочника в читабельном виде
        List<Integer> list;
        if (db.isEmpty()) {
            System.out.println("Справочник пуст! Сначала заполните его!");
            choice(db);
        } else {
            for (String keys : db.keySet()) {
                list = db.get(keys);
                keys += ": ";
                StringBuilder keysBuilder = new StringBuilder(keys);
                for (int i = 0; i < list.size() - 1; i++) {
                    keysBuilder.append(list.get(i)).append(", ");
                }
                keysBuilder.append(list.get(list.size() - 1));
                keys = keysBuilder.toString();
                System.out.println(keys);
            }
            choice(db);
        }
    }

    public static boolean first_name(String name) {
        //метод проверки введеной фамилии на отсутствие символов, отличных от букв
        for (int i = 0; i < name.length(); i++) {
            if (!Character.isLetter(name.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static int number() {
        //метод для проверки введенного номера на число
        Scanner in = new Scanner(System.in);
        int number;
        try {
            System.out.print("Введите номер: ");
            number = in.nextInt();
        } catch (Exception e) {
            System.out.println("Неверный формат ввода! Номер телефона должен состоять из цифр!");
            return number();
        }
        return number;
    }
}
