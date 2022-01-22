public enum Question {

    L0Q0("Zmienne służą do:", "Przechowywania danych w programach", "Zmiany właściwości metody", "Zmiany wartości pól klasy", "Zmiany nazwy pakietu"),
    L0Q1("W Javie operatorem przypisania jest:", "=", "==", "->", "is"),
    L0Q2("Stała nazwana jest definiowana za pomocą słowa kluczowego:", "final", "constans", "key", "private"),
    L1Q0("Który typ przechowuje liczbę zmiennoprzecinkową?", "double", "long", "int", "byte"),
    L1Q1("Iteracja to:", "Jedno wykonanie zawartości pętli", "Wypisywanie na ekranie litery 'i'", "Literowanie tekstu", "Inicjalizacja zemiennej typu String"),
    L1Q2("Inkrementacja to:", "Zwiększenie wartości liczbowej zmiennej o 1", "Zmiana wartości pola w klasie", "Zmniejszenie wartości liczbowej zmiennej o 1", "Komenda do zakończenia pętli"),
    L2Q0("Słowo kluczowe break:", "Służy do wyjścia z pętli", "Służy do wyjścia z programu", "Zatrzymuje program do czasu reakcji użytkownika", "Hamuje proces zużycia pamięci"),
    L2Q1("Enum to:", "Typ wyliczeniowy", "Typ prosty", "Metoda zwracająca wartość logiczną", "Klasa z jednym polem"),
    L2Q2("Metod do obsługi tablic należy szukać w klasie:", "Arrays", "String", "Integer", "StringBuilder"),
    L3Q0("OOP to skrót oznaczający:", "Programowanie obiektowe", "Programowanie funkcyjne", "Organizację Ochrony Programistów", "Interfejs funcyjny" ),
    L3Q1("Metoda abstrakcyjna:", "Jest zdefiniowana bez implementacji", "Zwraca abstrakcyjny typ danych","Jest to metoda bardzo skomplikowana", "Jest to metoda bezargumentowa"),
    L3Q2("Które zdanie jest fałszywe?", "Klasa Object jest abstrakcyjna", "Nie można tworzyć instancji klas abstrakcyjnych", "Można używać klasy abstrakcyjnej jako typu danych", "Metoda abstrakcyjkna nie może się znajdować w klasie nieabstrakcyjnej");

    String content;
    String correctAnswer;
    String answer1;
    String answer2;
    String answer3;

    Question(String content, String correctAnswer, String answer1, String answer2, String answer3) {
        this.content = content;
        this.correctAnswer = correctAnswer;
        this.answer1 = answer1;
        this.answer2 = answer2;
        this.answer3 = answer3;
    }
}
