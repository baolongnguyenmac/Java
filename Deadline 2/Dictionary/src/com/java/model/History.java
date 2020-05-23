package com.java.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement (name = "history")
public class History {
    private static History _instance = null;

    @XmlElement (name = "history_item")
    private ArrayList<HistoryItem> _historyList;

    private History() {
        _historyList = new ArrayList<>();
    }

    public static History get_instance() {
        if (_instance == null) {
            _instance = new History();
        }
        return _instance;
    }

    public void statisticWord() {
        System.out.print("Enter begin date (dd/mm/yyyy): ");
        String beginDate = Word.inputStringUTF8();
        Date bDate = null;
        try {
            bDate = new SimpleDateFormat("dd/mm/yyyy").parse(beginDate);
            bDate.setHours(0);
            bDate.setMinutes(0);
            bDate.setSeconds(0);
        }
        catch (NullPointerException | IllegalArgumentException | ParseException e) {
            System.out.println("Wrong format");
            bDate = new Date();
        }

        System.out.print("Enter end day (dd/mm/yyyy): ");
        String endDate = Word.inputStringUTF8();
        Date eDate = null;
        try {
            eDate = new SimpleDateFormat("dd/mm/yyyy").parse(endDate);
            eDate.setHours(23);
            eDate.setMinutes(59);
            eDate.setSeconds(59);
        }
        catch (NullPointerException | IllegalArgumentException | ParseException e) {
            System.out.println("Wrong format");
            eDate = new Date();
        }

        TreeMap<Word, Integer> treeMap = statisticWord(bDate, eDate);
        if (treeMap == null) {
            System.out.println("Wrong date");
        }
        else if (treeMap.size() == 0) {
            System.out.println("Empty list");
        }
        else {
            for(Map.Entry<Word, Integer> entry : treeMap.entrySet()) {
                System.out.println(entry.getKey() + " ---- " + entry.getValue());
            }
        }
    }

    private TreeMap<Word, Integer> statisticWord(Date d1, Date d2) {
        TreeMap<Word, Integer> treeMap = new TreeMap<>();
        if (!d1.before(d2)) {
            return null;
        }
        for (HistoryItem hi: _historyList) {
            if (hi.get_date().after(d1) && hi.get_date().before(d2)) {
                if (!treeMap.containsKey(hi.get_word())) {
                    treeMap.put(hi.get_word(), 1);
                }
                else {
                    int temp = treeMap.get(hi.get_word()) + 1;
                    treeMap.put(hi.get_word(), temp);
                }
            }
        }

        return treeMap;
    }
}

class HistoryItem {
    private Word _word;
    private Date _date;

    public Word get_word() {
        return _word;
    }

    public void set_word(Word _word) {
        this._word = _word;
    }

    public Date get_date() {
        return _date;
    }

    public void set_date(Date _date) {
        this._date = _date;
    }

    public HistoryItem(Word _word, Date _date) {
        this._word = _word;
        this._date = _date;
    }
}