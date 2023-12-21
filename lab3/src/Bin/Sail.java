package src.Bin;
import src.AbstractClasses.Entity;

public class Sail extends Entity {

private String name;

public Sail(){
    name = "Парус";
}

public String getName() {
    return name;
}

@Override
public boolean letlightthrough() {
    return true;
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
  if (!(obj instanceof Boat)) return false;

  Sail sail = (Sail) obj;

  return name != null ? name.equals(sail.name) : null;

}

@Override
public String toString() {
return "Character [name=" + name + "]";
}

}
