package com.example.demo.test;

import lombok.Data;

import java.util.*;

/**
 * @author zhang
 */
public class HashMapTest {
    public static void main(String[] args) {
        (new HashMapTest()).test();
    }


    /**
     * 通过hashCode()的高16位异或低16位实现的：(h = k.hashCode()) ^ (h >>> 16)，
     * 主要是从速度、功效、质量来考虑的，这么做可以在数组table的length比较小的时候，
     * 也能保证考虑到高低Bit都参与到Hash的计算中，同时不会有太大的开销。
     */
    private void test() {

        HashMap<String, Person> map = new HashMap<>();
        map.put("张三", new Person("张三", 21));
        map.put("李四", new Person("李四", 19));
        map.put("王五", new Person("王五", 25));
        map.put("赵六", new Person("赵六", 24));
        map.put("孙七", new Person("孙七", 32));
        map.put("周八", new Person("周八", 17));
        map.put("钱九", new Person("钱九", 24));
        map.put("吴十", new Person("吴十", 23));
        map.put("赵十一", new Person("吴十", 21));
        map.put("钱十二", new Person("吴十", 22));
        map.put("孙十三", new Person("吴十", 211));
        map.put("李十四", new Person("吴十", 231));
        map.put("周十五", new Person("吴十", 234));
        map.put("吴十六", new Person("吴十", 21233));
        map.put("郑十七", new Person("吴十", 213));

        Set<String> strings = map.keySet();
        Collection<Person> values = map.values();


        map.forEach((k, v) -> {
            String k1 = k;
            Person v1 = v;
            System.out.println(k);
        });

        Iterator<Map.Entry<String, Person>> iterator = map.entrySet().iterator();
        if (iterator.hasNext()) {
            Map.Entry<String, Person> next = iterator.next();
            String key = next.getKey();
            Person value = next.getValue();
        }

        System.out.println(map);

    }


    @Data
    class Person {
        String name;
        int age;

        Person(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }
}
