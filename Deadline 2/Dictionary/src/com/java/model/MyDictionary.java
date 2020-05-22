package com.java.model;

import java.util.TreeMap;

public class MyDictionary {
    private static MyDictionary single_instance = null; 

    private TreeMap<String, String> _wordList;

    private MyDictionary() {
        _wordList = new TreeMap<>();
    }

    public static MyDictionary getInstance() { 
        if (single_instance == null) {
            single_instance = new MyDictionary(); 
        }
        return single_instance; 
    }

    public TreeMap<String, String> get_wordList() {
        return _wordList;
    }

    public void set_wordList(TreeMap<String, String> _wordList) {
        this._wordList = _wordList;
    }
}