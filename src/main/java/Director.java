import java.util.HashSet;
import java.util.Random;

public class Director {

    final Question[][] arrayOfQuestion = new Question[3][3];

    {
        arrayOfQuestion[0][0] = Question.L0Q0;
        arrayOfQuestion[0][1] = Question.L0Q1;
        arrayOfQuestion[0][2] = Question.L0Q2;
        arrayOfQuestion[1][0] = Question.L1Q0;
        arrayOfQuestion[1][1] = Question.L1Q1;
        arrayOfQuestion[1][2] = Question.L1Q2;
        arrayOfQuestion[2][0] = Question.L2Q0;
        arrayOfQuestion[2][1] = Question.L2Q1;
        arrayOfQuestion[2][2] = Question.L2Q2;
    }

    final String[] congratsBox = new String[]{"Gratulacje!", "Świetnie!", "Dobra robota!", "Wyśmienicie!", "Oby tak dalej", "Brawo Ty!", "Wspaniale!", "I to jest poprawna odpowiedź!", "Udało się!", "Widzę, że mamy tu eksperta!"};

}