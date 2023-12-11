package src.Enums;
public enum Times {
morning("утро","восход"),day("день","зенит"),evening("вечер","закат");

private String time;
private String Position;

Times(String time,String Position){
    this.time = time;
    this.Position = Position;
}


public String getTypeString(){
    return time;
}

public String getPositon(){
    return Position;
}


}
