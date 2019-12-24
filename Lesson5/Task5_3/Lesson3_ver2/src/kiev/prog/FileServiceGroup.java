package kiev.prog;

import java.io.*;

public class FileServiceGroup {

    public static void writeTextToFile(File file, String information) {
        try (PrintWriter writer = new PrintWriter(file)) {
            writer.println(information);
        } catch (FileNotFoundException e) {
            System.out.println("ERROR --> File not found" + e.getMessage());
        }
    }

    public static String readFile(String path) throws IOException {
        StringBuffer stringBuffer = new StringBuffer();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(path));
            String s = "";
            while ((s = reader.readLine()) != null) {
                stringBuffer.append(s);
            }
        } catch (IOException e) {
            System.out.println("ERROR --> in method readFile()");
        }
        String resultReadFile = stringBuffer.toString();
        return resultReadFile;
    }
}
