package ru.vlborkunov.quadraticequation.soap.exception;

import jakarta.xml.ws.WebFault;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Exception если уравнение не квадратное
 */
@Getter
@WebFault
@AllArgsConstructor
public class NonQuadraticEquationWSException extends Exception {
    private static final long serialVersionUID = 1L;
    private String errorMessage;
    private String formula;
}