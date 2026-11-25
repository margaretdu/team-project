package app;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        AppBuilder appBuilder = new AppBuilder();
        appBuilder.setGUI();
        JFrame application = appBuilder
                .addHomescreenView()
                .addDeckView()
                .addStudyView()
                .addCreateDeckView()
                .addCreateFlashcardView()
                .addGetAllDecksUseCase()
                .addGetDeckUseCase()
                .addCreateDeckUseCase()
                .addCreateFlashcardUseCase()
                .addDeleteFlashcardUseCase()
                .build();

        application.pack();
        application.setLocationRelativeTo(null);
        application.setVisible(true);
    }
}
