package com.fernanda.teste2;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            String pdfResource = "anexo1.pdf";
            String csvPath = "src/output/procedimentos.csv";
            String zipPath = "src/output/Teste_Fernanda.zip";

            List<String[]> data = PdfExtractor.extractTextFromPDF(pdfResource);
            Substitutor.replaceAbbreviations(data);
            CsvWriter.writeToCsv(csvPath, data);
            Compressor.compressToZip(csvPath, zipPath);

            System.out.println("Teste 2 conclu\u00eddo com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
