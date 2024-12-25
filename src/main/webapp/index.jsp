<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Series Calculator</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            max-width: 1000px;
            margin: 0 auto;
            padding: 20px;
            background-color: #f5f5f5;
        }
        .container {
            display: grid;
            grid-template-columns: 1fr 1fr;
            gap: 20px;
        }
        .input-section, .results-section {
            background-color: white;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 2px 4px rgba(0,0,0,0.1);
        }
        .form-group {
            margin-bottom: 15px;
        }
        label {
            display: block;
            margin-bottom: 5px;
            font-weight: bold;
        }
        input[type="number"] {
            width: 100%;
            padding: 8px;
            border: 1px solid #ddd;
            border-radius: 4px;
        }
        button {
            background-color: #4CAF50;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            width: 100%;
        }
        button:hover {
            background-color: #45a049;
        }
        .result-table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }
        .result-table th, .result-table td {
            padding: 12px;
            border: 1px solid #ddd;
            text-align: left;
        }
        .result-table th {
            background-color: #4CAF50;
            color: white;
        }
        .error {
            color: red;
            padding: 10px;
            margin: 10px 0;
            border: 1px solid red;
            border-radius: 4px;
            background-color: #fee;
        }
        @media (max-width: 768px) {
            .container {
                grid-template-columns: 1fr;
            }
        }
    </style>
</head>
<body>
<div class="container">
    <div class="input-section">
        <h2>Input Parameters</h2>
        <form action="calculate" method="post">
            <div class="form-group">
                <label for="x">Value (x):</label>
                <input type="number" id="x" name="x" step="any" required
                       value="${param.x}">
            </div>
            <div class="form-group">
                <label for="n">Number of terms (n):</label>
                <input type="number" id="n" name="n" required
                       value="${param.n}">
            </div>
            <div class="form-group">
                <label for="epsilon1">Epsilon 1:</label>
                <input type="number" id="epsilon1" name="epsilon1" step="0.0001" required
                       value="${param.epsilon1}">
            </div>
            <button type="submit">Calculate</button>
        </form>

        <c:if test="${not empty error}">
            <div class="error">${error}</div>
        </c:if>
    </div>

    <div class="results-section">
        <h2>Results</h2>
        <c:if test="${not empty calculation}">
            <table class="result-table">
                <tr>
                    <th>Parameter</th>
                    <th>Value</th>
                </tr>
                <tr>
                    <td>Sum of n terms</td>
                    <td>${calculation.sum}</td>
                </tr>
                <tr>
                    <td>Sum with ε1</td>
                    <td>${sumEpsilon1}</td>
                </tr>
                <tr>
                    <td>Sum with ε2</td>
                    <td>${sumEpsilon2}</td>
                </tr>
                <tr>
                    <td>Exact Value</td>
                    <td>${calculation.exactValue}</td>
                </tr>
            </table>
        </c:if>
    </div>
</div>
</body>
</html>