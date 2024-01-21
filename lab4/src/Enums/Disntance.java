package src.Enums;
public enum Disntance {
near("Близко"),far("Далеко");

private String dist;

Disntance(String dist){
    this.dist = dist;
}

public String getdist(){
    return dist;
}
}
