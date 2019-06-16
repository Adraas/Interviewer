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
 * @param <T> extends the class {@code Number} and represents the type of a boundaries of the interval.
 * @author Orin Adraas
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class AnalyticalInformation<T extends Number> {

    /**
     * The field represents the information about an interval's boundaries.
     */
    private Interval<T> interval;

    /**
     * The field represents the analytical information of a current appropriate {@code Interval} object.
     */
    private String information;
}
