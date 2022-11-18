package utils;

import java.io.*;
import java.util.*;
import org.json.simple.*;
import org.json.simple.parser.*;

public class JSONReader {
    public JSONArray getJSONbyPath(String pathname) {
        JSONParser parser = new JSONParser();
        try {
            File file = new File(pathname);
            Object obj = parser.parse(new FileReader(file));
            JSONArray jsonArray = (JSONArray)obj;
            JSONObject jsonObject = new JSONObject((Map) jsonArray.get(0));
            return jsonArray;
        } catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}