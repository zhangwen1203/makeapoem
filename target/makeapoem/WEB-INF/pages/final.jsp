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
<form name="input" action="/home/final" method="post">
    <input type="submit" value="New Poem" />
</form>
</body>
</html>