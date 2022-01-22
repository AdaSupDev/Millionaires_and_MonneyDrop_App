import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;

public class MillionairesLeader extends Director {

    @Override
    public void welcomePlayer(String name) {
        System.out.println("Witaj, " + name + ", przed Tobą 12 pytań i milion do wygrania.");
        System.out.println("Pamiętaj, że masz 3 koła ratunkowe. By z nich skorzystać, zamiast odpowiedzi wpisz:");
        System.out.println("'1' by wybrać 50/50, '2' by wybrać telefon do przyjaciela, '3' by wybrać pytanie do publiczności.");
        System.out.println("Każde z kół możesz wykorzystać tylko raz. Możesz wykorzystać kilka kół przy jednym pytaniu.");
        System.out.println("'50/50' pozostawi odpowiedź poprawną oraz jedną z nieprawidłowych odpowiedzi.");
        System.out.println("Przyjaciel poda odpowiedź zgodnie z algorytmem dającym wysokie prawdopodobieństwo trafienia, ale nie zawsze będzie to poprawna odpowiedź.");
        System.out.println("Publiczość udzieli odpowiedzi zgodnie z algorytmem, który losowo dzieli 70 pp na wszystkie odpowiedzi, dodając 30 pp do poprawnej.");
        if (name.endsWith("a")) {
            System.out.println(name + ", jeśli jesteś gotowa, wciśnij Enter:");
        } else {
            System.out.println(name + ", jeśli jesteś gotowy, wciśnij Enter:");
        }
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }

    @Override
    public void introQuestion(int numberOfRound, Player p) {
        int[] cash = new int[]{500, 1_000, 2_000, 5_000, 10_000, 20_000, 40_000, 75_000, 125_000, 250_000, 500_000, 1_000_000};
        System.out.println("Pytanie " + (numberOfRound + 1) + ":");
        System.out.println(p.getName() + ", grasz o " + cash[numberOfRound] + " zł!");
        System.out.println();
    }

    @Override
    public Question drawQuestion(int numberOfRound, Question[][] Q) {
        int randomNumber;
        Random random = new Random();
        randomNumber = random.nextInt(3);
        return Q[numberOfRound][randomNumber];
    }

    public boolean askQuestion(Question Q, Player p) {
        HashSet<String> answerSet = new HashSet<>(); //elements will be added in random order
        answerSet.add(Q.correctAnswer);
        answerSet.add(Q.answer1);
        answerSet.add(Q.answer2);
        answerSet.add(Q.answer3);

        System.out.println(Q.content);
        Object[] arr = answerSet.toArray();
        char letter = 'A';
        for (int i = 0; i < 4; i++) {
            System.out.println(letter + ". " + arr[i]);
            letter++;
        }
        System.out.println();

        System.out.println("Twoja odpowiedź:");
        String answerOfPlayer = "";
        Scanner scanner = new Scanner(System.in);
        String temp;
        do {
            temp = scanner.nextLine();
            if (temp.equals("a")) {
                answerOfPlayer = (String) arr[0];
            }
            if (temp.equals("b")) {
                answerOfPlayer = (String) arr[1];
            }
            if (temp.equals("c")) {
                answerOfPlayer = (String) arr[2];

            }
            if (temp.equals("d")) {
                answerOfPlayer = (String) arr[3];
            }
            if (temp.equals("1") && p.isFiftyLifebuoy()) {
                arr = fiftyFifty(arr, Q);
                p.setFiftyLifebuoy(false);
            }
            if (temp.equals("2") && p.isFriendLifebuoy()) {
                askFriend(arr, Q);
                p.setFriendLifebuoy(false);
            }
            if (temp.equals("3") && p.isAudienceLifebuoy()) {
                askAudience(arr, Q);
                p.setAudienceLifebuoy(false);
            }
        } while (!(temp.equals("a") || temp.equals("b") || temp.equals("c") || temp.equals("d")));

        if (Q.correctAnswer.equals(answerOfPlayer)) { // Watch NullPointerException when reversed!
            Random random = new Random();
            System.out.println(congratsBox[random.nextInt(10)]);
            System.out.println();
        }
        return answerOfPlayer.equals(Q.correctAnswer);
    }

    public Object[] fiftyFifty(Object[] arr, Question Q) {
        Object[] newArr = new Object[4];
        char letter = 'A';
        int temp = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals(Q.correctAnswer)) {
                System.out.println(letter + ". " + arr[i]);
                newArr[i] = arr[i];
            } else if (temp < 1) {
                System.out.println(letter + ". " + arr[i]);
                newArr[i] = arr[i];
                temp++;
            } else {
                System.out.println();
                newArr[i] = null;
            }
            letter++;
        }
        System.out.println();
        System.out.println("Twoja odpowiedź:");
        return newArr;
    }

    public void askFriend(Object[] arr, Question Q) {
        Random random = new Random();
        int[] num = new int[arr.length];
        int sum = 0;
        for (int i = 0; i < num.length; i++) {
            num[i] = random.nextInt(10);
            sum += i;
        }
        int[] numArr = new int[arr.length];
        for (int i = 0; i < numArr.length; i++) {
            numArr[i] = num[i] * 55 / sum;
        }
        for (int i = 0; i < 4; i++) {
            if (arr[i].equals(Q.correctAnswer)) {
                numArr[i] += 45;
            }
        }
        int temp = 0;
        String answer = "";
        for (int i = 0; i < 4; i++) {
            if (numArr[i] > temp) {
                temp = numArr[i];
                answer = (String) arr[i];
            }

        }
        System.out.println("Myślę, że prawidłowa odpowiedź to... " + answer + ".");
        System.out.println();
        System.out.println("Twoja odpowiedź:");

    }

    public void askAudience(Object[] arr, Question Q) {
        Random random = new Random();
        int[] num = new int[arr.length];
        int sum = 0;
        for (int i = 0; i < num.length; i++) {
            if (arr[i] != null) {
                num[i] = random.nextInt(50);
                sum += num[i];
            } else {
                num[i] = 0;
            }
        }
        int[] numArr = new int[arr.length];
        for (int i = 0; i < numArr.length; i++) {
            if (arr[i] != null) {
                numArr[i] = num[i] * 70 / sum;
            } else {
                numArr[i] = 0;
            }
        }
        char letter = 'A';
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != null && arr[i].equals(Q.correctAnswer)) {
                numArr[i] += 30;
            }
            if (arr[i] != null) {
                System.out.println(letter + ". " + arr[i] + ": " + numArr[i] + " %");
            }
            letter++;
        }
        System.out.println();
        System.out.println("Twoja odpowiedź:");

    }
}


