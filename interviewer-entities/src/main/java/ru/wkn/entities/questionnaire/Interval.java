package ru.wkn.entities.questionnaire;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.wkn.exceptions.EntityException;

/**
 * The class {@code Interval} represents a single interval for a user grading by his grades.
 *
 * @param <T> extends the class {@code Number} and represents the type of the boundaries of this interval.
 * @author Orin Adraas
 */
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Interval<T extends Number> {

    /**
     * The min value of an interval.
     */
    private T minValue;

    /**
     * The max value of an interval.
     */
    private T maxValue;

    /**
     * Initializes a newly created {@code Interval} object with the given parameter assignments to the fields of
     * an {@code Interval} object.
     *
     * @param minValue {@link #minValue}
     * @param maxValue {@link #maxValue}
     * @throws EntityException thrown if some problems was occurred with the parameter values.
     */
    @SuppressWarnings(value = {"unused"})
    public Interval(T minValue, T maxValue) throws EntityException {
        if (minValue.doubleValue() > maxValue.doubleValue()) {
            throw new EntityException("A min value more than a max value of an interval");
        }
        this.minValue = minValue;
        this.maxValue = maxValue;
    }
}
