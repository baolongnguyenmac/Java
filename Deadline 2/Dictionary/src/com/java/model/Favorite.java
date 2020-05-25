package com.java.model;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement (name = "favorite")
public class Favorite {
    private static Favorite _instance = null;

    @XmlElement (name = "list_favorite")
    private ArrayList<Word> _wordList;

    private Favorite() {
        _wordList = new ArrayList<>();
    }

    public ArrayList<Word> get_wordList() {
        return _wordList;
    }

    public static Favorite get_instance() {
        if (_instance == null) {
            _instance = new Favorite();
        }
        return _instance;
    }

    public void addFavorite(Word w) {
        if (!_wordList.contains(w)) {
            _wordList.add(w);
        }
    }

    public void sortWordList(boolean isAZ) {
        for (int i = 0; i < _wordList.size(); i++) {
            for (int j = i + 1; j < _wordList.size(); j++) {
                if (isAZ) {
                    if (_wordList.get(i).compareTo(_wordList.get(j)) > 0) {
                        Word temp = _wordList.get(i);
                        _wordList.set(i, _wordList.get(j));
                        _wordList.set(j, temp);
                    }
                }
                else {
                    if (_wordList.get(i).compareTo(_wordList.get(j)) < 0) {
                        Word temp = _wordList.get(i);
                        _wordList.set(i, _wordList.get(j));
                        _wordList.set(j, temp);
                    }
                }
            }
        }
    }
}