package ru.wkn.report.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Map;

/**
 * The class {@code Statistics} represents a statistics by questionnaire surveying results.
 *
 * @author Orin Adraas
 */
@AllArgsConstructor
@Getter
public class Statistics {

    /**
     * The grades by criteria.
     */
    private Map<String, Integer> gradesByCriteria;

    /**
     * The analytical information by criteria.
     */
    private Map<String, String> analyticalInformationByCriteria;
}
