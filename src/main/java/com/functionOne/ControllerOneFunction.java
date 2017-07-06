package com.functionOne;

import com.com.convert.JSON_parsing;
import com.com.convert.ParsingError.ChekError;
import com.com.convert.Parsing_groop;
import com.comonfunction.inquire.inquire;
import org.json.simple.parser.JSONParser;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import java.io.Serializable;

/**
 * Created by Evgeny on 03.07.2017.
 */

@ManagedBean(name = "controlleone", eager = true)
@RequestScoped
public class ControllerOneFunction implements Serializable {

    private inquire inq = new inquire();

    @ManagedProperty(value = "#{param.textinquire}")
    private String textinquire;

    @ManagedProperty(value = "#{param.token}")
    private String token;


    public void Start() {
       this.textinquire = ("https://api.vk.com/method/groups.search?q=" + this.getTextinquire() + "&access_token=" + this.getToken() + "&v=5.65");
       // this.textinquire = ("https://api.vk.com/method/stats.get?q=" + this.getTextinquire() + "&access_token=" + this.getToken() +"" +"&v=5.65");

        this.inq.setInquir(this.getTextinquire());

        this.inq.respons();
        String s = this.inq.getResult().substring(4, this.inq.getResult().length());
        Parsing_groop pars = new Parsing_groop();
        ChekError error = new ChekError();
        error.setCheck(s);
        if(error.check_error()){
            System.out.println("sdf");
        }
       // pars.getList(s);

         //   obj = parser.parse(s);
        //    JSONObject jsonObj = (JSONObject) obj;
        //    JSONObject jsonObject = (JSONObject) jsonObj.get("respons");

        //     JsonArray ja = (JsonArray) jsonObject.get("items");


        // } catch (ParseException e) {
        //  e.printStackTrace();
        // }
        //}

    }
    public String Result() {
        return this.inq.getResult();
    }


    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }


    public String getTextinquire() {
        return textinquire;
    }

    public void setTextinquire(String textinquire) {
        this.textinquire = textinquire;
    }
}
