package io.github.zblackops.hrms.dataAccess.abstracts;

import io.github.zblackops.hrms.entities.concretes.CurriculumVitae;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurriculumVitaeDao extends JpaRepository<CurriculumVitae, Integer> {

    CurriculumVitae getByJobSeeker_Id(int id);

}
