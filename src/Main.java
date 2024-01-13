import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Stream;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    static List<String> list = new ArrayList<>();

    public static void main(String[] args) {
        load();
        System.out.print("Số dòng:");
        System.out.println(list.size());
        System.out.println("Đếm số từ:");
        list.stream().forEach(string -> {
            System.out.print(string + " : ");
            System.out.println(string.length());
        });


        System.out.println("Những dòng có số từ là số chẵn");
        list.stream().filter(string -> string.length() % 2 == 0).forEach(string -> {
            System.out.print(string + " : ");
            System.out.println(string.length());
        });


    }

    public static void load() {

        try {
            FileReader file = new FileReader("input.txt");
           /* FileInputStream fis = new FileInputStream(file);*/
            BufferedReader bis = new BufferedReader(file);
            int data = 0;
            StringBuilder string = new StringBuilder();
            String s = "";
            while (data != -1) {
                data = bis.read();
                s = String.valueOf(string.append((char) data));
            }
            Stream<String> fileData = s.lines();
            fileData.map(String::toString).forEach(s1 -> list.add(s1));
        } catch (IOException ioe) {
            ioe.getStackTrace();
        }
    }


}