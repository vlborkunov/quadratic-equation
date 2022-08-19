package ru.vlborkunov.quadraticequation.soap.webservice;

import com.sun.xml.ws.developer.ValidationErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

/**
 * Класс управления валидацией по структуре SOAP запросов
 */
public class ValidatorSOAP extends ValidationErrorHandler {
    @Override
    public void warning(SAXParseException exception) throws SAXException {
        handleException(exception);
    }

    @Override
    public void error(SAXParseException exception) throws SAXException {
        handleException(exception);
    }

    @Override
    public void fatalError(SAXParseException exception) throws SAXException {
        handleException(exception);
    }

    private void handleException(SAXParseException e) throws SAXException {
        throw e;
    }
}
