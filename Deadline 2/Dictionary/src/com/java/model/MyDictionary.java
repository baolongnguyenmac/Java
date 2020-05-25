package com.java.model;

import java.util.ArrayList;
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

    public void set_wordList(WordList list) {
        ArrayList<Word> wordList = list.get_wordList();
        for (int i = 0; i < wordList.size(); i++) {
            this._wordList.put(wordList.get(i).get_word(), wordList.get(i).get_meaning());
        }
    }

    public void searchWord() {
        System.out.print("Enter you word: ");
        String key = Word.inputStringUTF8();

        String value = searchWord(key);
        if (value == null) {
            System.out.println("Word not found");
        }
        else {
            System.out.println(value);
        }
    }

    private String searchWord(String word) {
        return _wordList.get(word);
    }

    public void addWord() {
        System.out.print("Enter your word: ");
        String key = Word.inputStringUTF8();
        System.out.print("Enter meaning of word: ");
        String value = Word.inputStringUTF8();
        if (addWord(key, value)) {
            System.out.println("Add Succeed");
        }
        else {
            System.out.println("Add Fail");
        }
    }

    private boolean addWord(String key, String value) {
        if (!_wordList.containsKey(key)) {
            _wordList.put(key, value);
            return true;
        }
        else {
            return false;
        }
    }

    public void eraseWord() {
        System.err.println("Enter your word: ");
        String key = Word.inputStringUTF8();
        if (eraseWord(key) != null) {
            System.out.println("Erase Succeed");
        } 
        else {
            System.out.println("Erase Fail");
        }
    }

    private Word eraseWord(String key) {
        if (_wordList.containsKey(key)) {
            Word w = new Word(key, _wordList.get(key));
            _wordList.remove(key);
            return w;
        }
        else {
            return null;
        }
    }
}