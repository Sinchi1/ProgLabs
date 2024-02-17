package Collections;

public class Location {
    private Float x; //Поле не может быть null
    private double y;
    private int z;
    private String name; //Строка не может быть пустой, Поле может быть null
    
    public Location(Float x, double y, int z, String name) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.name = name;
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
