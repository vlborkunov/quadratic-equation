package ru.vlborkunov.quadraticequation.rest.webservice;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import ru.vlborkunov.quadraticequation.soap.webservice.*;
import ru.vlborkunov.quadraticequation.rest.webservice.dto.SolveRESTResponse;
import ru.vlborkunov.quadraticequation.rest.webservice.exception.SOAPException;

import java.util.Objects;

/**
 * REST сервис по решению квадратного уровнения.
 * Вызывает SOAP сервис из модуля quadratic-equation-soap
 */
@Path("/calc")
public class QuadraticEquationREST {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public SolveRESTResponse solve(@QueryParam("a") Double a,
                                   @QueryParam("b") Double b,
                                   @QueryParam("c") Double c) throws SOAPException {
        Request request = buildRequest(a, b, c);

        QuadraticEquationSOAP serviceProxy = new QuadraticEquationSOAPImplService().getQuadraticEquationSOAPImplPort();

        try {
            Response response = serviceProxy.solve(request);
            return buildRESTResponse(response);
        } catch (NonQuadraticEquationWSException_Exception exception) {
            NonQuadraticEquationWSException info = exception.getFaultInfo();
            throw new SOAPException(info.getErrorMessage(), info.getFormula());
        } catch (NegativeDiscriminantWSException_Exception exception) {
            NegativeDiscriminantWSException info = exception.getFaultInfo();
            throw new SOAPException(info.getErrorMessage(), info.getFormula(), info.getD());
        }
    }

    private SolveRESTResponse buildRESTResponse(Response response) {
        SolveRESTResponse restResponse = new SolveRESTResponse();
        restResponse.setFormula(response.getFormula());
        restResponse.setD(response.getD());
        restResponse.setX1(response.getX1());
        if (Objects.nonNull(response.getX2())) {
            restResponse.setX2(response.getX2());
        }
        return restResponse;
    }

    private Request buildRequest(Double a, Double b, Double c) {
        Request request = new Request();
        if (Objects.nonNull(a)) {
            request.setA(a);
        }
        if (Objects.nonNull(b)) {
            request.setB(b);
        }
        if (Objects.nonNull(c)) {
            request.setC(c);
        }
        return request;
    }
}