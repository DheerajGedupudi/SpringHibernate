<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
    <head>
        <title>Customer Registration</title>

        <style>
            .error{color:red}
        </style>
    </head>

    <body>

    <i>Fill the form.</i>
    <br><br>

        <form:form action="processForm" modelAttribute="customer">
            First Name : <form:input path="firstName" />
            <br><br>

            Last Name* : <form:input path="lastName" />
            <form:errors path="lastName" cssClass="error" />
            <br><br>

            Number Check* : <form:input path="numberCheck" />
            <form:errors path="numberCheck" cssClass="errors" />
            <br><br>

            Pin Code : <form:input path="pinCode" />
            <form:errors path="pinCode" cssClass="errors" />
            <br><br>

            Course Code : <form:input path="courseCode" />
            <form:errors path="courseCode" cssClass="errors" />
            <br><br>

            <input type="submit" value="Submit" />
        </form:form>
    </body>
</html>