<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>

    <head>
        <title>Customer List</title>

        <!-- reference to css file -->

        <link type="text/css"
            rel="stylesheet"
            href="${pageContext.request.contextPath}/resources/css/style.css" />

    </head>

    <body>
        <div id="wrapper">
            <div id="header">
                <h2>Customer Relationship Manager</h2>
            </div>
        </div>

        <div id="container">
            <div id="content">

                <!-- adding customer button -->

                <input type="button" value="Add New"
                    onclick="window.location.href='showFormNewCustomer'; return false;"
                     class="add-button"
                />

                <!-- html table will be here -->

                <table>
                    <tr>
                        <th>First Name</th>
                        <th>Last Name</th>
                        <th>Email</th>
                        <th>Modify</th>
                    </tr>

                    <!-- Loop and Print -->

                    <c:forEach var="tempCustomer" items="${customers}">

                        <!-- getting link for updating -->
                        <c:url var="updateLink" value="/customer/showFormUpdateCustomer">
                            <c:param name="customerId" value="${tempCustomer.id}" />
                        </c:url>

                        <!-- getting link for deleting -->
                        <c:url var="deleteLink" value="/customer/deleteCustomer">
                            <c:param name="customerId" value="${tempCustomer.id}" />
                        </c:url>

                        <tr>
                            <td> ${tempCustomer.firstName} </td>
                            <td> ${tempCustomer.lastName} </td>
                            <td> ${tempCustomer.email} </td>
                            <td>
                                <!-- display link for updating -->
                                <a href="${updateLink}">Change</a>
                                |
                                <a href="${deleteLink}"
                                onclick="if(!(confirm('Do you really want to delete this customer?'))) return false">Remove</a>
                            </td>

                        </tr>

                    </c:forEach>

                </table>

            </div>
        </div>
    </body>
</html>