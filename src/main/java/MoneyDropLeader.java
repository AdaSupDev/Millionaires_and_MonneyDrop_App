import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;

public class MoneyDropLeader extends Director {

    @Override
    public void welcomePlayer(String name) {
        System.out.println("Witaj, " + name + ". Przed Tobą milion złotych i 8 pytań.");
        System.out.println("Ponieważ jest to uproszczona wersja gry, nie będziesz wybierać kategorii i nie będzie odmierzany czas.");
        System.out.println("Musisz postawić całą forsę na 1, 2 lub 3 odpowiedzi. Jeśli przy odpowiedziach A, B i C podasz liczbę większą od 0,");
        System.out.println("System automatycznie uzupełni pole D = 0 i jeśli została Ci forsa, której nie przypisałeś, trafi ona na pole C.");
        System.out.println("Jeśli przy odpowiedzi D wpiszesz liczbę większą od 0, ale niepoprawną, System automatycznie ustawi tam resztę z Twojego konta.");
        System.out.println("Grasz, póki masz kasę. Ciekawe, ile wyrgasz!");
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
        System.out.println(p.getName() + ", masz " + p.getAccount() + " zł.");
        if (p.getName().endsWith("a")) {
            System.out.println("Jeśli jesteś gotowa na rundę " + ++numberOfRound + ", wciśnij Enter:");
        } else {
            System.out.println("Jeśli jesteś gotowy na rundę " + ++numberOfRound + ", wciśnij Enter:");
        }
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }

    @Override
    public Question drawQuestion(int numberOfRound, Question[][] Q) {
        int randomNumber;
        Random random = new Random();
        randomNumber = random.nextInt(3);
        return Q[numberOfRound][randomNumber];
    }

    public int askQuestionDrop(Question Q, Player p) {
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
        int[] traps = new int[4];
        int counter = 0;
        int account = p.getAccount();
        letter = 'A';
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < traps.length - 1; i++) {
            do {
                System.out.println("Na odpowiedź " + letter + " stawiasz:");
                traps[i] = scanner.nextInt();
                if (traps[i] > account - counter) {
                    System.out.println("Nie masz tyle forsy!");
                }
            } while (traps[i] > account - counter); //!
            letter++;
            counter += traps[i];
            System.out.println("Zostało Ci " + (account - counter) + " zł.");
        }

        System.out.println("Na odpowiedź D stawiasz:");
        scanner.nextInt();
        if (traps[0] > 0 && traps[1] > 0 && traps[2] > 0) {
            traps[3] = 0;
            traps[2] = account - (traps[0] + traps[1]);
        } else if (counter == 0) {
            traps[3] = account;
        } else {
            traps[3] = account - counter;
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals(Q.correctAnswer)) {
                account = traps[i];
            }
        }
        System.out.println("Na D postawiłeś " + traps[3] + " zł.");
        System.out.println();
        System.out.println("Wygrywasz.... " + account + " zł.");
        return account;
    }

}
