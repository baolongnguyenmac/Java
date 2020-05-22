package com.java.model;

import java.util.ArrayList;

import javax.xml.bind.annotation.*;

@XmlRootElement (name = "dictionary")
@XmlAccessorType(XmlAccessType.FIELD)

public class WordList {
    @XmlElement(name = "record")
    private ArrayList<Word> bookList;

    public void setBookList(ArrayList<Word> bookList) {
        this.bookList = bookList;
    }

    public ArrayList<Word> getBooksList() {
        return bookList;
    }
}