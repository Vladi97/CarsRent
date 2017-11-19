/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Util.Conexion;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

/**
 *
 * @author vmata
 */
public class Car {
    private int id;
    private String license_plate;
    private int brand;
    private int model;
    private int style;
    private String transmission;
    private int age;
    private double price;
    //private photo;
    private boolean state;

    public Car() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLicense_plate() {
        return license_plate;
    }

    public void setLicense_plate(String license_plate) {
        this.license_plate = license_plate;
    }

    public int getBrand() {
        return brand;
    }

    public void setBrand(int brand) {
        this.brand = brand;
    }

    public int getModel() {
        return model;
    }

    public void setModel(int model) {
        this.model = model;
    }

    public int getStyle() {
        return style;
    }

    public void setStyle(int style) {
        this.style = style;
    }

    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }
    
    /**
     * 
     * @returns a boolean value to know if it really added the car or is something failed
     * @throws Exception 
     */
    public boolean add() throws Exception {
        try (Connection con = Conexion.conexion()) {
            String sql = "insert into car(license_plate, brand, model, style, transmission,"
                    + "age, price, photo, state) values (?,?,?,?,?,?,?,?,?);";
            PreparedStatement smt = con.prepareStatement(sql);
            smt.setString(1, this.getLicense_plate());
            smt.setInt(2, this.getBrand());
            smt.setInt(3, this.getModel());
            smt.setInt(4, this.getStyle());
            smt.setString(5, this.getTransmission());
            smt.setInt(6, this.getAge());
            smt.setDouble(7, this.getPrice());
            //smt.setInt(8, this.getPhoto);
            smt.setBoolean(9, this.isState());
            return smt.executeUpdate() > 0;
        } catch (Exception ex) {
            throw ex;
        }
    }

    /**
     * 
     * @returns a list with all the cars
     */
    public LinkedList<Model.Car> select() {
        LinkedList<Model.Car> cars = new LinkedList<>();
        try (Connection con = Conexion.conexion()) {
            String sql = "select * from car;";
            PreparedStatement smt = con.prepareStatement(sql);
            ResultSet rs = smt.executeQuery();
            while (rs.next()) {
                cars.add(load(rs));
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return cars;
    }

    /**
     * 
     * @returns a boolean value to know if it really deleted the car or is something failed
     */
    public boolean delete() {
        try (Connection con = Conexion.conexion()) {
            String sql = "delete from car where id = ?;";
            PreparedStatement smt = con.prepareStatement(sql);
            smt.setInt(1, this.getId());
            return smt.executeUpdate() > 0;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }

    /**
     * 
     * @param rs (is the result got from the database)
     * @returns a Car object with its data
     * @throws SQLException 
     */
    private Model.Car load(ResultSet rs) throws SQLException {
        Model.Car m = new Model.Car();
        m.setId(rs.getInt("id"));
        m.setLicense_plate(rs.getString("license_plate"));
        m.setBrand(rs.getInt("brand"));
        m.setModel(rs.getInt("model"));
        m.setStyle(rs.getInt("style"));
        m.setTransmission(rs.getString("transmission"));
        m.setAge(rs.getInt("age"));
        m.setPrice(rs.getDouble("price"));
        //m.setPhoto(rs.getInt("photo"));
        m.setState(rs.getBoolean("state"));
        return m;
    }

    /**
     * 
     * @returns a boolean value to know if it really updated the car or is something failed
     * @throws Exception 
     */
    public boolean update() throws Exception {
        try (Connection con = Conexion.conexion()) {
            String sql = "UPDATE car SET license_plate=?, brand = ?, model = ?, "
                    + "style = ?, transmission = ?, age = ?, price = ?, photo = ?, state = ?, "
                    + "WHERE id = ?";
            PreparedStatement smt = con.prepareStatement(sql);
            smt.setString(1, this.getLicense_plate());
            smt.setInt(2, this.getBrand());
            smt.setInt(3, this.getModel());
            smt.setInt(4, this.getStyle());
            smt.setString(5, this.getTransmission());
            smt.setInt(6, this.getAge());
            smt.setDouble(7, this.getPrice());
            //smt.setInt(8, this.getPhoto);
            smt.setBoolean(9, this.isState());
            smt.setInt(10, this.getId());
            return smt.executeUpdate() > 0;
        } catch (Exception ex) {
            throw ex;
        }
    }
}
