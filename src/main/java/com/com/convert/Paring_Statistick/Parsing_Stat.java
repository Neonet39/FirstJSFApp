package com.com.convert.Paring_Statistick;

import com.com.convert.Interface.Parsing_Statick;
import com.com.convert.JSON_parsing;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 * Created by Evgeny on 06.07.2017.
 */
public class Parsing_Stat extends JSON_parsing implements Parsing_Statick {

    private String parsingText;

    public void setParsingText(String parsingText) {
        this.parsingText = parsingText;
    }





    @Override
    public String Statistick() {
        double sum = 0;
        JSONArray array = getJsonArry(fromObject(this.parsingText),"response");
        for (int i=0;i<=array.size();i++){
           JSONObject object = (JSONObject) array.get(i);
          // System.out.println(object.get("reach").toString());
        }

        return String.valueOf(sum/array.size());
    }
}
