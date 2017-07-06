package com.com.convert;

import com.com.convert.Interface.getSpisok;
import com.com.convert.JSON_parsing;
import com.com.structur.ClassStructur;
import org.json.JSONObject;
import java.util.ArrayList;
/**
 * Created by Evgeny on 06.07.2017.
 */
public class Parsing_groop extends JSON_parsing implements getSpisok {

    @Override
    public ArrayList<ClassStructur> getList(String Json) {

        ArrayList<ClassStructur> list = new ArrayList<>();

        fromObject(Json);
        getJsonArry(getJson("response"),"items");

        for (int i=0;i<this.jsonArray.size();i++) {
            this.jsonObj = (org.json.simple.JSONObject) jsonArray.get(i);

            list.add(new ClassStructur(this.jsonObj.get("screen_name"),
                    Integer.valueOf(this.jsonObj.get("id").toString()),
                    this.jsonObj.get("name")));

        }

        return list;
    }
}
