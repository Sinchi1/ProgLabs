package Managers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.ZonedDateTime;
import java.util.*;

import Collections.*;
import com.fasterxml.jackson.core.JsonProcessingException;

/*
 * Class that contains realization all commands
 */

public class CollectionManager {


    CommandManager commandManager = new CommandManager();
    public ZonedDateTime creationDate = ZonedDateTime.now();
    public static LinkedList<Movie> moviesCollection = new LinkedList<>();

    private static int elementIp = 0;

    public LinkedList<Movie> getMoviesCollection() {
        return moviesCollection;
    }

    public String helpComma() {
        return """
                •	+ help : вывести справку по доступным командам
                •	+ info : вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)
                •	+ show : вывести в стандартный поток вывода все элементы коллекции в строковом представлении
                •	+ add {element} : добавить новый элемент в коллекцию
                •	+ update id {element} : обновить значение элемента коллекции, id которого равен заданному
                •	+ remove_by_id id : удалить элемент из коллекции по его id
                •	+ clear : очистить коллекцию
                •	+ save : сохранить коллекцию в файл
                •	execute_script file_name : считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде,
                    в котором их вводит пользователь в интерактивном режиме.
                •	+ exit : завершить программу (без сохранения в файл)
                •	+ head : вывести первый элемент коллекции
                •	? add_if_max {element} : добавить новый элемент в коллекцию, если его значение превышает значение наибольшего элемента этой коллекции
                •	+ remove_lower {element} : удалить из коллекции все элементы, меньшие, чем заданный
                •	+ remove_any_by_oscars_count oscarsCount : удалить из коллекции один элемент, значение поля oscarsCount которого эквивалентно заданному
                •	+ filter_starts_with_name name : вывести элементы, значение поля name которых начинается с заданной подстроки
                •	+ print_field_ascending_genre : вывести значения поля genre всех элементов в порядке возрастания
                """;
    }

    public String infoComma() {
        return "Тип коллекции:" + moviesCollection.getClass().getSimpleName() + "\n" +
                "Дата создания:" + creationDate + "\n" +
                "Количество элементов в коллекции:" + getMoviesCollection().size();
    }

    public void showComma() {
        ArrayList<String> result = new ArrayList<>();
        if (moviesCollection.isEmpty()) {
            System.out.println("Дорогой пользователь, Коллекция пуста!");

        } else {
            for (Movie movie : moviesCollection) {
                System.out.print(movie.getName());
            }
        }



    }

    public void update_id(String args) {
        Movie mov1;
        int id = Integer.parseInt(args);
        String filmName = null;
        for (Movie mov : moviesCollection) {
            if (mov.getId() == id) {
                filmName = mov.getName();
                break;
            }
        }

        if (filmName == null){
        System.out.println("Указанного id не существует!");
            return;
        }


        System.out.println(filmName);

        Scanner scan = new Scanner(System.in);
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
        long length;
        while (true) {
            System.out.println("Введите Длину фильма в часах:");
            length = scan.nextLong();
            if (length < 0) {
                System.out.println("Значение не может быть меньше нуля!");
                continue;
            } else {
                break;
            }
        }
        // Жанр Кино
        MovieGenre genre;
        try {
            genre = null;
            while (true) {
                System.out.print("""
                        Выберите Жанр Кино:
                        ACTION,
                        DRAMA,
                        ADVENTURE,
                        THRILLER,
                        SCIENCE_FICTION;
                        """);
                scan.nextLine();
                String genreInput = scan.nextLine().toUpperCase();
                boolean flag = false;
                do {
                    for (MovieGenre gen : MovieGenre.values()) {
                        if (gen.name().equals(genreInput)) {
                            System.out.println("Строка соответствует одной из констант Enum");
                            genre = MovieGenre.valueOf(genreInput);
                            flag = true;
                            break;
                        }
                    }
                    if (flag) {
                        break;
                    }
                    System.out.println("Вы ввели несуществующий тип, попробуйте ещё раз!");
                    System.out.print("""
                            Выберите Жанр Кино:
                            ACTION,
                            DRAMA,
                            ADVENTURE,
                            THRILLER,
                            SCIENCE_FICTION;
                            """);
                    genreInput = scan.nextLine().toUpperCase();
                } while (!flag);
                break;
            }
        } catch (IllegalArgumentException e) {
            return;
        }

        // name
        String PersonName;
        while (true) {
            System.out.println("Введите имя режиссёра:");
            PersonName = scan.nextLine();
            if (PersonName.isEmpty()) {
                System.out.println("Вы ввели пустое имя, попробуйте снова!");
            } else if (PersonName == null) {
                System.out.println("Строка не может быть null, попробуйте ещё раз!");
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
        Color col = null;
        try {
            while (true) {
                System.out.println("""
                            Выберите Цвет волос режиссёра:
                            GREEN,
                            YELLOW,
                            ORANGE,
                            WHITE;
                        """);
                scan.nextLine();
                String colorInput = scan.nextLine().toUpperCase();
                boolean flag = false;
                do {
                    for (Color color : Color.values()) {
                        if (color.name().equals(colorInput)) {
                            System.out.println("Строка соответствует одной из констант Enum");
                            col = Color.valueOf(colorInput);
                            flag = true;
                            break;
                        }
                    }
                    if (flag) {
                        break;
                    }
                    System.out.println("Вы ввели несуществующий тип, попробуйте ещё раз!");
                    System.out.println("""
                                Выберите Цвет волос режиссёра :
                                GREEN,
                                YELLOW,
                                ORANGE,
                                WHITE;
                            """);
                    colorInput = scan.nextLine().toUpperCase();
                } while (!flag);
                break;
            }
        } catch (IllegalArgumentException e) {
            return;
        }

        //Цвет волос режиссёра
        Color hairCol = null;
        try {
            while (true) {
                System.out.println("""
                            Выберите Цвет глаз режиссёра:
                            GREEN,
                            YELLOW,
                            ORANGE,
                            WHITE;
                        """);
                String hairColorInput = scan.nextLine().toUpperCase();
                boolean flag = false;
                do {
                    for (Color color : Color.values()) {
                        if (color.name().equals(hairColorInput)) {
                            System.out.println("Строка соответствует одной из констант Enum");
                            hairCol = Color.valueOf(hairColorInput);
                            flag = true;
                            break;
                        }
                    }
                    if (flag) {
                        break;
                    }
                    System.out.println("Вы ввели несуществующий тип, попробуйте ещё раз!");
                    System.out.println("""
                                Выберите Цвет глаз режиссёра :
                                GREEN,
                                YELLOW,
                                ORANGE,
                                WHITE;
                            """);
                    hairColorInput = scan.nextLine().toUpperCase();
                } while (!flag);
                break;
            }
        } catch (NullPointerException e) {
            return;
        }
        // Национальность
        Country country = null;
        try {
            while (true) {
                System.out.println("""
                            Выберите Цвет волос режиссёра:
                            FRANCE,
                            CHINA,
                            VATICAN,
                            SOUTH_KOREA;
                        """);
                String countryInput = scan.nextLine().toUpperCase();
                boolean flag = false;
                do {
                    for (Country country1 : Country.values()) {
                        if (country1.name().equals(countryInput)) {
                            System.out.println("Строка соответствует одной из констант Enum");
                            country = Country.valueOf(countryInput);
                            flag = true;
                            break;
                        }
                    }
                    if (flag) {
                        break;
                    }
                    System.out.println("Вы ввели несуществующий тип, попробуйте ещё раз!");
                    System.out.println("""
                                Выберите Цвет волос режиссёра:
                                FRANCE,
                                CHINA,
                                VATICAN,
                                SOUTH_KOREA;
                            """);
                    countryInput = scan.nextLine().toUpperCase();
                } while (!flag);
                break;
            }
        }catch (IllegalArgumentException e){
            return;
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

        mov1 = new Movie(id, filmName, cor, creationDate1, oscarCount, goldenPalmCount, length, genre, operator);

        moviesCollection.set(id,mov1);
    }

    public String addCommand(String argument) {
        Movie mov1;
        Scanner scan = new Scanner(System.in);
        int id = elementIp + 1;
        elementIp += 1;
        String filmName = argument;
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
        long length;
        while (true) {
            System.out.println("Введите Длину фильма в часах:");
            length = scan.nextLong();
            if (length < 0) {
                System.out.println("Значение не может быть меньше нуля!");
                continue;
            } else {
                break;
            }
        }
        // Жанр Кино
        MovieGenre genre;
        try {
            genre = null;
            while (true) {
                System.out.println("Выберите жанр кино:");

                var E = MovieGenre.values();
                for (var to: E){
                    System.out.println(to);
                }

                scan.nextLine();
                String genreInput = scan.nextLine().toUpperCase();
                boolean flag = false;
                do {
                    for (MovieGenre gen : MovieGenre.values()) {
                        if (gen.name().equals(genreInput)) {
                            System.out.println("Строка соответствует одной из констант Enum");
                            genre = MovieGenre.valueOf(genreInput);
                            flag = true;
                            break;
                        }
                    }
                    if (flag) {
                        break;
                    }
                    System.out.println("Вы ввели несуществующий тип, попробуйте ещё раз!");
                    System.out.println("Выберите жанр кино:");
                    E = MovieGenre.values();
                    for (var to: E){
                        System.out.println(to);
                    }

                    genreInput = scan.nextLine().toUpperCase();
                } while (!flag);
                break;
            }
        } catch (IllegalArgumentException e) {
            return "Вы ввели неверный тип!";
        }

        // name
        String PersonName;
        while (true) {
            System.out.println("Введите имя режиссёра:");
            PersonName = scan.nextLine();
            if (PersonName.isEmpty()) {
                System.out.println("Вы ввели пустое имя, попробуйте снова!");
            } else if (PersonName == null) {
                System.out.println("Строка не может быть null, попробуйте ещё раз!");
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
        Color col = null;
        try {
            while (true) {
                System.out.println("Выберите Цвет волос режиссёра:");
                var E = Color.values();
                for (var to: E){
                    System.out.println(to);
                }
                scan.nextLine();
                String colorInput = scan.nextLine().toUpperCase();
                boolean flag = false;
                do {
                    for (Color color : Color.values()) {
                        if (color.name().equals(colorInput)) {
                            System.out.println("Строка соответствует одной из констант Enum");
                            col = Color.valueOf(colorInput);
                            flag = true;
                            break;
                        }
                    }
                    if (flag) {
                        break;
                    }
                    System.out.println("Вы ввели несуществующий тип, попробуйте ещё раз!");
                    System.out.println("Выберите Цвет волос режиссера");
                    for (var to: E){
                        System.out.println(to);
                    }
                    colorInput = scan.nextLine().toUpperCase();
                } while (!flag);
                break;
            }
        } catch (IllegalArgumentException e) {
            return "Вами был указан несуществующий тип";
        }

        //Цвет волос режиссёра
        Color hairCol = null;
        try {
            while (true) {
                System.out.println("Выберите Цвет глаз режиссёра:");
                var E = Color.values();
                for (var to: E){
                    System.out.println(to);
                }
                String hairColorInput = scan.nextLine().toUpperCase();
                boolean flag = false;
                do {
                    for (Color color : Color.values()) {
                        if (color.name().equals(hairColorInput)) {
                            System.out.println("Строка соответствует одной из констант Enum");
                            hairCol = Color.valueOf(hairColorInput);
                            flag = true;
                            break;
                        }
                    }
                    if (flag) {
                        break;
                    }
                    System.out.println("Вы ввели несуществующий тип, попробуйте ещё раз!");
                    System.out.println("Выберите Цвет глаз режиссёра:");
                    for (var to: E){
                        System.out.println(to);
                    }
                    hairColorInput = scan.nextLine().toUpperCase();
                } while (!flag);
                break;
            }
        } catch (NullPointerException e) {
            return "Вами был указан несуществующий тип";
        }
        // Национальность
        Country country = null;
        try {
            while (true) {
                System.out.println("Выберите страну съёмки:");
                var E = Country.values();
                for (var to: E){
                    System.out.println(to);
                }
                String countryInput = scan.nextLine().toUpperCase();
                boolean flag = false;
                do {
                    for (Country country1 : Country.values()) {
                        if (country1.name().equals(countryInput)) {
                            System.out.println("Строка соответствует одной из констант Enum");
                            country = Country.valueOf(countryInput);
                            flag = true;
                            break;
                        }
                    }
                    if (flag) {
                        break;
                    }
                    System.out.println("Вы ввели несуществующий тип, попробуйте ещё раз!");
                    System.out.println("Выберите страну съёмки:");
                for (var to: E){
                    System.out.println(to);
                }
                    countryInput = scan.nextLine().toUpperCase();
                } while (!flag);
                break;
            }
        }catch (IllegalArgumentException e){
            return "Вы ввели неверный тип!";
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

        mov1 = new Movie(id, filmName, cor, creationDate1, oscarCount, goldenPalmCount, length, genre, operator);

        moviesCollection.add(mov1);

        return "Вы успешно создали элемент коллекции!";

    }

    public void removeLower(String args) {
        int element = Integer.parseInt(args);
        Iterator<Movie> iter = moviesCollection.iterator();
        int i = 0;
        if (element > moviesCollection.size()) {
            while (iter.hasNext()) {
                Movie mov = iter.next();
                iter.remove();
            }
        } else {
            while (iter.hasNext() && i != element) {
                Movie mov = iter.next();
                iter.remove();
                i++;
            }
        }
    }

    public String clearCommand() {
        moviesCollection.clear();
        return "Коллекция:" + moviesCollection.getClass().getSimpleName() + " Успешно очищена!";
    }

    public void exitCommand() {
        System.out.println("Программа успешно прекращена! (Без сохранения)");
        System.exit(0);
    }

    public String headCommand() {
        if (moviesCollection.isEmpty()) {
            return "Дорогой пользователь, коллекция пуста => первого элемента не существует :)";
        } else {
            return "Первый элемент коллекции:" + moviesCollection.get(0).getName();
        }
    }

    public void ascedGenreCommand() {
        if (moviesCollection.isEmpty()){
            System.out.println("Коллекция пуста!");
        }
        else {
            for (Movie mov : moviesCollection) {
                System.out.print(mov.getGenre().toString());
            }
        }

    }
    public void removeById(String args) {
        int id = Integer.parseInt(args);
        Iterator<Movie> iter = moviesCollection.iterator();
        while (iter.hasNext()) {
            Movie mov = iter.next();
            if (mov.getId() == id) {
                iter.remove();
                System.out.println("Элемент удалён!");
                return;
            }

        }

    }
    public String filterStartsWithName(String argument) {
        int result = 0;
        for (Movie mov : moviesCollection) {
            if (mov.getName().equals(argument)) {
                result += 1;
            }
        }
        return String.valueOf(result);
    }
    public void removeOneOscar(String args) {
        int oscar = Integer.parseInt(args);
        Iterator<Movie> iter = moviesCollection.iterator();
        while (iter.hasNext()) {
            Movie mov = iter.next();
            if (mov.getOscarsCount() == oscar) {
                iter.remove();
                System.out.println("Элемент найден и удалён");
                break;
            }

        }
    }
    public String execute_script(String args) {
        Scanner scan = new Scanner(System.in);
        try (BufferedReader reader = new BufferedReader(new FileReader(args))) {
            String command;
            while ((command = reader.readLine()) != null){
                if (!command.isEmpty() && !command.equals("exit")){
                    String[] words = command.split(" ");
                    String commandName = words[0].toLowerCase();
                    if (words.length > 1 && (commandManager.isHavingArgument(commandName))){
                        String argument = words[1];
                        switch (commandName){
                            case "remove_by_id" -> removeById(argument);
                            case "update_id" -> update_id(argument); // Доделать чутка
                            case "add" -> addCommand(argument);
                            case "remove_lower" -> removeLower(argument);
                            case "execute_script_file_name" -> execute_script(argument);
                            case "filter_starts_with_name" -> filterStartsWithName(argument);
                        }
                    } else if (words.length > 1 && !(commandManager.isHavingArgument(commandName))){
                        System.out.println("В прочитанной команде находится лишний символ!");
                        throw new RuntimeException();
                    }
                    else {
                        switch (commandName){
                            case "help" -> System.out.println(helpComma());
                            case "info" -> System.out.println(infoComma());
                            case "show" -> showComma();
                            case "clear" -> System.out.println(clearCommand());
                            //case "save" -> saveComma();
                            case "head" -> System.out.println(headCommand());
                            case "print_field_ascending_genre" ->ascedGenreCommand();
                        }
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Такого файла не существует!");
            throw new RuntimeException(e);
        }
    return "";
    }

    public void save() throws JsonProcessingException {
        XmlParser xmlParser = new XmlParser();
        xmlParser.SerializeCollection("Test.xml");
        System.out.println("Файл сохранён!");
        System.exit(1);
    }
    public void addMovie(LinkedList<Movie> mov){
        moviesCollection = mov;
    }
}
