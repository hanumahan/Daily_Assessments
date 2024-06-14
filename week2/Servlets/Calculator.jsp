<!DOCTYPE html>
<html>
<head>
    <title>Simple Calculator</title>
</head>
<body>
    <h2>Simple Calculator</h2>
    <form method="post">
        <label for="num1">Number 1:</label>
        <input type="text" id="num1" name="num1"><br><br>
        
        <label for="num2">Number 2:</label>
        <input type="text" id="num2" name="num2"><br><br>
        
        <input type="submit" name="operation" value="Add">
        <input type="submit" name="operation" value="Subtract">
        <input type="submit" name="operation" value="Multiply">
        <input type="submit" name="operation" value="Divide">
    </form>
    
    <%
        
        if (request.getMethod().equalsIgnoreCase("post")) {
            String operation = request.getParameter("operation");
            double num1 = Double.parseDouble(request.getParameter("num1"));
            double num2 = Double.parseDouble(request.getParameter("num2"));
            double result = 0.0;

            switch(operation) {
                case "Add":
                    result = num1 + num2;
                    break;
                case "Subtract":
                    result = num1 - num2;
                    break;
                case "Multiply":
                    result = num1 * num2;
                    break;
                case "Divide":
                    if (num2 != 0) {
                        result = num1 / num2;
                    } else {
                        out.println("<p style='color:red;'>Error: Division by zero!</p>");
                    }
                    break;
                default:
                    out.println("<p style='color:red;'>Error: Invalid operation!</p>");
            }

            out.println("<h3>Result:</h3>");
            out.println("<p>" + num1 + " " + operation + " " + num2 + " = " + result + "</p>");
        }
    %>
</body>
</html>
