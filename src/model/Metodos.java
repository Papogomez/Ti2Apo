package model;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Metodos{

    private Conectar conectar;
    private Ciudad ciudad;
    private Connection con;


    private Pais pais;

    public Metodos(){
        ciudad = new Ciudad();
        pais = new Pais();
        conectar = new Conectar();
    }

    public void insertarCiudades(String id, String name, double population, String countryID){
        PreparedStatement ps;
        String sql;
        ciudad.setId(id);
        ciudad.setName(name);
        ciudad.setPopulation(population);
        ciudad.setCountryID(countryID);
        try{
            con = conectar.getConexion();
            sql = "insert into datos(id, name, population, countryId) values(?,?,?)";
            ps = con.prepareStatement(sql);
            ps.setString(1,ciudad.getId());
            ps.setString(2, ciudad.getName());
            ps.setDouble(3, ciudad.getPopulation());
            ps.setString(4,ciudad.getCountryID());
            ps.executeUpdate();
            con.close();
            JOptionPane.showMessageDialog(null, "Se han insertado los datos");
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error de conexión:" + e.getMessage());
        }
    }


    public void insertarPaises(Pais pais){
        PreparedStatement ps;
        String sql;
        pais.setId(pais.getId());
        pais.setName(pais.getName());
        pais.setPopulation(pais.getPopulation());
        pais.setCountryCode(pais.getCountryCode());
        try{
            con = conectar.getConexion();
            sql = "insert into geografica.countries(id, name, population, countrycode) values(?,?,?,?)";
            ps = con.prepareStatement(sql);
            ps.setString(1,pais.getId());
            ps.setString(2, pais.getName());
            ps.setDouble(3, pais.getPopulation());
            ps.setString(4,pais.getCountryCode());
            ps.executeUpdate();
            con.close();
            JOptionPane.showMessageDialog(null, "Se han insertado los datos");
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error de conexión:" + e.getMessage());
        }
    }

    public String getUUID(){
        String out = "";
        Connection connect;
        connect = conectar.getConexion();
        try {
            PreparedStatement pstmt = connect.prepareStatement("select uuid() as uid;");
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                    out = rs.getString(1);
            }
        }catch (SQLException ex){
            System.out.println("Error al obtener el UUID: " + ex.getMessage());
        }
        return out;
    }



}
