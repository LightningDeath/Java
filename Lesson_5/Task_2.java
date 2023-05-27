package Lesson_5;

import java.util.*;

public class Task_2 {
    public static TreeMap<String, Integer> compare(String key, Integer value, TreeMap<String, Integer> db2,
                                                   LinkedHashMap<String, Integer> res1) {
        TreeMap<String, Integer> res = new TreeMap<>();
        TreeMap<String, Integer> res2 = new TreeMap<>();
        res2.putAll(db2);
        for (String keys : res1.keySet()) {
            res2.remove(keys);
        }
        for (String db3 : res2.keySet()) {
            if (res2.size() == 1) {
                res.put(db3, res2.get(db3));
            } else if (value < res2.get(db3) && !key.equals(db3)) {
                value = res2.get(db3);
                key = db3;
                res.put(key, value);
            } else if (value.equals(res2.get(db3)) && !key.equals(db3)) {
                res.put(key, value);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        HashMap<String, String> db = new HashMap<>();
        TreeMap<String, Integer> db_new = new TreeMap<>();
        LinkedHashMap<String, Integer> res = new LinkedHashMap<>();
        db.put("Иванов", "Иван");
        db.put("Петровна", "Светлана");
        db.put("Белова", "Кристина");
        db.put("Мусина", "Анна");
        db.put("Крутова", "Анна");
        db.put("Юрин", "Иван");
        db.put("Лыков", "Петр");
        db.put("Чернов", "Павел");
        db.put("Чернышов", "Петр");
        db.put("Федорова", "Мария");
        db.put("Светлова", "Марина");
        db.put("Савина", "Мария");
        db.put("Рыкова", "Мария");
        db.put("Лугова", "Марина");
        db.put("Владимирова", "Анна");
        db.put("Мечников", "Иван");
        db.put("Петин", "Петр");
        db.put("Ежов", "Иван");
        LinkedList<String> list = new LinkedList<>(db.values());
        Collections.sort(list);
        String word = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            if (word.equals(list.get(i))) {
                int count = Collections.frequency(list, word);
                db_new.putIfAbsent(word, count);
            } else {
                word = list.get(i);
                int count = Collections.frequency(list, word);
                db_new.putIfAbsent(word, count);
            }
        }
        String key = db_new.firstKey();
        int value = db_new.get(db_new.firstKey());
        for (String db1 : db_new.keySet()) {
            if (value < db_new.get(db1) && !key.equals(db1)) {
                value = db_new.get(db1);
                key = db1;
            }
        }
        res.put(key, value);
        for (String db2 : db_new.keySet()) {
            res.putAll(compare(db2, db_new.get(db2), db_new, res));
        }
        if (res.size() != db_new.size()) {
            for (String db3 : db_new.keySet()) {
                res.putAll(compare(db3, db_new.get(db3), db_new, res));
            }
        }
        for (String keys : res.keySet()) {
            System.out.printf("Имя '%s', количество повторений: %d\n", keys, res.get(keys));
        }
    }
}
