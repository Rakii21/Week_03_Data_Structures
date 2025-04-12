import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class Problem5{
    public static void main(String[] args) {
        String filePath = "sample.txt"; 

        try {
            FileReader fr = new FileReader(filePath);
            BufferedReader br = new BufferedReader(fr);

            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

            br.close();
            fr.close();
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}
