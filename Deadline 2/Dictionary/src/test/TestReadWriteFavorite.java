package test;

import com.java.handlefile.*;
import com.java.model.MyDictionary;

public class TestReadWriteFavorite {
    public static void main(String[] args) {
        Reader r = new Reader();
        r.readDictionary();
        r.readFavorite();
        MyDictionary m = MyDictionary.getDictionary();

        for (int i = 0; i < 1; i++) {
            m.searchWord(false);
        }

        Writer w = new Writer();
        // w.writeDictionary();
        w.writeFavorite();
    }
}