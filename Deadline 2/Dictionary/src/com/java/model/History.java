package com.java.model;

import java.util.*;

public class History {
    private static History _instance = null;

    private ArrayList<HistoryItem> _history;

    private History() {
        _history = new ArrayList<>();
    }

    public static History getHistory() {
        if (_instance == null) {
            _instance = new History();
        }
        return _instance;
    }

    public ArrayList<HistoryItem> getListHistory() {
        return _history;
    }

    public void setHistory(ArrayList<HistoryItem> list) {
        _history.clear();
        for (HistoryItem hi: list) {
            _history.add(hi);
        }
    }

    public void addHistoryItem(String word) {
        _history.add(new HistoryItem(word, new Date()));
    }
}