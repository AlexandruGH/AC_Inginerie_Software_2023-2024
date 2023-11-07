package repository.book;

import java.util.*;

public class Cache<T> {
    private List<T> storage;

    public void save(List<T> entities){
        this.storage = entities;
    }

    public List<T> load(){
        System.out.println("Loaded from cache");
        return storage;
    }

    public void invalidateCache(){
        storage = null;
    }

    public boolean hasResult(){
        return storage != null;
    }

}
