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
public class Pelamar extends User {
    
    private int idPelamar;
    private String username;
    private String password;

    private ArrayList<String> daftarFile;

    public Pelamar() {
        
    }
    
    public Pelamar(String nama, String email, String alamat, int umur) {
        super(nama, email, alamat, umur);
    }

    public Pelamar(String nama, String email, String alamat, int umur, 
            String username, String password) {
        super(nama, email, alamat, umur);
        this.username = username;
        this.password = password;
        daftarFile = new ArrayList();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ArrayList<String> getDaftarFile() {
        return daftarFile;
    }

    public void setDaftarFile(ArrayList<String> daftarFile) {
        this.daftarFile = daftarFile;
    }

    public int getIdPelamar() {
        return idPelamar;
    }

    public void setIdPelamar(int idPelamar) {
        this.idPelamar = idPelamar;
    }
}
