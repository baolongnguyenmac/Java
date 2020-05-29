package com.java.model;

import java.util.*;
import java.io.*;

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

    public void searchWord(boolean isAnh_Viet) {
        String str = null;
        try {
            System.out.print("Enter your word: ");
            str = Word.inputUTF8(new BufferedReader(
                                    new InputStreamReader(System.in, "utf8")));
            Word w = searchWord(str, isAnh_Viet);
            if (w == null) {
                System.out.println("Word not found");
            }
            else {
                System.out.println(w.getMeaning());
            }
        }
        catch (IOException e) {
            System.err.println("io error <searchWord>");
        }
    }

    private Word searchWord(String word, boolean isAnh_Viet) {
        String meaning;
        if (isAnh_Viet) {
            meaning = _Anh_VietDictionary.get(word);
        }
        else {
            meaning = _Viet_AnhDictionary.get(word);
        }
        if (meaning == null) {
            return null;
        }
        History.getHistory().addHistoryItem(word);

        Word res = new Word(word, meaning);
        return res;
    }

    public void addWord(boolean isAnh_Viet) {
        String word = null;
        String meaning = null;
        try {
            System.out.print("Enter your word: ");
            word = Word.inputUTF8(new BufferedReader(new InputStreamReader(System.in, "utf8")));
            System.out.println("Enter meaning: ");
            meaning = Word.inputUTF8(new BufferedReader(new InputStreamReader(System.in, "utf8")));
            if (addWord(new Word(word, meaning), isAnh_Viet)) {
                System.out.println("Add succeed");
            }
            else {
                System.out.println("Add Fail - Word exists");
            }
        }
        catch (IOException e) {
            System.err.println("io error - <addWord>");
        }
    }

    private boolean addWord(Word w, boolean isAnh_Viet) {
        if (isAnh_Viet) {
            if (!_Anh_VietDictionary.containsKey(w.getWord())) {
                _Anh_VietDictionary.put(w.getWord(), w.getMeaning());
                return true;
            }
            return false;
        }
        else {
            if (!_Viet_AnhDictionary.containsKey(w.getWord())) {
                _Viet_AnhDictionary.put(w.getWord(), w.getMeaning());
                return true;
            }
            return false;
        }
    }

    public void eraseWord(boolean isAnh_Viet) {
        String word = null;
        try {
            System.out.print("Enter your word: ");
            word = Word.inputUTF8(new BufferedReader(new InputStreamReader(System.in, "utf8")));
            if (eraseWord(word, isAnh_Viet)) {
                System.out.println("Erase succeed");
            }
            else {
                System.out.println("Erase fail - Word not found");
            }
        }
        catch (IOException e) {
            System.err.println("io error <erase word>");
        }
    }

    private boolean eraseWord(String word, boolean isAnh_Viet) {
        if (isAnh_Viet) {
            if (_Anh_VietDictionary.remove(word) != null) {
                return true;
            }
            return false;
        }
        else {
            if (_Viet_AnhDictionary.remove(word) != null) {
                return true;
            }
            return false;
        }
    }
}