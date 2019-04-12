package com.shatokhina.homework11;

import java.io.*;

public class FileCopier {
    static int copy(File input, File output) {
        int count = 0;
        try (InputStream inputStream = new FileInputStream(input);
             OutputStream outputStream = new FileOutputStream(output)) {
//            inputStream.transferTo(outputStream);
            int literal;
            while ((literal = inputStream.read()) != -1) {
                outputStream.write(literal);
                count++;
            }
        } catch (IOException e) { e.printStackTrace(); }
        return count;
    }
}