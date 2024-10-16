package webui.utils;

import java.io.File;

public class FileUtils {

    public static void clearDirectory(String name) {
        String dirPath = System.getProperty("user.dir") + "/" + name + "/";
        File directory = new File(dirPath);

        if (directory.exists()) {
            File[] files = directory.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        file.delete();
                    }
                }
            }
        }
    }
}
