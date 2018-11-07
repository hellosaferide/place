package dao;

import db.DBUtil;
import entity.City;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CityDao {
    //查询所有的城市
    public ArrayList<City> query()throws SQLException {

        Connection connection=DBUtil.getConnection();
        String sql="select * from tcity";
        PreparedStatement ptmt=connection.prepareStatement(sql);
        ResultSet rs=ptmt.executeQuery();
        ArrayList<City> list=new ArrayList<City>();
        City city=null;
        while (rs.next()){
            city=new City();
            city.setCityCode(rs.getString("cityCode"));
            city.setCityId(rs.getInt("cityId"));
            city.setProvinceId(rs.getInt("provinceId"));
            city.setCityName(rs.getString("cityName"));
            list.add(city);
        }


        return list;
    }
    //根据id获取城市
    public City get(int id)throws SQLException{
        Connection connection=DBUtil.getConnection();
        String sql="select * from tcity where cityId=?";
        PreparedStatement ptmt=connection.prepareStatement(sql);
        ptmt.setInt(1,id);
        ResultSet rs=ptmt.executeQuery();
        City city=new City();
        while(rs.next()){
            city.setCityCode(rs.getString("cityCode"));
            city.setCityId(rs.getInt("cityId"));
            city.setProvinceId(rs.getInt("provinceId"));
            city.setCityName(rs.getString("cityName"));
        }
        return city;
    }
    //根据provinceId获取该省的所有的城市
    public ArrayList<City> getByprovinceId(int provinceId)throws SQLException{
        Connection connection=DBUtil.getConnection();
        String sql="select * from tcity where provinceId=?";
        PreparedStatement ptmt=connection.prepareStatement(sql);
        ptmt.setInt(1,provinceId);
        ResultSet rs=ptmt.executeQuery();
        ArrayList<City> list=new ArrayList<City>();
        City city=null;
        while (rs.next()){
            city=new City();
            city.setCityCode(rs.getString("cityCode"));
            city.setCityId(rs.getInt("cityId"));
            city.setProvinceId(provinceId);
            city.setCityName(rs.getString("cityName"));
            list.add(city);
        }
        return list;
    }
}
