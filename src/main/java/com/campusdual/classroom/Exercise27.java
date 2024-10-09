package com.campusdual.classroom;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Exercise27 {
    public static void main(String[] args) {
        ArrayList<String> xml = new ArrayList<>();
        ArrayList<String> json = new ArrayList<>();
        File fileXML = new File("./src/main/resources/shoppingList.xml");
        File fileJSON = new File("./src/main/resources/shoppingList.json");
        File resources = fileXML.getParentFile();
        PrintWriter pw = null;
        xml = createListXML();
        createFile(xml,fileXML, resources, pw);
        json = createListJSON();
        createFile(json,fileJSON, resources, pw);
    }

    public static ArrayList<String> createListXML(){
        ArrayList<String> xml = new ArrayList<>();
        xml.add("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>");
        xml.add("<shoppinglist>");
        xml.add("<items>");
        xml.add("<item quantity='2'>Manzana</item>");
        xml.add("<item quantity='1'>Leche</item>");
        xml.add("<item quantity='3'>Pan</item>");
        xml.add("<item quantity='2'>Huevo</item>");
        xml.add("<item quantity='1'>Queso</item>");
        xml.add("<item quantity='1'>Cereal</item>");
        xml.add("<item quantity='4'>Agua</item>");
        xml.add("<item quantity='6'>Yogur</item>");
        xml.add("<item quantity='2'>Arroz</item>");
        xml.add("</items>");
        xml.add("</shoppinglist>");
        return xml;
    }

    public static ArrayList<String> createListJSON(){
        ArrayList<String> json = new ArrayList<>();
        json.add("{items:[");
        json.add("{\"quantity\":2, \"text\":\"Manzana\"},");
        json.add("{\"quantity\":1, \"text\":\"Leche\"},");
        json.add("{\"quantity\":3, \"text\":\"Pan\"},");
        json.add("{\"quantity\":2, \"text\":\"Huevo\"},");
        json.add("{\"quantity\":1, \"text\":\"Queso\"},");
        json.add("{\"quantity\":1, \"text\":\"Cereal\"},");
        json.add("{\"quantity\":4, \"text\":\"Agua\"},");
        json.add("{\"quantity\":6, \"text\":\"Yogur\"},");
        json.add("{\"quantity\":2, \"text\":\"Arroz\"},");
        json.add("]}");
        return json;
    }

    public static void createFile(ArrayList<String> type, File file, File resources, PrintWriter pw){
        try{
            // Creamos los directorios si no existen
            if (!resources.exists()){
                resources.mkdirs();
            }
            pw = new PrintWriter(new FileWriter(file));
            for (int i = 0; i < type.size(); i++) {
                pw.println(type.get(i));
            }
        }catch (IOException e) {
            System.out.println("Error " + e.getMessage());
        }finally {
            try{
                if(file!=null){
                    pw.close();
                }
            }catch(Exception e){
                System.out.println("Error " + e.getMessage());
            }
        }
    }
}
