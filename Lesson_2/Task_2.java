package Lesson_2;

import java.util.*;
import java.io.FileReader;

public class Task_2 {
    public static void main(String[] args) {
        try {
            FileReader userData = new FileReader("userData.txt");
            Scanner reader = new Scanner(userData);
            String line = "";
            String[] li_1 = new String[1];
            int i = 0;
            while (reader.hasNextLine()) {
                if (i == 0) {
                    line = reader.nextLine();
                    li_1 = line.split(":|,");
                } else {
                    li_1 = append(li_1, reader.nextLine().split(":|,"));
                }
                i++;
            }
            int j = 0;
            while (j <= li_1.length - 6) {
                System.out.printf("Студент %s получил %s по предмету %s\n", li_1[j + 1], li_1[j + 3], li_1[j + 5]);
                j += 6;
            }
            userData.close();
        } catch (Exception e) {
            System.out.println("Файл отсутствует или не верно указано имя!");
        }
    }

    public static String[] append(String[] arr, String[] value) {
        /*
         *функция по расширению массива
         */
        List<String> lineNo = new ArrayList<>(Arrays.asList(arr));
        lineNo.addAll(Arrays.asList(value));
        return lineNo.toArray(new String[0]);
    }
}

