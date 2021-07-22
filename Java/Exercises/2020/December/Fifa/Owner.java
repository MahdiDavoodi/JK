package ir.blog.mahdidavoodi;

import java.util.ArrayList;

public class Owner {
    private final String ownerName;
    private int UEFAChampionsLeague, UEFAEuropaLeague, UEFASuperCup, MTLeague, totalCups, totalWin, totalLose, totalDraw;
    protected ArrayList<Club> ownerClubs;

    public Owner(String ownerName) {
        this.ownerName = ownerName;
    }
}
