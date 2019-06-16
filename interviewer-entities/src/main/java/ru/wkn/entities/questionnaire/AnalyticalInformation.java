package ru.wkn.entities.questionnaire;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class AnalyticalInformation<T extends Number> {

    private Interval<T> interval;
    private String information;
}
