package hw_java;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.FileReader;

public class Lot {

    private List<Toy> listToys = new ArrayList<>();
    private int toy_count;

    /**
     * @return Список игрушек в розыгрыше
     */
    public List<Toy> getToys() {
        System.out.print("В розыгрыше = " + listToys);
        return listToys;
    }

    /**
     * @return Количество оставшихся игрушек
     */
    public int getToy_count() {
        System.out.println("Осталось игрушек в розыгрыше = " + toy_count);
        return toy_count;
    }

    //
    /**
     * @param name добавляем игрушку
     * @return возвращаем список с добавленной игрушкой
     */
    public List<Toy> add_toy_in_listToy(Toy name) {
        listToys.add(name);
        toy_count++;
        return listToys;
    }

    //
    /**
     * @param name удаление игрушки из спискка по имени
     * @return возвращаем список без удаленной игрушки
     */
    private List<Toy> delete_toy_in_listToy(Toy name) {
        listToys.remove(name);
        toy_count--;
        return listToys;
    }

    /**
     * метод записи выигранных в лоттерею игрушки в файл "winning_lot.txt"
     */
    private void saveInFile() {
        try (FileWriter writer = new FileWriter("winning_lot.txt", true)) {
            String text = listToys.get(0).getToy_name();
            writer.write(text + "\n");
            writer.close();
        } catch (Exception ex) {
            System.out.println("Ошибка записи файла");
        }
    }

    /**
     * метод чтения файла "winning_lot.txt" с выигранными игрушками
     */
    public void readFile() {
        try {
            FileReader fr = new FileReader("winning_lot.txt");
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            while (line != null) {
                System.out.println(line);
                line = reader.readLine();
            }

        } catch (Exception ex) {
            System.out.println("Ошибка");
        }
    }

    /**
     *   Разыгрываем максимально в 3 тура в зависимости от выпадающейго шанса, если выигрыш, то записываем имя игрушки в файл. из списка удаляем.
     */
    public void lottteryToy() {
        Scanner scan = new Scanner(System.in);
        int chance = 50;
        System.out.println("Шанс на выигрышь по умолчанию 50%");
        System.out.println("Если хотите изменить вероятность выигрыша, нажмите 0");
        System.out.println("Если хотите оставить вероятность выигрыша, нажмите 1");
        String changeСhance = scan.next();
        if (changeСhance.equals("0")) {
            System.out.println("введите целое число от 1 до 100 в процентах, это вероятность на победы!");
            chance = scan.nextInt();
        }
        if (chance >= 0 && chance <= 100) {
            Random rnd = new Random();
            int num = rnd.nextInt(100);

            int chance1 = chance - num;
            int chance2 = chance1 - num;
            System.out.println("Против вас играет казино, его шанс =" + num);
            if (num > chance) {
                System.out.println("проигрыш, попытайте удачу снова");

            } else if (num < chance) {
                System.out.println("поздравляю, вы выиграли!!!");
                saveInFile();
                delete_toy_in_listToy(listToys.get(0));
                if (num < chance1) {
                    System.out.println("второй тур, поздравляю, вы снова выйграли!!!");
                    saveInFile();
                    delete_toy_in_listToy(listToys.get(0));
                    if (num < chance2) {
                        System.out.println("финал, поздравляю, и опять вы выйграли!!!");
                        saveInFile();
                        delete_toy_in_listToy(listToys.get(0));
            }
                    } 
            }  else {
                System.out.println("Некорректный ввод! попробуйте еще раз..");
            }
        }
    }
}
