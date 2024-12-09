<!DOCTYPE html>
<html>
<head>
    <title>Elapsed Time</title>
    <style>
        .popup {
            padding: 10px;
            border-radius: 5px;
            color: white;
        }
        .green {
            background-color: green;
        }
        .red {
            background-color: red;
        }
    </style>
</head>
<body>
<h2>Elapsed Time Result</h2>

<c:if test="${not empty error}">
    <p style="color: red;">${error}</p>
</c:if>

<c:if test="${not empty elapsedHours}">
    <div class="popup ${isElapsed9HoursOrMore ? 'green' : 'red'}">
        <p>Elapsed Time: ${elapsedHours} hours</p>
    </div>
</c:if>

<a href="/home">Go Back</a>
</body>
</html>