package buchen.dictionary;
//
//import com.opencsv.exceptions.CsvValidationException;
//import org.junit.jupiter.api.Test;
//
//import java.io.IOException;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class EnglishDictionaryTest {
//
//    @Test
//    public void getDefinition() throws CsvValidationException, IOException {
//        // given
//        EnglishDictionary dictionary = new EnglishDictionary();
//
//        // when
//        List<String> definitions = dictionary.getDefinition("slee");
//
//        // then
//        assertEquals("[[To slay.]]", definitions);
//    }
//
//}

import com.opencsv.exceptions.CsvValidationException;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class EnglishDictionaryTest {
    @Test
    public void getDefinition() throws CsvValidationException, IOException {
        //given
        EnglishDictionary dictionary = new EnglishDictionary();

        //when
        List<String> definitions = dictionary.getDefinition("two");

        //then
        List<String> expected = Arrays.asList("[One and one,  twice one.]",
                "[The sum of one and one,  the number next greater than one, and next less than three,  two units or objects.]",
                "[A symbol representing two units, as 2, II., or ii.]");

        assertEquals(expected, definitions);
    }

}