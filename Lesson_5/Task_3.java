package Lesson_5;

import java.util.*;

public class Task_3 {
    public static int choice(List<Integer> ar1) {
        return (int) Math.floor(Math.random() * ar1.size());
    }

    public static void main(String[] args) {
        TreeMap<Integer, StringBuilder> board = new TreeMap<>();
        ArrayList<Integer> ar = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            ar.add(i);
        }
        StringBuilder a = new StringBuilder("0000000");
        a.insert(choice(ar), "x");
        board.put(1, a);
        ar.remove(a.indexOf("x"));
        int n = a.indexOf("x");
        for (int i = 2; i <= 8; i++) {
            StringBuilder b_n = new StringBuilder("0000000");
            if (n < 5) {
                n += 2;
                b_n.insert(n, "x");
                board.put(i, b_n);
            } else if (n == 6) {
                n = 1;
                b_n.insert(n, "x");
                board.put(i, b_n);
            } else if (n == 7) {
                n = 2;
                b_n.insert(n, "x");
                board.put(i, b_n);
            } else if (n == 5) {
                n -= 5;
                b_n.insert(n, "x");
                board.put(i, b_n);
            }
        }
        for (int k : board.keySet()) {
            System.out.println(board.get(k));
        }
    }
}

