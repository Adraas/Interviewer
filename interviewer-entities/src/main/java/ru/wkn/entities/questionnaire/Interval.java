package ru.wkn.entities.questionnaire;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.wkn.exceptions.EntityException;

/**
 * The class {@code Interval} represents a single interval for a user grading by his grades.
 *
 * @author Orin Adraas
 */
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Interval<T extends Number> {

    private T minValue;
    private T maxValue;

    public Interval(T minValue, T maxValue) throws EntityException {
        if (minValue.doubleValue() > maxValue.doubleValue()) {
            throw new EntityException("A min value more than a max value of an interval");
        }
        this.minValue = minValue;
        this.maxValue = maxValue;
    }
}
