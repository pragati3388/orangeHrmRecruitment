package utils;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;

public class Utils {

    public static JSONObject loadJsonFile(String fileLocation){
        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject = null;
        try {
            Object obj = jsonParser.parse(new FileReader(fileLocation));
            jsonObject = (JSONObject) obj;
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return jsonObject;
    }

}
