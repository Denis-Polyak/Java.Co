package service;

public class FunctionService {
    private static FunctionService instance;

    private FunctionService() {}

    public static FunctionService getInstance() {
        if (instance == null) {
            instance = new FunctionService();
        }
        return instance;
    }

    public double calculateFunction(double x) {
        return Math.tan(x); // Змінити на функцію відповідно до варіанта
    }
}
