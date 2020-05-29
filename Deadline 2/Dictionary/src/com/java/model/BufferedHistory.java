package com.java.model;

import java.util.*;

import javax.xml.bind.annotation.*;

@XmlRootElement (name = "history")
@XmlAccessorType(XmlAccessType.FIELD)
public class BufferedHistory {
    @XmlElement (name = "item")
    private ArrayList<HistoryItem> _listHistoryItem;

    public BufferedHistory() {
        _listHistoryItem = new ArrayList<>();
    }

    public void setListHistoryItem(ArrayList<HistoryItem> list) {
        _listHistoryItem.clear();
        for (HistoryItem hi: list) {
            _listHistoryItem.add(hi);
        }
    }

    public ArrayList<HistoryItem> getListHistoryItem() {
        return _listHistoryItem;
    }
}

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
class HistoryItem {
    @XmlElement (name = "word")
    private String _word;
    @XmlElement (name = "date")
    private Date _date;

    public HistoryItem(){}

    public HistoryItem(String word, Date date) {
        _word = word;
        _date = date;
    }

    public void setWord(String word) {
        _word = word;
    }

    public void setDate(Date date) {
        _date = date;
    }

    public String getWord() {
        return _word;
    }

    public Date getDate() {
        return _date;
    }
}