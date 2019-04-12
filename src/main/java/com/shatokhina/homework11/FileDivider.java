package com.shatokhina.homework11;

import java.io.*;

public class FileDivider {
    static boolean separation(File input, File part1, File part2, long lengthPart1) {
        try (InputStream inputStream = new FileInputStream(input);
             OutputStream part1Stream = new FileOutputStream(part1);
             OutputStream part2Stream = new FileOutputStream(part2)) {
            int literal;
            long count = 0;
            while ((literal = inputStream.read()) != -1) {
                if (++count <= lengthPart1) part1Stream.write(literal);
                else part2Stream.write(literal);
            }
        } catch (IOException e) { return false; }
        return true;
    }
}