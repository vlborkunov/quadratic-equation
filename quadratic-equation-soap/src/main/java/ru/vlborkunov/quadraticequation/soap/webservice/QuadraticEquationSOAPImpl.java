package ru.vlborkunov.quadraticequation.soap.webservice;

import com.sun.xml.ws.developer.SchemaValidation;
import jakarta.jws.WebService;
import ru.vlborkunov.quadraticequation.soap.exception.NegativeDiscriminantWSException;
import ru.vlborkunov.quadraticequation.soap.exception.NonQuadraticEquationWSException;
import ru.vlborkunov.quadraticequation.soap.webservice.dto.SolveRequest;
import ru.vlborkunov.quadraticequation.soap.webservice.dto.SolveResponse;

import java.math.BigDecimal;

/**
 * Реализация SOAP интерфейса для управления квадратным уравнением
 */
@WebService(endpointInterface = "ru.vlborkunov.quadraticequation.soap.webservice.QuadraticEquationSOAP")
@SchemaValidation(handler = ValidatorSOAP.class)
public class QuadraticEquationSOAPImpl implements QuadraticEquationSOAP {
    /**
     * Метод по решению квадратного уравнения по его параметрам вида:
     * ax^2+bx+c=0
     *
     * @param solveRequest - параметры в запросе - a,b,c
     * @return - дискриминант и корни уровнения, если корень один, второй не
     * возвращается
     * @throws NegativeDiscriminantWSException - при отрицательном дискриминанте
     * @throws NonQuadraticEquationWSException - при a=0, тогда уравнение не квадратное
     */
    @Override
    public SolveResponse solve(SolveRequest solveRequest)
            throws NegativeDiscriminantWSException, NonQuadraticEquationWSException {

        double a = solveRequest.getA();
        double b = solveRequest.getB();
        double c = solveRequest.getC();
        String formula = formulaPrepare(a, b, c);

        if (Math.abs(a) < 2 * Double.MIN_VALUE) {
            throw new NonQuadraticEquationWSException(
                    "Ошибка! Это не квадратное уровнение. Параметр 'a' не должен быть 0",
                    formula
            );
        }

        BigDecimal discriminant = discriminantCalc(a, b, c);
        if (discriminant.signum() < 0) {
            throw new NegativeDiscriminantWSException(
                    "Ошибка! Дискриминант меньше нуля",
                    formula,
                    discriminant.doubleValue()
            );
        }

        if (discriminant.equals(BigDecimal.ZERO)) {
            return new SolveResponse(
                    formula,
                    discriminant.doubleValue(),
                    x1Calc(a, b)
            );
        } else {
            return new SolveResponse(
                    formula,
                    discriminant.doubleValue(),
                    x1Calc(a, b, discriminant.doubleValue()),
                    x2Calc(a, b, discriminant.doubleValue())
            );
        }

    }

    private Double x1Calc(double a, double b, double d) {
        return (-b - Math.sqrt(d)) / (2 * a);
    }

    private Double x1Calc(double a, double b) {
        return -b / (2 * a);
    }

    private Double x2Calc(double a, double b, double d) {
        return (-b + Math.sqrt(d)) / (2 * a);
    }

    private String formulaPrepare(double a, double b, double c) {
        StringBuilder builder = new StringBuilder();
        if (Math.abs(a) > 2 * Double.MIN_VALUE) {
            builder.append(a);
            builder.append("x^2");
        }

        if (Math.abs(b) > 2 * Double.MIN_VALUE) {
            if (b > 0 && builder.length() > 0) {
                builder.append("+");
            }
            builder.append(b);
            builder.append("x");
        }

        if (Math.abs(c) > 2 * Double.MIN_VALUE) {
            if (c > 0 && builder.length() > 0) {
                builder.append("+");
            }
            builder.append(c);
        }
        builder.append("=0");
        return builder.toString();
    }

    private BigDecimal discriminantCalc(double a, double b, double c) {
        return new BigDecimal(b * b - 4 * a * c);
    }
}