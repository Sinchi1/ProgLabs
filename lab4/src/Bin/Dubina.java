package src.Bin;

import src.AbstractClasses.Entity;

public class Dubina extends Entity {

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

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
      if (this == obj) return true;
      if (!(obj instanceof Dubina)) return false;

      Dubina human = (Dubina) obj;

      return name != null ? name.equals(human.name) : null;

    }

    @Override
    public String toString() {
    return "Character [name=" + name + "]";
    }

}  

