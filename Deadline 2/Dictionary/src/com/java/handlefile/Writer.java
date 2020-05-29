package com.java.handlefile;

import java.io.*;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import com.java.model.*;

public class Writer {
    public void writeDictionary() {
        BufferDictionary list = new BufferDictionary();

        try {
            list.setWordList(MyDictionary.getDictionary().getDictionary(true));
            JAXBContext context = JAXBContext.newInstance(BufferDictionary.class);
            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            m.marshal(list, new BufferedWriter(
                                    new OutputStreamWriter(
                                        new FileOutputStream(Reader.Anh_Viet_FILENAME), "utf8")));

            list.setWordList(MyDictionary.getDictionary().getDictionary(false));
            m.marshal(list, new BufferedWriter(
                                    new OutputStreamWriter(
                                        new FileOutputStream(Reader.Viet_Anh_FILENAME), "utf8")));
        }
        catch (JAXBException e) {
            System.err.println(e);
        }
        catch (IOException e) {
            System.err.println(e);
        }
    }

    // public void writeHistory() {
    //     try {
    //         JAXBContext context = JAXBContext.newInstance(History.class);
    //         Marshaller m = context.createMarshaller();
    //         m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
    //         m.marshal(History.get_instance().get_historyList(), new BufferedWriter(
    //                                 new OutputStreamWriter(
    //                                     new FileOutputStream(Reader.HISTORY_FILENAME), "utf8")));
    //     }
    //     catch (JAXBException e) {
    //         System.err.println(e);
    //     }
    //     catch (IOException e) {
    //         System.err.println(e);
    //     }
    // }

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