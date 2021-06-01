package io.github.zblackops.hrms.dataAccess.abstracts;

import io.github.zblackops.hrms.entities.concretes.Employer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployerDao extends JpaRepository<Employer, Integer> {
    boolean existsByEmail(String eMail);
}
