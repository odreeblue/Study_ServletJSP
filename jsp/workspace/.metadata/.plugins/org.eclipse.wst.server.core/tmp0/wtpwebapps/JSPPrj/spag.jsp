<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>


<%pageContext.setAttribute("aa", "hello"); %>
<!-- ----------------------------------------- -->
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%-- <%=request.getAttribute("result") %>입니다. --%>
	${result}입니다.<!-- EL --><br>
	
	${names[0]}<br>
	
	${notice.title}<br>
	
	${aa}<br>
	
	${param.n gt 3 }<br>
	
	${header.accept}
	
</body>
</html>