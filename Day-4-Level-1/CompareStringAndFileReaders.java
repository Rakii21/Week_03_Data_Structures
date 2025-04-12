import java.io.*;
import java.util.*;

public class CompareStringAndFileReaders {

    public static void main(String[] args) {
        compareStringBuilders();
        compareFileReaders("largefile.txt");     }

    static void compareStringBuilders() {
        String word = "hello";
        int count = 1000000;

        
        long startSB = System.nanoTime();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append(word);
        }
        long endSB = System.nanoTime();
        System.out.println("StringBuilder Time: " + (endSB - startSB) / 1_000_000 + " ms");


        long startSBF = System.nanoTime();
        StringBuffer sbf = new StringBuffer();
        for (int i = 0; i < count; i++) {
            sbf.append(word);
        }
        long endSBF = System.nanoTime();
        System.out.println("StringBuffer Time: " + (endSBF - startSBF) / 1_000_000 + " ms");
    }

    static void compareFileReaders(String fileName) {
        try {
            
            long startFR = System.nanoTime();
            FileReader fr = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr);

            int wordCount1 = 0;
            String line1;
            while ((line1 = br.readLine()) != null) {
                String[] words = line1.trim().split("\\s+");
                wordCount1 += words.length;
            }

            br.close();
            fr.close();
            long endFR = System.nanoTime();
            System.out.println("FileReader Word Count: " + wordCount1);
            System.out.println("FileReader Time: " + (endFR - startFR) / 1_000_000 + " ms");

           
            long startISR = System.nanoTime();
            FileInputStream fis = new FileInputStream(fileName);
            InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
            BufferedReader br2 = new BufferedReader(isr);

            int wordCount2 = 0;
            String line2;
            while ((line2 = br2.readLine()) != null) {
                String[] words = line2.trim().split("\\s+");
                wordCount2 += words.length;
            }

            br2.close();
            isr.close();
            fis.close();
            long endISR = System.nanoTime();
            System.out.println("InputStreamReader Word Count: " + wordCount2);
            System.out.println("InputStreamReader Time: " + (endISR - startISR) / 1_000_000 + " ms");

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
