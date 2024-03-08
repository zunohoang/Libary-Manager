<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- Tell the browser to be responsiveto screen width -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="keywords" content="Quản lý thư viện libary manager">
    <meta name="description" content="Dự án cho cộng đồng">
    <meta name="robots" content="noindex,nofollow">
    <title>LibaryManager</title>
    <!-- Favicon icon -->
    <link rel="icon" type="image/png" sizes="16x16" href="assets/images/favicon.png">
    <!-- Bootstrap Core CSS -->
    <link href="assets/node_modules/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="assets/node_modules/perfect-scrollbar/css/perfect-scrollbar.css" rel="stylesheet">
    <!-- This page CSS -->
    <!-- chartist CSS -->
    <link href="assets/node_modules/morrisjs/morris.css" rel="stylesheet">
    <!--c3 CSS -->
    <link href="assets/node_modules/c3-master/c3.min.css" rel="stylesheet">
    <!-- Custom CSS -->
    <link href="html/css/style.css" rel="stylesheet">
    <!-- Dashboard 1 Page CSS -->
    <link href="html/css/pages/dashboard1.css" rel="stylesheet">
    <!-- You can change the theme colors from here -->
    <link href="html/css/colors/default.css" id="theme" rel="stylesheet">
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
<![endif]-->
</head>

<body class="fix-header fix-sidebar card-no-border">
    <!-- ============================================================== -->
    <!-- Preloader - style you can find in spinners.css -->
    <!-- ============================================================== -->
    <div class="preloader">
        <div class="loader">
            <div class="loader__figure"></div>
            <p class="loader__label">@zunohoang</p>
        </div>
    </div>
    <!-- ============================================================== -->
    <!-- Main wrapper - style you can find in pages.scss -->
    <!-- ============================================================== -->
    <div id="main-wrapper">
        <!-- ============================================================== -->
        <!-- Topbar header - style you can find in pages.scss -->
        <!-- ============================================================== -->
        <header class="topbar">
            <nav class="navbar top-navbar navbar-expand-md navbar-light">
                <!-- ============================================================== -->
                <!-- Logo -->
                <!-- ============================================================== -->
                <div class="navbar-header">
                    <a class="navbar-brand" href="html/index.html" display="flex" style="text-align: center">
                        <!-- Logo icon --><b>
                            <!--You can put here icon as well // <i class="wi wi-sunset"></i> //-->
                            <!-- Dark Logo icon -->
                            <img src="assets/images/logo-icon.png" alt="homepage" class="dark-logo" />
                            <!-- Light Logo icon -->
                        </b>
                        <!--End Logo icon -->
                        <!-- Logo text --><span style="color: #20aee3">
                            <!-- dark Logo text -->
                            Zuno Manager
                            <!-- Light Logo text --></span>
                    </a>
                </div>
                <!-- ============================================================== -->
                <!-- End Logo -->
                <!-- ============================================================== -->
                <div class="navbar-collapse">
                    <!-- ============================================================== -->
                    <!-- toggle and nav items -->
                    <!-- ============================================================== -->
                    <ul class="navbar-nav me-auto">
                        <li class="nav-item"> <a class="nav-link nav-toggler hidden-md-up waves-effect waves-dark"
                                href="javascript:void(0)"><i class="fa fa-bars"></i></a> </li>
                        <!-- ============================================================== -->
                        <!-- Search -->
                        <!-- ============================================================== -->
                        <li class="nav-item hidden-xs-down search-box"> <a
                                class="nav-link hidden-sm-down waves-effect waves-dark" href="javascript:void(0)"><i
                                    class="fa fa-search"></i></a>
                            <form class="app-search">
                                <input type="text" class="form-control" placeholder="Search & enter"> <a
                                    class="srh-btn"><i class="fa fa-times"></i></a>
                            </form>
                        </li>
                    </ul>
                    <!-- ============================================================== -->
                    <!-- User profile and search -->
                    <!-- ============================================================== -->
                    <ul class="navbar-nav my-lg-0">
                        <!-- ============================================================== -->
                        <!-- Profile -->
                        <!-- ============================================================== -->
                        <li class="nav-item dropdown u-pro">
                            <a class="nav-link dropdown-toggle waves-effect waves-dark profile-pic" href="#"
                                id="navbarDropdown" data-bs-toggle="dropdown" aria-haspopup="true"
                                aria-expanded="false"><img src="assets/images/users/1.jpg" alt="user" class="" />
                                <span class="hidden-md-down">Admin - Zunohoang &nbsp;</span> </a>
                            <ul class="dropdown-menu" aria-labelledby="navbarDropdown"></ul>
                        </li>
                    </ul>
                </div>
            </nav>
        </header>
        <!-- ============================================================== -->
        <!-- End Topbar header -->
        <!-- ============================================================== -->
        <!-- ============================================================== -->
        <!-- Left Sidebar - style you can find in sidebar.scss  -->
        <!-- ============================================================== -->
        <aside class="left-sidebar">
            <!-- Sidebar scroll-->
            <div class="scroll-sidebar">
                <!-- Sidebar navigation-->
                <nav class="sidebar-nav">
                    <ul id="sidebarnav">
                        <li> <a class="waves-effect waves-dark" href="home" aria-expanded="false"><i
                                class="fa fa-tachometer"></i><span class="hide-menu">Thống kê</span></a>
                        </li>
                        <li> <a class="waves-effect waves-dark" href="quan-ly-sach" aria-expanded="false"><i
                                class="fa fa-book"></i><span class="hide-menu">Quản lý sách</span></a>
                        </li>
                        <li> <a class="waves-effect waves-dark" href="quan-ly-nguoi-muon" aria-expanded="false"><i
                                class="fa fa-address-card-o"></i><span class="hide-menu">Quản lý người
                                    mượn</span></a>
                        </li>
                        <li> <a class="waves-effect waves-dark" href="quan-ly-quyen" aria-expanded="false"><i
                                class="fa  fa-group"></i><span class="hide-menu">Quản lý quyền</span></a>
                        </li>
                        <li> <a class="waves-effect waves-dark" href="thong-tin-ca-nhan" aria-expanded="false"><i
                                class="fa fa-user-circle-o"></i><span class="hide-menu">Thông tin cá nhân</span></a>
                        </li>
                    </ul>
                    <div class="text-center mt-4">
                        <a href="dang-xuat" class="btn waves-effect waves-light btn-info hidden-md-down text-white"> Đăng xuất</a>
                    </div>
                </nav>
                <!-- End Sidebar navigation -->
            </div>
            <!-- End Sidebar scroll-->
        </aside>
        <!-- ============================================================== -->
        <!-- End Left Sidebar - style you can find in sidebar.scss  -->
        <!-- ============================================================== -->
        <!-- ============================================================== -->
        <!-- Page wrapper  -->
        <!-- ============================================================== -->
        <div class="page-wrapper">
            <!-- ============================================================== -->
            <!-- Container fluid  -->
            <!-- ============================================================== -->
            <div class="container-fluid">
                <!-- ============================================================== -->
                <!-- Bread crumb and right sidebar toggle -->
                <!-- ============================================================== -->
                <div class="row page-titles">
                    <div class="col-md-5 align-self-center">
                        <h3 class="text-themecolor">Kho sách</h3>
                        <ol class="breadcrumb">
                            <li class="breadcrumb-item"><a href="javascript:void(0)">Zuno</a></li>
                            <li class="breadcrumb-item">Kho sách</li>
                            <li class="breadcrumb-item active">Tạo hóa đơn</li>
                        </ol>
                    </div>
                    <div class="col-md-7 align-self-center">
                        <a href=""
                            class="btn waves-effect waves-light btn btn-info pull-right hidden-sm-down text-white">
                            Tạo hóa đơn</a>
                    </div>
                </div>
                <!-- ============================================================== -->
                <!-- End Bread crumb and right sidebar toggle -->
                <!-- ============================================================== -->
                <!-- ============================================================== -->
                <!-- Start Page Content -->
                <!-- ============================================================== -->
                <div class="row">
                    <!-- column -->
                    <div class="col-lg-4 d-flex align-items-stretch">
                        <div class="card w-100">
                            <div class="card-body">
                                <h4 class="card-title">Tạo hóa đơn</h4>
                                <h6 class="card-subtitle">Cho mượn <code>.book</code></h6>
                                <form class="form-horizontal form-material">
                                    <div class="form-group">
                                        <label class="col-md-12">Tên sách</label>
                                        <div class="col-md-12">
                                            <input type="text" placeholder="Nhập tên sách"
                                                class="form-control form-control-line" name="nameBook">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-md-12">ID Sách</label>
                                        <div class="col-md-12">
                                            <input type="text" placeholder="Nhập ID sách"
                                                class="form-control form-control-line" name="idBook">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-md-12">Người mượn</label>
                                        <div class="col-md-12">
                                            <input type="text" placeholder="Nhập tên người mượn"
                                                class="form-control form-control-line" name="nameBorrower">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-md-12">ID người mượn</label>
                                        <div class="col-md-12">
                                            <input type="text" placeholder="Nhập ID người mượn"
                                                class="form-control form-control-line" name="idBorrower">
                                        </div>
                                    </div>
                                    <div></div>
                                    <div class="form-group">
                                        <div class="col-sm-12" style="text-align: center;">
                                            <button class="btn btn-success">Tạo hóa đơn</button>
                                        </div>
                                    </div>
                                </form>
                                <script>
                                    var currentUrl = window.location.href;
                                    var urlParams = new URLSearchParams(new URL(currentUrl).search);
                                    var idBookValue = urlParams.get("id");
                                    var nameBookValue = urlParams.get("name");
                                    console.log(idBookValue, nameBookValue);

                                    document.getElementsByName("idBook")[0].value = idBookValue;
                                    document.getElementsByName("nameBook")[0].value = nameBookValue;
                                </script>
                            </div>
                        </div>
                    </div>
                    <!-- ============================================================== -->
                    <!-- End PAge Content -->
                    <!-- ============================================================== -->
                    <!-- column -->
                    <div class="col-lg-8 d-flex align-items-stretch">
                        <div class="card">
                            <div class="card-body">
                                <h4 class="card-title">Hóa đơn gần đây</h4>
                                <h6 class="card-subtitle">Sắp xếp gần đây nhất</h6>
                                <div class="searchbar-box">
                                    <input type="text" class="searchbar" name="searchbar" id="mySearchbar"
                                        placeholder="Search">
                                    <button class="search-button">
                                        <span class="button-icon">
                                            <i class="fa fa-search"></i>
                                        </span>
                                    </button>
                                </div>
                                <div class="table-responsive">
                                    <table class="table" class="message-center">
                                        <thead>
                                            <tr>
                                                <th>ID</th>
                                                <th>Người mượn</th>
                                                <th>Tên sách</th>
                                                <th>Giá</th>
                                                <th>Trạng thái</th>
                                                <th>Thời gian tạo</th>
                                                <th>Chi tiết(In)</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <tr>
                                                <td>1</td>
                                                <td>Nguyễn Văn Hoàng</td>
                                                <td>Cậu là bạn nhỏ của tớ</td>
                                                <td>Cho mượn</td>
                                                <td>Hạn trả 01/01/2025</td>
                                                <td>9:00PM 01/01/2024</td>
                                                <td><a href="hoa-don.jsp?id=1">Chi tiết</a></td>
                                            </tr>
                                        </tbody>
                                    </table>
                                    <script>
                                        function createBill(idBook) {
                                            window.location.href = "tao-hoa-don.jsp?id=" + idBook + "&name=" + "Bạn là cậu nhỏ của tớ";
                                        }
                                    </script>
                                </div>
                                <div style="text-align:center;">
                                    <style>
                                        .pagination {
                                            display: inline-block;
                                        }

                                        .pagination a {
                                            color: black;
                                            float: left;
                                            padding: 8px 16px;
                                            text-decoration: none;
                                            transition: background-color .3s;
                                        }

                                        .pagination a.active {
                                            background-color: #4CAF50;
                                            color: white;
                                            border-radius: 5px;
                                        }

                                        .pagination a:hover:not(.active) {
                                            background-color: #ddd;
                                            border-radius: 5px;
                                        }
                                    </style>
                                    <br>
                                    <div class="pagination">
                                        <a href="#">&laquo;</a>
                                        <a href="#" class="active">1</a>
                                        <a href="#">2</a>
                                        <a href="#">3</a>
                                        <a href="#">&raquo;</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- ============================================================== -->
                <!-- End Container fluid  -->
                <!-- ============================================================== -->
                <!-- ============================================================== -->
                <!-- footer -->
                <!-- ============================================================== -->
                <footer class="footer"> © 2024 ZunoLibary by <a href="https://gihub.com/zunohoang">zunohoang</a>
                </footer>
                <!-- ============================================================== -->
                <!-- End footer -->
                <!-- ============================================================== -->
            </div>
            <!-- ============================================================== -->
            <!-- End Page wrapper  -->
            <!-- ============================================================== -->
        </div>
        <!-- ============================================================== -->
        <!-- End Wrapper -->
        <!-- ============================================================== -->
        <!-- ============================================================== -->
        <!-- All Jquery -->
        <!-- ============================================================== -->
        <script src="assets/node_modules/jquery/jquery.min.js"></script>
        <!-- Bootstrap popper Core JavaScript -->
        <script src="assets/node_modules/bootstrap/js/bootstrap.bundle.min.js"></script>
        <!-- slimscrollbar scrollbar JavaScript -->
        <script src="html/js/perfect-scrollbar.jquery.min.js"></script>
        <!--Wave Effects -->
        <script src="html/js/waves.js"></script>
        <!--Menu sidebar -->
        <script src="html/js/sidebarmenu.js"></script>
        <!--Custom JavaScript -->
        <script src="html/js/custom.min.js"></script>
        <!-- ============================================================== -->
        <!-- This page plugins -->
        <!-- ============================================================== -->
        <!--morris JavaScript -->
        <script src="assets/node_modules/raphael/raphael-min.js"></script>
        <script src="assets/node_modules/morrisjs/morris.min.js"></script>
        <!--c3 JavaScript -->
        <script src="assets/node_modules/d3/d3.min.js"></script>
        <script src="assets/node_modules/c3-master/c3.min.js"></script>
        <!-- Chart JS -->
        <script src="html/js/dashboard1.js"></script>
</body>

</html>