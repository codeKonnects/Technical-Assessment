package io.davidabejirin.assessment.utils;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Map;
import java.util.OptionalDouble;

@AllArgsConstructor
@Data
public class TermlyResult {
    private OptionalDouble average;
    private Map<String, Double> result;
}
