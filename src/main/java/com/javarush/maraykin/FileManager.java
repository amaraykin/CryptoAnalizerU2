package com.javarush.maraykin;

import java.io.*;
import java.nio.file.*;

public class FileManager {
    public String readFile(String filePath) throws IOException {
        if (!Files.exists(Paths.get(filePath))) {
            throw new FileNotFoundException("Файл не найден: " + filePath);
        }
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(filePath))) {
            return reader.lines().collect(java.util.stream.Collectors.joining("\n"));
        }
    }

    public void writeFile(String content, String filePath) throws IOException {
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(filePath))) {
            writer.write(content);
        }
    }
}