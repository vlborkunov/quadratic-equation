
package ru.vlborkunov.quadraticequation.soap.webservice;

import jakarta.xml.ws.WebFault;


/**
 * This class was generated by the XML-WS Tools.
 * XML-WS Tools 4.0.0
 * Generated source version: 3.0
 * 
 */
@WebFault(name = "NonQuadraticEquationWSException", targetNamespace = "http://webservice.soap.quadraticequation.vlborkunov.ru/")
public class NonQuadraticEquationWSException_Exception
    extends Exception
{

    /**
     * Java type that goes as soapenv:Fault detail element.
     * 
     */
    private NonQuadraticEquationWSException faultInfo;

    /**
     * 
     * @param faultInfo
     * @param message
     */
    public NonQuadraticEquationWSException_Exception(String message, NonQuadraticEquationWSException faultInfo) {
        super(message);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @param cause
     * @param faultInfo
     * @param message
     */
    public NonQuadraticEquationWSException_Exception(String message, NonQuadraticEquationWSException faultInfo, Throwable cause) {
        super(message, cause);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @return
     *     returns fault bean: ru.vlborkunov.quadraticequation.soap.webservice.NonQuadraticEquationWSException
     */
    public NonQuadraticEquationWSException getFaultInfo() {
        return faultInfo;
    }

}
