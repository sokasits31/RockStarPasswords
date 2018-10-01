<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

<div class="container-fluid">
    <h2>All users: </h2>

    <c:choose>

        <c:when test = "${users[0].id > 0}">
            <table border="2" cellpadding="2">
                <tr>
                    <th>ID</th>
                    <th>Email</th>
                    <th>User Role</th>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Primary Support Flag</th>
                    <th>Secondary Support Flag</th>
                    <th>Password</th>
                </tr>

                <c:forEach var="user" items="${users}">
                    <tr>
                        <td>${user.id}</td>
                        <td>${user.emailAddress}</td>
                        <td>${user.userRole}</td>
                        <td>${user.firstName}</td>
                        <td>${user.lastName}</td>
                        <td>${user.primarySupport}</td>
                        <td>${user.secondarySupport}</td>
                        <td>${user.password}</td>
                    </tr>
                </c:forEach>
            </table>
        </c:when>

        <c:otherwise>
            <H4>No User Data Found....   Go back and try again</H4>
        </c:otherwise>
    </c:choose>

</div>

</body>
</html>

