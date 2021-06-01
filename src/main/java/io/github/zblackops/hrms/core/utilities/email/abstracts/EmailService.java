package io.github.zblackops.hrms.core.utilities.email.abstracts;

public interface EmailService {

    boolean theLinkIsClicked();
    void sendVerificationMail(String eMail);

}
