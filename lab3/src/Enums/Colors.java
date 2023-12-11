package src.Enums;
public enum Colors {
Red("красный"),Blue("синий"),
Green("зеленый"),White("белый"),
Yellow("желтый"),GoldenYellow("золотистый");

private String colour;

Colors(String colour){
    this.colour = colour;
}

public String getColour(){
    return colour;
}



}
