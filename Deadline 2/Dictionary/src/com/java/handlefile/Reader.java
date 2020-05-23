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

    public void readDictionary(boolean isAnh_Viet) {
        WordList list = WordList.get_instance();

        try {
            JAXBContext context = JAXBContext.newInstance(WordList.class);
            Unmarshaller um = context.createUnmarshaller();
            if (isAnh_Viet) {
                list = (WordList) um.unmarshal(new BufferedReader(
                                                new InputStreamReader(
                                                    new FileInputStream(Anh_Viet_FILENAME), "utf8")));
            }
            else {
                list = (WordList) um.unmarshal(new BufferedReader(
                                                new InputStreamReader(
                                                    new FileInputStream(Viet_Anh_FILENAME), "utf8")));
            }
        }
        catch (JAXBException e) {
            System.err.println(e);
        }
        catch (IOException e) {
            System.err.println(e);
        }

        MyDictionary m = MyDictionary.getInstance();
        m.set_wordList(list);
    }

    public void readHistory() {
        History h = History.get_instance();

        try {
            JAXBContext context = JAXBContext.newInstance(History.class);
            Unmarshaller um = context.createUnmarshaller();
            h = (History) um.unmarshal(new BufferedReader(
                                        new InputStreamReader(
                                            new FileInputStream(HISTORY_FILENAME), "utf8")));
        }
        catch (IOException e) {
            System.err.println(e);
        }
        catch (JAXBException e) {
            System.err.println(e);
        }
    }

    public void readFavorite() {
        Favorite f = Favorite.get_instance();

        try {
            JAXBContext context = JAXBContext.newInstance(Favorite.class);
            Unmarshaller um = context.createUnmarshaller();
            f = (Favorite) um.unmarshal(new BufferedReader(
                                        new InputStreamReader(
                                            new FileInputStream(FAVORITE_FILENAME), "utf8")));
        }
        catch (IOException e) {
            System.err.println(e);
        }
        catch (JAXBException e) {
            System.err.println(e);
        }
    }
}