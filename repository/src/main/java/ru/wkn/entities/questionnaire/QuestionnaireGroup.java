package ru.wkn.entities.questionnaire;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

/**
 * The class {@code QuestionnaireGroup} represents questionnaire group.
 *
 * @author Orin Adraas
 */
@Entity
@Table(name = "questionnaire_group")
public class QuestionnaireGroup {

    /**
     * The unique ID of questionnaire group.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false, insertable = false, updatable = false)
    private long id;

    /**
     * The ID of questionnaire group author.
     */
    @Column(name = "author_id", nullable = false, length = 60)
    private long authorId;

    /**
     * The theme of questionnaire group.
     */
    @Column(name = "theme", nullable = false, length = 30)
    private String theme;

    /**
     * The preset questionnaires of questionnaire group.
     */
    @OneToMany(targetEntity = Questionnaire.class, cascade = {CascadeType.PERSIST}, fetch = FetchType.EAGER)
    private Set<Questionnaire> questionnaires;
}
