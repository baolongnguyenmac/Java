package com.java.model;

import java.util.*;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement (name = "dictionary")
public class BufferDictionary {
    @XmlElement (name = "record")
    private ArrayList<Word> _wordList;

    public BufferDictionary() {
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
}