package src.Bin;

import src.AbstractClasses.Entity;

public class Dubina extends Entity {

    // Тут будет класс полис инвентори и вложенный клас дубинка thumbs up

    private String name;

    private String material;

    private String effect;

    public Dubina(String name, String material, String effect){
        this.name = name;
        this.material = material;
        this.effect = effect;
    }


    public Dubina(String name, String material){
        this.name = name;
        this.material = material;
    }

    public Dubina(String name){
        this.name = name;
    }


    // getters

    public String getName() {
        return name;
    }

    public String getMaterial() {
        return material;
    }

    public String getEffect() {
        return effect;
    }


    @Override
    public boolean letlightthrough() {
       return false;
    }


    @Override
    public boolean emitlight() {
        return false;
    }

}  

