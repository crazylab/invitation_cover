package com.dataHandler;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileIO {
    public static List<String> readLines(String filePath) throws IOException {
        List<String> guestListAsText = new ArrayList<String>();
        BufferedReader reader = new BufferedReader(new FileReader(filePath));

        while (reader.readLine() != null)
            guestListAsText.add(reader.readLine());

        return guestListAsText;
    }
}
