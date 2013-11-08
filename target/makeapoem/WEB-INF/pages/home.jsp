<%@ include file="/WEB-INF/pages/includes/header.jsp"%>

<html>
<body>
	<h1>Make A Poem</h1>

    <form name="input" action="/home" method="post">
        First line:
        <input type="text" name="first" />
        <input type="submit" value="Next" />
    </form>
</body>
</html>