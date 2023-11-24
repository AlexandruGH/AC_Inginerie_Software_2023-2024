package model.validator;

import java.util.*;
import java.util.stream.Collectors;

public class ResultFetchException extends RuntimeException{

    private final List<String> errors;

    public ResultFetchException(List<String> errors){
        super("Failed to fetch the result as operation encountered errors!");
        this.errors = errors;
    }

    @Override
    public String toString(){
        return errors.stream().map(Object::toString).collect(Collectors.joining(",")) + super.toString();
    }
}
