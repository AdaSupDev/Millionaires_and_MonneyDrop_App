public class Player {

    private String name; // 4egz. of encapsulation
    private boolean fiftyLifebuoy = true;
    private boolean friendLifebuoy = true;
    private boolean audienceLifebuoy = true;
    private int account = 1_000_000;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isFiftyLifebuoy() {
        return fiftyLifebuoy;
    }

    public void setFiftyLifebuoy(boolean fiftyLifebuoy) {
        this.fiftyLifebuoy = fiftyLifebuoy;
    }

    public boolean isFriendLifebuoy() {
        return friendLifebuoy;
    }

    public void setFriendLifebuoy(boolean friendLifebuoy) {
        this.friendLifebuoy = friendLifebuoy;
    }

    public boolean isAudienceLifebuoy() {
        return audienceLifebuoy;
    }

    public void setAudienceLifebuoy(boolean audienceLifebuoy) {
        this.audienceLifebuoy = audienceLifebuoy;
    }

    public int getAccount() {
        return account;
    }

    public void setAccount(int account) {
        this.account = account;
    }
}
