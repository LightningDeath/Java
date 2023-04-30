package Lesson_2;

import java.io.IOException;
import java.util.Arrays;
import java.util.logging.*;

public class Task_1 {
    public static void main(String[] args) throws IOException {
        Logger logger = Logger.getLogger(Task_1.class.getName());
        FileHandler fh = new FileHandler("Log.txt");
        logger.addHandler(fh);
        SimpleFormatter sFormat = new SimpleFormatter ();
        fh.setFormatter(sFormat);
        int current = 0;
        int[] array = new int[]{4, 5, 1, 5, 8, 5, 2, 10, 1, 3, 7, 5, 6};
        logger.info(Arrays.toString(array));
        System.out.println(Arrays.toString(array));
        boolean result = false;
        while (!result) {
            result = true;
            for (int j = 0; j < array.length-1; j++){
                    if (array[j] > array[j + 1]) {
                        result = false;
                        current = array[j];
                        array[j] = array[j + 1];
                        array[j + 1] = current;
                        logger.log(Level.INFO, Arrays.toString(array));
                    }
            }
        }
        System.out.println(Arrays.toString(array));
    }

}

