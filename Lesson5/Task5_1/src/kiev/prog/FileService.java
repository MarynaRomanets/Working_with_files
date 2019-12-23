package kiev.prog;

import java.io.*;

public class FileService {

    public static void searchFile(String pathFolderFrom, String pathFolderTo, String extFile) throws IOException {
        File myFolder = new File(pathFolderFrom);
        if (!myFolder.exists()) {
            throw new IOException("Folder doesn't exist");
        }

        /* list of files with .doc */
        File[] filesExt = myFolder.listFiles(new FileFilterDoc(extFile));

        if (filesExt.length != 0) {
            File f = new File(pathFolderTo);
            if (f.exists() | f.mkdir()) {
                /* list of all files */
                File[] files = myFolder.listFiles();
                for (int i = 0; i < files.length; i++) {
                    for (int j = 0; j < filesExt.length; j++) {
                        /* compare if this file is .doc-file */
                        if (files[i].equals(filesExt[j])) {

                            try {
                                String pathtemp = pathFolderTo + '/' + filesExt[j].getName();
                                /* new path */
                                f = new File(pathtemp);
                                fileCopy(filesExt[j], f);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            } else {
                throw new IOException("Directory wasn't created");
            }
            System.out.println("Copying is successful");
        }
    }

    public static void streamCopy(InputStream is, OutputStream os) throws IOException {
        byte[] buffer = new byte[10_000_000];
        int number = 0;
        for (; (number = is.read(buffer)) > 0; ) {
            os.write(buffer, 0, number);
        }
    }

    public static void fileCopy(File in, File out) throws IOException {
        try (InputStream is = new FileInputStream(in);
            OutputStream os = new FileOutputStream(out)) {
            streamCopy(is, os);
        } catch (IOException e) {
            throw e;
        }
    }

}