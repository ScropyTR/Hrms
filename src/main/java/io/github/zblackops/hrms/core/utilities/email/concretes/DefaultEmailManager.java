package io.github.zblackops.hrms.core.utilities.email.concretes;

import io.github.zblackops.hrms.business.constants.Messages;
import io.github.zblackops.hrms.core.utilities.email.abstracts.EmailService;
import org.springframework.stereotype.Service;

@Service
public class DefaultEmailManager implements EmailService {

    @Override
    public boolean theLinkIsClicked() {
        return true;
    }

    @Override
    public void sendVerificationMail(String eMail) {
        System.out.println(Messages.sentVerificationMail);
    }
}
