public interface Mechanisms {

    public void welcomePlayer(String name);
    public void introQuestion(int numberOfRound, Player p);
    public Question drawQuestion(int numberOfRound, Question[][] Q);


}
