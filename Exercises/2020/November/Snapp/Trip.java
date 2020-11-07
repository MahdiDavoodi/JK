package ir.blog.mahdidavoodi;

public class Trip {

    private final Double sCX;
    private final Double sCY;
    private final Double tCX;
    private final Double tCY;

    public Trip(Double sCX, Double sCY, Double tCX, Double tCY) {
        this.sCX = sCX;
        this.sCY = sCY;
        this.tCX = tCX;
        this.tCY = tCY;
    }

    public void normalTrip(String startingCity, String targetCity) {

        System.out.println(Main.ANSI_BLUE + "-----> Trip for " + startingCity + " to " + targetCity + "..." + Main.ANSI_RESET);
        System.out.println(Main.ANSI_BLUE + "-----> Time: " + timeFormula(distance(sCX, sCY, tCX, tCY)) + " minutes" + Main.ANSI_RESET);
        System.out.println(Main.ANSI_BLUE + "-----> Price: " + priceFormula(distance(sCX, sCY, tCX, tCY)) + " $" + Main.ANSI_RESET);

    }

    public double priceFormula(double distance) {
        return distance / 100;
    }

    public double timeFormula(double distance) {
        return distance / 60;   // We have to improve.
    }

    public double distance(Double sCX, Double sCY, Double tCX, Double tCY) {
        return 1000 * (Math.sqrt(Math.pow(tCX - sCX, 2) + Math.pow(tCY - sCY, 2)));
    }
}
