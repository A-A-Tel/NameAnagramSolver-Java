package com.anthony.anagramName;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class AnagramSolver {

    private static final String[] names;

    static {
        File file = new File("list.txt");

        Scanner sc;
        try {
            sc = new Scanner(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        List<String> list = new ArrayList<>();

        while (sc.hasNextLine()) {
            list.add(sc.nextLine().toLowerCase().replaceAll("[^a-z]", ""));
        }

        names = list.toArray(new String[0]);
    }

    public static String[] FindAnagrams(String name) {

        final byte[] charCount = new byte[26];

        for (char c : name.toLowerCase().toCharArray()) {
            charCount[c - 'a']++;
        }
        System.out.println(names.length);

        List<String> list = new ArrayList<>();

        for (String listedName : names) {

            byte[] listedCharCount = new byte[26];
            for (char c : listedName.toCharArray()) {
                listedCharCount[c - 'a']++;
            }

            if (Arrays.equals(charCount, listedCharCount)) list.add(listedName);
        }

        return list.toArray(new String[0]);
    }

}
