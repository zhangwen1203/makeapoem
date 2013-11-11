<%@ include file="/WEB-INF/pages/includes/header.jsp"%>

<html>

<body>
<h2>Make A Poem</h2>

<form:form method="POST" commandName="poem" action="/home">
    <form:errors path="*" cssClass="errorblock" element="div" />
    <table>
        <tr>
            <td>First Line :</td>
            <td><form:input path="newSentence" /></td>
            <td><form:errors path="newSentence" cssClass="error" /></td>
        </tr>
        <tr>
            <td colspan="3"><input type="submit" value="next"/></td>
        </tr>
    </table>
</form:form>

</body>
</html>