import java.io.*;
import java.util.ArrayList;

public class ReverseFile {
    public static void main(String[] args) throws IOException {
        if (args.length != 1) {
            System.err.println("Usage: ReverseFile <text filename>");
            System.exit(1);
        }
        ArrayList<String> list = new ArrayList<String>();
        BufferedReader input = null;
        PrintWriter out = null;
        try{
            File inputFile = new File(args[0]);
            File outFile = new File("temp.txt");
            input = new BufferedReader(new FileReader(inputFile));
            out = new PrintWriter(new FileWriter(outFile));
            String line;
            while ((line = input.readLine()) != null){
                list.add(line);
            }
            int size = list.size();
            for (int i = size - 1; i >= 0; i--){
                out.println(list.get(i));
            }
            inputFile.delete();
            outFile.renameTo(inputFile);
        } finally {
            if (input != null){
                input.close();
            }
            if (out != null){
                out.close();
            }
        }
    }
}
