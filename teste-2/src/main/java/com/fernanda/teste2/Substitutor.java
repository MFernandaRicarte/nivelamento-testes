package com.fernanda.teste2;

import java.util.List;

public class Substitutor {
    public static void replaceAbbreviations(List<String[]> data) {
        for (String[] row : data) {
            for (int i = 0; i < row.length; i++) {
                if (row[i].equalsIgnoreCase("OD")) {
                    row[i] = "Seg. Odontol\u00f3gica";
                } else if (row[i].equalsIgnoreCase("AMB")) {
                    row[i] = "Seg. Ambulatorial";
                }
            }
        }
    }
}
