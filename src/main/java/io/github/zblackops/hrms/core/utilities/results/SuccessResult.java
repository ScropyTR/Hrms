package io.github.zblackops.hrms.core.utilities.results;

public class SuccessResult extends Result {

    public SuccessResult() {
        super(true);
    }

    public SuccessResult(String messsage) {
        super(true, messsage);
    }
}
