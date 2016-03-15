package com.command;

import util.IO;
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
        public List<String[]> readCSVFile(String path) throws IOException {
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
    public void test_runCommand_runs_the_given_command_when_asked_for_first_name_first_with_age_and_country_condition_irespective_of_the_font_casing_in_command() throws Exception {
        cli.runCommand("--firstNameFirst --couNtry bangladesh --ageAbove 28 file_path".split(" "));
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

    @Test
    public void test_runCommand_gives_label_for_all_when_asked_for_last_name_first_with_no_condition() throws Exception {
        cli.runCommand("--lastNameFirst file_path".split(" "));
        List<String> expected = new ArrayList<>();

        expected.add(
            "+---------------------+\n" +
            "| Ms Barrows, Julius  |\n" +
            "|---------------------|\n" +
            "| Veda haven, Vermont |\n" +
            "| Macedonia           |\n" +
            "+---------------------+"
        );

        expected.add(
            "+-----------------------------+\n" +
            "| Mr Hills, Catharine         |\n" +
            "|-----------------------------|\n" +
            "| West Shanna, South Carolina |\n" +
            "| Macedonia                   |\n" +
            "+-----------------------------+"
        );

        expected.add(
            "+------------------------------+\n" +
            "| Mr Denesik, Ashly            |\n" +
            "|------------------------------|\n" +
            "| Katlynn view, South Carolina |\n" +
            "| Bangladesh                   |\n" +
            "+------------------------------+"
        );

        expected.add(
            "+---------------------+\n" +
            "| Mr Runte, Jovanny   |\n" +
            "|---------------------|\n" +
            "| Crooks ton, Georgia |\n" +
            "| Qatar               |\n" +
            "+---------------------+"
        );

        expected.add(
            "+----------------------------+\n" +
            "| Ms Howe, Kaela             |\n" +
            "|----------------------------|\n" +
            "| New Alanna, Vermont        |\n" +
            "| Slovakia (Slovak Republic) |\n" +
            "+----------------------------+"
        );
        expected.add(
            "+-----------------------+\n" +
            "| Ms Ruecker, Alice     |\n" +
            "|-----------------------|\n" +
            "| West Shanna, Illinois |\n" +
            "| Romania               |\n" +
            "+-----------------------+"
        );


        expected.add(
            "+---------------------+\n" +
            "| Ms Walter, Gerry    |\n" +
            "|---------------------|\n" +
            "| New Alanna, Vermont |\n" +
            "| Bangladesh          |\n" +
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

        expected.add(
            "+------------------------------+\n" +
            "| Mr Denesik, Ashly            |\n" +
            "|------------------------------|\n" +
            "| Katlynn view, South Carolina |\n" +
            "| Bangladesh                   |\n" +
            "+------------------------------+"
        );


        for (int i = 0; i < results.size(); i++)
            assertEquals(expected.get(i), results.get(i));
    }
}