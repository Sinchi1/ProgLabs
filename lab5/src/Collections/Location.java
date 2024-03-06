package Collections;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class Location {
    @JacksonXmlProperty(localName = "x")
    private Float x; //Поле не может быть null
    @JacksonXmlProperty(localName = "y")
    private double y;
    @JacksonXmlProperty(localName = "z")
    private int z;
    @JacksonXmlProperty(localName = "name")
    private String name; //Строка не может быть пустой, Поле может быть null
    
    public Location(Float x, double y, int z, String name) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.name = name;
    }

    public Location(){

    }

    public Float getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public int getZ() {
        return z;
    }

    public String getName() {
        return name;
    }
}
