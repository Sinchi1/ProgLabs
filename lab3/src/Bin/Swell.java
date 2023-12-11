package src.Bin;
import src.AbstractClasses.Entity;

public class Swell extends Entity {
    private String name;

    public Swell(String name){
    // уууууээээ
    this.name = name; 
    System.out.println("Создан " + name + " !");
    }
     
    public String getName() {
        return name;
    }


@Override
public void letlightthrough() {
    System.out.println("Пропускает 10% света");
}

@Override
public void emitlight() {
    System.out.println("Не излучает свет");
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
  if (!(obj instanceof Boat)) return false;

  Swell  swell  = (Swell) obj;

  return name != null ? name.equals(swell.name) :  null;

}


@Override
public String toString() {
return "Character [name=" + name + "]";
}
}