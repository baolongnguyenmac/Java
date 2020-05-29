package com.java.model;

import java.util.*;

public class MyDictionary {
    private static MyDictionary _instance = null;

    private TreeMap<String, String> _Anh_VietDictionary;
    private TreeMap<String, String> _Viet_AnhDictionary;

    private MyDictionary() {
        _Anh_VietDictionary = new TreeMap<>();
        _Viet_AnhDictionary = new TreeMap<>();
    }

    public static MyDictionary getDictionary() {
        if (_instance == null) {
            _instance = new MyDictionary();
        }
        return _instance;
    }

    public TreeMap<String, String> getDictionary(boolean isAnh_Viet) {
        if (isAnh_Viet) {
            return _Anh_VietDictionary;
        }
        return _Viet_AnhDictionary;
    }

    public void setDictionary(ArrayList<Word> wordList, boolean isAnh_Viet) {
        if (isAnh_Viet) {
            for (Word w: wordList) {
                _Anh_VietDictionary.put(w.getWord(), w.getMeaning());
            }
        }
        else {
            for (Word w: wordList) {
                _Viet_AnhDictionary.put(w.getWord(), w.getMeaning());
            }
        }
    }
}