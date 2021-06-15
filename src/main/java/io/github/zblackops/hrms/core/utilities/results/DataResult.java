package io.github.zblackops.hrms.core.utilities.results;

import javax.xml.crypto.Data;

public class DataResult<T> extends Result {

    T data;

    public DataResult (T data, boolean success){
        super(success);
        this.data=data;
    }

    public DataResult (T data, boolean success, String message){
        super(success, message);
        this.data=data;
    }

    public T getData() {
        return data;
    }
}
