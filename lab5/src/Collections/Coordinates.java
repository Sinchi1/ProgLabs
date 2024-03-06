package Collections;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class Coordinates {
    @JacksonXmlProperty(localName = "x")
    private int x; //Максимальное значение поля: 985
    @JacksonXmlProperty(localName = "y")
    private long y;

    public Coordinates(int x, long y) {
        this.x = x;
        this.y = y;
    }

    public Coordinates(){

    }


    public int getX() {
        return x;
    }

    public long getY() {
        return y;
    }


}