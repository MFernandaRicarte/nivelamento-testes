package com.fernanda.teste2;

import com.opencsv.CSVWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CsvWriter {
    public static void writeToCsv(String filePath, List<String[]> data) throws IOException {
        File file = new File(filePath);
        File parentDir = file.getParentFile();
        if (parentDir != null && !parentDir.exists()) {
            parentDir.mkdirs();
        }

        try (CSVWriter writer = new CSVWriter(new FileWriter(file))) {
            for (String[] row : data) {
                writer.writeNext(row);
            }
        }
    }
}

