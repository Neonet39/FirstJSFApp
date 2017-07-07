package com.com.convert.ParsingError;

import com.com.convert.Interface.Error;
import com.com.convert.JSON_parsing;
import org.json.simple.JSONObject;

/**
 * Created by Evgeny on 06.07.2017.
 */
public class ChekError extends JSON_parsing implements Error {
    private String check;

    public void setCheck(String check){
        this.check = check;
    }

    @Override
    public boolean check_error() {
        try {
            fromObject(this.check);
            String s = (String) this.jsonObj.get("error");
            if(s.equals("null"))
                return false;
            else return true;
        }catch (Exception e){
            return false;
        }


    }

    @Override
    public boolean check_errorSix() {

            try {
                if( getJson("error").get("error_code").toString().equals("6"))
                    return true; else return false;
            }catch (Exception e){
                return false;
            }


    }

    @Override
    public String code() {
        if(check_error()!=true){
            return null;
        }else {
            try {
                return getJson("error").get("error_code").toString();

            }catch (Exception e){
                return null;
            }
        }

    }
}
