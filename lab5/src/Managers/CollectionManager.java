package Managers;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

import Collections.*;
import Exceptions.ProgrammStateException;

/*
 * Class that contains realization all commands
 */

public class CollectionManager {

    public LocalDateTime creationDate;

    public LinkedList<Movie> moviesCollection = new LinkedList<>();

    public LinkedList<Movie> getMoviesCollection() {
        return moviesCollection;
    }

    public void setMoviesCollection(LinkedList<Movie> moviesCollection) {
        this.moviesCollection = moviesCollection;
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
            •	+ update id {element} : обновить значение элемента коллекции, id которого равен заданному
            •	+ remove_by_id id : удалить элемент из коллекции по его id
            •	+ clear : очистить коллекцию
            •	save : сохранить коллекцию в файл
            •	execute_script file_name : считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде,
                в котором их вводит пользователь в интерактивном режиме.
            •	+ exit : завершить программу (без сохранения в файл)
            •	+ head : вывести первый элемент коллекции
            •	add_if_max {element} : добавить новый элемент в коллекцию, если его значение превышает значение наибольшего элемента этой коллекции
            •	+ remove_lower {element} : удалить из коллекции все элементы, меньшие, чем заданный
            •	+ remove_any_by_oscars_count oscarsCount : удалить из коллекции один элемент, значение поля oscarsCount которого эквивалентно заданному
            •	+ filter_starts_with_name name : вывести элементы, значение поля name которых начинается с заданной подстроки
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

    public void update_id(){

    }

    public void addCommand(){
        Scanner scan = new Scanner(System.in);
        int id = moviesCollection.size() + 1 ;
        try {
            String filmName;
            while (true) {
                System.out.println("Введите название фильма:");
                filmName = scan.nextLine();
                if (filmName.isEmpty()) {
                    System.out.println("Вы ввели пустое имя, попробуйте снова!");
                    continue;
                } else if (filmName == null) {
                    System.out.println("Строка не может быть null, попробуйте ещё раз!");
                    continue;
                } else {
                    break;
                }
            }
            // Координаты
            Coordinates cor;
            while (true) {
                System.out.println("Введите Координаты x:");
                int intX = scan.nextInt();
                System.out.println("Введите Координаты y:");
                int intY = scan.nextInt();
                if (intX > 985) {
                    System.out.println("Координата X не должна быть больше 985, введите её ещё раз");
                    continue;
                } else {
                    cor = new Coordinates(intX, intY);
                    break;
                }
            }
            // Дата создания
            ZonedDateTime creationDate1 = ZonedDateTime.now();
            // Количество Оскаров
            int oscarCount;
            while (true) {
                System.out.println("Введите количество Оскаров");
                oscarCount = scan.nextInt();
                if (!(oscarCount > 0)) {
                    System.out.println("Количество оскаров должно быть положительным!");
                    continue;
                } else {
                    break;
                }
            }

            // Количество goldenPalmCount
            long goldenPalmCount;
            while (true) {
                System.out.println("Введите количество золотых наград:");
                goldenPalmCount = scan.nextLong();
                if (goldenPalmCount < 0) {
                    System.out.println("Число наград должно быть больше нуля!");
                    continue;
                } else {
                    break;
                }
            }
            // Длина
            long lenght;
            while (true) {
                System.out.println("Введите Длину фильма в часах:");
                lenght = scan.nextLong();
                if (lenght < 0) {
                    System.out.println("Значение не может быть меньше нуля!");
                    continue;
                } else {
                    break;
                }
            }
            // Жанр Кино
            MovieGenre genre;
            while (true) {
                System.out.println("""
                        Выберите Жанр Кино:
                        ACTION,
                        DRAMA,
                        ADVENTURE,
                        THRILLER,
                        SCIENCE_FICTION;
                        """);
                String genreInput = scan.nextLine().toUpperCase();
                genre = MovieGenre.valueOf(genreInput);
                if (genre == null) {
                    System.out.println("Поле не можеть быть равно null!");
                    continue;
                } else {
                    break;
                }
            }
            // name
            String PersonName;
            while (true) {
                System.out.println("Введите имя режиссёра:");
                PersonName = scan.nextLine();
                if (PersonName.isEmpty()) {
                    System.out.println("Вы ввели пустое имя, попробуйте снова!");
                    continue;
                } else if (PersonName == null) {
                    System.out.println("Строка не может быть null, попробуйте ещё раз!");
                    continue;
                } else {
                    break;
                }
            }
            // height
            Double height;
            while (true) {
                System.out.println("Введите рост режиссёра:");
                height = scan.nextDouble();
                if (height < 0) {
                    System.out.println("Рост должен быть больше нуля))");
                    continue;
                } else {
                    break;
                }
            }

            // Цвет волос режиссёра
            Color col;
            while (true) {
                System.out.println("""
                            Выберите Цвет волос режиссёра:
                            GREEN,
                            YELLOW,
                            ORANGE,
                            WHITE;
                        """);
                String colorInput = scan.nextLine().toUpperCase();
                col = Color.valueOf(colorInput);
                if (col == null) {
                    System.out.println("Поле не может быть null");
                    continue;
                } else {
                    break;
                }
            }
            //Цвет волос режиссёра
            Color hairCol;
            while (true) {
                System.out.println("""
                            Выберите Цвет глаз режиссёра:
                            GREEN,
                            YELLOW,
                            ORANGE,
                            WHITE;
                        """);
                String hairColorInput = scan.nextLine().toUpperCase();
                hairCol = Color.valueOf(hairColorInput);
                if (hairCol == null) {
                    System.out.println("Поле не может быть null");
                    continue;
                } else {
                    break;
                }
            }
            // Национальность
            Country country;
            while (true) {
                System.out.println("""
                            Выберите Цвет волос режиссёра:
                            FRANCE,
                            CHINA,
                            VATICAN,
                            SOUTH_KOREA;
                        """);
                String countryInput = scan.nextLine().toUpperCase();
                country = Country.valueOf(countryInput);
                if (country == null) {
                    System.out.println("Поле не может быть null");
                    continue;
                } else {
                    break;
                }
            }
            // лакейшн)
            System.out.println("Введите координату x:");
            Float x = scan.nextFloat();
            System.out.println("Введите координату y:");
            double y = scan.nextDouble();
            System.out.println("Введите координату z:");
            int z = scan.nextInt();
            String name;
            while (true) {
                System.out.println("Введите название места:");
                name = scan.nextLine();
                if (name.isEmpty()) {
                    System.out.println("Название места не может быть пустым!");
                    continue;
                } else {
                    break;
                }

            }
            Location location = new Location(x, y, z, name);

            Person operator = new Person(name, height, col, hairCol, country, location);

            // Сборка объекта коллекции!

            Movie mov1 = new Movie(id, filmName, cor, creationDate1, oscarCount, goldenPalmCount, lenght, genre, operator);
        }catch (ProgrammStateException e){
            System.out.println("Не предвиденная ошибка программы :(");
        }
    }

    //удалить из коллекции все элементы, меньшие, чем заданный
    public void removeLower(){
        Scanner scan = new Scanner(System.in);
        int element = scan.nextInt();
        Iterator<Movie> iter = moviesCollection.iterator();
        int i = 0;
        if (element > moviesCollection.size()){
            while(iter.hasNext()){
                Movie mov = iter.next();
                iter.remove();
            }
        }
        else {
            while (iter.hasNext() && i != element){
                Movie mov = iter.next();
                iter.remove();
                i++;
            }
        }
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
        for (Movie mov : moviesCollection) {
            return mov.getGenre().toString();
        }
        return "null";
    }

    public void removeById(){
        Scanner scan = new Scanner(System.in);
        int id = scan.nextInt();
        Iterator<Movie> iter = moviesCollection.iterator();
        while (iter.hasNext()){
            Movie mov = iter.next();
            if (mov.getId() == id){
                iter.remove();
                return;
            }

        }

    }

    // filter_starts_with_name name : вывести элементы, значение поля name которых начинается с заданной подстроки

    public String filterStartsWithName(){
        Scanner scan = new Scanner(System.in);
        String name = scan.nextLine();
        int result = 0;
        for (Movie mov : moviesCollection) {
            if (mov.getName().equals(name)) {
                result += 1;
            }
        }
        return String.valueOf(result);
    }

    // remove_any_by_oscars_count oscarsCount : удалить из коллекции один элемент, значение поля oscarsCount которого эквивалентно заданному

    public String removeOneOscar(){
        Scanner scan = new Scanner(System.in);
        int oscar = scan.nextInt();
        Iterator<Movie> iter = moviesCollection.iterator();
        while (iter.hasNext()){
            Movie mov = iter.next();
            if (mov.getOscarsCount() == oscar){
                System.out.println("Элемент найден и удалён!");
                break;
            }

        }
        return "Нету элементов с таким количеством оскаров";
    }
}
