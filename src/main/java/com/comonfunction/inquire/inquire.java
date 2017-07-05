package com.comonfunction.inquire;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Evgeny on 01.07.2017.
 */

@ManagedBean(name = "inq", eager = true)
@RequestScoped
public class inquire {

    private String inquir;

    private String result;

    public String getInquir() {
        return inquir;
    }

    public void setInquir(String inquir) {
        this.inquir = inquir;
    }

    public void setResult(String result) {
        this.result = result;
    }


    public void respons(){
        try {
            Thread.sleep(0);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        URL url;
        HttpURLConnection conn;
        BufferedReader rd;
        String line;

        try {
            url = new URL(this.inquir);
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream(),"UTF-8"));
            while ((line = rd.readLine()) != null) {
                this.result += line;
            }
            rd.close();

        } catch (Exception e) {

        }

    }

    public String getResult(){
       return this.result;
    }

}
