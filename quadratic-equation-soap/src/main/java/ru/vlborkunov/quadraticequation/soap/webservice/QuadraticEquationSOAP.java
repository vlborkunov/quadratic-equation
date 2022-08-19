package ru.vlborkunov.quadraticequation.soap.webservice;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebResult;
import jakarta.jws.WebService;
import jakarta.xml.bind.annotation.XmlElement;
import ru.vlborkunov.quadraticequation.soap.exception.NegativeDiscriminantWSException;
import ru.vlborkunov.quadraticequation.soap.exception.NonQuadraticEquationWSException;
import ru.vlborkunov.quadraticequation.soap.webservice.dto.SolveRequest;
import ru.vlborkunov.quadraticequation.soap.webservice.dto.SolveResponse;

/**
 * SOAP интерфейс для управления квадратным уравнением
 */
@WebService
public interface QuadraticEquationSOAP {
    @WebMethod
    @WebResult(name = "response")
    SolveResponse solve(
            @XmlElement(required = true)
            @WebParam(name = "request")
            SolveRequest solveRequest
    ) throws NegativeDiscriminantWSException, NonQuadraticEquationWSException;
}
