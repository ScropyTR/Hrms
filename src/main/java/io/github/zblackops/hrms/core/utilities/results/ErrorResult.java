package io.github.zblackops.hrms.core.utilities.results;

public class ErrorResult extends Result {

    public ErrorResult() {
        super(false);
    }

    public ErrorResult(String messsage) {
        super(false, messsage);
    }
}
