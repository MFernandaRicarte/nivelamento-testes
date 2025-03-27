package com.fernanda.teste2;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class PdfExtractor {
    public static List<String[]> extractTextFromPDF(String resourcePath) throws IOException {
        List<String[]> tableData = new ArrayList<>();
        try (InputStream is = PdfExtractor.class.getClassLoader().getResourceAsStream(resourcePath);
             PDDocument document = PDDocument.load(is)) {
            PDFTextStripper stripper = new PDFTextStripper();
            String text = stripper.getText(document);
            String[] lines = text.split("\\r?\\n");
            for (String line : lines) {
                if (line.trim().isEmpty()) continue;
                String[] columns = line.split("\\s{2,}");
                tableData.add(columns);
            }
        }
        return tableData;
    }
}
