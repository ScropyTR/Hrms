package io.github.zblackops.hrms.entities.concretes;

import io.github.zblackops.hrms.entities.abstracts.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "job_seekers")
@PrimaryKeyJoinColumn(name="user_id")
public class JobSeeker extends User {

    @Column(name = "first_name", nullable = true)
    private String firstName;

    @Column(name = "last_name", nullable = true)
    private String lastName;

    @Column(name = "nationality_id", nullable = true)
    private String nationalityId;

    @Column(name = "date_of_birth", nullable = true)
    private LocalDate dateOfBirth;

    @OneToOne(mappedBy = "jobSeeker")
    private CurriculumVitae curriculumVitae;

    @OneToOne(mappedBy = "jobSeeker")
    private Image image;

}
