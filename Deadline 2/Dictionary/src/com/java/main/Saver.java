package com.java.main;

import com.java.handlefile.Writer;

public class Saver {
    public void save() {
        Writer w = new Writer();
        w.writeDictionary();
        w.writeFavorite();
        w.writeHistory();
    }
}