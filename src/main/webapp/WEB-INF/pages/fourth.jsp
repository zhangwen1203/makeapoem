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
    <form name="input" action="/home/fourth" method="post">
        Fourth line:
        <input type="text" name="fourth" />
        <input type="submit" value="Submit" />
     </form>
</body>
</html>