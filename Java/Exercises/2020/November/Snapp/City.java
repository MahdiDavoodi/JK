package ir.blog.mahdidavoodi;

import java.io.*;

public class City {

    private String startingCity, targetCity;
    private Double startingCityCoordinatesX, startingCityCoordinatesY, targetCityCoordinatesX, targetCityCoordinatesY;
    public final File citiesData = new File("Cities.txt");
    public String[] cityNames = new String[40];
    public Double[][] cityCoordinates = new Double[40][2];

    public Double getStartingCityCoordinatesX() {
        return startingCityCoordinatesX;
    }

    public void setStartingCityCoordinatesX(Double startingCityCoordinatesX) {
        this.startingCityCoordinatesX = startingCityCoordinatesX;
    }

    public Double getStartingCityCoordinatesY() {
        return startingCityCoordinatesY;
    }

    public void setStartingCityCoordinatesY(Double startingCityCoordinatesY) {
        this.startingCityCoordinatesY = startingCityCoordinatesY;
    }

    public Double getTargetCityCoordinatesX() {
        return targetCityCoordinatesX;
    }

    public void setTargetCityCoordinatesX(Double targetCityCoordinatesX) {
        this.targetCityCoordinatesX = targetCityCoordinatesX;
    }

    public Double getTargetCityCoordinatesY() {
        return targetCityCoordinatesY;
    }

    public void setTargetCityCoordinatesY(Double targetCityCoordinatesY) {
        this.targetCityCoordinatesY = targetCityCoordinatesY;
    }

    public String getStartingCity() {
        return startingCity;
    }

    public void setStartingCity(String startingCity) {
        this.startingCity = startingCity;
    }

    public String getTargetCity() {
        return targetCity;
    }

    public void setTargetCity(String targetCity) {
        this.targetCity = targetCity;
    }

    private void fillArrays() throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader(citiesData));
        String line;
        int counter = 0;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split("\t");
            cityNames[counter] = parts[0];
            cityCoordinates[counter][0] = Double.valueOf(parts[1]);
            cityCoordinates[counter][1] = Double.valueOf(parts[2]);
            counter++;
        }

    }

    public void showCityList() throws IOException {
        fillArrays();
        for (String cityName : cityNames) {
            System.out.println(Main.ANSI_BLUE + "--> " + cityName + " \t " + Main.ANSI_RESET);
        }
    }

}
