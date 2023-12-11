package src.Enums;
public enum Speeds {
slow("медленно"),normally("Нормально"),fast("Быстро");

private String characterization;


Speeds(String characterization){
    this.characterization = characterization;
}

public String getCharacterization(){
    return characterization;
    }
}
