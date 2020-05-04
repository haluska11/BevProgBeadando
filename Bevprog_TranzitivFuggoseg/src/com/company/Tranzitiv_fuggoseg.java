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

    public Map<String, HashSet<String>> getFuggosegek() {
        Map<String, HashSet<String>> tranzitivfuggosegek = new HashMap<>();
        for (Entry<String, HashSet<String>> entry : alapfuggoseg.entrySet()) {
            String kulcs = entry.getKey(); //kulcs a betű amihez képest a többi függ pl.: A
            Set<String> fuggesakulcshoz = entry.getValue();
            Queue<String> fuggesekQueue = new LinkedList<String>();
            if (fuggesakulcshoz != null) {
                fuggesekQueue.addAll(fuggesakulcshoz);
            }
            HashSet<String> osszesfuggesek = new HashSet<String>(); //a konkrét függések listáját jeleníti meg (A függ B,C)
            Queue<String> segedfuggosegQueue = new LinkedList<String>();
            while (!fuggesekQueue.isEmpty()) {
                for (String d : fuggesekQueue) {
                    osszesfuggesek.add(d);
                    if (alapfuggoseg.get(d) != null) {
                        for (String s : alapfuggoseg.get(d)) {
                            segedfuggosegQueue.add(s);
                        }
                    }
                }
                fuggesekQueue = segedfuggosegQueue;
                segedfuggosegQueue = new LinkedList<String>();
            }
            tranzitivfuggosegek.put(kulcs, osszesfuggesek);
        }
        return tranzitivfuggosegek;
    }
}