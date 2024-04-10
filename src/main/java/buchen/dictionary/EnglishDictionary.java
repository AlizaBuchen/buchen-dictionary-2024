package buchen.dictionary;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.*;
import java.util.*;



/**
 * Reads the englishDictionary file ONCE.
 */
public class EnglishDictionary {
    public ArrayList<String[]> words = new ArrayList<>();

    public EnglishDictionary() throws CsvValidationException, IOException {
        // gets the file from the "resources" directory
        InputStream in = EnglishDictionary.class.getResourceAsStream(
                "/englishDictionary.csv");

        CSVReader reader = new CSVReader(new InputStreamReader(in));
        String[] record = null;

        while ((record = reader.readNext()) != null) {
            // record is ONE line of the CSV
            words.add(record);
        }

        reader.close();
    }

    /**
     * @param word to look up.
     * @return a List of definitions, or an empty list if the word doesn't exist.
     */
    public List<String> getDefinition(String word) {
        List<String> def = new ArrayList<>();

        for (String[] record : words) {
            if (record[0].equalsIgnoreCase(word)) {
                def.add(record[2]);
            }
        }
        return def;
    }
}