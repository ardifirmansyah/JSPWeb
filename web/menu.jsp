<%-- 
    Document   : menu
    Created on : Apr 20, 2017, 1:46:06 PM
    Author     : ardifirmansyah
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <body>
        <!-- sidebar: style can be found in sidebar.less -->
        <section class="sidebar">
            <!-- Sidebar user panel -->
            <div class="user-panel">
                <div class="pull-left image">
                    <img src="dist/img/user.png" class="img-circle" alt="User Image">
                </div>
                <div class="pull-left info">
                    <p>ADMIN</p>
                </div>
            </div>
            <!-- sidebar menu: : style can be found in sidebar.less -->
            <ul class="sidebar-menu">
                <li class="header">MAIN NAVIGATION</li>
                <li>
                    <a href="HandlerPegawai?action=home">
                        <i class="fa fa-dashboard"></i> <span>Dashboard</span>
                    </a>
                </li>
                <li>
                    <a href="#">
                        <i class="fa fa-briefcase"></i> <span>Lowongan</span>
                        <span class="pull-right-container">
                            <i class="fa fa-angle-left pull-right"></i>
                        </span>
                    </a>
                    <ul class="treeview-menu">
                        <li><a href="HandlerPegawai?action=tambahLowongan">
                                <i class="fa fa-circle-o"></i> Tambah Lowongan</a></li>
                        <li><a href="HandlerPegawai?action=lihatLowongan">
                                <i class="fa fa-circle-o"></i> Lihat Lowongan</a></li>
                    </ul>
                </li>
                <li>
                    <a href="#">
                        <i class="fa fa-users"></i> <span>Pelamar</span>
                        <span class="pull-right-container">
                            <i class="fa fa-angle-left pull-right"></i>
                        </span>
                    </a>
                    <ul class="treeview-menu">
                        <li><a href="HandlerPegawai?action=tambahPelamar">
                                <i class="fa fa-circle-o"></i> Tambah Pelamar</a></li>
                        <li><a href="HandlerPegawai?action=lihatPelamar">
                                <i class="fa fa-circle-o"></i> Lihat Pelamar</a></li>
                    </ul>
                </li>
                <li>
                    <a href="HandlerPegawai?action=penilaian">
                        <i class="fa fa-balance-scale"></i> <span>Penilaian</span>
                    </a>
                </li>
            </ul>
        </section>
        <!-- /.sidebar -->
    </body>
</html>
