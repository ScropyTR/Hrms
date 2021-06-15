package io.github.zblackops.hrms.dataAccess.abstracts;

import io.github.zblackops.hrms.entities.concretes.JobExperience;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobExperienceDao extends JpaRepository<JobExperience, Integer> {

    List<JobExperience> getByIdOrderByFinishedDateDesc(int experienceId);

}
