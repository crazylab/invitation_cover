package fileIO;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CSVReader {
    private String fileName;

    List<String[]> entries = new ArrayList<>();

    public CSVReader(String fileName) {
        this.fileName = fileName;
    }

    public List<String[]> getData() throws IOException {
        File file = new File(fileName);
        long fileSize = file.length();

        String line = "";
        BufferedReader reader = new BufferedReader(new FileReader(file));

        while (reader.readLine() != null) {
            line = reader.readLine();
            String[] personDetails = line.split(",");
            entries.add(personDetails);
        }
        return entries;
    }
}
