import java.io.*;

public class UserInputToFile {
    public static void main(String[] args) {
        String filePath = "user_input.txt"; 

        try {
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(isr);
            FileWriter fw = new FileWriter(filePath);

            String input;
            System.out.println("Enter text (type 'exit' to stop):");

            while (!(input = br.readLine()).equalsIgnoreCase("exit")) {
                fw.write(input + "\n");
            }

            fw.close();
            br.close();
            isr.close();

            System.out.println("Input has been saved to " + filePath);
        } catch (IOException e) {
            System.out.println("IO Exception: " + e.getMessage());
        }
    }
}
