package com.com.convert;

import com.com.structur.ArrayStructur;
import com.com.structur.ClassStructur;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.util.ArrayList;

/**
 * Created by Evgeny on 05.07.2017.
 */
public abstract class JSON_parsing {

  protected JSONObject jsonObj;
  protected JSONObject keyJson;
  protected JSONArray jsonArray;

  protected JSONObject getJson(String key){

      return this.keyJson = (JSONObject) jsonObj.get(key);
  }

  protected JSONArray getJsonArry(JSONObject obj, String key){

      return jsonArray = (JSONArray) obj.get(key);
  }


  protected  JSONObject fromObject(String str){

      Object obj = null;
      JSONParser parser = new JSONParser();
      try {
          obj = parser.parse(str);

      } catch (ParseException e) {
          e.printStackTrace();
      }

      return jsonObj = (JSONObject) obj;
  }


  }


