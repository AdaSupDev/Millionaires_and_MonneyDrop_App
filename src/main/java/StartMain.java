import java.util.Scanner;

public class StartMain {
    public static void main(String[] args) {

        System.out.println("Zagrajmy w grę :) Jak masz na imię?");
        Player player = new Player();
        Scanner scanner = new Scanner(System.in);
        player.setName(scanner.nextLine()); // 4egz. of encapsulation
        String nameOfPlayer = player.getName();

        int num;
        do {
            System.out.println("Jeśli chcesz zagrać w 'Milionerów', wpisz 1. Jeśli chcesz zagrać w 'Postaw na Milion', wpisz 2.");
            num = Integer.parseInt(scanner.nextLine()); // Avoids the problem on line 31
        } while (!(num == 1 || num == 2));

        Director leader;
        if (num == 1) {
            leader = new MillionairesLeader();
        } else {
            leader = new MoneyDropLeader();
        }

        leader.welcomePlayer(nameOfPlayer);
        int numberOfRound = 0;
        boolean isTrue = true;

        while (isTrue && numberOfRound < 4) { //Set number of available levels!
            leader.introQuestion(numberOfRound, player);
            Question nextQuestion = leader.drawQuestion(numberOfRound, leader.arrayOfQuestion);
            if (num == 1) {
                isTrue = ((MillionairesLeader) leader).askQuestion(nextQuestion, player); // Core of round <-------------------
            } else {
                player.setAccount(((MoneyDropLeader) leader).askQuestionMoneyDrop(nextQuestion, player));
            }
            if (player.getAccount() == 0) {
                isTrue = false;
            }
            if (isTrue && numberOfRound < 3) { //Set number of available levels - 1!
                System.out.println("Następne pytanie? Wciśnij Enter!");
                System.out.println();
                scanner.nextLine();
            }
            numberOfRound++;
        }
        if (num == 1 && isTrue) {
            System.out.println("Gratulacje, jesteś MILIONEREM");
        } else if (num != 1 && player.getAccount() > 0) {
            System.out.println("Gratulacje, Twoja nagroda to " + player.getAccount() + " zł!!!");
        } else {
            System.out.println("Niestety, to była błędna odpowiedź...");
        }

    }
}
