package com.command;

import com.util.IO;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class CLITest {
    private List<String> results = new ArrayList<>();
    private IO io;
    private CLI cli;

    private class mockIO extends IO {
        @Override
        public void print(List<String> labels) {
            for (String label : labels)
                results.add(label);
        }

        @Override
        public List<String[]> readCSV(String path) throws IOException {
            ArrayList<String[]> guestListAsArray = new ArrayList<>();
            guestListAsArray.add("Julius,Barrows,Female,18,Veda haven,Vermont,Macedonia".split(","));
            guestListAsArray.add("Catharine,Hills,Male,20,West Shanna,South Carolina,Macedonia".split(","));
            guestListAsArray.add("Ashly,Denesik,Male,21,Katlynn view,South Carolina,Bangladesh".split(","));
            guestListAsArray.add("Jovanny,Runte,Male,28,Crooks ton,Georgia,Qatar".split(","));
            guestListAsArray.add("Kaela,Howe,Female,20,New Alanna,Vermont,Slovakia (Slovak Republic)".split(","));
            guestListAsArray.add("Alice,Ruecker,Female,37,West Shanna,Illinois,Romania".split(","));
            guestListAsArray.add("Gerry,Walter,Female,31,New Alanna,Vermont,Bangladesh".split(","));
            guestListAsArray.add("Major,Durgan,Male,29,Veda haven,Georgia,Bangladesh".split(","));
            return guestListAsArray;
        }
    }

    @Before
    public void setUp() throws Exception {
        io = new mockIO();
        cli = new CLI(io);
    }

    @Test
    public void test_runCommand_runs_the_given_command_when_asked_for_first_name_first_with_age_and_country_condition() throws Exception {
        cli.runCommand("--firstNameFirst --country Bangladesh --ageabove 28 file_path".split(" "));
        List<String> expected = new ArrayList<>();

        expected.add(
            "+---------------------+\n" +
            "| Ms Gerry Walter     |\n" +
            "|---------------------|\n" +
            "| New Alanna, Vermont |\n" +
            "| Bangladesh          |\n" +
            "+---------------------+"
        );
        expected.add(
            "+---------------------+\n" +
            "| Mr Major Durgan     |\n" +
            "|---------------------|\n" +
            "| Veda haven, Georgia |\n" +
            "| Bangladesh          |\n" +
            "+---------------------+");

        for (int i = 0; i < results.size(); i++)
            assertEquals(expected.get(i), results.get(i));
    }

    @Test
    public void test_runCommand_runs_the_given_command_when_asked_for_last_name_first_with_age_and_country_condition() throws Exception {
        cli.runCommand("--lastNameFirst --country Bangladesh --ageabove 28 file_path".split(" "));
        List<String> expected = new ArrayList<>();

        expected.add(
            "+---------------------+\n"+
            "| Ms Walter, Gerry    |\n"+
            "|---------------------|\n"+
            "| New Alanna, Vermont |\n"+
            "| Bangladesh          |\n"+
            "+---------------------+"
        );
        expected.add(
            "+---------------------+\n" +
            "| Mr Durgan, Major    |\n" +
            "|---------------------|\n" +
            "| Veda haven, Georgia |\n" +
            "| Bangladesh          |\n" +
            "+---------------------+"
        );

        for (int i = 0; i < results.size(); i++)
            assertEquals(expected.get(i), results.get(i));
    }

    @Test
    public void test_runCommand_runs_the_given_command_when_asked_for_first_name_first_with_country_condition_only() throws Exception {
        cli.runCommand("--firstNameFirst --country Bangladesh file_path".split(" "));
        List<String> expected = new ArrayList<>();

        expected.add(
            "+------------------------------+\n" +
            "| Mr Ashly Denesik             |\n" +
            "|------------------------------|\n" +
            "| Katlynn view, South Carolina |\n" +
            "| Bangladesh                   |\n" +
            "+------------------------------+"
        );
        expected.add(
            "+---------------------+\n" +
            "| Ms Gerry Walter     |\n" +
            "|---------------------|\n" +
            "| New Alanna, Vermont |\n" +
            "| Bangladesh          |\n" +
            "+---------------------+"
        );
        expected.add(
            "+---------------------+\n" +
            "| Mr Major Durgan     |\n" +
            "|---------------------|\n" +
            "| Veda haven, Georgia |\n" +
            "| Bangladesh          |\n" +
            "+---------------------+"
        );

        for (int i = 0; i < results.size(); i++)
            assertEquals(expected.get(i), results.get(i));
    }

    @Test
    public void test_runCommand_runs_the_given_command_when_asked_for_first_name_first_with_age_condition_only() throws Exception {
        cli.runCommand("--firstNameFirst --ageabove 28 file_path".split(" "));
        List<String> expected = new ArrayList<>();

        expected.add(
            "+-----------------------+\n" +
            "| Ms Alice Ruecker      |\n" +
            "|-----------------------|\n" +
            "| West Shanna, Illinois |\n" +
            "| Romania               |\n" +
            "+-----------------------+"
        );


        expected.add(
            "+---------------------+\n" +
            "| Ms Gerry Walter     |\n" +
            "|---------------------|\n" +
            "| New Alanna, Vermont |\n" +
            "| Bangladesh          |\n" +
            "+---------------------+"
        );
        expected.add(
                "+---------------------+\n" +
                "| Mr Major Durgan     |\n" +
                "|---------------------|\n" +
                "| Veda haven, Georgia |\n" +
                "| Bangladesh          |\n" +
                "+---------------------+"
        );

        for (int i = 0; i < results.size(); i++)
            assertEquals(expected.get(i), results.get(i));
    }
}