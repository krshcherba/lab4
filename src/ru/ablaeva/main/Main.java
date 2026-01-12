package ru.ablaeva.main;

import ru.ablaeva.geometry.*;
import ru.ablaeva.model.*;

import java.util.Scanner;
import java.util.function.Function;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static Generics generic = new Generics<>();

    public static void main(String[] args) {
        boolean exit = false;
        while (!exit) {
            printMenu();
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    task1();
                    break;
                case 2:
                    task2();
                    break;
                case 3:
                    task3();
                    break;
                case 4:
                    
                    break;
                case 5:
                    
                    break;
                
                case 6:
                    task6();
                    break;

                case 7:
                    task7();
                    break;

                case 0:
                    exit = true;
                    break;
                default:
                    System.out.println("Некорректный ввод.");
                    break;
            }
        }
    }

    private static void printMenu() {
        System.out.println("Выберите задание: ");
        System.out.println("1 - Без null");
        System.out.println("2 - Обобщенная линия");
        System.out.println("3 - Сдвинуть линию");
        System.out.println("4 - Функция");
        System.out.println("5 - Фильтр");
        System.out.println("6 - Сокращение");
        System.out.println("7 - Коллекционирование");
        System.out.println("0 - Выход");
    }

    private static void task1() {
        // 1. Хранилище чисел с null, альтернатива 0
        Storage<Integer> intStorage1 = new Storage<>(null);
        processIntegerStorage(intStorage1, 0);
        
        // 2. Хранилище чисел со значением 99, альтернатива -1
        Storage<Integer> intStorage2 = new Storage<>(99);
        processIntegerStorage(intStorage2, -1);
        
        // 3. Хранилище строк с null, альтернатива "default"
        Storage<String> stringStorage1 = new Storage<>(null);
        processStringStorage(stringStorage1, "default");
        
        // 4. Хранилище строк со значением "hello", альтернатива "hello world"
        Storage<String> stringStorage2 = new Storage<>("hello");
        processStringStorage(stringStorage2, "hello world");
    }
    
    private static void processIntegerStorage(Storage<Integer> storage, int defaultValue) {
        int value = storage.get(defaultValue);
        System.out.println("Извлеченное значение: " + value);
        System.out.println("toString: " + storage.toString());
        System.out.println();
    }
    
    private static void processStringStorage(Storage<String> storage, String defaultValue) {
        String value = storage.get(defaultValue);
        System.out.println("Извлеченное значение: " + value);
        System.out.println("toString: " + storage.toString());
        System.out.println();
    }
    
    private static void task2() {
        // Создаем линию в трехмерном пространстве
        Point3D start3D = new Point3D(1, 2, 3);
        Point3D end3D = new Point3D(4, 5, 6);
        Line<Point3D> line3D = new Line<>(start3D, end3D);
        
        System.out.println("Трехмерная линия:");
        System.out.println(line3D);
        System.out.println("Точка начала: " + line3D.getStart());
        System.out.println("Точка конца: " + line3D.getEnd());
        System.out.println();
        
        // Создаем линию в двумерном пространстве
        Point start2D = new Point(10, 20);
        Point end2D = new Point(30, 40);
        Line<Point> line2D = new Line<>(start2D, end2D);
        
        System.out.println("Двумерная линия:");
        System.out.println(line2D);
        System.out.println("Точка начала: " + line2D.getStart());
        System.out.println("Точка конца: " + line2D.getEnd());
    }
    
    private static void task3() {
        // Создаем линию в трехмерном пространстве
        Point3D start3D = new Point3D(1, 2, 3);
        Point3D end3D = new Point3D(4, 5, 6);
        Line<Point3D> line3D = new Line<>(start3D, end3D);
        
        System.out.println("Исходная трехмерная линия:");
        System.out.println(line3D);
        
        // Используем метод shiftStartX() из класса Line
        line3D.shiftStartX();
        
        System.out.println("Линия после сдвига точки начала на 10 единиц по оси X:");
        System.out.println(line3D);
        System.out.println();
        
        // Создаем линию в двумерном пространстве
        Point start2D = new Point(10, 20);
        Point end2D = new Point(30, 40);
        Line<Point> line2D = new Line<>(start2D, end2D);
        
        System.out.println("Исходная двумерная линия:");
        System.out.println(line2D);
        
        // Используем метод shiftStartX() из класса Line
        line2D.shiftStartX();
        
        System.out.println("Линия после сдвига точки начала на 10 единиц по оси X:");
        System.out.println(line2D);
    }

    private static void task6() {
        List<String> list1 = List.of("qwerty", "asdfg", "zx");
        String res1 = generic.concat(list1, new Function<List<String>,String>() {
            @Override
            public String apply(List<String> l) {
                String res = "";
                for (String s : l) {
                    res += s;
                }
                return res;
            }    
        });
        System.out.println(res1);

        List<Integer> list2 = List.of(1,-3,7);
        Integer res2 = generic.concat(list2, new Function<List<Integer>,Integer>() {
            @Override
            public Integer apply(List<Integer> l) {
                Integer res = 0;
                for (Integer i : l) {
                    res += i;
                }
                return res;
            }    
        });
        System.out.println(res2);

        List<List<Integer>> list3 = List.of(List.of(1, 0, 5), List.of(-4, -3, -1), List.of(6, 7, 3));
        List<Integer> res3 = generic.concat(list3, new Function<List<List<Integer>>,List<Integer>>() {
            @Override
            public List<Integer> apply(List<List<Integer>> l) {
                List<Integer> res = new ArrayList<>();
                for (List<Integer> li : l) {
                    res.add(li.size());
                }
                return res;
            }    
        });
        System.out.println(res3);
    }

    private static void task7() {
        
    }
}