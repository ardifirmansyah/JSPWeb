/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;

/**
 *
 * @author ardifirmansyah
 */
public class Lowongan {

    private int idLowongan;
    private String kodeLowongan;
    private String deskripsiLowongan;
    private ArrayList<Pelamar> daftarPelamar;

    public Lowongan(int idLowongan, String kodeLowongan,
            String deskripsiLowongan) {
        this.idLowongan = idLowongan;
        this.kodeLowongan = kodeLowongan;
        this.deskripsiLowongan = deskripsiLowongan;
        daftarPelamar = new ArrayList();
    }

    public Lowongan() {
        
    }

    public Pelamar getPelamar(int idPelamar) {
        for (Pelamar p : daftarPelamar) {
            if (p.getIdPelamar()== idPelamar) {
                return p;
            }
        }
        return null;
    }

    public void addPelamar(Pelamar p) {
        daftarPelamar.add(p);
    }

    public void removePelamar(int idPelamar) {
        Pelamar p = getPelamar(idPelamar);
        daftarPelamar.remove(p);
    }

    public int getIdLowongan() {
        return idLowongan;
    }

    public void setIdLowongan(int idLowongan) {
        this.idLowongan = idLowongan;
    }

    public String getKodeLowongan() {
        return kodeLowongan;
    }

    public void setKodeLowongan(String kodeLowongan) {
        this.kodeLowongan = kodeLowongan;
    }

    public String getDeskripsiLowongan() {
        return deskripsiLowongan;
    }

    public void setDeskripsiLowongan(String deskripsiLowongan) {
        this.deskripsiLowongan = deskripsiLowongan;
    }
}
