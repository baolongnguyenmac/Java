package com.java.main;

import com.java.handlefile.Reader;

public class Loader {
    public void load (boolean isAnh_Viet) {
        Reader r = new Reader();
        r.readDictionary(isAnh_Viet);
        r.readFavorite();
        r.readHistory();
    }
}