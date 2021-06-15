package io.github.zblackops.hrms.entities.concretes;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "educations")
@Entity
public class Education {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int educationId;

    @Column(name = "school_name", nullable = false)
    private String schoolName;

    @Column(name = "department", nullable = false)
    private String department;

    @Column(name = "started_date", nullable = false)
    private LocalDate startedDate;

    @Column(name = "graduation_date")
    private LocalDate graduationDate;

    @ManyToOne
    @JoinColumn(name = "curriculum_vitae_id", nullable = false)
    private CurriculumVitae curriculumVitae;

}