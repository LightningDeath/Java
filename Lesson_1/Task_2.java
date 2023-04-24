package Lesson_1;

public class Task_2 {
    public static void main(String[] args) {
        System.out.printf("%d ", 2);
        for (int n = 2; n <= 1000; n++){
            if (n % 2 != 0){
                if (SimpleNumb(n)) {
                    System.out.printf("%d ", n);
                }
            }
        }
    }
    public static boolean SimpleNumb(int value){
        for (int j = 2; j < value; j++){
            if (value % j == 0){
                return false;
            }
        }
        return true;
    }
}
