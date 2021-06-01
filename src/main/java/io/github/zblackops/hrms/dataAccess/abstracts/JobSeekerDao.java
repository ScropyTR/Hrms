package io.github.zblackops.hrms.dataAccess.abstracts;

import io.github.zblackops.hrms.entities.concretes.JobSeeker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobSeekerDao extends JpaRepository<JobSeeker, Integer> {

    boolean existsByNationalityId(String nationalityId);
    boolean existsByEmail(String eMail);

}
