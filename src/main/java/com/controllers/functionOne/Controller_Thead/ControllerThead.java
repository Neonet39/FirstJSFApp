package com.controllers.functionOne.Controller_Thead;

import com.Thead.TheadStatic;
import com.structur.ArrayStructur;
import com.structur.ClassStructur;

import java.util.ArrayList;

/**
 * Created by Evgeny on 06.07.2017.
 */
public class ControllerThead  {

    private ArrayList<ClassStructur> list = new ArrayList<ClassStructur>();
    private ArrayList<TheadStatic> thead = new ArrayList<TheadStatic>();

    public void setList(ArrayList<ClassStructur> list) {
        this.list = list;
    }

    public ArrayList<ClassStructur> Calculation(){


        for (int i=0;i<this.list.size();i++){
            thead.add((new TheadStatic(this.list.get(i))));
            thead.get(i).start();
        }


        for (int i=0;i<thead.size();i++){
            while (thead.get(i).isAlive()){}
          //  System.out.println(thead.get(i).getResult());
        }

        return list;
    }
}
