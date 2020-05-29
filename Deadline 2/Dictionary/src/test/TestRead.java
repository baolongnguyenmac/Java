package test;

import com.java.handlefile.*;
import com.java.model.*;

public class TestRead {
    public static void main(String[] args) {
        Reader r = new Reader();
        r.readDictionary();
        MyDictionary m = MyDictionary.getDictionary();
        Writer w = new Writer();
        w.writeDictionary();
    }
}