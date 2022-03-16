package com.mkyong.io.csv.opencsv;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;


public class OpenCsvExample {

    public static void main(String[] args) throws IOException, CsvException {

        String fileName = "exemplo_trabalho_TAP_historico.csv";
        try (CSVReader reader = new CSVReader(new FileReader(fileName))) {
            List<String[]> r = reader.readAll();
            r.forEach(x -> System.out.println(Arrays.toString(x)));
        }

    }

}