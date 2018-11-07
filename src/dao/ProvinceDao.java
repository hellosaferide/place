package dao;

import db.DBUtil;
import entity.City;
import entity.Province;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProvinceDao {
    public ArrayList<Province> query() throws SQLException {

        Connection connection=DBUtil.getConnection();
        String sql="select * from tprovince";
        PreparedStatement ptmt=connection.prepareStatement(sql);
        ResultSet rs=ptmt.executeQuery();
        ArrayList<Province> list=new ArrayList<Province>();
        Province province=null;
        while (rs.next()){
            province=new Province();
            province.setProvinceCode(rs.getString("provinceCode"));
            province.setProvinceId(rs.getInt("provinceId"));
            province.setProvinceName(rs.getString("provinceName"));
            list.add(province);
        }

        return list;
    }
    public Province get(int id)throws SQLException{
        Connection connection=DBUtil.getConnection();
        String sql="select * from tprovince WHERE provinceId=?";
        PreparedStatement ptmt=connection.prepareStatement(sql);
        ptmt.setInt(1,id);
        ResultSet rs=ptmt.executeQuery();
        Province province=new Province();
        while (rs.next()){
            province.setProvinceCode(rs.getString("provinceCode"));
            province.setProvinceId(rs.getInt("provinceId"));
            province.setProvinceName(rs.getString("provinceName"));
        }
        return province;
    }
}
