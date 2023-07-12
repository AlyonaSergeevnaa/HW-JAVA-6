/* Подумать над структурой класса Ноутбук для магазина техники — выделить поля и методы. Реализовать в Java.
 Создать множество ноутбуков.
Написать метод, который будет запрашивать у пользователя критерий (или критерии) фильтрации и выведет ноутбуки, отвечающие фильтру. Критерии фильтрации можно хранить в Map. Например:
“Введите цифру, соответствующую необходимому критерию:
1 - ОЗУ
2 - Объём ЖД
3 - Операционная система
4 - Цвет …
Далее нужно запросить минимальные значения для указанных критериев — сохранить параметры фильтрации можно также в Map.
Отфильтровать ноутбуки их первоначального множества и вывести проходящие по условиям.*/

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.TreeSet;

public class Task_6 {
    public static void main(String[] args) {
        Notebook n1 = new Notebook("HP", "Raider GE78 HX 13VH-094RU", 32, 2000, "Windows 11", "черный");
        Notebook n2 = new Notebook("Xiaomi", Aspire 3 A315-23-R0HR", 8, 512, "Windows 8", "белый");
        Notebook n3 = new Notebook("Acer", "IdeaPad 3 15IML05", 8, 1000, "Windows 10", "серебристый");
        Notebook n4 = new Notebook("HP", "Modern 15 B11-002RU", 8, 256, "Без ОС", "серый");
        Notebook n5 = new Notebook("Apple", "MacBook Air", 8, 256, "macOS", "серый");
        Notebook n6 = new Notebook("Asus", "Summit E13 Flip Evo A12MT-061RU", 16, 512, "Без ОС", "серый");
        Notebook n7 = new Notebook("Acer", "MateBook D16 RLEF-X", 16, 512, "Windows 10", "серый");
        Notebook n8 = new Notebook("Huawei", "ROG Zephyrus G14 GA402RJ-L4045", 8, 1000, "Windows 11", "серый");
        Notebook n9 = new Notebook("HP", D543MA-DM1368",16,512,Windows 10, черный);
        Notebook n10 = new Notebook("Lenovo", "VivoBook Pro 14 K3400PA-KP109", 16, 512, "Windows 10", "серебристый");

        HashSet<Notebook> notebooks = new HashSet<Notebook>(
                Arrays.asList(n1, n2, n3, n4, n5, n6, n7, n8, n9, n10));

        Scanner sc = new Scanner(System.in);
        System.out.println();
        System.out.println("Добрый день!\n" +
                "Введите цифру, соответствующую необходимому критерию: \n");
        boolean filter = true;
        while (filter) {
            System.out.println("1 - ОЗУ.\n" +
                    "2 - Объем жесткого диска.\n" +
                    "3 - ОС.\n" +
                    "4 - Цвет.\n" +
                    "5 - Посмотреть все модели.\n" +
                    "0 - Выход.");

            String operation = sc.nextLine();
            switch (operation) {
                case "1":
                    filterRAM(notebooks, sc);
                    break;
                case "2":
                    filterHardDisk(notebooks, sc);
                    break;
                case "3":
                    filterOS(notebooks, sc);
                    break;
                case "4":
                    filterColor(notebooks, sc);
                    break;
                case "5":
                    showCatalog(notebooks);
                    break;
                case "0":
                    System.out.println("Хорошего дня!");
                    filter = false;
                    break;
                default:
                    System.out.println("Неверная операция, повторите попытку");
                    System.out.println();
                    break;
            }
        }

    }
    
    public static void filterRAM(HashSet<Notebook> notebooks, Scanner scanner) {
        TreeSet<Integer> ram = new TreeSet<>();
        for (Notebook note : notebooks) {
            ram.add(note.getRam());
        }
        System.out.println();
        System.out.println("У нас представлены ноутбуки с оперативной памятью "
                + ram.toString().replaceAll("^\\[|\\]$", "") + " Гб\n" +
                "Введите значение: ");

        String oper = scanner.nextLine();
        int filter = Integer.parseInt(oper);
        if (ram.contains(filter)) {
            System.out.println();
            System.out.println("Подходящие модели: ");
            System.out.println();
            for (Notebook note : notebooks) {
                if (note.getRam() == filter) {
                    note.showInfo();
                }
            }
        } else {
            System.out.println("Значение не распознано. Повторите попытку");
            filterRAM(notebooks, scanner);
        }

    }
  
    public static void filterHardDisk(HashSet<Notebook> notebooks, Scanner scanner) {
        TreeSet<Integer> hardDisk = new TreeSet<>();
        for (Notebook note : notebooks) {
            hardDisk.add(note.getHardDisk());
        }
        System.out.println();
        System.out.println("У нас представлены ноутбуки с объемом жесткого диска "
                + hardDisk.toString().replaceAll("^\\[|\\]$", "") + " Гб\n" +
                "Введите значение: ");

        String oper = scanner.nextLine();
        int filter = Integer.parseInt(oper);
        if (hardDisk.contains(filter)) {
            System.out.println();
            System.out.println("Подходящие модели по вашему запросу: ");
            System.out.println();
            for (Notebook note : notebooks) {
                if (note.getHardDisk() == filter) {
                    note.showInfo();
                }
            }
        } else {
            System.out.println("Неверное значение. Повторите попытку");
            filterHardDisk(notebooks, scanner);
        }
    }

    public static void filterOS(HashSet<Notebook> notebooks, Scanner scanner) {
        TreeSet<String> operSystems = new TreeSet<>();
        for (Notebook note : notebooks) {
            operSystems.add(note.getOperSystem());
        }
        System.out.println();
        System.out.println("У нас представлены операционные системы: "
                + operSystems.toString().replaceAll("^\\[|\\]$", "") + "\n" +
                "Укажите интересующую ОС: ");

        String oper = scanner.nextLine().toUpperCase();
        if (operSystems.contains(oper)) {
            System.out.println();
            System.out.println("Подходящие модели по вашему запросу: ");
            System.out.println();
            for (Notebook note : notebooks) {
                if (note.getOperSystem().equals(oper)) {
                    note.showInfo();
                }
            }
        } else {
            System.out.println("Нет такой ОС. Повторите попытку");
            filterOS(notebooks, scanner);

        }
    }
    
    public static void filterColor(HashSet<Notebook> notebooks, Scanner scanner){
        TreeSet<String> colors = new TreeSet<>();
        for (Notebook note: notebooks){
            colors.add(note.getColor());
        }
        System.out.println();
        System.out.println("У представлены ноутбуки следующих цветов: "
                + colors.toString().replaceAll("^\\[|\\]$", "") + "\n" +
                "Введите цвет: ");

        String oper = scanner.nextLine().toLowerCase();
        if (colors.contains(oper)) {
            System.out.println();
            System.out.println("Подходящие модели по вашему запросу: ");
            System.out.println();
            for (Notebook note : notebooks) {
                if (note.getColor().equals(oper)) {
                    note.showInfo();
                }
            }
        } else {
            System.out.println("Не найдено. Повторите попытку");
            filterColor(notebooks, scanner);
        }
    }
    
    public static void showCatalog(HashSet<Notebook> notebooks){
        System.out.println();
        System.out.println("Полный каталог: ");
        System.out.println();
        for (Notebook note : notebooks) {
                note.showInfo();
        }
    }
}