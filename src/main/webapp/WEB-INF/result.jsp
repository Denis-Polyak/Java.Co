<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calculation Results</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 20px; }
        .result-group { margin: 15px 0; }
    </style>
</head>
<body>
<h2>Calculation Results</h2>

<div class="result-group">
    <h3>Sum of ${calculation.n} terms:</h3>
    <p>${calculation.sum}</p>
</div>

<div class="result-group">
    <h3>Sum of terms above epsilon1 (${calculation.epsilon}):</h3>
    <p>${sumEpsilon1}</p>
</div>

<div class="result-group">
    <h3>Sum of terms above epsilon2 (${calculation.epsilon * 0.1}):</h3>
    <p>${sumEpsilon2}</p>
</div>

<div class="result-group">
    <h3>Exact value of ln(1 + ${calculation.x}):</h3>
    <p>${calculation.exactValue}</p>
</div>

<a href="../index.jsp">Calculate Again</a>
</body>
</html>