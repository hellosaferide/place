package servlet;

import dao.CityDao;
import dao.ProvinceDao;
import entity.City;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import com.google.gson.*;

public class VerifyServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String sid=request.getParameter("provinceId");
        int provinceId=Integer.parseInt(sid);
        ArrayList<City> cityList;
        CityDao cityDao=new CityDao();
        try {
            cityList=cityDao.getByprovinceId(provinceId);
            Gson gson=new Gson();
            String result=gson.toJson(cityList);
            response.setCharacterEncoding("utf-8");
            response.getWriter().println(result);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
