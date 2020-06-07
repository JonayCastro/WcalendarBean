<%@page import="beans.Calendario"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html lang="es">
	
	<head>
		<meta charset="ISO-8859-1">
		<link rel="stylesheet" href="styles/calendar-style.css"/>
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
		<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
		<script src="scripts/eventos.js"></script>
		<title>WCalendar</title>
	</head>
	
	<body>
		
		<jsp:useBean id="calendario" class="beans.Calendario" scope="session">
		
			<jsp:setProperty property="year" name="calendario" />
			<jsp:setProperty property="month" name="calendario"/>
			<jsp:setProperty property="today" name="calendario"/>
		
		</jsp:useBean>
		
		<c:set value="${calendario.getNameMonth() }" var="selectedMonth"/>
		<c:set value="${calendario.getMonthGrid() }" var="monthGrid"/>
		<c:set value="${calendario.getListOfMonth() }" var="listOfMonths"/>
		<c:set value="${calendario.getListOfDaysOfWeek() }" var="namesOfDays"/>
		<c:set value="${calendario.getToday() }" var="today"/>
		
		<header>
			<h2>WCalendar</h2>
		</header>
		
		<section id="principal">
		
		<div id="event-list" >
			<p id="event-list-title"></p>
			<button class="btn-new-events" id="new-btn-cls">Cerrar</button>
			<div id="event-list-new">
				<p id="event-list-title">Nuevo</p>
				<form action="MonthCtrl" method="get" id="form-new-event">
					<input type="text" name="event-name" placeholder="Nombre del evento"/>
					<input type="submit" class="btn-new-events" value="Crear evento"/>
				</form>
				<select id="event-type-select" name="evento-type" form="form-new-event">
					<option value="curso">Curso</option>
					<option value="reunion" selected>Reuni&oacute;n</option>
					<option value="puente">Puente</option>
					<option value="festivo">Festivo</option>
					<option value="otros">Otros</option>	
				</select>
				<textarea id="reason-area" rows="4" cols="30" form="form-new-event" name="reason" placeholder="Breve descripci&oacute;n del evento (opcional)" maxlength="120"></textarea>
				<p id="contador">0/120</p>
			</div>
			
			<div id="event-list-list">
				<p id="event-list-title">Creados</p>
			</div>
		</div>
		
		<div id="month-selector">
			<button class="btn">Meses</button>
			<div class="dropdown">
				<button class="btn" style="border-left:1px solid #0d8bf2">
					<i class="fa fa-caret-down"></i>
				</button>
				<div class="dropdown-content">
					<form action="MonthCtrl" method="get">
						<c:forEach items="${listOfMonths }" var="mes">
							<c:choose>
								<c:when test="${mes == selectedMonth }">
								    <input class="item" id="selected" type="submit" name="mes" value="${mes }"/>
								</c:when>
								<c:otherwise>
								    <input class="item" type="submit" name="mes" value="${mes }" />
								</c:otherwise>	
							</c:choose>
						</c:forEach>
					</form>
				</div>
			</div>
		</div>
		
		<table>
				<thead>
					<tr>
						<th colspan="7"><jsp:getProperty property="year" name="calendario"/></th>
					</tr>
					<tr>
						<th id="actualMonth-title" colspan="7">${selectedMonth }</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<c:forEach items="${namesOfDays }" var="dia">
							<c:choose>
								<c:when test="${dia == 'Sabado' || dia == 'Domingo'}">
									<th id="festivo">${dia }</th>
								</c:when>
								<c:otherwise>
									<th id="laboral">${dia }</th>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</tr>
					<c:forEach items="${monthGrid }" var="week">
						<tr>
							<c:forEach items="${week }" var="day" varStatus="index">
								<c:choose>
								<c:when test="${day != 0 }">
									<c:choose>
										<c:when test="${index.index < 5 }">
											<td id="dia-laboral"><c:out value="${day}"/></td>
										</c:when>
										<c:otherwise>
											<td id="dia-festivo"><c:out value="${day}"/></td>
										</c:otherwise>

									</c:choose>
									
								</c:when>
								<c:otherwise>
									<td id="vacio"><c:out value=""/></td>
								</c:otherwise>
								</c:choose>	
							</c:forEach>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</section>
		
		<footer>
			<address><a href="mailto:zeven8540@gmail.com">Jonay Zebensui Castro Su&aacute;rez</a></address>
		</footer>
		
	</body>
</html>