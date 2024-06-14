<!DOCTYPE html>
<html>
<head>
    <title>Student Information Form</title>
</head>
<body>
    <h2>Student Information Form</h2>
    <form action="StudentServlet" method="post">
        <label for="name">Name:</label>
        <input type="text" id="name" name="name"><br><br>
        
        <label for="age">Age:</label>
        <input type="number" id="age" name="age"><br><br>
        
        <label for="grade">Grade:</label>
        <input type="text" id="grade" name="grade"><br><br>
        
        <input type="submit" value="Submit">
    </form>
</body>
</html>
