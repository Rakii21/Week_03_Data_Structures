import java.io.*;

public class ByteToCharStreamReader {
    public static void main(String[] args) {
        String filePath = "utf8sample.txt"; // Make sure this file exists and is UTF-8 encoded

        try {
            FileInputStream fis = new FileInputStream(filePath);
            InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
            BufferedReader br = new BufferedReader(isr);

            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

            br.close();
            isr.close();
            fis.close();
        } catch (UnsupportedEncodingException e) {
            System.out.println("Unsupported Encoding: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IO Exception: " + e.getMessage());
        }
    }
}
