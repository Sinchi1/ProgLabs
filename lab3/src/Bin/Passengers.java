package src.Bin;

public class Passengers extends Human {

    public String name;

    private static int count = getLenght();


    public Passengers(String name) {
        super(name);
        
    }

    public static int getCount() {
        return count;
    }

    @Override
    public int hashCode(){
        int result = super.hashCode();
        result = 31 * result + ((name != null) ? name.hashCode() :0);
        return result;
    }
    @Override
    public String toString(){
    return "Имя персонажа " + name; 
    }
    @Override
    public boolean equals(Object obj){
    if (this == obj) return true;
    if (!(obj instanceof Passengers)) return false;

    Passengers boat = (Passengers) obj;

    return (name != null)? name.equals(boat.name) : false;
    }
}
