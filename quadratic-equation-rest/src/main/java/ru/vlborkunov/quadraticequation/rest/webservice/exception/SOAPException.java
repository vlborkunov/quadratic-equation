package ru.vlborkunov.quadraticequation.rest.webservice.exception;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;

/**
 * Исключение при возникновении ошибки при вызове
 * SOAP запроса на решение квадратного уравнения
 */
@AllArgsConstructor
@JsonAutoDetect(
        fieldVisibility = JsonAutoDetect.Visibility.NONE,
        setterVisibility = JsonAutoDetect.Visibility.NONE,
        getterVisibility = JsonAutoDetect.Visibility.NONE,
        isGetterVisibility = JsonAutoDetect.Visibility.NONE,
        creatorVisibility = JsonAutoDetect.Visibility.NONE
)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SOAPException extends Exception {
    @JsonProperty
    private final String errorMessage;
    @JsonProperty
    private final String formula;
    @JsonProperty
    private Double d;

    public SOAPException(final String errorMessage, final String formula) {
        this.errorMessage = errorMessage;
        this.formula = formula;
    }
}
