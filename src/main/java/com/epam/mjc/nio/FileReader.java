package com.epam.mjc.nio;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;


public class FileReader {

    public Profile getDataFromFile(File file) {
        String name = "";
        Integer age = 0;
        String email = "";
        Long phone = 0L;
        try(FileInputStream input = new FileInputStream(file)) {
            int ch;
            StringBuilder stringBuilder = new StringBuilder();
            while ((ch = input.read()) != -1) {
                stringBuilder.append((char) ch);
            }
            String str = stringBuilder.toString();
            String[] arr = str.split("\n");

            for (var item: arr) {
                if (item.contains("Name")) {
                    name = item.split(":")[1].trim();
                }
                if (item.contains("Age")) {
                    age = Integer.valueOf(item.split(":")[1].trim());
                }
                if (item.contains("Email")) {
                    email = item.split(":")[1].trim();
                }
                if (item.contains("Phone")) {
                    phone = Long.valueOf(item.split(":")[1].trim());
                }
            }
            return new Profile(name, age, email, phone);
        } catch (IOException e) {
            return null;
        }
    }
}
