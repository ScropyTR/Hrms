package io.github.zblackops.hrms.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.EnableMBeanExport;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "job_advertisements")
@Entity
public class JobAdvertisement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int jobAdvertisementId;

    @Column(name = "job_description", nullable = true)
    private String jobDescription;

    @Column(name = "is_active", nullable = true)
    private boolean isActive;

    @Column(name = "number_of_open_positions", nullable = true)
    private int numberOfOpenPositions;

    @Column(name = "min_salary")
    private int minSalary;

    @Column(name = "max_salary")
    private int maxSalary;

    @Column(name = "application_deadline")
    private LocalDate applicationDeadLine;

    @Column(name = "release_date", nullable = true)
    private LocalDate releaseDate;

    @ManyToOne()
    @JoinColumn(name = "employer_id", nullable = true)
    private Employer employer;

    @ManyToOne()
    @JoinColumn(name = "job_position_id", nullable = true)
    private JobPosition jobPosition;

    @ManyToOne()
    @JoinColumn(name = "city_id", nullable = true)
    private City city;

}
