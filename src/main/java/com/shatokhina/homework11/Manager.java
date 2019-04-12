package com.shatokhina.homework11;

import java.io.File;
import java.io.IOException;

public class Manager {
    void copy(String pathInput, String pathOutput) {
        File output = new File(pathOutput);
        if (notCreatedFile(output)) return;
        File input = new File(pathInput);
        System.out.println("Bytes copied: " + FileCopier.copy(input, output));
    }

    void separation(String pathInput, String pathOutputPart1, String pathOutputPart2, long length) {
        File outputPart1 = new File(pathOutputPart1);
        File outputPart2 = new File(pathOutputPart2);
        if (notCreatedFile(outputPart1) | notCreatedFile(outputPart2)) return;
        File input = new File(pathInput);
        if (FileDivider.separation(input, outputPart1, outputPart2, length)) System.out.println("File is divided");
        else System.out.println("File not split");
    }

    void merge(String pathInputPart1, String pathInputPart2, String pathOutput) {
        File output = new File(pathOutput);
        if (notCreatedFile(output)) return;
        File inputPart1 = new File(pathInputPart1);
        File inputPart2 = new File(pathInputPart2);
        if (FileConsolidator.merge(inputPart1, inputPart2, output)) System.out.println("Files merged");
        else System.out.println("Files not merged");
    }

    private boolean notCreatedFile(File file) {
        try {
            if (file.createNewFile()) return false;
        } catch (IOException e) { e.printStackTrace(); }
        System.out.println("Sorry, but i can't create new file with this path: " + file.getPath());
        return true;
    }
}