package model.validator;

import java.util.*;

public class Notification<T>{
    private T result;
    private final List<String> errors;

    public Notification(){
        this.errors = new ArrayList<>();
    }

    public void addError(String error){
        this.errors.add(error);
    }

    public boolean hasErrors(){
        return !this.errors.isEmpty();
    }

    public void setResult(T result) {
        this.result = result;
    }

    public T getResult() {
        if (hasErrors()){
            throw new ResultFetchException(errors);
        }
        return result;
    }

    public String getFormattedErrors(){
        return String.join("\n", errors);
    }
}
