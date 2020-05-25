package com.java.model;

import java.util.*;

import javax.xml.bind.annotation.*;

@XmlRootElement (name = "dictionary")
@XmlAccessorType(XmlAccessType.FIELD)

public class WordList {
    private static WordList _instance = null;

    @XmlElement(name = "record")
    private ArrayList<Word> _wordList;

    private WordList() {
        _wordList = new ArrayList<>();
    }

    public static WordList get_instance() {
        if (_instance == null) {
            _instance = new WordList();
        }
        return _instance;
    }

    public void set_wordList(ArrayList<Word> _wordList) {
        this._wordList = _wordList;
    }

    public ArrayList<Word> get_wordList() {
        return _wordList;
    }

    public void set_wordList(TreeMap<String, String> treeMap) {
        _wordList.clear();
        for(Map.Entry<String, String> entry : treeMap.entrySet()) {
            Word temp = new Word(entry.getKey(), entry.getValue());
            _wordList.add(temp);
        }
    }
}