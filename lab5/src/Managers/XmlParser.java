package Managers;

import Collections.*;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;

/**
 * The class that parsing from java to xml
 */
public class XmlParser {

    public LinkedList<Movie> movies;
    public Movie movie;

    private static String path;

    CollectionManager collectionManager;

    public void deserializeCollection(String path) throws IOException {
        File file = new File(path);
        setPath(path);
        collectionManager = CollectionManager.getInstance();
        ObjectMapper mapper = new XmlMapper();
        mapper.findAndRegisterModules();
        movies = mapper.readValue(file, new TypeReference<LinkedList<Movie>>() {
        });
        int elementId = 0;
        for (Movie mov: movies){
            elementId = mov.getId();
        }
        collectionManager.SetMoviesCollection(movies);
        collectionManager.setElementId(elementId);
        collectionManager.setPath(path);
    }


    public String serializeCollection(LinkedList<Movie> movies, String fileName) throws JsonProcessingException {
        ObjectMapper mapper = new XmlMapper();
        collectionManager = CollectionManager.getInstance();
        String path = collectionManager.getPath();
        mapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
        collectionManager = CollectionManager.getInstance();
        String jsonStr;
        mapper.findAndRegisterModules();
        jsonStr = mapper.writeValueAsString(movies);
        try {
            FileWriter writer = new FileWriter(
                    path);
            writer.write(jsonStr);
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (NullPointerException ignored){
            return ("Файл не может быть сохранен");
        }
        return "Файл успешно сохранен!";
    }

    public String getPath(){
        return path;
    }

    public void setPath(String path){
        XmlParser.path = path;
    }

}
