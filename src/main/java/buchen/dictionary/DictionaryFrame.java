package buchen.dictionary;

import com.opencsv.exceptions.CsvValidationException;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.List;

public class DictionaryFrame extends JFrame {
    private final JTextField wordField;
    private final JTextArea defArea;
    private final EnglishDictionary engDic;

    public DictionaryFrame() throws CsvValidationException, IOException {
        engDic = new EnglishDictionary();
        setSize(800, 600);
        setTitle("English Dictionary");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setLayout(new BorderLayout());

        wordField = new JTextField();
        wordField.setText("Word");

        wordField.getDocument().addDocumentListener(
                (SimpleDocumentListener) e -> updateDefinition());


        defArea = new JTextArea();
        defArea.setEditable(false);
        defArea.setLineWrap(true);
        defArea.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(defArea);

        add(wordField, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

    }

    private void updateDefinition() {
        SwingUtilities.invokeLater(() -> {
            String word = wordField.getText();
            List<String> defs = engDic.getDefinition(word);
            defArea.setText("");
            for (String def : defs) {
                defArea.append(def + "\n");
            }
        });
    }
}

