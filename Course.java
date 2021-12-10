package com.example.demo15;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Course {

    ArrayList<String[]> team1SampleArray = new ArrayList<>();
    ArrayList<String[]> team2SampleArray = new ArrayList<>();


    public void loadStudents2() {
        String line = "";
        String splitBy = ",";

        try {
            BufferedReader br = new BufferedReader(new FileReader("gameScore2.csv"));

            while ((line = br.readLine()) != null){
                if (line.equals("")) {
                    continue;
                }else{
                    String temp[] = line.split(splitBy);
                    team2SampleArray.add(temp);
                    System.out.println(line);
                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }


    public void loadStudents() {
        String line = "";
        String splitBy = ",";

        try {
            BufferedReader br = new BufferedReader(new FileReader("gameScore1.csv"));

            while ((line = br.readLine()) != null){
                if (line.equals("")) {
                }else{
                    String[] temp = line.split(splitBy);
                    team1SampleArray.add(temp);
                    System.out.println(line);
                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public ArrayList<String[]> getTeam1SampleArray() {
        return team1SampleArray;
    }

    public ArrayList<String[]> getTeam2SampleArray() {
        return team2SampleArray;
    }


}
