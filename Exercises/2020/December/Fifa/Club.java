package ir.blog.mahdidavoodi;

public class Club {
    private final String clubName, clubID, owner;
    private long clubWorth, transferBudget;
    private int UEFAChampionsLeague, UEFAEuropaLeague, UEFASuperCup, MTLeague, totalCups, totalWin, totalLose, totalDraw;

    public Club(String clubName, String clubID, String owner) {
        this.clubName = clubName;
        this.clubID = clubID;
        this.owner = owner;
    }

    public long getClubWorth() {
        return clubWorth;
    }

    public void setClubWorth(long clubWorth) {
        this.clubWorth = clubWorth;
    }

    public long getTransferBudget() {
        return transferBudget;
    }

    public void setTransferBudget(long transferBudget) {
        this.transferBudget = transferBudget;
    }

    public int getUEFAChampionsLeague() {
        return UEFAChampionsLeague;
    }

    public void setUEFAChampionsLeague(int UEFAChampionsLeague) {
        this.UEFAChampionsLeague = UEFAChampionsLeague;
    }

    public int getUEFAEuropaLeague() {
        return UEFAEuropaLeague;
    }

    public void setUEFAEuropaLeague(int UEFAEuropaLeague) {
        this.UEFAEuropaLeague = UEFAEuropaLeague;
    }

    public int getUEFASuperCup() {
        return UEFASuperCup;
    }

    public void setUEFASuperCup(int UEFASuperCup) {
        this.UEFASuperCup = UEFASuperCup;
    }

    public int getMTLeague() {
        return MTLeague;
    }

    public void setMTLeague(int MTLeague) {
        this.MTLeague = MTLeague;
    }

    public int getTotalCups() {
        return totalCups;
    }

    public void setTotalCups(int totalCups) {
        this.totalCups = totalCups;
    }

    public int getTotalWin() {
        return totalWin;
    }

    public void setTotalWin(int totalWin) {
        this.totalWin = totalWin;
    }

    public int getTotalLose() {
        return totalLose;
    }

    public void setTotalLose(int totalLose) {
        this.totalLose = totalLose;
    }

    public int getTotalDraw() {
        return totalDraw;
    }

    public void setTotalDraw(int totalDraw) {
        this.totalDraw = totalDraw;
    }
}
