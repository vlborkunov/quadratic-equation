
package ru.vlborkunov.quadraticequation.soap.webservice;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebResult;
import jakarta.jws.WebService;
import jakarta.xml.bind.annotation.XmlSeeAlso;
import jakarta.xml.ws.Action;
import jakarta.xml.ws.FaultAction;
import jakarta.xml.ws.RequestWrapper;
import jakarta.xml.ws.ResponseWrapper;


/**
 * This class was generated by the XML-WS Tools.
 * XML-WS Tools 4.0.0
 * Generated source version: 3.0
 * 
 */
@WebService(name = "QuadraticEquationSOAP", targetNamespace = "http://webservice.soap.quadraticequation.vlborkunov.ru/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface QuadraticEquationSOAP {


    /**
     * 
     * @param request
     * @return
     *     returns ru.vlborkunov.quadraticequation.soap.webservice.Response
     * @throws NegativeDiscriminantWSException_Exception
     * @throws NonQuadraticEquationWSException_Exception
     */
    @WebMethod
    @WebResult(name = "response", targetNamespace = "")
    @RequestWrapper(localName = "solve", targetNamespace = "http://webservice.soap.quadraticequation.vlborkunov.ru/", className = "ru.vlborkunov.quadraticequation.soap.webservice.Solve")
    @ResponseWrapper(localName = "solveResponse", targetNamespace = "http://webservice.soap.quadraticequation.vlborkunov.ru/", className = "ru.vlborkunov.quadraticequation.soap.webservice.SolveResponse")
    @Action(input = "http://webservice.soap.quadraticequation.vlborkunov.ru/QuadraticEquationSOAP/solveRequest", output = "http://webservice.soap.quadraticequation.vlborkunov.ru/QuadraticEquationSOAP/solveResponse", fault = {
        @FaultAction(className = NegativeDiscriminantWSException_Exception.class, value = "http://webservice.soap.quadraticequation.vlborkunov.ru/QuadraticEquationSOAP/solve/Fault/NegativeDiscriminantWSException"),
        @FaultAction(className = NonQuadraticEquationWSException_Exception.class, value = "http://webservice.soap.quadraticequation.vlborkunov.ru/QuadraticEquationSOAP/solve/Fault/NonQuadraticEquationWSException")
    })
    public Response solve(
        @WebParam(name = "request", targetNamespace = "")
        Request request)
        throws NegativeDiscriminantWSException_Exception, NonQuadraticEquationWSException_Exception
    ;

}