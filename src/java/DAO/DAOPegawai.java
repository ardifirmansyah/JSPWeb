/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DBConnection.ConnectionConfig;
import Model.Lowongan;
import Model.Pelamar;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author ardifirmansyah
 */
public class DAOPegawai {

    private Connection conn;

    public DAOPegawai() throws SQLException {
        conn = ConnectionConfig.getConnection();
        if (conn != null) {
            System.out.println("Koneksi berhasil");
        }
    }

    public void addLowongan(Lowongan lo) {
        try {
            String query = "insert into lowongan (kodeLowongan, deskripsiLowongan) values "
                    + "(?, ?)";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, lo.getKodeLowongan());
            statement.setString(2, lo.getDeskripsiLowongan());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList getAllPelamar() {
        ArrayList daftarPelamar = new ArrayList();
        try {
            String sql = "select * from pelamar";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Pelamar p = new Pelamar(rs.getString("fullname"),
                        rs.getString("email"), rs.getString("alamat"),
                        rs.getInt("umur"), rs.getString("username"),
                        rs.getString("password"));
                p.setIdPelamar(rs.getInt("idPelamar"));
                daftarPelamar.add(p);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return daftarPelamar;
    }

    public ArrayList getAllLowongan() {
        ArrayList daftarLowongan = new ArrayList();
        try {
            String sql = "select * from lowongan";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Lowongan lo = new Lowongan();
                lo.setIdLowongan(rs.getInt("idLowongan"));
                lo.setKodeLowongan(rs.getString("kodeLowongan"));
                lo.setDeskripsiLowongan(rs.getString("deskripsiLowongan"));
                daftarLowongan.add(lo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return daftarLowongan;
    }
    
    public void editPelamar(Pelamar p) {
        try {
            String sql = "update pelamar set fullname=?, umur=?, email=?, alamat=?"
                    + " where idPelamar=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(5, p.getIdPelamar());
            ps.setString(1, p.getNama());
            ps.setInt(2, p.getUmur());
            ps.setString(3, p.getEmail());
            ps.setString(4, p.getAlamat());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void editLowongan(Lowongan lo) {
        try {
            String sql = "update lowongan set kodeLowongan=?, deskripsiLowongan=?"
                    + " where idLowongan=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(3, lo.getIdLowongan());
            ps.setString(1, lo.getKodeLowongan());
            ps.setString(2, lo.getDeskripsiLowongan());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Lowongan getLowonganById(int idLowongan) {
        Lowongan lo = new Lowongan();
        try {
            String sql = "select * from lowongan where idLowongan=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, idLowongan);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                lo.setIdLowongan(rs.getInt("idLowongan"));
                lo.setKodeLowongan(rs.getString("kodeLowongan"));
                lo.setDeskripsiLowongan(rs.getString("deskripsiLowongan"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lo;
    }
    
    public Pelamar getPelamarById(int idPelamar) {
        Pelamar p = new Pelamar();
        try {
            String sql = "select * from pelamar where idPelamar=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, idPelamar);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                p.setIdPelamar(rs.getInt("idPelamar"));
                p.setUsername(rs.getString("username"));
                p.setPassword(rs.getString("password"));
                p.setNama(rs.getString("fullname"));
                p.setUmur(rs.getInt("umur"));
                p.setEmail(rs.getString("email"));
                p.setAlamat(rs.getString("alamat"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return p;
    }
    
    public Pelamar getPelamarByUsername(String username) {
        Pelamar p = null;
        try {
            String sql = "select * from pelamar where username=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                p = new Pelamar();
                p.setIdPelamar(rs.getInt("idPelamar"));
                p.setUsername(rs.getString("username"));
                p.setPassword(rs.getString("password"));
                p.setNama(rs.getString("fullname"));
                p.setUmur(rs.getInt("umur"));
                p.setEmail(rs.getString("email"));
                p.setAlamat(rs.getString("alamat"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return p;
    }

    public void removeLowongan(int idLowongan) {
        try {
            String sql = "delete from lowongan where idLowongan=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, idLowongan);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addPelamar(Pelamar p) {
        try {
            String query = "insert into pelamar (username, password, fullname, "
                    + "umur, email, alamat) values "
                    + "(?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, p.getUsername());
            statement.setString(2, p.getPassword());
            statement.setString(3, p.getNama());
            statement.setInt(4, p.getUmur());
            statement.setString(5, p.getEmail());
            statement.setString(6, p.getAlamat());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removePelamar(int id) {
        try {
            String sql = "delete from pelamar where idPelamar=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
