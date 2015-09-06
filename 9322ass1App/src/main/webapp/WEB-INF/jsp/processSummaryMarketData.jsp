<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>9322ass1Client Application</title>
</head>
<body>
<h1>Called SummaryMarketData and Received the Following</h1>
The summaried data is as followed:<br/>
eventSetId: <b><c:out value="${eventSetId}"></c:out></b><br/>
sec: <b><c:out value="${sec}"></c:out></b><br/>
startDate: <b><c:out value="${startDate}"></c:out></b><br/>
endDate: <b><c:out value="${endDate}"></c:out></b><br/>
currencyCode: <b><c:out value="${currencyCode}"></c:out></b><br/>
numberOfLines: <b><c:out value="${numberOfLines}"></c:out></b><br/>
</body>
</html>