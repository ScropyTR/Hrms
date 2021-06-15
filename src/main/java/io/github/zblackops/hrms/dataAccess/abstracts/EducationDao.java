package io.github.zblackops.hrms.dataAccess.abstracts;

import io.github.zblackops.hrms.entities.concretes.Education;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EducationDao extends JpaRepository<Education, Integer> {

    List<Education> getByEducationIdOrderByGraduationDateDesc(int educationId);

}
