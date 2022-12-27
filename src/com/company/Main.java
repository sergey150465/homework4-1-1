package com.company;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {

    public static void main(String[] args) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        addDir("/Users/sergeynechaev/Desktop/Netology/Games/src/main", stringBuilder);
        addDir("/Users/sergeynechaev/Desktop/Netology/Games/src/test", stringBuilder);
        addDir("/Users/sergeynechaev/Desktop/Netology/Games/res/drawables", stringBuilder);
        addDir("/Users/sergeynechaev/Desktop/Netology/Games/res/vectors", stringBuilder);
        addDir("/Users/sergeynechaev/Desktop/Netology/Games/res/icons", stringBuilder);
        addDir("/Users/sergeynechaev/Desktop/Netology/Games/savegames", stringBuilder);
        addDir("/Users/sergeynechaev/Desktop/Netology/Games/tmp", stringBuilder);
        addFile("/Users/sergeynechaev/Desktop/Netology/Games/tmp", "temp.txt", stringBuilder);
        infoWrite("/Users/sergeynechaev/Desktop/Netology/Games/tmp/temp.txt", stringBuilder);
    }

    public static void addDir(String path, StringBuilder info) {
        File dir = new File(path);
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm");
        Date date = new Date();
        if (dir.mkdirs()) {
            System.out.println("Папка " + dir.getName() + " создана");
        }
        info.append(formatter.format(date.getTime()) + "  Папка " + dir.getName() + " создана в " + dir.getParent() + "\n\n");
    }

    public static void addFile(String path, String fileName, StringBuilder info) {
        File file = new File(path, fileName);
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm");
        Date date = new Date();
        try {
            if (file.createNewFile()) {
                System.out.println("Файл " + file.getName() + " создан в папке " + file.getParent());
                info.append(formatter.format(date.getTime()) + "  Файл " + file.getName() + " создан в " + file.getParent() + "\n\n");
            }
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
    }

    public static void infoWrite(String path, StringBuilder info) {
        try (FileWriter writer = new FileWriter(path, false)) {
            writer.write(String.valueOf(info));
            writer.flush();
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
    }
}
