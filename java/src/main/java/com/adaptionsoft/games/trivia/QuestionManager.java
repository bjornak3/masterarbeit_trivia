package com.adaptionsoft.games.trivia;

import java.util.LinkedList;

public class QuestionManager {

    private final LinkedList popQuestions = new LinkedList();
    private final LinkedList scienceQuestions = new LinkedList();
    private final LinkedList sportsQuestions = new LinkedList();
    private final LinkedList rockQuestions = new LinkedList();

    public QuestionManager(){
        initializeQuestions();
    }

    private void initializeQuestions(){
        for (int i = 0; i < 50; i++) {
            popQuestions.addLast("Pop Question " + i);
            scienceQuestions.addLast(("Science Question " + i));
            sportsQuestions.addLast(("Sports Question " + i));
            rockQuestions.addLast(createRockQuestion(i));
        }
    }

    private String createRockQuestion(int index){
        return "Rock Question " + index;
    }

    public void askQuestion(int place) {
        if (currentCategory(place) == "Pop")
            System.out.println(popQuestions.removeFirst());
        if (currentCategory(place) == "Science")
            System.out.println(scienceQuestions.removeFirst());
        if (currentCategory(place) == "Sports")
            System.out.println(sportsQuestions.removeFirst());
        if (currentCategory(place) == "Rock")
            System.out.println(rockQuestions.removeFirst());
    }

    public String currentCategory(int place) {
        if (place == 0) return "Pop";
        if (place == 4) return "Pop";
        if (place == 8) return "Pop";
        if (place == 1) return "Science";
        if (place == 5) return "Science";
        if (place == 9) return "Science";
        if (place == 2) return "Sports";
        if (place == 6) return "Sports";
        if (place == 10) return "Sports";
        return "Rock";
    }
}
