package io.github.zblackops.hrms.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "social_media_accounts")
@Entity
public class SocialMediaAccount {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "type", length = 256, nullable = false)
    private String type;

    @Column(name = "url", length = 256, nullable = false)
    private String url;

    @ManyToOne
    @JoinColumn(name = "curriculum_vitae_id")
    private CurriculumVitae curriculumVitae;

}
