package kiev.prog;

import java.io.File;
import java.io.IOException;

import static kiev.prog.FileService.searchFile;

public class Main {

    public static void main(String[] args) {
        String pathFolderFrom = "c:/myFolder";
        String extFile = "doc";
        String pathFolderTo  = "c:/myFolder2";
        try {
            searchFile(pathFolderFrom, pathFolderTo, extFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
