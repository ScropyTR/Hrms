package io.github.zblackops.hrms.business.concretes;

import io.github.zblackops.hrms.business.abstracts.EmployerService;
import io.github.zblackops.hrms.business.constants.Messages;
import io.github.zblackops.hrms.core.utilities.email.abstracts.EmailService;
import io.github.zblackops.hrms.core.utilities.results.*;
import io.github.zblackops.hrms.dataAccess.abstracts.EmployerDao;
import io.github.zblackops.hrms.entities.concretes.Employer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployerManager implements EmployerService {

    EmployerDao employerDao;
    EmailService emailService;

    @Autowired
    public EmployerManager(EmployerDao employerDao, EmailService emailService) {
        this.employerDao = employerDao;
        this.emailService=emailService;
    }

    @Override
    public DataResult<List<Employer>> getAll() {
        return new SuccessDataResult<List<Employer>>(employerDao.findAll(), "İşverenler listelendi");
    }

    @Override
    public Result add(Employer employer) {
        if (isFieldsEmpty(
                employer.getEmail(),
                employer.getPassword(),
                employer.getWebSite(),
                employer.getCompanyName())) return new ErrorResult(Messages.allFieldsAreRequired);

        if (!eMailIsDomainCheck(employer)) return new ErrorResult(Messages.eMailIsDomainInvalid);
        if(employerDao.existsByEmail(employer.getEmail())) return new ErrorResult(Messages.eMailAlreadyExists);
        emailService.sendVerificationMail(employer.getEmail());
        if(!emailService.theLinkIsClicked()) return new ErrorResult(Messages.verificationNotConfirmed);
        employerDao.save(employer);
        return new SuccessResult(Messages.successfullyAddedEmployer);
    }

    public boolean eMailIsDomainCheck(Employer employer) {
        if(employer.getEmail().split("@")[1].equals(employer.getWebSite().split("www.")[1])) return true;
        return false;
    }

    public boolean isFieldsEmpty(String... fields) {
        for (String field : fields) {
            if (field.isEmpty() || field == null) {
                return field.isEmpty();
            }
        }
        return false;
    }

}
