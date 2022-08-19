package ru.vlborkunov.quadraticequation.rest.webservice.exception.mapper;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import lombok.SneakyThrows;
import ru.vlborkunov.quadraticequation.rest.webservice.exception.SOAPException;

/**
 * Маппер REST Исключения SOAPException для формирования структуры ответа
 * на запрос по решению квадратного уравнения при возникновении ошибки
 */
@Provider
public class SOAPExceptionMapper implements ExceptionMapper<SOAPException> {
    @Override
    @SneakyThrows
    public Response toResponse(SOAPException exception) {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        Response response = Response
                .status(Response.Status.BAD_REQUEST)
                .entity(ow.writeValueAsString(exception))
                .build();
        return response;
    }

}
