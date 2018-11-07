<%@ page import="dao.ProvinceDao" %>
<%@ page import="dao.CityDao" %>
<%@ page import="entity.Province" %>
<%@ page import="entity.City" %><%--
  Created by IntelliJ IDEA.
  User: ddd
  Date: 2018/10/17
  Time: 14:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String sprovince=request.getParameter("province");
    String scity=request.getParameter("city");
    int provinceId=Integer.parseInt(sprovince);
    int cityId=Integer.parseInt(scity);
    ProvinceDao provinceDao=new ProvinceDao();
    CityDao cityDao=new CityDao();
    Province province=provinceDao.get(provinceId);
    City city=cityDao.get(cityId);
%>
<html>
<head>
    <title>查询结果</title>
</head>
<body>
    省份:<%=province.getProvinceName()%>
    <br>
    城市:<%=city.getCityName()%>
</body>
</html>
