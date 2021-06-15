package io.github.zblackops.hrms.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "curriculum_vitaes")
public class CurriculumVitae {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "cover_letter", length = 1200)
    private String coverLetter;

    @OneToOne
    @JoinColumn(name = "job_seeker_id")
    private JobSeeker jobSeeker;

    @OneToMany(mappedBy = "curriculumVitae")
    private List<JobExperience> jobExperiences;

    @OneToMany(mappedBy = "curriculumVitae")
    private List<Education> educations;

    @OneToMany(mappedBy = "curriculumVitae")
    private List<SocialMediaAccount> socialMediaAccounts;

}
