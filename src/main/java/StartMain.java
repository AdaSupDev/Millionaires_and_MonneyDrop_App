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




        if (num == 1) {
            MillionairesLeader millionairesLeader = new MillionairesLeader();
            millionairesLeader.welcomePlayer(nameOfPlayer);
            int numberOfRound = 0;
            boolean isTrue = true;

            while (isTrue && numberOfRound < 4) { //Set number of available levels!
                millionairesLeader.introQuestion(numberOfRound, player);
                Question nextQuestion = millionairesLeader.drawQuestion(numberOfRound, millionairesLeader.arrayOfQuestion);
                isTrue = millionairesLeader.askQuestion(nextQuestion, player); // Core of round <-------------------
                if (isTrue && numberOfRound < 2) {
                    System.out.println("Następne pytanie? Wciśnij Enter!");
                    System.out.println();
                    scanner.nextLine();
                }
                numberOfRound++;
            }
            if (isTrue) {
                System.out.println("Gratulacje, jesteś MILIONEREM");
            } else {
                System.out.println("Niestety, to była błędna odpowiedź...");
            }
        } else {
            MoneyDropLeader moneyDropLeader = new MoneyDropLeader();
            moneyDropLeader.welcomePlayer(nameOfPlayer);
            int numberOfRound = 0;

            while (numberOfRound < 4 && player.getAccount() > 0) {  //Set number of available levels!
                moneyDropLeader.introQuestion(numberOfRound, player);
                Question nextQuestion = moneyDropLeader.drawQuestion(numberOfRound, moneyDropLeader.arrayOfQuestion);
                player.setAccount(moneyDropLeader.askQuestionDrop(nextQuestion, player));
                if (player.getAccount() > 0 && numberOfRound < 3) { //Set number of available levels - 1!
                    System.out.println("Następne pytanie? Wciśnij Enter!");
                    System.out.println();
                    scanner.nextLine();
                }
                numberOfRound++;
            }
            if (player.getAccount() > 0) {
                System.out.println("Gratulacje, Twoja nagroda to " + player.getAccount() + " zł!!!");
            } else {
                System.out.println("Niestety, to koniec gry...");
            }

        }

    }
}
