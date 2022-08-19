package ru.vlborkunov.quadraticequation.soap.webservice.dto;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import lombok.*;

/**
 * Структура SOAP запроса по решению квадратного уравнения
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlType(name = "request")
@XmlAccessorType(XmlAccessType.FIELD)
public class SolveRequest {
    @XmlElement(required = true)
    private Double a;

    @XmlElement(required = true)
    private Double b;

    @XmlElement(required = true)
    private Double c;
}
