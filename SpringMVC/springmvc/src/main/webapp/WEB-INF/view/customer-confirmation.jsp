<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>

<html>
    <head>
        <title>Customer Confirmation</title>
    </head>

    <body>
        The Customer is ${customer.firstName} ${customer.lastName}
        <br><br>

        Number is validated : ${customer.numberCheck}
        <br><br>

        Pin Code : ${customer.pinCode}

        <br><br>

        Course Code : ${customer.courseCode}
    </body>
</html>