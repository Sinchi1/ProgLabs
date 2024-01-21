package src.AbstractClasses;
public abstract class Entity {
    private String name;


    public abstract boolean letlightthrough();

    public abstract boolean emitlight();


    public String getName(){
        return name;
    }


}
