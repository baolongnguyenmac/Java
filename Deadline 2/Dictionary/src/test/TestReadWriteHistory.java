package test;

import com.java.handlefile.*;
import com.java.model.MyDictionary;

public class TestReadWriteHistory {
    public static void main(String[] args) {
        Reader r = new Reader();
        r.readDictionary();
        r.readHistory();
        MyDictionary m = MyDictionary.getDictionary();

        // m.addWord(true);
        // m.eraseWord(true);

        for (int i = 0; i < 1; i++) {
            m.searchWord(true);
        }

        Writer w = new Writer();
        w.writeDictionary();
        w.writeHistory();
    }
}