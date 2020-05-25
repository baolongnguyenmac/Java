package com.java.model;

import java.io.*;
import javax.xml.bind.annotation.*;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Word implements Comparable<Word> {

    @XmlElement (name = "word")
    private String _word;
    @XmlElement (name = "meaning")
    private String _meaning;

    public Word(String word, String meaning) {
        _word = word;
        _meaning = meaning;
    }

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

    public static String inputStringUTF8() {
        BufferedReader br = null;
        String key = null;
        try {
            br = new BufferedReader(new InputStreamReader(System.in, "utf8"));
            key = br.readLine();
        }
        catch (IOException e) {
            System.err.println(e);
        }
        finally {
            if (br != null) {
                try {
                    br.close();
                }
                catch (IOException e) {
                    System.err.println(e);
                }
            }
        }
        return key;
    }
}