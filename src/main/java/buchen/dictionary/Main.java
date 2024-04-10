package buchen.dictionary;

import com.opencsv.exceptions.CsvValidationException;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws CsvValidationException, IOException {
        new DictionaryFrame().setVisible(true);
    }
}