package com.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileIO {
    public static ArrayList<String[]> readCSVLine(String filePath) throws IOException {
        ArrayList<String[]> guestListAsText = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(filePath));

        while (reader.readLine() != null)
            guestListAsText.add(reader.readLine().split(","));

        return guestListAsText;
    }
}
