package kiev.prog;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        String path1 = "c:/myFolder/test1.docx";
        File fileFirst = new File(path1);
        writeTextToFile(fileFirst, "absolute, Math, java, testing, testing, role, agile, delivery, scope, maven, empty, class");

        String path2 = "c:/myFolder/test2.docx";
        File fileSecond = new File(path2);
        writeTextToFile(fileSecond, "level, selenium, java, Scrum, role, jenkins, maven, home, print, Testing, assert, role ");

        String path3 = "c:/myFolder/testResult.docx";

        try {
            if (exists(path1) && exists(path2)) {
                System.out.println("From file First " + path1 + " text : " + readFile(path1));
                System.out.println("From file Second " + path2 + " text : " + readFile(path2));
                File fileResult = writingResultFile(fileFirst, fileSecond, path3);
                System.out.println("From file Result " + path3 + " text : " + readFile(path3));
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found --> " + e.getMessage());
        }

    }

    public static String[] createArrayFromString(File file) throws IOException {
        try {
            String textFromFile = readFile(file.getPath());
            textFromFile = textFromFile.toLowerCase().replaceAll("[.,]", "");
            String[] textFirstArray = textFromFile.split("[ ]");
            return textFirstArray;
        } catch (IOException e) {
            System.out.println("ERROR --> in method writingResultFile()");
        }
        return null;
    }

    public static File writingResultFile(File fileFirst, File fileSecond, String pathResult) throws IOException {
        String[] arrayFileFirst = createArrayFromString(fileFirst);
        String[] arrayFileSecond = createArrayFromString(fileSecond);
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < arrayFileFirst.length; i++) {
            for (int j = 0; j < arrayFileSecond.length; j++) {
                if (arrayFileFirst[i].equals(arrayFileSecond[j])) {
                    if (!stringBuffer.toString().contains(arrayFileFirst[i])) {
                        stringBuffer.append(arrayFileFirst[i]);
                        stringBuffer.append(" ");
                        //System.out.println("+ " + arrayFileFirst[i]);
                    }
                }
            }
        }
        File fileResult = new File(pathResult);
        String storyResult = stringBuffer.toString();
        writeTextToFile(fileResult, storyResult);
        return fileResult;
    }

    public static void writeTextToFile(File file, String story) {
        try (PrintWriter writer = new PrintWriter(file)) {
            writer.println(story);
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

    private static boolean exists(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        if (!file.exists()){
            throw new FileNotFoundException(file.getPath());
        }
        return true;
    }

}
