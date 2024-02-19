package Managers;

import Collections.Movie;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;

public class XmlParser {
    XmlMapper xmlMapper = new XmlMapper();

    CollectionManager collectionManager = new CollectionManager();


    public void serializeCollection(String args){
        try {
            XmlMapper xmlMapper = new XmlMapper();
            File file = new File("Test.xml");
            Movie obj = xmlMapper.readValue(file, Movie.class);

            System.out.println(obj); // Вывод данных на консоль
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void deSerializeCollection(String args){


    }
}
