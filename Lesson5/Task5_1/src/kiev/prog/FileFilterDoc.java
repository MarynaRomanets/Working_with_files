package kiev.prog;

import java.io.File;
import java.io.FileFilter;

public class FileFilterDoc implements FileFilter {

    String extFile;

    public FileFilterDoc(String extFile) {
        this.extFile = extFile;
    }

    public boolean ifExt(String partName) {
        if (extFile.equalsIgnoreCase(partName)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean accept(File pathname) {
        int indexDot = pathname.getName().lastIndexOf(".");
        //System.out.println(indexDot);
        if ( indexDot == -1) {
            return false;
        } else {
            return ifExt(pathname.getName().substring(indexDot + 1));
        }
    }
}
