package com.java.model;

import java.util.*;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

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

    public void statisticHistory() {
        String date = null;
        try {
            System.out.print("Enter beginning date (dd/MM/yyyy): ");
            date = Word.inputUTF8(new BufferedReader(new InputStreamReader(System.in, "utf8")));
            Date d1 = new SimpleDateFormat("dd/MM/yyyy").parse(date);
            d1.setHours(0);
            d1.setMinutes(0);
            d1.setSeconds(0);

            System.out.print("Enter end date (dd/MM/yyy): ");
            date = Word.inputUTF8(new BufferedReader(new InputStreamReader(System.in, "utf8")));
            Date d2 = new SimpleDateFormat("dd/MM/yyyy").parse(date);
            d2.setHours(23);
            d2.setMinutes(59);
            d2.setSeconds(59);

            if (!d1.before(d2)) {
                System.out.println("No history in this time");
                return;
            }

            TreeMap<String, Integer> list = statisticHistory(d1, d2);
            if (list.size() != 0) {
                System.out.println("WORD\t--\tNUMBER OF WORD");
                System.out.println("------------------------------");
                for(Map.Entry<String, Integer> entry : list.entrySet()) {
                    System.out.println(entry.getKey() + "\t--\t" + entry.getValue());
                }
            }
            else {
                System.out.println("No history in this time");
            }
        }
        catch (IOException e) {
            System.err.println("io error <statistic history>");
        }
        catch (ParseException e) {
            System.err.println("parse error <statistic history>");
        }
    }

    private TreeMap<String, Integer> statisticHistory(Date d1, Date d2) {
        TreeMap<String, Integer> treeMap = new TreeMap<>();
        for (HistoryItem hi: _history) {
            if (hi.getDate().before(d2) && hi.getDate().after(d1)) {
                if (!treeMap.containsKey(hi.getWord())) {
                    treeMap.put(hi.getWord(), 1);
                }
                else {
                    treeMap.put(hi.getWord(), treeMap.get(hi.getWord()) + 1);
                }
            }
        }
        return treeMap;
    }
}