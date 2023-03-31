<%@ page import="com.example.user_register_ee.models.User" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head lang="en">
    <title>Home</title>
</head>
<body>


<% if ((User)request.getSession().getAttribute("currentUser")!=null) { %>
   <% response.sendRedirect("/user-home");%>
<% } else { %>
<h1><%= "User Registration Application: home page" %>
</h1>
<br/>
<div class="registration">
    <p>Registration</p>
    <form action="register" method="post">
        <label for="reg_name">Name :</label> <input id="reg_name" name="name" type="text" placeholder="User name"> <br>
        <label for="reg_surname">Surname :</label> <input id="reg_surname" name="surname" type="text"><br>
        <label for="reg_birth_date">Birth Date :</label> <input id="reg_birth_date" name="birth_date" type="date"><br>
        <label  for="reg_gender"> Gender: </label>
        <select name="gender" id="reg_gender">
            <option value="MALE">Male</option>
            <option value="FEMALE">Female</option>
            <option value="OTHER">Other</option>
        </select> <br>

        <label for="reg_email">Email :</label> <input id="reg_email" name="email" type="email"><br>
        <label for="reg_password">Password :</label> <input id="reg_password" name="password" type="password"><br>
<%--        <label for="reg_image">Image :</label> <input id="reg_image" name="file" type="file"><br>--%>
        <p>${regErrorUserExists}</p>
        <input type="submit" value="Register">

    </form>

</div>

<div class="login">
    <p>Login</p>
    <form action="/login" method="post">
        <label for="login_email">Email :</label> <input id="login_email" name="email" type="text" placeholder="User name"> <br>
        <label for="login_password">Password :</label> <input id="login_password" name="password" type="password"><br>
        <p STYLE="color: red">${loginError}</p>
        <input type="submit" value="Login">
    </form>

</div>
<% } %>

</body>
</html>