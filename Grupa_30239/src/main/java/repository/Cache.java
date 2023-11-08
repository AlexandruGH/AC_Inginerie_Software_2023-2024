package repository;
import java.util.List;


public class Cache<T> {
    private List<T> storage;

    public void save(List<T> entities){
        this.storage = entities;
    }

    public List<T> load(){
        return storage;
    }

    public void invalidateCache(){
        storage = null;
    }

    public boolean hasResult(){
        return storage != null;
    }

}
