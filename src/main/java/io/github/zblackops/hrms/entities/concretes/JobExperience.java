package io.github.zblackops.hrms.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "job_experiences")
@Entity
public class JobExperience {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "work_place_name", nullable = false)
    private String workPlaceName;

    @Column(name = "department_name", nullable = false)
    private String department;

    @Column(name = "started_date", nullable = false)
    private LocalDate startedDate;

    @Column(name = "finished_date")
    private LocalDate finishedDate;

    @ManyToOne
    @JoinColumn(name = "curriculum_id", nullable = false)
    private CurriculumVitae curriculumVitae;

}
