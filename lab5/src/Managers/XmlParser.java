package Managers;

import Collections.Movie;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;

public class XmlParser {

    public void serializeCollection(){
        try {
            XmlMapper xmlMapper = new XmlMapper();
            xmlMapper.findAndRegisterModules();
            File file = new File("Test.xml");


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void deSerializeCollection(String args){


    }
}
