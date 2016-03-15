package com.dispatcher.farouq.uiadispatcher;

/**
 * Created by epic on 14/03/2016.
 */
public class Item {

    public Integer id;
    public String name;
    public String Descr;

    public Item(Integer id,String name, String descr) {
        this.id = id;
        this.name = name;
        Descr = descr;
    }

    public String getDescr() {
        return Descr;
    }

    public void setDescr(String descr) {
        Descr = descr;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
