package biz.casino.roulette.model;
public class WheelPocket{
    private String name;
    private String color;
    private int numberValue;
    private String evenOdd;
    private int americanWheelPosition;
    private int europeanWheelPosition;

    public int getAmericanWheelPosition() {
        return americanWheelPosition;
    }

    public int getEuropeanWheelPosition() {
        return europeanWheelPosition;
    }

    public int getNumberValue() {
        return numberValue;
    }

    public String getColor() {
        return color;
    }

    public String getEvenOdd() {
        return evenOdd;
    }

    public String getName() {
        return name;
    }

    public void setEvenOdd(String evenOdd) {
        this.evenOdd = evenOdd;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setEuropeanWheelPosition(int europeanWheelPosition) {
        this.europeanWheelPosition = europeanWheelPosition;
    }

    public void setNumberValue(int numberValue) {
        this.numberValue = numberValue;
    }

    public void setAmericanWheelPosition(int americanWheelPosition) {
        this.americanWheelPosition = americanWheelPosition;
    }
}