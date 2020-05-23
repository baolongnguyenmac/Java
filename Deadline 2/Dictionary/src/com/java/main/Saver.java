package com.java.main;

import com.java.handlefile.Writer;

public class Saver {
    public void save (boolean isAnh_Viet) {
        Writer w = new Writer();
        w.writeDictionary(isAnh_Viet);
        w.writeFavorite();
        w.writeHistory();
    }
}