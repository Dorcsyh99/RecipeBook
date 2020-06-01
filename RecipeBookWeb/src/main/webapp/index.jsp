<%@ page import="hu.alkfejl.model.Recept" %>
<%@ page import="java.util.List" %>
<%@ page import="hu.alkfejl.controller.ReceptController" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<link href="web-style.css" rel="stylesheet" type="text/css"/>
<%
    List<Recept> receptek = ReceptController.getInstance().Osszes();
%>

<body>
<div>
    <h1>Receptek</h1>
</div>
<div class="card-container">
    <div class="recipe-card">
        <h4><%=receptek.get(0).getNev()%></h4>
        <p><%=receptek.get(0).getNehezseg()%></p>
        <p><%=receptek.get(0).getIdotartam()%> perc</p>
        <p><%=receptek.get(0).getFo()%> főre</p>
        <p><%=receptek.get(0).getKategoria()%></p>
        <p>Hozzávalók:
        <p><%=receptek.get(0).getAlapanyagok()%></p>
        </p>
        <p>Leírás:
        <p><%=receptek.get(0).getLeiras()%></p>
        </p>
    </div>
    <div class="recipe-card">
        <h4><%=receptek.get(0).getNev()%></h4>
        <p><%=receptek.get(0).getNehezseg()%></p>
        <p><%=receptek.get(0).getIdotartam()%> perc</p>
        <p><%=receptek.get(0).getFo()%> főre</p>
        <p><%=receptek.get(0).getKategoria()%></p>
        <p>Hozzávalók:
        <p><%=receptek.get(0).getAlapanyagok()%></p>
        </p>
        <p>Leírás:
        <p><%=receptek.get(0).getLeiras()%></p>
        </p>
    </div>
</div>
</body>
</html>
