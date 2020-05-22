package com.java.model;

import javax.xml.bind.annotation.*;

@XmlRootElement //(name = "record")
// @XmlType(propOrder = { "_word", "_meaning"})
@XmlAccessorType(XmlAccessType.FIELD)
public class Word implements Comparable<Word> {

    @XmlElement (name = "word")
    private String _word;
    @XmlElement (name = "meaning")
    private String _meaning;

    public String get_word() {
        return _word;
    }

    public void set_word(String _word) {
        this._word = _word;
    }

    public String get_meaning() {
        return _meaning;
    }

    public void set_meaning(String _meaning) {
        this._meaning = _meaning;
    }

    @Override
    public int compareTo(Word o) {
        return this._word.compareTo(o._word);
    }
}