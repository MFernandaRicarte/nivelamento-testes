package br.com.nivelamento;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class WebScraper {

    private static final String TARGET_URL = "https://www.gov.br/ans/pt-br/acesso-a-informacao/participacao-da-sociedade/atualizacao-do-rol-de-procedimentos";
    private static final String OUTPUT_DIR = "downloads/";
    private static final String ZIP_FILE_NAME = "anexos.zip";

    public static void main(String[] args) {
        try {
            Document doc = Jsoup.connect(TARGET_URL).get();

            String anexo1 = null;
            String anexo2 = null;

            Elements links = doc.select("a[href$=.pdf]");

            for (Element link : links) {
                String text = link.text().toLowerCase();
                if (text.contains("anexo i") && anexo1 == null) {
                    anexo1 = link.absUrl("href");
                } else if (text.contains("anexo ii") && anexo2 == null) {
                    anexo2 = link.absUrl("href");
                }
            }

            if (anexo1 == null || anexo2 == null) {
                System.out.println("Não foi possível encontrar os links dos anexos.");
                return;
            }

            Files.createDirectories(new File(OUTPUT_DIR).toPath());

            File file1 = downloadFile(anexo1, OUTPUT_DIR + "anexo1.pdf");
            File file2 = downloadFile(anexo2, OUTPUT_DIR + "anexo2.pdf");

            zipFiles(new File[]{file1, file2}, OUTPUT_DIR + ZIP_FILE_NAME);

            System.out.println("Download e compactação finalizados com sucesso!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static File downloadFile(String urlStr, String outputPath) throws IOException {
        URL url = new URL(urlStr);
        InputStream in = url.openStream();
        File outFile = new File(outputPath);
        Files.copy(in, outFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
        in.close();
        System.out.println("Arquivo salvo em: " + outputPath);
        return outFile;
    }

    private static void zipFiles(File[] files, String zipFilePath) throws IOException {
        try (ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(zipFilePath))) {
            for (File file : files) {
                try (FileInputStream fis = new FileInputStream(file)) {
                    zos.putNextEntry(new ZipEntry(file.getName()));

                    byte[] buffer = new byte[1024];
                    int length;
                    while ((length = fis.read(buffer)) >= 0) {
                        zos.write(buffer, 0, length);
                    }

                    zos.closeEntry();
                }
            }
        }
        System.out.println("Arquivos compactados em: " + zipFilePath);
    }
}
