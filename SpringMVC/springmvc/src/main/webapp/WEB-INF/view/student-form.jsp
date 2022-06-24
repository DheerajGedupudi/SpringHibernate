<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>

<html>

    <head>
        <title>Student Registration</title>
    </head>

    <body>

        <form:form action="processForm" modelAttribute="student">

            First name: <form:input path="firstName" />

            <br><br>

            Last Name: <form:input path="lastName" />

            <br><br>

            Country: <form:select path="country">
                <form:options items="${student.countryOptions}" />
            </form:select>

            <br><br>

            Programming Language Known :
            <br>

            Java<form:radiobutton path="programmingLanguage" value="Java" />
            C++<form:radiobutton path="programmingLanguage" value="C++" />
            Python<form:radiobutton path="programmingLanguage" value="Python" />
            JavaScript<form:radiobutton path="programmingLanguage" value="JavaScript" />

            <br><br>

            Speaking Languages:
            <br>

            English <form:checkbox path="regularLanguages" value="English" />
            Telugu <form:checkbox path="regularLanguages" value="Telugu" />
            Hindi <form:checkbox path="regularLanguages" value="Hindi" />

            <br><br>

            <input type="submit" value="Submit" />

        </form:form>

    </body>

</html>