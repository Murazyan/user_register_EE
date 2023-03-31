<%@ page import="com.example.user_register_ee.models.User" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Home</title>
</head>
<body>
<h1><%= "User Registration Application: user page" %>
</h1>
<br/>
<%--<a href="/hello-servlet">Hello Servlet</a>--%>
<%User currentUser = (User) request.getSession().getAttribute("currentUser");%>
<p><%=currentUser.getName() + " " + currentUser.getSurname()%>
</p>
<form action="/log-out" method="post">
    <input type="submit" value="LogOut">
</form>
<p>
    Avatar:
<form action="upload-avatar" method="post" enctype="multipart/form-data">
    <label for="reg_image">Image :</label> <input id="reg_image" name="file" type="file"><br>
    <input type="submit" value="Upload">

</form>

<%String avatar = ((User) request.getSession().getAttribute("currentUser")).getAvatar();%>
<img src="/avatar?img=<%=avatar%>">
</p>
</body>
</html>