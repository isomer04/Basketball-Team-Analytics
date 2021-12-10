package com.example.demo15;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class Main extends Application {

    public static ArrayList<String[]> team1Array = new ArrayList<>();
    public static ArrayList<String[]> team2Array = new ArrayList<>();

    public static Stage window;

    @Override
    public void start(Stage stage) throws IOException {
        this.window = stage;
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("studentLayout.fxml"));

        Scene scene = new Scene(fxmlLoader.load(), 750, 400);
        stage.setTitle("Basketball Team Analytics");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        Course course = new Course();
        course.loadStudents();
        course.loadStudents2();

        team1Array = course.getTeam1SampleArray();
        team2Array = course.getTeam2SampleArray();



        launch();
    }

}