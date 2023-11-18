package repository.book;

import java.util.*;

public class Cache<T>{

    private List<T> storage;

    public List<T> load(){
        return storage;
    }

    public void save(List<T> entities){
        this.storage = entities;
    }

    public boolean hasResult(){
        return storage != null;
    }

    public void invalidateCache(){
        storage = null;
    }
}
