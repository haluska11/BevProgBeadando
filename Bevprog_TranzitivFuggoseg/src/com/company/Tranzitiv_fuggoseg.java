package com.company;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;

public class Tranzitiv_fuggoseg {
    Map<String, HashSet<String>> alapfuggoseg = new HashMap<>();

    public static void main(String args[]) {
        Tranzitiv_fuggoseg fuggesek = new Tranzitiv_fuggoseg();
        fuggesek.Mapfeltolto("A B C");
        fuggesek.Mapfeltolto("B C E");
        fuggesek.Mapfeltolto("C G");
        fuggesek.Mapfeltolto("D A F");
        fuggesek.Mapfeltolto("E F");
        fuggesek.Mapfeltolto("F H");

        System.out.println(fuggesek.getFuggosegek());
    }

    public boolean Mapfeltolto(String beirtfuggoseg) {
        String[] StringElvalaszto = beirtfuggoseg.split(" ");
        String key = StringElvalaszto[0];
        HashSet<String> fuggosegek = new HashSet<>();
        for (int i = 1; i < StringElvalaszto.length; i++) {
            fuggosegek.add(StringElvalaszto[i]);
        }
        return alapfuggoseg.put(key, fuggosegek) != null;
    }

