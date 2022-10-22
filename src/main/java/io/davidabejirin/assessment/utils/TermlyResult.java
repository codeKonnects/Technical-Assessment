package io.davidabejirin.assessment.utils;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Map;
import java.util.OptionalDouble;

@AllArgsConstructor
@Data
public class TermlyResult {
    private Double average;
    private Map<String, Double> result;
}
