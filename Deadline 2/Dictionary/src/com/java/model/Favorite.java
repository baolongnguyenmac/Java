package com.java.model;

import java.util.*;

public class Favorite {
    private static Favorite _instance = null;

    private ArrayList<Word> _listFavorite;

    private Favorite() {
        _listFavorite = new ArrayList<>();
    }

    public static Favorite getFavorite() {
        if (_instance == null) {
            _instance = new Favorite();
        }
        return _instance;
    }

    public ArrayList<Word> getListFavorite() {
        return _listFavorite;
    }

    public void setListFavorite(ArrayList<Word> list) {
        _listFavorite.clear();
        for (Word w: list) {
            _listFavorite.add(w);
        }
    }

    public void addWord(Word w) {
        for (Word word: _listFavorite) {
            if (w.getWord().equals(word.getWord())) {
                return;
            }
        }
        _listFavorite.add(w);
    }

    
}