package utils;

import java.io.File;

public class FileUtils {
    public static void deleteAllFilesInFolder(String pathOfFolder) {
        try {
            File folder = new File(pathOfFolder);
            File[] files = folder.listFiles();
            for (File file : files) {
                file.delete();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
