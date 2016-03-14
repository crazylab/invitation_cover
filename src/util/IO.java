package util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class IO {
    public void print(List<String> labels) {
        for (String label : labels)
            System.out.println(label);
    }

    public List<String[]> readCSV(String path) throws IOException {
        ArrayList<String[]> guestListAsArray = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(path));
        while (reader.readLine() != null)
            guestListAsArray.add(reader.readLine().split(","));
        return guestListAsArray;
    }
}
