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

