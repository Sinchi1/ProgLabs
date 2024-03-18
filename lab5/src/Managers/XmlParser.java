package Managers;

import Collections.*;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;

public class XmlParser {

    public LinkedList<Movie> movies;
    public Movie movie;

    CollectionManager collectionManager = new CollectionManager();

    public void deserializeCollection(String path) throws IOException {
        ObjectMapper mapper = new XmlMapper();

        mapper.findAndRegisterModules();

        movies = mapper.readValue(new File("src/data/"
                + path), new TypeReference<LinkedList<Movie>>() {
        });

        int elId = 0;

        for (Movie mov: movies){
            elId = mov.getId();
        }

        collectionManager.SetMoviesInCollection(movies);

        collectionManager.setElementId(elId);

    }


    public void serializeCollection(String fileName) throws JsonProcessingException {
        ObjectMapper mapper = new XmlMapper();
        mapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);

        CollectionManager collectionManager = new CollectionManager();

        String jsonStr;

        mapper.findAndRegisterModules();

        movies = collectionManager.getMoviesCollection();

        jsonStr = mapper.writeValueAsString(movies);


        try {

            FileWriter writer = new FileWriter("src/data/"
                    + fileName);
            writer.write(jsonStr);
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
