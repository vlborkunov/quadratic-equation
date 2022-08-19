package ru.vlborkunov.quadraticequation.rest.webservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Структура REST ответа на запрос по решению квадратного уравнения
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SolveRESTResponse {
    private String formula;
    private Double d;
    private Double x1;
    private Double x2;
}
