
package ru.vlborkunov.quadraticequation.soap.webservice;

import javax.xml.namespace.QName;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ru.vlborkunov.quadraticequation.soap.webservice package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _NegativeDiscriminantWSException_QNAME = new QName("http://webservice.soap.quadraticequation.vlborkunov.ru/", "NegativeDiscriminantWSException");
    private final static QName _NonQuadraticEquationWSException_QNAME = new QName("http://webservice.soap.quadraticequation.vlborkunov.ru/", "NonQuadraticEquationWSException");
    private final static QName _Solve_QNAME = new QName("http://webservice.soap.quadraticequation.vlborkunov.ru/", "solve");
    private final static QName _SolveResponse_QNAME = new QName("http://webservice.soap.quadraticequation.vlborkunov.ru/", "solveResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ru.vlborkunov.quadraticequation.soap.webservice
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link NegativeDiscriminantWSException }
     * 
     * @return
     *     the new instance of {@link NegativeDiscriminantWSException }
     */
    public NegativeDiscriminantWSException createNegativeDiscriminantWSException() {
        return new NegativeDiscriminantWSException();
    }

    /**
     * Create an instance of {@link NonQuadraticEquationWSException }
     * 
     * @return
     *     the new instance of {@link NonQuadraticEquationWSException }
     */
    public NonQuadraticEquationWSException createNonQuadraticEquationWSException() {
        return new NonQuadraticEquationWSException();
    }

    /**
     * Create an instance of {@link Solve }
     * 
     * @return
     *     the new instance of {@link Solve }
     */
    public Solve createSolve() {
        return new Solve();
    }

    /**
     * Create an instance of {@link SolveResponse }
     * 
     * @return
     *     the new instance of {@link SolveResponse }
     */
    public SolveResponse createSolveResponse() {
        return new SolveResponse();
    }

    /**
     * Create an instance of {@link Request }
     * 
     * @return
     *     the new instance of {@link Request }
     */
    public Request createRequest() {
        return new Request();
    }

    /**
     * Create an instance of {@link Response }
     * 
     * @return
     *     the new instance of {@link Response }
     */
    public Response createResponse() {
        return new Response();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link NegativeDiscriminantWSException }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link NegativeDiscriminantWSException }{@code >}
     */
    @XmlElementDecl(namespace = "http://webservice.soap.quadraticequation.vlborkunov.ru/", name = "NegativeDiscriminantWSException")
    public JAXBElement<NegativeDiscriminantWSException> createNegativeDiscriminantWSException(NegativeDiscriminantWSException value) {
        return new JAXBElement<>(_NegativeDiscriminantWSException_QNAME, NegativeDiscriminantWSException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link NonQuadraticEquationWSException }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link NonQuadraticEquationWSException }{@code >}
     */
    @XmlElementDecl(namespace = "http://webservice.soap.quadraticequation.vlborkunov.ru/", name = "NonQuadraticEquationWSException")
    public JAXBElement<NonQuadraticEquationWSException> createNonQuadraticEquationWSException(NonQuadraticEquationWSException value) {
        return new JAXBElement<>(_NonQuadraticEquationWSException_QNAME, NonQuadraticEquationWSException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Solve }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Solve }{@code >}
     */
    @XmlElementDecl(namespace = "http://webservice.soap.quadraticequation.vlborkunov.ru/", name = "solve")
    public JAXBElement<Solve> createSolve(Solve value) {
        return new JAXBElement<>(_Solve_QNAME, Solve.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SolveResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SolveResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://webservice.soap.quadraticequation.vlborkunov.ru/", name = "solveResponse")
    public JAXBElement<SolveResponse> createSolveResponse(SolveResponse value) {
        return new JAXBElement<>(_SolveResponse_QNAME, SolveResponse.class, null, value);
    }

}
