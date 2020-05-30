package com.java.main;

import com.java.handlefile.Reader;

public class Loader {
    public void load() {
        Reader r = new Reader();
        r.readDictionary();
        r.readHistory();
        r.readFavorite();
    }
}