package controller;

import model.TabulationResult;
import service.FunctionService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/tabulate")
public class TabulateServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Отримання параметрів з форми
        double xStart = Double.parseDouble(request.getParameter("xStart"));
        double xEnd = Double.parseDouble(request.getParameter("xEnd"));
        double step = Double.parseDouble(request.getParameter("step"));

        // Список для збереження результатів табуляції
        List<TabulationResult> tabulation = new ArrayList<>();

        // Табулюємо функцію для всіх значень x від xStart до xEnd з кроком step
        for (double x = xStart; x <= xEnd; x += step) {
            double fx = calculateFunction(x);  // Обчислюємо f(x) для кожного x без накопичення
            tabulation.add(new TabulationResult(x, fx));
        }

        // Передача результатів у JSP для відображення
        request.setAttribute("tabulation", tabulation);
        request.getRequestDispatcher("/tabulation.jsp").forward(request, response);
    }

    // Функція для обчислення f(x)
    private double calculateFunction(double x) {
        // Приклад функції f(x) = x^2 (можна змінити на іншу функцію)
        return x * x;  // f(x) = x^2, змініть функцію за потребою
    }

    // Клас для зберігання результатів табуляції
    public static class TabulationResult {
        private double x;
        private double fx;

        public TabulationResult(double x, double fx) {
            this.x = x;
            this.fx = fx;
        }

        public double getX() {
            return x;
        }

        public double getFx() {
            return fx;
        }
    }
}


