package kiev.prog;

import java.io.*;

public class FileServiceGroup {

    public static String readFile(String path) throws IOException {
        StringBuffer stringBuffer = new StringBuffer();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(path));
            String s = "";
            while ((s = reader.readLine()) != null) {
                stringBuffer.append(s);
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("ERROR --> in method readFile()");
        }
        String resultReadFile = stringBuffer.toString();

        return resultReadFile;
    }

    public static String[] createArrayFromString(File file) throws IOException {
        try {
            String textFromFile = readFile(file.getPath());
            textFromFile = textFromFile.replaceAll("[{}]", "");
            textFromFile = textFromFile.substring(0, textFromFile.length()-1);
            String[] textArray = textFromFile.split("[ ]");
            return textArray;
        } catch (IOException e) {
            System.out.println("ERROR --> in method writingResultFile()");
        }
        return null;
    }

}
