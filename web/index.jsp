<%@ page import="dao.CityDao" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="entity.City" %>
<%@ page import="dao.ProvinceDao" %>
<%@ page import="entity.Province" %>

<%--
  Created by IntelliJ IDEA.
  User: ddd
  Date: 2018/10/16
  Time: 23:07
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<%
    CityDao cityDao=new CityDao();
    ProvinceDao provinceDao=new ProvinceDao();
    ArrayList<Province> provinceArrayList=provinceDao.query();
    request.setAttribute("province",provinceArrayList);
%>
<html>
  <head>
    <title>地区查询</title>
    <script src="js/jquery-3.3.1.min.js" type="text/javascript"></script>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <script type="text/javascript" src="js/bootstrap.min.js"></script>
    <script type="text/javascript">
        $(function () {
            $("#province").change(function () {
                var provinceId=document.getElementById("province").value;
                var url="VerifyServlet?provinceId="+provinceId;
                var xhr=new XMLHttpRequest();
                xhr.open("GET",url);
                xhr.send(null);
                xhr.onreadystatechange=function () {
                    if(xhr.readyState==4){
                        if(xhr.status==200||xhr.status==304){
                            var result=xhr.responseText;
                            var json=JSON.parse(result);
                            //将市的数据渲染到前台
                            var city=$("#city");
                            city.empty();
                            for(var i=0;i<json.length;i++){
                                city.append("<option value="+json[i].cityId+">"+json[i].cityName+"</option>")
                            }
                        }
                    }
                }
            })


        })
    </script>
  </head>
  <body>
  <form action="success.jsp">
      <select name="province" id="province">
          <option value="0">==请选择省份==</option>
          <c:forEach var="provinceItem" items="${requestScope.province}">
              <option value="${provinceItem.provinceId}">${provinceItem.provinceName}</option>
          </c:forEach>
      </select>
      <select name="city" id="city">
          <option value="0">==请选择城市==</option>
      </select>
      <button type="submit">提交</button>
  </form>
  </body>
</html>
