package model;

import java.util.Observable;

public class SimpleModel extends Observable {
    private String field;

    public String getField(){
        return field;
    }

    public void setField(String field){
        this.field = field;
        setChanged();
        notifyObservers();
    }

}
