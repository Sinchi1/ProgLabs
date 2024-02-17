package Collections;

import java.time.ZonedDateTime;

public class Movie {
    private Integer id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private java.time.ZonedDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private Integer oscarsCount; //Значение поля должно быть больше 0, Поле не может быть null
    private long goldenPalmCount; //Значение поля должно быть больше 0
    private long length; //Значение поля должно быть больше 0
    private MovieGenre genre; //Поле может быть null
    private Person operator; //Поле может быть null
    
    
    public Movie(Integer id, String name, Coordinates coordinates, ZonedDateTime creationDate, Integer oscarsCount,
        long goldenPalmCount, long length, MovieGenre genre, Person operator) {
        this.id = id;
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = creationDate;
        this.oscarsCount = oscarsCount;
        this.goldenPalmCount = goldenPalmCount;
        this.length = length;
        this.genre = genre;
        this.operator = operator;
    }

    public void setId(Integer id){
        this.id = id;
    }

    public Integer getId(){
        return id;
    }

    public String getName() {
        return name;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public java.time.ZonedDateTime getCreationDate() {
        return creationDate;
    }

    public Integer getOscarsCount() {
        return oscarsCount;
    }

    public long getGoldenPalmCount() {
        return goldenPalmCount;
    }

    public long getLength() {
        return length;
    }

    public MovieGenre getGenre() {
        return genre;
    }

    public Person getOperator() {
        return operator;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public void setCreationDate(java.time.ZonedDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public void setOscarsCount(Integer oscarsCount) {
        this.oscarsCount = oscarsCount;
    }

    public void setGoldenPalmCount(long goldenPalmCount) {
        this.goldenPalmCount = goldenPalmCount;
    }

    public void setLength(long length) {
        this.length = length;
    }

    public void setGenre(MovieGenre genre) {
        this.genre = genre;
    }

    public void setOperator(Person operator) {
        this.operator = operator;
    }
}

