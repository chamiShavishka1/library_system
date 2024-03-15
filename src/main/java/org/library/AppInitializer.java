package org.library;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.library.util.SessionFactoryConfiguration;

import java.io.IOException;

public class AppInitializer extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        Session session = SessionFactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        primaryStage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/forms/WelcomeForm.fxml"))));
        primaryStage.setTitle("BOOK Worm LiBrary");
        primaryStage.show();
    }
}