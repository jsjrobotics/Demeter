package com.jsjrobotics.demeter;

import com.jsjrobotics.defaultTemplate.lifecycle.functional.Optional;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileUtils {
    private static final int ONE_KILOBYTE = 1024;

    public static Optional<String> readFile(File file) {
        byte[] buffer = new byte[ONE_KILOBYTE];
        FileInputStream fileStream = null;
        BufferedInputStream inputStream = null;
        StringBuilder result = new StringBuilder();
        try {
            fileStream = new FileInputStream(file);
            inputStream = new BufferedInputStream(fileStream);
            int read = 0;
            while (read != -1) {
                read = inputStream.read(buffer);
                for (int index = 0; index < read; index++) {
                    result.append(buffer[index]);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }

                if (fileStream != null) {
                    fileStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        String content = result.toString();
        if (!content.isEmpty()) {
            return Optional.of(content);
        }
        return Optional.empty();
    }

    public static void writeToFile(File file, String content) {
        FileOutputStream fileStream = null;
        BufferedOutputStream outputStream = null;
        try {
            fileStream = new FileOutputStream(file);
            outputStream = new BufferedOutputStream(fileStream);
            outputStream.write(content.getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (outputStream != null) {
                    outputStream.close();
                }

                if (fileStream != null) {
                    fileStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
