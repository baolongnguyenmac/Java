package com.java.handlefile;

import java.io.*;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import com.java.model.*;

public class Writer {
    public void writeDictionary() {
        BufferedDictionary list = new BufferedDictionary();

        try {
            JAXBContext context = JAXBContext.newInstance(BufferedDictionary.class);
            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            list.setWordList(MyDictionary.getDictionary().getDictionary(true));
            m.marshal(list, new BufferedWriter(
                                    new OutputStreamWriter(
                                        new FileOutputStream(Reader.Anh_Viet_FILENAME), "utf8")));

            list.setWordList(MyDictionary.getDictionary().getDictionary(false));
            m.marshal(list, new BufferedWriter(
                                    new OutputStreamWriter(
                                        new FileOutputStream(Reader.Viet_Anh_FILENAME), "utf8")));
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

    public void writeHistory() {
        BufferedHistory list = new BufferedHistory();
        list.setListHistoryItem(History.getHistory().getListHistory());

        try {
            JAXBContext context = JAXBContext.newInstance(BufferedHistory.class);
            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            m.marshal(list, new BufferedWriter(
                                                    new OutputStreamWriter(
                                                        new FileOutputStream(Reader.HISTORY_FILENAME), "utf8")));
        }
        catch (JAXBException e) {
            // System.err.println(e);
            System.err.println("jaxb error <writeHistory>");
        }
        catch (IOException e) {
            // System.err.println(e);
            System.err.println("io error <writeHistory>");
        }
    }

    // public void writeFavorite() {
    //     try {
    //         JAXBContext context = JAXBContext.newInstance(Favorite.class);
    //         Marshaller m = context.createMarshaller();
    //         m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
    //         m.marshal(Favorite.get_instance().get_wordList(), new BufferedWriter(
    //                                 new OutputStreamWriter(
    //                                     new FileOutputStream(Reader.FAVORITE_FILENAME), "utf8")));
    //     }
    //     catch (JAXBException e) {
    //         System.err.println(e);
    //     }
    //     catch (IOException e) {
    //         System.err.println(e);
    //     }
    // }
}