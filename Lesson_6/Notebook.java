package Lesson_6;

public class Notebook {
    private String manufacturer;
    private String model;
    private int ram;
    private int hdd;
    private String os;
    private String color;

    public Notebook(String manufacturer, String model, int ram, int hdd, String os, String color) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.ram = ram;
        this.hdd = hdd;
        this.os = os;
        this.color = color;
    }

    public String getManufacturer() {
        return this.manufacturer;
    }

    public String getModel() {
        return this.model;
    }

    public int getRam() {
        return this.ram;
    }

    public int getHdd() {
        return this.hdd;
    }

    public String getOs() {
        return this.os;
    }

    public String getColor() {
        return this.color;
    }

    public String toString() {
        return this.manufacturer + this.model + ", ram= " + this.ram + "Gb" + ", hdd= " + this.hdd + "Gb" + ", os= " + this.os + ", color= " + this.color;
    }
}
