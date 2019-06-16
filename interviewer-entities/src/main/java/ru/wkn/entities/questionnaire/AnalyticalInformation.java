package ru.wkn.entities.questionnaire;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The class {@code AnalyticalInformation} represents an analytical information containing an {@code Interval} object
 * and appropriate its an information.
 *
 * @author Orin Adraas
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class AnalyticalInformation {

    /**
     * The field represents the information about an interval's boundaries.
     */
    private Interval<Integer> interval;

    /**
     * The field represents the analytical information of a current appropriate {@code Interval} object.
     */
    private String information;
}
