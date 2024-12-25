package controller;

import model.SeriesCalculation;
import service.CalculatorService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/calculate")
public class CalculatorServlet extends HttpServlet {
    private final CalculatorService calculatorService = CalculatorService.getInstance();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            double x = Double.parseDouble(request.getParameter("x"));
            int n = Integer.parseInt(request.getParameter("n"));
            double epsilon1 = Double.parseDouble(request.getParameter("epsilon1"));
            double epsilon2 = epsilon1 * 0.1;

            SeriesCalculation calc = new SeriesCalculation(x, n, epsilon1);
            calc.setSum(calculatorService.calculateNTermSum(x, n));
            double sum1 = calculatorService.calculateEpsilonSum(x, epsilon1, n);
            double sum2 = calculatorService.calculateEpsilonSum(x, epsilon2, n);
            calc.setExactValue(calculatorService.calculateExactValue(x));

            request.setAttribute("calculation", calc);
            request.setAttribute("sumEpsilon1", sum1);
            request.setAttribute("sumEpsilon2", sum2);

            request.getRequestDispatcher("/index.jsp").forward(request, response);

        } catch (NumberFormatException e) {
            request.setAttribute("error", "Invalid input parameters");
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        }
    }
}
