<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>Function Tabulation</title>
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
  <!-- Input Section -->
  <div class="input-section">
    <h2>Function Tabulation</h2>
    <form action="tabulate" method="post">
      <div class="form-group">
        <label for="xStart">Start Value (x₀):</label>
        <input type="number" id="xStart" name="xStart" step="any" required
               value="${param.xStart}">
      </div>
      <div class="form-group">
        <label for="xEnd">End Value (xₙ):</label>
        <input type="number" id="xEnd" name="xEnd" step="any" required
               value="${param.xEnd}">
      </div>
      <div class="form-group">
        <label for="step">Step (Δx):</label>
        <input type="number" id="step" name="step" step="any" required
               value="${param.step}">
      </div>
      <button type="submit">Tabulate</button>
    </form>

    <c:if test="${not empty error}">
      <div class="error">${error}</div>
    </c:if>
  </div>

  <!-- Results Section -->
  <div class="results-section">
    <h2>Results</h2>

    <c:if test="${not empty tabulation}">
      <table class="result-table">
        <thead>
        <tr>
          <th>x</th>
          <th>f(x)</th>
        </tr>
        </thead>
        <tbody>
        <!-- Iterate through the tabulation results -->
        <c:forEach var="result" items="${tabulation}">
          <tr>
            <td>${result.x}</td>
            <td>${result.fx}</td>
          </tr>
        </c:forEach>
        </tbody>
      </table>
    </c:if>
  </div>
</div>
</body>
</html>
