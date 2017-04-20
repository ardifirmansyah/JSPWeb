/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Handler;

import DAO.DAOPegawai;
import Model.Lowongan;
import Model.Pelamar;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ardifirmansyah
 */
public class HandlerPegawai extends HttpServlet {

    private static String INDEX = "/index.jsp";
    private static String tambahLowongan = "/tambahLowongan.jsp";
    private static String lihatLowongan = "/lihatLowongan.jsp";
    private static String editLowongan = "/editLowongan.jsp";

    private static String tambahPelamar = "/tambahPelamar.jsp";
    private static String lihatPelamar = "/lihatPelamar.jsp";
    private static String editPelamar = "/editPelamar.jsp";
    private DAOPegawai daoPegawai;

    private ArrayList<Lowongan> daftarLowongan;
    private ArrayList<Pelamar> daftarPelamar;

    public HandlerPegawai() throws SQLException {
        super();
        daoPegawai = new DAOPegawai();
        daftarPelamar = daoPegawai.getAllPelamar();
        daftarLowongan = daoPegawai.getAllLowongan();
    }

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        String redirect = "";
        String action = request.getParameter("action");
        if (action.equalsIgnoreCase("login")) {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            if (username.equals("admin") && password.equals("admin")) {
                redirect = INDEX;
            } else {
                Pelamar p = daoPegawai.getPelamarByUsername(username);
                if (p != null) {
                    if (password.equals(p.getPassword())) {
                        redirect = "HandlerPegawai?action=home";
                    }
                } else {
                    throw new IllegalArgumentException("Username atau password salah");
                }
            }
        }
        if (action == null || action.equalsIgnoreCase("home")) {
            redirect = INDEX;
        } else if (action.equalsIgnoreCase("tambahLowongan")) {
            redirect = tambahLowongan;
        } else if (action.equalsIgnoreCase("lihatLowongan")) {
            redirect = lihatLowongan;
            request.setAttribute("daftarLowongan", daoPegawai.getAllLowongan());
        } else if (action.equalsIgnoreCase("formEditLowongan")) {
            redirect = editLowongan;
        } else if (action.equalsIgnoreCase("editLow")) {
            String idLowongan = request.getParameter("idLowongan");
            System.out.println("Id lowongan : " + idLowongan);
            int idLow = Integer.parseInt(idLowongan);
            Lowongan lo = new Lowongan();
            lo.setIdLowongan(idLow);
            lo.setKodeLowongan(request.getParameter("kodeLowongan"));
            lo.setDeskripsiLowongan(request.getParameter("deskripsiLowongan"));
            daoPegawai.editLowongan(lo);
            request.setAttribute("lowongan", lo);
            redirect = lihatLowongan;
        } else if (action.equalsIgnoreCase("insertLowongan")) {
            Lowongan lo = new Lowongan();
            lo.setDeskripsiLowongan(request.getParameter("deskripsiLowongan"));
            lo.setKodeLowongan(request.getParameter("kodeLowongan"));
            daoPegawai.addLowongan(lo);
            redirect = lihatLowongan;
            System.out.println("Data lowongan berhasil ditambah");
        } else if (action.equalsIgnoreCase("deleteLowongan")) {
            String idLowongan = request.getParameter("idLowongan");
            int id = Integer.parseInt(idLowongan);
            daoPegawai.removeLowongan(id);
            redirect = lihatLowongan;
        } else if (action.equalsIgnoreCase("tambahPelamar")) {
            redirect = tambahPelamar;
        } else if (action.equalsIgnoreCase("insertPelamar")) {
            String username = request.getParameter("username");
            Pelamar p = daoPegawai.getPelamarByUsername(username);
            if (p != null) {
                throw new IllegalArgumentException("Username pelamar telah terpakai. Silahkan kembali ke halaman sebelumnya");
            } else {
                p = new Pelamar(request.getParameter("fullname"),
                        request.getParameter("email"),
                        request.getParameter("address"),
                        Integer.parseInt(request.getParameter("age")),
                        request.getParameter("username"),
                        request.getParameter("password"));
                daoPegawai.addPelamar(p);
                redirect = lihatPelamar;
            }
        } else if (action.equalsIgnoreCase("lihatPelamar")) {
            redirect = lihatPelamar;
        } else if (action.equalsIgnoreCase("formEditPelamar")) {
            redirect = editPelamar;
        } else if (action.equalsIgnoreCase("editPelamar")) {
            String idPelamar = request.getParameter("idPelamar");
            int idP = Integer.parseInt(idPelamar);
            Pelamar p = new Pelamar();
            p.setIdPelamar(idP);
            p.setNama(request.getParameter("fullname"));
            p.setUmur(Integer.parseInt(request.getParameter("age")));
            p.setEmail(request.getParameter("email"));
            p.setAlamat(request.getParameter("address"));
            daoPegawai.editPelamar(p);
            request.setAttribute("pelamar", p);
            redirect = lihatPelamar;
        } else if (action.equalsIgnoreCase("deletePelamar")) {
            String idPelamar = request.getParameter("idPelamar");
            int id = Integer.parseInt(idPelamar);
            daoPegawai.removePelamar(id);
            redirect = lihatPelamar;
        } else if (action.equalsIgnoreCase("penilaian")) {
            throw new IllegalArgumentException("Maaf, fitur ini belum tersedia.");
        }
        RequestDispatcher rd = request.getRequestDispatcher(redirect);
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
