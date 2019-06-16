package ru.wkn.report.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Map;

@AllArgsConstructor
@Getter
public class Statistics {

    private Map<String, Integer> gradesByCriteria;
    private Map<String, String> analyticalInformationByCriteria;
}
