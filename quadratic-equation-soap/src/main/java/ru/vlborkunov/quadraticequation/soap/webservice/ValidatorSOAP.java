package ru.vlborkunov.quadraticequation.soap.webservice;

import com.sun.xml.ws.developer.ValidationErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

/**
 * Класс управления валидацией по структуре SOAP запросов
 */
public class ValidatorSOAP extends ValidationErrorHandler {
    @Override
    public void warning(final SAXParseException exception) throws SAXException {
        handleException(exception);
    }

    @Override
    public void error(final SAXParseException exception) throws SAXException {
        handleException(exception);
    }

    @Override
    public void fatalError(final SAXParseException exception) throws SAXException {
        handleException(exception);
    }

    private void handleException(final SAXParseException e) throws SAXException {
        throw e;
    }
}
