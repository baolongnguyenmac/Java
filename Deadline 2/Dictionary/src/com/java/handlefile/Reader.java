package com.java.handlefile;

import java.io.*;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import com.java.model.*;

public class Reader {
    public static final String FAVORITE_FILENAME = "Favorite.xml";
    public static final String HISTORY_FILENAME = "History.xml";
    public static final String Anh_Viet_FILENAME = "Anh_Viet.xml";
    public static final String Viet_Anh_FILENAME = "Viet_Anh.xml";

    public void readDictionary() {
        BufferedDictionary list = new BufferedDictionary();
        MyDictionary dictionary = MyDictionary.getDictionary();

        try {
            JAXBContext context = JAXBContext.newInstance(BufferedDictionary.class);
            Unmarshaller um = context.createUnmarshaller();
            list = (BufferedDictionary) um.unmarshal(new BufferedReader(
                                                        new InputStreamReader(
                                                            new FileInputStream(Anh_Viet_FILENAME), "utf8")));
            dictionary.setDictionary(list.getWordList(), true);

            list = (BufferedDictionary) um.unmarshal(new BufferedReader(
                                                        new InputStreamReader(
                                                            new FileInputStream(Viet_Anh_FILENAME), "utf8")));
            dictionary.setDictionary(list.getWordList(), false);
        }
        catch (JAXBException e) {
            // System.err.println(e);
            System.err.println("jaxb error <writeDictionary>");
        }
        catch (IOException e) {
            // System.err.println(e);
            System.err.println("io error <writeDictionary>");
        }
    }

    public void readHistory() {
        History history = History.getHistory();
        BufferedHistory list = new BufferedHistory();

        try {
            JAXBContext context = JAXBContext.newInstance(BufferedHistory.class);
            Unmarshaller um = context.createUnmarshaller();
            list = (BufferedHistory) um.unmarshal(new BufferedReader(
                                            new InputStreamReader(
                                                new FileInputStream(HISTORY_FILENAME), "utf8")));
            history.setHistory(list.getListHistoryItem());
        }
        catch (IOException e) {
            // System.err.println(e);
            System.err.println("io error <readHistory>");
        }
        catch (JAXBException e) {
            // System.err.println(e);
            System.err.println("jaxb error <readHistory>");
        }
    }

    // public void readFavorite() {
    //     Favorite f = Favorite.get_instance();

    //     try {
    //         JAXBContext context = JAXBContext.newInstance(Favorite.class);
    //         Unmarshaller um = context.createUnmarshaller();
    //         f = (Favorite) um.unmarshal(new BufferedReader(
    //                                     new InputStreamReader(
    //                                         new FileInputStream(FAVORITE_FILENAME), "utf8")));
    //     }
    //     catch (IOException e) {
    //         System.err.println(e);
    //     }
    //     catch (JAXBException e) {
    //         System.err.println(e);
    //     }
    // }
}