package com.Thead;

import com.com.convert.Edit;
import com.com.convert.Paring_Statistick.Parsing_Stat;
import com.com.convert.ParsingError.ChekError;
import com.comonfunction.inquire.inquire;
import com.structur.ArrayStructur;
import com.structur.ClassStructur;
import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.util.ArrayList;

/**
 * Created by Evgeny on 06.07.2017.
 */
public class TheadStatic extends Thread {

    private inquire inq;
    private ChekError chekError;
    private String id;
    private String result;
    private Parsing_Stat pars;



    public TheadStatic(ClassStructur o){
        this.id = String.valueOf(o.getId());
    }
    @Override
    public void run() {

        inq = new inquire();
        chekError = new ChekError();
        inq.setInquir("https://api.vk.com/method/stats.get?v=5.67&access_token=6174b7732f4599c7be0dea99f48b4b6757f9e832464eb2b79c8e42fcd3ff25c3ad63d0d09be4862eed87b&group_id="+this.id+"&app_id=5325854&date_from=2017-06-08&date_to=2017-06-15");

        while (true) {
            inq.respons();
            chekError.setCheck(Edit.Edit_Json(inq.getResult()));
            System.out.println(Edit.Edit_Json(inq.getResult()));
            System.out.println();
            if (!chekError.check_errorSix()) {

                break;
            }else try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            if (!chekError.check_error()) {
                this.pars.setParsingText(Edit.Edit_Json(inq.getResult()));
                System.out.println(1);
                this.result = pars.Statistick();
            }
        }catch (Exception e){}
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getResult() {
        return result;
    }
}
