package test;

import java.text.ParseException;

import com.java.handlefile.*;
import com.java.model.*;

public class TestReadWriteHistory {
    public static void main(String[] args) throws ParseException {
        Reader r = new Reader();
        // r.readDictionary();
        r.readHistory();
        // MyDictionary m = MyDictionary.getDictionary();

        // m.addWord(true);
        // m.eraseWord(true);

        // for (int i = 0; i < 1; i++) {
        //     m.searchWord(true);
        // }

        // Writer w = new Writer();
        // w.writeDictionary();
        // w.writeHistory();

        History h = History.getHistory();
        h.statisticHistory();
        // String sDate1="31/12/1998";  
        // Date date1 = new SimpleDateFormat("dd/MM/yyyy").parse(sDate1);
        // System.out.println(date1.toString());
    }
}