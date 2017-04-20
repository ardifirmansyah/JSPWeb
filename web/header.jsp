<%-- 
    Document   : header
    Created on : Apr 20, 2017, 10:57:20 PM
    Author     : ardifirmansyah
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <body>
        <!-- Logo -->
        <a href="HandlerPegawai?action=home" class="logo">
            <!-- mini logo for sidebar mini 50x50 pixels -->
            <span class="logo-mini"><b>A</b>SP</span>
            <!-- logo for regular state and mobile devices -->
            <span class="logo-lg"><b>Seleksi</b> Pegawai</span>
        </a>
        <!-- Header Navbar: style can be found in header.less -->
        <nav class="navbar navbar-static-top">
            <!-- Sidebar toggle button-->
            <a href="#" class="sidebar-toggle" data-toggle="offcanvas" role="button">
                <span class="sr-only">Toggle navigation</span>
            </a>

            <div class="navbar-custom-menu">
                <ul class="nav navbar-nav">
                    <!-- User Account: style can be found in dropdown.less -->
                    <li class="dropdown user user-menu">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                            <img src="dist/img/user.png" class="user-image" alt="User Image">
                            <span class="hidden-xs">ADMIN</span>
                        </a>
                        <ul class="dropdown-menu">
                            <!-- User image -->
                            <li class="user-header">
                                <img src="dist/img/user.png" class="img-circle" alt="User Image">

                                <p>
                                    ADMIN
                                </p>
                            </li>
                            <!-- Menu Footer-->
                            <li class="user-footer">
                                <form action="LogoutServlet" method="post">
                                    <div class="pull-right">
                                        <button type="submit" class="btn btn-default btn-flat">Sign Out</button>
                                    </div>
                                </form>
                            </li>
                        </ul>
                    </li>
                </ul>
            </div>
        </nav>
    </body>
</html>
