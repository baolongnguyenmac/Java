package com.java.model;

import java.util.*;

import javax.xml.bind.annotation.*;

@XmlRootElement (name = "favorite")
@XmlAccessorType(XmlAccessType.FIELD)
public class BufferedFavorite {
    @XmlElement (name = "item")
    private ArrayList<Word> _listFavorite;

    public BufferedFavorite() {
        _listFavorite = new ArrayList<>();
    }

    public void setListFavorite(ArrayList<Word> list) {
        _listFavorite.clear();
        for (Word w: list) {
            _listFavorite.add(w);
        }
    }

    public ArrayList<Word> getListFavorite() {
        return _listFavorite;
    }
}