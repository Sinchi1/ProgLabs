package src.Enums;
public enum Places {
    nose("Нос"),ship("Корабль"),island("Остров Хатиффантов"),horizont("Горизонт");
    private String name;

    Places(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
}
