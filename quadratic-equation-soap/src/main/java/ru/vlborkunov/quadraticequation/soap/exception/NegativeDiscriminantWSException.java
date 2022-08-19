package ru.vlborkunov.quadraticequation.soap.exception;

import jakarta.xml.ws.WebFault;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Exception когда дискриминант меньше нуля
 */
@Getter
@WebFault
@AllArgsConstructor
public class NegativeDiscriminantWSException extends Exception {
    private static final long serialVersionUID = 1L;
    private String errorMessage;
    private String formula;
    private Double d;
}