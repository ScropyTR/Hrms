package io.github.zblackops.hrms.core.utilities.results;

public class Result {

    boolean success;
    String messsage;

    public Result(boolean success) {
        this.success = success;
    }

    public Result(boolean success, String messsage) {
        this(success);
        this.messsage = messsage;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMesssage() {
        return messsage;
    }
}
