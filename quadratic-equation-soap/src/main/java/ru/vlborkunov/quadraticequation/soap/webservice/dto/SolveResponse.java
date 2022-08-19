package ru.vlborkunov.quadraticequation.soap.webservice.dto;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * Структура SOAP ответа по решению квадратного уравнения
 */
@Data
@AllArgsConstructor
@RequiredArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "response")
public class SolveResponse {
    @NonNull
    @XmlElement(required = true)
    private String formula;

    @NonNull
    @XmlElement(name = "D", required = true)
    private Double d;

    @NonNull
    @XmlElement(required = true)
    private Double x1;

    @XmlElement
    private Double x2;
}
