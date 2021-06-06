package io.github.zblackops.hrms.dataAccess.abstracts;

import io.github.zblackops.hrms.core.utilities.results.DataResult;
import io.github.zblackops.hrms.entities.concretes.Employer;
import io.github.zblackops.hrms.entities.concretes.JobAdvertisement;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer> {

    JobAdvertisement findByJobAdvertisementId(int id);

    List<JobAdvertisement> getByIsActiveTrue();

    List<JobAdvertisement> getByIsActiveTrueAndEmployer(Employer employer);

    List<JobAdvertisement> getByIsActiveTrueOrderByReleaseDateDesc();

}
