package Readers;

import Collections.*;
import Managers.CollectionManager;
import Managers.ConsolePrinter;
import Managers.ProgramRunner;
import Managers.XmlParser;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.ZonedDateTime;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
/**
 * Class for simple reading element
 */
public class MovieReader {

    XmlParser xmlParser = new XmlParser();

    IntegerChecker integerChecker = (x, y ,z) -> {
        if (z){
            return x < y;
        }
        else{
            return x > y;
        }
    };

    LongChecker longCheck = (x, y ,z) -> {
        if (z){
            return x < y;
        }
        else{
            return x > y;
        }
    };

    DoubleCheck doubleCheck = (x, y ,z) -> {
        if (z){
            return x < y;
        }
        else{
            return x > y;
        }
    };

    Reader reader = new Reader();
    CollectionManager collectionManager;

    ProgramRunner programRunner = new ProgramRunner();
    /**
     * The method to read element of Collection from file
     */
    public Movie readMovieFromFile(String args) throws IOException {
        collectionManager = CollectionManager.getInstance();
        BufferedReader reader = new BufferedReader(new FileReader("src/data/"+ programRunner.getScriptName()));
        int id = collectionManager.getElementId() + 1;
        collectionManager.setElementId(id);
        reader.readLine();
        ZonedDateTime creationDate1 = ZonedDateTime.now();
        int intX = Integer.parseInt(reader.readLine());
        int intY = Integer.parseInt(reader.readLine());
        Coordinates cor = new Coordinates(intX, intY);
        int oscarCount = Integer.parseInt(reader.readLine());
        long goldenPalmCount = Long.parseLong(reader.readLine());
        long length = Long.parseLong(reader.readLine());
        MovieGenre genre = MovieGenre.valueOf(reader.readLine().toUpperCase());
        String PersonName = reader.readLine();
        double height = Double.parseDouble(reader.readLine());
        Color col = Color.valueOf(reader.readLine().toUpperCase());
        Color hairCol = Color.valueOf(reader.readLine().toUpperCase());
        Country country = Country.valueOf(reader.readLine().toUpperCase());
        float x = Float.parseFloat(reader.readLine());
        double y = Double.parseDouble(reader.readLine());
        int z =  Integer.parseInt(reader.readLine());
        String name = reader.readLine();
        reader.close();
        Location location = new Location(x, y, z, name);
        Person operator = new Person(PersonName, height, col, hairCol, country, location);
        return new Movie(id, args, cor, creationDate1, oscarCount, goldenPalmCount, length, genre, operator);
    }
    /**
     * The method to read element of Collection from input device
     */
    public Movie readMovie(String args) throws JsonProcessingException {
        int id = 0;
        Coordinates cor = null;
        ZonedDateTime creationDate1 = null;
        int oscarCount = 0;
        long goldenPalmCount = 0;
        Person operator = null;
        MovieGenre genre = null;
        long length = 0;
        try {
            collectionManager = CollectionManager.getInstance();
            int elementId = collectionManager.getElementId();
            id = elementId + 1;
            collectionManager.setElementId(id);
            // Координаты
            int intX; // net
            int intY;
            do {
                try {
                    intX = reader.readInt("Координата X (<985, int)");
                    if (!integerChecker.checkint(intX, 985, true)) {
                        ConsolePrinter.messageToConsole("Координата должна быть меньше 985");
                        continue;
                    }
                    break;
                } catch (InputMismatchException ignored) {
                    ConsolePrinter.messageToConsole("Неправильный тип данных");
                }
            } while (true);
            do {
                try {
                    intY = reader.readInt("Координата Y");
                    break;
                } catch (InputMismatchException ignored) {
                    ConsolePrinter.messageToConsole("Неправильный тип данных");
                }
            } while (true);
            cor = new Coordinates(intX, intY);
            // Дата создания
            creationDate1 = ZonedDateTime.now();
            // Количество Оскаров
            do {
                try {
                    oscarCount = reader.readInt("Количество Оскаров (>0, int)");
                    if (!integerChecker.checkint(oscarCount, 0, false)) {
                        ConsolePrinter.messageToConsole("Количество Оскаров должно быть больше 0");
                        continue;
                    }
                    break;
                } catch (InputMismatchException ignored) {
                    ConsolePrinter.messageToConsole("Неправильный тип данных");
                }
            } while (true);
            // Количество goldenPalmCount
            do {
                try {
                    goldenPalmCount = reader.readlong("Количество Золотых Пальм (>0, long)");
                    if (!longCheck.checkLong(goldenPalmCount, 0, false)) {
                        ConsolePrinter.messageToConsole("Количество Золотых Пальм должно быть больше 0");
                        continue;
                    }
                    break;
                } catch (InputMismatchException ignored) {
                    ConsolePrinter.messageToConsole("Неправильный тип данных");
                }
            } while (true);
            // Длина
            do {
                try {
                    length = reader.readlong("Длину фильма (>0, long)");
                    if (!longCheck.checkLong(length, 0, false)) {
                        ConsolePrinter.messageToConsole("Длина должна быть больше 0");
                        continue;
                    }
                    break;
                } catch (InputMismatchException ignored) {
                    ConsolePrinter.messageToConsole("Неправильный тип данных");
                }
            } while (true);
            // Жанр Кино
            genre = reader.readEnum("Введите Жанр Кино", MovieGenre.class);
            // name
            String PersonName;
            while (true) {
                try {
                    PersonName = reader.readString("Имя режиссёра").trim();
                    if (PersonName.isEmpty()) {
                        ConsolePrinter.messageToConsole("Вы ввели пустое имя");
                    } else {
                        break;
                    }
                } catch (InputMismatchException ignored) {
                    ConsolePrinter.messageToConsole("Неправильный тип данных");
                }

            }
            // height
            double height;
            do {
                try {
                    height = reader.readDouble("Рост (double, >60)");
                    if (doubleCheck.checkDouble(height, 60, true)) {
                        ConsolePrinter.messageToConsole("Вы ввели число большее 60");
                        continue;
                    }
                    break;
                } catch (InputMismatchException ignored) {
                    ConsolePrinter.messageToConsole("Неправильный тип данных");
                }
            } while (true);
            // Цвет волос режиссёра
            Color col = reader.readEnum("Введите цвет глаз режиссёра", Color.class);
            //Цвет волос режиссёра
            Color hairCol = reader.readEnum("Введите цвет волос режиссёра", Color.class);
            // Национальность
            Country country = reader.readEnum("Введите Место рождения режиссёра", Country.class);
            // Локация
            float x;
            double y;
            int z;
            do {
                try {
                    x = reader.readFloat("Введите координату x (Float)");
                    break;
                } catch (InputMismatchException ignored) {
                    ConsolePrinter.messageToConsole("Неправильный тип данных");
                }

            } while (true);
            do {
                try {
                    y = reader.readDouble("Введите координату y (Double)");
                    break;
                } catch (InputMismatchException ignored) {
                    ConsolePrinter.messageToConsole("Неправильный тип данных");
                }

            } while (true);
            do {
                try {
                    z = reader.readInt("Введите координату z (Int)");
                    break;
                } catch (InputMismatchException ignored) {
                    ConsolePrinter.messageToConsole("Неправильный тип данных");
                }

            } while (true);
            String name;
            while (true) {
                try {
                    name = reader.readString("Название Города").trim();
                    if (name.isEmpty()) {
                        ConsolePrinter.messageToConsole("Название города должно содержать больше 0 букв");
                    } else {
                        break;
                    }
                } catch (InputMismatchException ignored) {
                    ConsolePrinter.messageToConsole("Неправильный тип данных");
                }

            }
            Location location = new Location(x, y, z, name);
            operator = new Person(PersonName, height, col, hairCol, country, location);
            return new Movie(id, args, cor, creationDate1, oscarCount, goldenPalmCount, length, genre, operator);
        } catch (NoSuchElementException ignored) {
        }
        return new Movie(id, args, cor, creationDate1, oscarCount, goldenPalmCount, length, genre, operator);
    }
}
