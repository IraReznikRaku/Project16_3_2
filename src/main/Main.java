package main;

import java.io.*;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) throws IOException {
        File f = new File("aaa.txt");
        if (!f.exists()) {
            f.createNewFile();
        }
//        Path afterMove = Files.move(FileSystems.getDefault().getPath
//        ("C:\\Java47\\Project16_3_2\\aaa.txt"), FileSystems.getDefault().getPath("C:\\Java47\\bbb.txt"));
//        System.out.println(afterMove);

        try (BufferedReader r = new BufferedReader(new FileReader("aaa.txt"));
             BufferedWriter w = new BufferedWriter(new FileWriter("C:\\Java47\\bbb.txt"))) {
            String s = r.readLine();
            while (s != null) {
                w.write(s);
                if((s = r.readLine()) != null) {
                    w.newLine();
                }
            }
        }
        File f2 = new File("ccc.dll");
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(f2));
             BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream
                     (new File("C:\\Java47\\ddd.txt")))) {
            int c;
            while ((c = bis.read()) != -1) {
                bos.write(c);
            }
        }
    }
}
