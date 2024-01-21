package src.Enums;
public enum MentalState {
normal("нормальный"),mad("слабоумный");


private String state;

MentalState(String state){
    this.state = state;
}

public String getState(){
    return state;
}



}
