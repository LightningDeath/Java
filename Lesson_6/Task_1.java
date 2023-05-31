package Lesson_6;

import java.util.*;

import static java.lang.System.exit;

public class Task_1 {
    public static String choiceParameters(ArrayList<Notebook> listNotebook) {
        HashSet<String> listManufacturer = new HashSet<>();
        HashSet<String> listOS = new HashSet<>();
        HashSet<String> listColor = new HashSet<>();
        for (Notebook a : listNotebook) {
            listManufacturer.add(a.getManufacturer());
            listOS.add(a.getOs());
            listColor.add(a.getColor());
        }
        Scanner in = new Scanner(System.in);
        System.out.println("""
                Выберите категорию поиска:
                 1 - Производитель;
                 2 - Объем ОЗУ;
                 3 - Объем HDD;
                 4 - Операционная система;
                 5 - Цвет;
                 6 - Посмотреть все доступные ноутбуки;
                 7 - Выход.""");
        System.out.print("Введите Ваш выбор: ");
        try {
            int choice = in.nextInt();
            if (choice == 1) {
                manufacturerParameters(listManufacturer, listNotebook);
            } else if (choice == 2) {
                ramParameters(listNotebook);
            } else if (choice == 3) {
                hddParameters(listNotebook);
            } else if (choice == 4) {
                osParameters(listOS, listNotebook);
            } else if (choice == 5) {
                colorParameters(listColor, listNotebook);
            } else if (choice == 6) {
                displayAll(listNotebook);
            } else if (choice == 7){
                exit(0);
            }else{
                System.out.println("Введен некорректный параметр! Попробуйте ещё раз.");
                choiceParameters(listNotebook);
            }
        } catch (Exception e) {
            System.out.println("Введен некорректный параметр! Попробуйте ещё раз.");
            choiceParameters(listNotebook);
        }
        return null;
    }

    public static void manufacturerParameters(HashSet<String> lm, ArrayList<Notebook> l) {
        Scanner in = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        System.out.println("Выбирите и введите производителей из доступных");
        System.out.print("в наличии: ");
        for (String s : lm) {
            sb.append(s).append(", ");
        }
        sb.deleteCharAt(sb.length() - 2);
        System.out.println(sb);
        System.out.print("Введите Ваш выбор: ");
        String a = in.nextLine();
        a = a.substring(0, 1).toUpperCase() + a.substring(1).toLowerCase();
        if (lm.contains(a)) {
            for (Notebook s : l) {
                if (s.getManufacturer().equalsIgnoreCase(a)) {
                    System.out.println(s);
                }
            }
        } else if (a.equalsIgnoreCase("hp")) {
            a = a.toUpperCase();
            for (Notebook s : l) {
                if (s.getManufacturer().equalsIgnoreCase(a)) {
                    System.out.println(s);
                }
            }
        } else {
            System.out.println("Данной позиции нет на складе! Либо введено верное название!");
            manufacturerParameters(lm, l);
        }
        System.out.println("Хотите повторить поиск по другим параматрам?(да/нет)");
        if (yesOrNo()) {
            choiceParameters(l);
        } else {
            exit(0);
        }
    }

    public static void ramParameters(ArrayList<Notebook> l) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите желаемый объем ОЗУ в пределах от 4 Гб до 32 Гб включительно");
        System.out.print("Введите Ваш выбор: ");
        try {
            int ramSize = in.nextInt();
            if (ramSize == 4 | ramSize == 8 | ramSize == 16 | ramSize == 24 | ramSize == 32) {
                for (Notebook n : l) {
                    if (n.getRam() == ramSize) {
                        System.out.println(n);
                    }
                }
            } else {
                System.out.println("Ноутбука с таким параметром нет:( Можете попробовать выбрать диапазон значений!\n Пробуем?(да/нет)");
                if (yesOrNo()) {
                    rangeParameters(l, "ОЗУ", 4, 32);
                }
            }
        } catch (Exception e) {
            System.out.println("Не верный ввод! Попробуйте еще раз!");
            ramParameters(l);
        }
        System.out.println("Хотите повторить поиск по другим параматрам?(да/нет)");
        if (yesOrNo()) {
            choiceParameters(l);
        } else {
            exit(0);
        }
    }

    public static void rangeParameters(ArrayList<Notebook> l, String a, int minVol, int maxVol) {
        Scanner in = new Scanner(System.in);
        int min = 0;
        int max = 0;
        try {
            System.out.printf("Введите минимальный объем %s(мин. %d Гб): ", a, minVol);
            min = in.nextInt();
            System.out.printf("Введите максимальный объем %s(макс. %d Гб): ", a, maxVol);
            max = in.nextInt();
            if (min < minVol) {
                System.out.printf("Введены неверные данные! Минимальный объем %d Гб, максимальный %d Гб!", minVol, maxVol);
                rangeParameters(l, a, minVol, maxVol);
            } else if (max > maxVol) {
                System.out.printf("Введены неверные данные! Минимальный объем %d Гб, максимальный %d Гб!", minVol, maxVol);
                rangeParameters(l, a, minVol, maxVol);
            } else if (max < minVol) {
                System.out.printf("Введены неверные данные! Минимальный объем %d Гб, максимальный %d Гб!", minVol, maxVol);
                rangeParameters(l, a, minVol, maxVol);
            } else if (min > maxVol) {
                System.out.printf("Введены неверные данные! Минимальный объем %d Гб, максимальный %d Гб!", minVol, maxVol);
                rangeParameters(l, a, minVol, maxVol);
            }
        } catch (Exception e) {
            System.out.println("Введены неверные данные! попробуйте еще раз!");
            rangeParameters(l, a, minVol, maxVol);
        }
        if (a.equalsIgnoreCase("ОЗУ")) {
            for (Notebook n : l) {
                if (n.getRam() >= min && n.getRam() <= max) {
                    System.out.println(n);
                }
            }
        } else if (a.equalsIgnoreCase("HDD")) {
            for (Notebook n : l) {
                if (n.getHdd() >= min && n.getHdd() <= max) {
                    System.out.println(n);
                }
            }
        }
        System.out.println("Хотите повторить поиск по другим параматрам?(да/нет)");
        if (yesOrNo()) {
            choiceParameters(l);
        } else {
            exit(0);
        }
    }

    public static void hddParameters(ArrayList<Notebook> l) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите желаемый объем HDD в пределах от 250 Гб до 1000 Гб включительно");
        System.out.print("Введите Ваш выбор: ");
        try {
            int hddSize = in.nextInt();
            if (hddSize == 250 | hddSize == 350 | hddSize == 500 | hddSize == 1000) {
                for (Notebook n : l) {
                    if (n.getHdd() == hddSize) {
                        System.out.println(n);
                    }
                }
            } else {
                System.out.println("Ноутбука с таким параметром нет:( Можете попробовать выбрать диапазон значений!\n Пробуем?(да/нет)");
                if (yesOrNo()) {
                    rangeParameters(l, "HDD", 250, 1000);
                }
            }
        } catch (Exception e) {
            System.out.println("Не верный ввод! Попробуйте еще раз!");
            ramParameters(l);
        }
        System.out.println("Хотите повторить поиск по другим параматрам?(да/нет)");
        if (yesOrNo()) {
            choiceParameters(l);
        } else {
            exit(0);
        }
    }

    public static void osParameters(HashSet<String> lOs, ArrayList<Notebook> l) {
        Scanner in = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        System.out.println("Выбирите и введите операционную систему из доступных");
        System.out.print("в наличии: ");
        for (String s : lOs) {
            sb.append(s).append(", ");
        }
        sb.deleteCharAt(sb.length() - 2);
        System.out.println(sb);
        System.out.print("Введите Ваш выбор: ");
        String a = in.nextLine();
        a = a.substring(0, 1).toUpperCase() + a.substring(1).toLowerCase();
        if (lOs.contains(a)) {
            for (Notebook s : l) {
                if (s.getOs().equalsIgnoreCase(a)) {
                    System.out.println(s);
                }
            }
        } else if (a.equalsIgnoreCase("MacOS")) {
            a = "MacOS";
            for (Notebook s : l) {
                if (s.getOs().equalsIgnoreCase(a)) {
                    System.out.println(s);
                }
            }
        } else {
            System.out.println("Ноутбука с такой операционной системой нет на складе! Либо введено не верное название!");
            manufacturerParameters(lOs, l);
        }
        System.out.println("Хотите повторить поиск по другим параматрам?(да/нет)");
        if (yesOrNo()) {
            choiceParameters(l);
        } else {
            exit(0);
        }
    }

    public static void colorParameters(HashSet<String> lc, ArrayList<Notebook> l) {
        Scanner in = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        System.out.println("Выбирите и введите цвет из доступных");
        System.out.print("в наличии: ");
        for (String s : lc) {
            sb.append(s).append(", ");
        }
        sb.deleteCharAt(sb.length() - 2);
        System.out.println(sb);
        System.out.print("Введите Ваш выбор: ");
        String a = in.nextLine();
        a = a.substring(0, 1).toUpperCase() + a.substring(1).toLowerCase();
        if (lc.contains(a)) {
            for (Notebook s : l) {
                if (s.getColor().equalsIgnoreCase(a)) {
                    System.out.println(s);
                }
            }
        } else {
            System.out.println("Ноутбука с таким цветом нет на складе! Либо введен не верно цвет!");
            manufacturerParameters(lc, l);
        }
        System.out.println("Хотите повторить поиск по другим параматрам?(да/нет)");
        if (yesOrNo()) {
            choiceParameters(l);
        } else {
            exit(0);
        }
    }

    public static void displayAll(ArrayList<Notebook> l) {
        for (Notebook ln : l) {
            System.out.println(ln);
        }
        System.out.println("\nХотите повторить поиск по другим параматрам?(да/нет)");
        if (yesOrNo()) {
            choiceParameters(l);
        } else {
            exit(0);
        }
    }

    public static boolean yesOrNo() {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите Ваш выбор: ");
        String yn = in.nextLine();
        if (yn.equalsIgnoreCase("да") || yn.equalsIgnoreCase("yes")) {
            return true;
        } else if (yn.equalsIgnoreCase("нет") || yn.equalsIgnoreCase("no")) {
            return false;
        } else {
            System.out.println("Нет такого ответа! Либо 'да', либо 'нет'!");
            yesOrNo();
        }
        return false;
    }

    public static void main(String[] args) {
        Notebook notebook1 = new Notebook("Lenovo", " x1", 4, 250, "Windows", "Black");
        Notebook notebook2 = new Notebook("Lenovo", " x2", 8, 500, "Windows", "Red");
        Notebook notebook3 = new Notebook("Lenovo", " x0", 16, 500, "Linux", "Yellow");
        Notebook notebook4 = new Notebook("Asus", " a1", 12, 500, "Windows", "Silver");
        Notebook notebook5 = new Notebook("HP", " h1", 4, 350, "Windows", "Green");
        Notebook notebook6 = new Notebook("Acer", " s1", 24, 300, "Windows", "Blue");
        Notebook notebook7 = new Notebook("Apple", " p1", 4, 250, "MacOS", "Black");
        Notebook notebook8 = new Notebook("Apple", " p2", 32, 500, "MacOS", "Black");
        Notebook notebook9 = new Notebook("Apple", " p3", 32, 1000, "MacOS", "Black");
        Notebook notebook10 = new Notebook("HP", " h2", 8, 500, "Windows", "Black");
        Notebook notebook11 = new Notebook("Asus", " a2", 8, 500, "Windows", "Black");
        ArrayList<Notebook> listNotebook = new ArrayList<>();
        listNotebook.add(notebook1);
        listNotebook.add(notebook2);
        listNotebook.add(notebook3);
        listNotebook.add(notebook4);
        listNotebook.add(notebook5);
        listNotebook.add(notebook6);
        listNotebook.add(notebook7);
        listNotebook.add(notebook8);
        listNotebook.add(notebook9);
        listNotebook.add(notebook10);
        listNotebook.add(notebook11);
        System.out.println("\nВас приветствует каталог ноутбуков 'Ля-ля-тополя'!\n");
        choiceParameters(listNotebook);
    }
}
