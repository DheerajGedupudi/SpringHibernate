<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>

<html>

    <head>
        <title>Student Confirmation</title>

    </head>

    <body>

        The Student is confirmed : ${student.firstName} ${student.lastName}

        <br><br>

        Country : ${student.country}

        <br><br>

        Programming Language : ${student.programmingLanguage}

        <br><br>

        Regular Languages :

        <ul>
            <c:forEach var="temp" items="${student.regularLanguages}">
                <li> ${temp} </li>
            </c:forEach>
        </ul>

    </body>

</html>