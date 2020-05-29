package com.java.model;

import java.util.*;
import java.io.*;

import javax.xml.bind.annotation.*;

@XmlRootElement (name = "dictionary")
@XmlAccessorType(XmlAccessType.FIELD)
public class BufferedDictionary {
    @XmlElement (name = "record")
    private ArrayList<Word> _wordList;

    public BufferedDictionary() {
        _wordList = new ArrayList<>();
    }

    public void setWordList(TreeMap<String, String> treeMap) {
        _wordList.clear();
        for(Map.Entry<String, String> entry : treeMap.entrySet()) {
            _wordList.add(new Word(entry.getKey(), entry.getValue()));
        }
    }

    public ArrayList<Word> getWordList() {
        return _wordList;
    }
}

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
class Word {
    @XmlElement (name = "word")
    private String _word;
    @XmlElement (name = "meaning")
    private String _meaning;

    public Word(){}

    public Word(String word, String meaning) {
        _word = word;
        _meaning = meaning;
    }

    public String getWord() {
        return _word;
    }

    public String getMeaning() {
        return _meaning;
    }

    public void setWord(String word) {
        _word = word;
    }

    public void setMeaning(String meaning) {
        _meaning = meaning;
    }

    public static String inputUTF8(BufferedReader br) {
        String str = null;
        try {
            str = br.readLine();
        }
        catch (IOException e) {
            System.err.println("io error");
        }
        return str;
    }
}