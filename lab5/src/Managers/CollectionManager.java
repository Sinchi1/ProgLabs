package Managers;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

import Collections.*;

/*
 * Class that contains realization all commands
 */

public class CollectionManager {

    private LocalDateTime creationDate;

    private LinkedList<Movie> moviesCollection;

    public LinkedList<Movie> getMoviesCollection() {
        return moviesCollection;
    }

    public void setMoviesCollection(LinkedList<Movie> moviesCollection) {
        this.moviesCollection = moviesCollection;
    }

    public void createCollection(){
        moviesCollection = new LinkedList<>();
        creationDate = LocalDateTime.now();
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public String helpComma(){
        return """
            •	+ help : вывести справку по доступным командам
            •	+ info : вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)
            •	+ show : вывести в стандартный поток вывода все элементы коллекции в строковом представлении
            •	+ add {element} : добавить новый элемент в коллекцию
            •	update id {element} : обновить значение элемента коллекции, id которого равен заданному
            •	+ remove_by_id id : удалить элемент из коллекции по его id
            •	+ clear : очистить коллекцию
            •	save : сохранить коллекцию в файл
            •	execute_script file_name : считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде,
                в котором их вводит пользователь в интерактивном режиме.
            •	+ exit : завершить программу (без сохранения в файл)
            •	+ head : вывести первый элемент коллекции
            •	add_if_max {element} : добавить новый элемент в коллекцию, если его значение превышает значение наибольшего элемента этой коллекции
            •	remove_lower {element} : удалить из коллекции все элементы, меньшие, чем заданный
            •	remove_any_by_oscars_count oscarsCount : удалить из коллекции один элемент, значение поля oscarsCount которого эквивалентно заданному
            •	filter_starts_with_name name : вывести элементы, значение поля name которых начинается с заданной подстроки
            •	+ print_field_ascending_genre : вывести значения поля genre всех элементов в порядке возрастания
            """;
    }

    public String infoComma(){
        return "Тип коллекции:" + moviesCollection.getClass().getSimpleName()+ "\n" +
        "Дата создания:" + creationDate + "\n" +
        "Количество элементов в коллекции:" + moviesCollection.size();
    }

    public String showComma(){
        ArrayList<String> result = new ArrayList<>();
        if (moviesCollection.isEmpty()){
            return "Дорогой пользователь, Коллекция пуста!";

        }
        else{
            for (Movie movie : moviesCollection ){
                result.add(movie.getName() + "\n");
            }
        }
        return result.toString();


    }

    public void addCommand(){
        Scanner scan = new Scanner(System.in);
        int id = moviesCollection.size() +1 ;
        System.out.println("Введите данные:");
        // Проверки + do while
        System.out.println("Введите название фильма:");
        String filmName = scan.nextLine();
        // Координаты
        System.out.println("Введите Координаты x:");
        int intX = scan.nextInt();
        System.out.println("Введите Координаты y:");
        int intY = scan.nextInt();
        Coordinates cor = new Coordinates(intX, intY);
        // Дата создания
        ZonedDateTime creationDate1 = ZonedDateTime.now();
        // Количество Оскаров
        int oscarCount = scan.nextInt();
        // Количество goldenPalmCount
        long goldenPalmCount = scan.nextLong();
        // Длина
        long lenght = scan.nextLong();
        // Жанр Кино
        System.out.println("""
                    Выберите Жанр Кино:
                    ACTION,
                    DRAMA,
                    ADVENTURE,
                    THRILLER,
                    SCIENCE_FICTION;
                """);
        String genreInput = scan.nextLine().toUpperCase();
        MovieGenre genre;
        genre = MovieGenre.valueOf(genreInput);
        // Person blyatttttttttttttttttt
        // name
        System.out.println("Введите имя режиссёра:");
        String PersonName = scan.nextLine();
        // height
        System.out.println("Введите рост режиссёра:");
        Double height = scan.nextDouble();
        // Цвет волос режиссёра
        System.out.println("""
                    Выберите Цвет волос режиссёра:
                    GREEN,
                    YELLOW,
                    ORANGE,
                    WHITE;
                """);
        String colorInput = scan.nextLine().toUpperCase();
        Color col;
        col = Color.valueOf(colorInput);
        //Цвет волос режиссёра
        System.out.println("""
                    Выберите Цвет глаз режиссёра:
                    GREEN,
                    YELLOW,
                    ORANGE,
                    WHITE;
                """);
        String hairColorInput = scan.nextLine().toUpperCase();
        Color hairCol;
        hairCol = Color.valueOf(hairColorInput);
        // Национальность
        System.out.println("""
                    Выберите Цвет волос режиссёра:
                    FRANCE,
                    CHINA,
                    VATICAN,
                    SOUTH_KOREA;
                """);
        String countryInput = scan.nextLine().toUpperCase();
        Country country;
        country = Country.valueOf(countryInput);
        // лакейшн)
        System.out.println("Введите координату x:");
        Float x = scan.nextFloat();
        System.out.println("Введите координату y:");
        double y = scan.nextDouble();
        System.out.println("Введите координату z:");
        int z = scan.nextInt();
        System.out.println("Введите название места:");
        String name = scan.nextLine();

        Location location = new Location(x,y,z,name);

        Person operator = new Person(name,height,col,hairCol,country,location);

        // Сборка объекта коллекции!

        Movie mov1 = new Movie(id,filmName,cor,creationDate1,oscarCount, goldenPalmCount,lenght,genre,operator);

    }


    public String clearCommand(){
        moviesCollection.clear();
        return "Коллекция:" + moviesCollection.getClass().getSimpleName() + " Успешно очищена!";
    }

    public void exitCommand(){
        System.out.println("Программа успешно прекращена! (Без сохранения)");
        System.exit(0);
    }

    public String headCommand(){
        if (moviesCollection.size() == 0){
            return "Дорогой пользователь, коллекция пуста => первого элемента не существует :)";
        }
        else{
            return "Первый элемент коллекции:" + moviesCollection.get(0);
        }
    }

    public String ascedGenreCommand(){
        Iterator<Movie> it = moviesCollection.iterator();
        while (it.hasNext()){
            Movie mov = it.next();
            return mov.getGenre().toString();
        }
        return "";
    }

    public void removeById(int id){
        Iterator<Movie> iter = moviesCollection.iterator();
        while (iter.hasNext()){
            Movie mov = iter.next();
            if (mov.getId() == id){
                iter.remove();
                return;
            }

        }

    }


}
