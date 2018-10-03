
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ include file="/head-tag.jsp"%>
<body>
    <div id="container">
        <%@ include file="/header.jsp"%>

        <form action="/supportIT/grantAccess" method="get">

            <table>
                <tr>
                    <td>Email Address</td>
                    <td><input type="text" name="emailAddress"></td>
                </tr>
                <tr>
                    <td>Password</td>
                    <td><input type="text" name="password"></td>
                </tr>
            </table>
            <br>
            <input type="submit" name="submit" VALUE="Submit">


        </form>
        </p>



        <%@ include file="/footer.jsp"%>
    </div>
</body>
</html>