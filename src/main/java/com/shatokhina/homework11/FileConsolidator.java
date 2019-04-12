package com.shatokhina.homework11;

import java.io.*;

public class FileConsolidator {
    static boolean merge(File inputPart1, File inputPart2, File output) {
        try (InputStream inputPart1Stream = new FileInputStream(inputPart1);
             InputStream inputPart2Stream = new FileInputStream(inputPart2);
             OutputStream outputStream = new FileOutputStream(output)) {
            int literal;
            while ((literal = inputPart1Stream.read()) != -1) outputStream.write(literal);
            outputStream.write(' ');
            while ((literal = inputPart2Stream.read()) != -1) outputStream.write(literal);
        } catch (IOException e) { return false; }
        return true;
    }
}