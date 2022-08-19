package ru.vlborkunov.quadraticequation.soap.webservice;

import org.junit.jupiter.api.Test;
import ru.vlborkunov.quadraticequation.soap.exception.NegativeDiscriminantWSException;
import ru.vlborkunov.quadraticequation.soap.exception.NonQuadraticEquationWSException;
import ru.vlborkunov.quadraticequation.soap.webservice.dto.SolveRequest;
import ru.vlborkunov.quadraticequation.soap.webservice.dto.SolveResponse;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit Тесты по SOAP сервису управления квадратным уровнением QuadraticEquationSOAP
 */
class QuadraticEquationSOAPImplTest {
    private static QuadraticEquationSOAP service = new QuadraticEquationSOAPImpl();

    @Test
    void solveDiscriminantNotZero() throws NegativeDiscriminantWSException, NonQuadraticEquationWSException {
        SolveRequest request = new SolveRequest(1.0, -4.0, 3.0);

        SolveResponse response = service.solve(request);

        assertEquals("1.0x^2-4.0x+3.0=0", response.getFormula());
        assertEquals(4.0, response.getD());
        assertEquals(1.0, response.getX1());
        assertEquals(3.0, response.getX2());
    }

    @Test
    void solveDiscriminantZero() throws NegativeDiscriminantWSException, NonQuadraticEquationWSException {
        SolveRequest request = new SolveRequest(1.0, -2.0, 1.0);

        SolveResponse response = service.solve(request);

        assertEquals("1.0x^2-2.0x+1.0=0", response.getFormula());
        assertEquals(0.0, response.getD());
        assertEquals(1.0, response.getX1());
        assertNull(response.getX2());
    }

    @Test
    void solveDiscriminantLessThanZero() {
        SolveRequest request = new SolveRequest(12.0, 3.0, 4.0);

        NegativeDiscriminantWSException exception =
                assertThrows(NegativeDiscriminantWSException.class, () -> service.solve(request));

        assertEquals("12.0x^2+3.0x+4.0=0", exception.getFormula());
        assertEquals(-183.0, exception.getD());
        assertEquals("Ошибка! Дискриминант меньше нуля", exception.getErrorMessage());
    }

    @Test
    void solveAIsZero() {
        SolveRequest request = new SolveRequest(0.0, 3.0, 4.0);

        NonQuadraticEquationWSException exception =
                assertThrows(NonQuadraticEquationWSException.class, () -> service.solve(request));

        assertEquals("3.0x+4.0=0", exception.getFormula());
        assertEquals("Ошибка! Это не квадратное уровнение. Параметр 'a' не должен быть 0", exception.getErrorMessage());
    }

    @Test
    void solveBIsZero() throws NegativeDiscriminantWSException, NonQuadraticEquationWSException {
        SolveRequest request = new SolveRequest(1.0, 0.0, -4.0);

        SolveResponse response = service.solve(request);

        assertEquals("1.0x^2-4.0=0", response.getFormula());
        assertEquals(16.0, response.getD());
        assertEquals(-2.0, response.getX1());
        assertEquals(2.0, response.getX2());
    }

    @Test
    void solveCIsZero() throws NegativeDiscriminantWSException, NonQuadraticEquationWSException {
        SolveRequest request = new SolveRequest(1.0, -4.0, 0.0);

        SolveResponse response = service.solve(request);

        assertEquals("1.0x^2-4.0x=0", response.getFormula());
        assertEquals(16.0, response.getD());
        assertEquals(0.0, response.getX1());
        assertEquals(4.0, response.getX2());
    }
}