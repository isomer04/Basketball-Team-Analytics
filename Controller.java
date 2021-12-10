package com.example.demo15;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.cell.TextFieldListCell;
import javafx.scene.text.Text;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Controller {

    @FXML
    private ListView<String> studentListView;
    @FXML
    private ListView<String> studentListView1;
    @FXML
    private Text averagePoints;
    @FXML
    private Text averagePointsDifferentials;
    @FXML
    private Text highestScore;
    @FXML
    private Text lowestScore;

//    ObservableList : A list that enables listeners to track changes when they occur.
    ObservableList<String> items = FXCollections.observableArrayList();
    ObservableList<String> items2 = FXCollections.observableArrayList();


//    Global Arrays
    int[] team1Scores = new int[10];
    int[] team2Scores = new int[10];

    double[] team1AverageGame = new double[10];
    double[] team2AverageGame = new double[10];

    double[] quarterArrayAverageTeam1 = new double[4];
    double[] quarterArrayAverageTeam2 = new double[4];


    double[] halfQuarterArrayAverageTeam1 = new double[2];
    double[] halfQuarterArrayAverageTeam2 = new double[2];



    double[] averageDifferentialQuarter = new double[4];
    double[] averageDifferentialHalf = new double[2];
    double[] averageDifferentialGame = new double[10];



    ArrayList<String[]> team1Array = Main.team1Array;
    ArrayList<String[]> team2Array = Main.team2Array;





    // populating data in first List for team1
    public void populateList() {
        populateTeamSampleData(studentListView, items, team1Array);

    }

    private void populateTeamSampleData(ListView<String> studentListView, ObservableList<String> items, ArrayList<String[]> studentArray) {
        try {
            studentListView.getItems().clear();
            studentListView.setEditable(true);
            studentListView.setCellFactory(TextFieldListCell.forListView());
            studentListView.setItems(items);

            for (int i = 0; i < studentArray.size(); i++) {
                String[] temp = studentArray.get(i);

                String testStudent = arrayToString(temp);
                studentListView.getItems().add(testStudent);
            }
        } catch (Exception e) {
        }
    }

    // populating data in second List for team2


    public void populateList2() {
        populateTeamSampleData(studentListView1, items2, team2Array);

    }


    public String arrayToString(String[] team) {

        return team[0] + "" + team[1] + " " + team[2] + "" + team[3];

    }


    // Generate data for reports
    public void updateList() {

        try{
            getTeam1LineTotalGameScore();
            getTeam2LineTotalGameScore();

            System.out.println(Arrays.toString(team1AverageGame) +" This is team1averageScoresQuarter" );
            System.out.println(Arrays.toString(team2AverageGame) +" This is team2averageScoresQuarter" );


            averagePointDifferential();


            // Display report text in javaFx window
            averagePoints.setText("Team1 Game Average: " + Arrays.toString( team1AverageGame) + "\n" + "Team2 Game Average: "
                    + Arrays.toString(team2AverageGame) + "\n" + "Team 1 Average points Quarter: "  + Arrays.toString( quarterArrayAverageTeam1)
                    +  "\n" +   "Team 2 Average points Quarter: " + Arrays.toString( quarterArrayAverageTeam2)
                    +  "\n"   +  "Team 1 Average points Half Quarter: " + Arrays.toString( halfQuarterArrayAverageTeam1)
                    +  "\n"  +  "Team 2 Average points Half Quarter: " + Arrays.toString( halfQuarterArrayAverageTeam2)


            );


            averagePointsDifferentials.setText("Game Average Differentials: " + Arrays.toString(averageDifferentialGame)
                    + "\n" + " Average points Quarter Differentials: "  + Arrays.toString(averageDifferentialQuarter)
                    +  "\n"   +  " Average points Half Quarter Differentials: " + Arrays.toString(averageDifferentialHalf)


            );

            lowestHighestPoint_new(items, items2);

        }

        catch (Exception e){
            System.out.println("\nClick on both teams sample data");
        }


    }

    private void getTeam1LineTotalGameScore() {

        teamScoreLineTotal(team1Scores, items, team1AverageGame, quarterArrayAverageTeam1, halfQuarterArrayAverageTeam1);

    }


    private void getTeam2LineTotalGameScore() {

        teamScoreLineTotal(team2Scores, items2, team2AverageGame, quarterArrayAverageTeam2, halfQuarterArrayAverageTeam2);


    }

    private void teamScoreLineTotal(int[] teamScores, List<String> items, double[] teamAverageGame, double[] quarterArrayAverageTeam, double[] halfQuarterArrayAverageTeam) {

        int i ;
        int j = 0;

        int totalSum1 = 0;
        int totalSum2 = 0;
        int totalSum3 = 0;
        int totalSum4 = 0;

        System.out.println("##########################################################");


        System.out.println("##########################################################");


        for (String tab : items) {


            // calling replaceAll() method and split() method on
            // string
            String[] string = tab.replaceAll("\\s", ",").replaceAll(",{2,}", ",").split(",");


            // declaring an array with the size of string


            int[] arr = new int[string.length];

            // parsing the String argument as a signed decimal
            // integer object and storing that integer into the
            // array
            for (i = 0; i < string.length; i++) {
                arr[i] = Integer.valueOf(string[i]);
            }



            // Average by per game
            int sum = 0;
            double average = 0;



            for (i = 0; i < arr.length; i++) {
                sum += arr[i];
                average = (double) sum / 4;
            }

            teamScores[j] = sum;
            teamAverageGame[j] = average;
            j++;


            for (i = 1; i < arr.length; i++) {
                sum += arr[i];
            }

            // Average by per quarter

            int sum1 = 0;
            int sum2 = 0;
            int sum3 = 0;
            int sum4 = 0;


            //first quarter average
            for ( i = 0; i <1; i++) {
                sum1 += arr[0];
            }
            totalSum1 += sum1;

            quarterArrayAverageTeam[0] = (double )totalSum1 /10;

            //second quarter average
            for ( i = 1; i <2; i++) {
                sum2 += arr[1];
            }
            totalSum2 += sum2;
            quarterArrayAverageTeam[1] = (double )totalSum2 /10;

            //Third quarter average
            for ( i = 2; i <3; i++) {
                sum3 += arr[2];
            }
            totalSum3 += sum3;
            quarterArrayAverageTeam[2] = (double )totalSum3 /10;


            //Fourth quarter average
            for ( i = 3; i <4; i++) {
                sum4 += arr[3];
            }
            totalSum4 += sum4;
            quarterArrayAverageTeam[3] = (double )totalSum4 /10;

            // Average by per half quarter


            halfQuarterArrayAverageTeam[0] = quarterArrayAverageTeam[0] + quarterArrayAverageTeam[1];
            halfQuarterArrayAverageTeam[1] = quarterArrayAverageTeam[2] + quarterArrayAverageTeam[3];

        }

        System.out.println(Arrays.toString(quarterArrayAverageTeam) + "this is a quarterArrayAverageTeam" );

        System.out.println(Arrays.toString(halfQuarterArrayAverageTeam) + "this is a halfQuarterArrayAverageTeam");



    }

    public void averagePointDifferential(){


        for(int i = 0; i< averageDifferentialQuarter.length; i++){
            averageDifferentialQuarter[i] = (quarterArrayAverageTeam1[i]) - quarterArrayAverageTeam2[i];
        }

        for(int i = 0; i< averageDifferentialHalf.length; i++){
            averageDifferentialHalf[i] = halfQuarterArrayAverageTeam1[i] - halfQuarterArrayAverageTeam2[i];
        }

        for(int i = 0; i< averageDifferentialGame.length; i++){
            averageDifferentialGame[i] = team1AverageGame[i] - team2AverageGame[i];
        }

        System.out.println(Arrays.toString(averageDifferentialQuarter) + " this is averagDifferentialQuarter ");

        System.out.println(Arrays.toString(averageDifferentialHalf) + " this is averagDifferentialHalf ");
        System.out.println(Arrays.toString(averageDifferentialGame) + " this is averagDifferentialGame ");

        Arrays.stream(averageDifferentialQuarter).filter(s -> s >= 0).toArray();
        System.out.println(Arrays.toString(averageDifferentialQuarter) + " this is averagDifferentialQuarter ");


    }

//    public void teamHalfScores(int[] teamScores1,int[] teamScores2){
//        int team1halfScorestotal = 0;
//        int team2halfScorestotal = 0;
//
//
//        for (int i = 0; i < (teamScores1.length /2) ; i++) {
//            team1halfScorestotal += teamScores1[i];
//            team2halfScorestotal += teamScores2[i];
//
//
//
//        }
//
//
//
////        System.out.println(team2halfScorestotal + " half score arrays");
//        double team1halfscoreAverage = (double) team1halfScorestotal/(teamScores1.length /2) ;
//        double team2halfscoreAverage = (double) team2halfScorestotal/(teamScores2.length /2);
//
//        System.out.println(team1halfscoreAverage + " This is team1halfscoreAverage============== " + team1halfScorestotal);
//        System.out.println(team2halfscoreAverage + " This is team2halfscoreAverage============== "  + team2halfScorestotal);
//    }





    public void lowestHighestPoint_new(List<String> items, List<String> items2) {


        // converting team list to String array

        StringBuilder strbul1=new StringBuilder();
        StringBuilder strbul2=new StringBuilder();

        for(String str : items)
        {
            strbul1.append(str);
            //for adding comma between elements
            strbul1.append(",");
        }

        for(String str : items2)
        {
            strbul2.append(str);
            //for adding comma between elements
            strbul2.append(",");
        }


        String str1=strbul1.toString();
        String str2=strbul2.toString();




        String[] team1 = str1.replaceAll("\\s", ",").replaceAll(",{2,}", ",").split(",");
        String[] team2 = str2.replaceAll("\\s", ",").replaceAll(",{2,}", ",").split(",");


        // copying both team scores arrays to one array
        String[] bothTeamQuarterScore = Arrays.copyOf(team1, team1.length + team1.length);
        System.arraycopy(team2, 0, bothTeamQuarterScore, team1.length, team2.length);



//      Converting String Array to Int Array
        int[] bothTeamIntQuarterScore = Arrays.stream(bothTeamQuarterScore).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(bothTeamIntQuarterScore);

        System.out.println("Lowest score in all quarters is " + bothTeamIntQuarterScore[0]);
        System.out.println("Highest score in all quarters is " + bothTeamIntQuarterScore[bothTeamIntQuarterScore.length -1]);
        System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");

        lowestScore.setText("Lowest score: " + bothTeamIntQuarterScore[0]);
        highestScore.setText("Highest score: " + bothTeamIntQuarterScore[bothTeamIntQuarterScore.length -1]);


    }

}
