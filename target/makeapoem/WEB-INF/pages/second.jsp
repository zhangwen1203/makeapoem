<%@ include file="/WEB-INF/pages/includes/header.jsp"%>
<html>
<body>
<h1>Make A Poem</h1>

<c:forEach var="sentence" items="${sentences}">
    <tr>
        <td><c:out value="${sentence}"></c:out></td>
        <p></p>
    </tr>
</c:forEach>
<form name="input" action="/home/second" method="post">
    Second line:
    <input type="text" name="second" />
    <input type="submit" value="Next" />
</form>
</body>
</html>