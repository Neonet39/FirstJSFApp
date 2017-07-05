package com.com.convert;

import com.com.structur.ArrayStructur;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.util.ArrayList;

/**
 * Created by Evgeny on 05.07.2017.
 */
public class JSON_parsing {

  private JSONObject jsonObj;
  private JSONObject keyJson;
  private JSONArray jsonArray;

  private JSONObject getJson(String key){

      return this.keyJson = (JSONObject) jsonObj.get(key);
  }
  private JSONArray getJsonArry(JSONObject obj, String key){

      return jsonArray = (JSONArray) obj.get(key);
  }

  private JSONObject fromObject(String str){

      Object obj = null;
      JSONParser parser = new JSONParser();
      try {
          obj = parser.parse(str);

      } catch (ParseException e) {
          e.printStackTrace();
      }

      return jsonObj = (JSONObject) obj;
  }

  public ArrayList<ArrayStructur> groops(String Json){

      ArrayList<ArrayStructur> list = new ArrayList<>();

      fromObject(Json);
      getJsonArry(getJson("response"),"items");
        for (int i=0;i<this.jsonArray.size();i++) {
            this.jsonObj = (JSONObject) jsonArray.get(i);
            System.out.println(this.jsonObj.get("id"));
        }

   return null;
  }

}
