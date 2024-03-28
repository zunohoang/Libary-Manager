<%@ page import="com.example.libary_manager.models.Bill" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

<head>
    <title>Hóa đơn mượn sách</title>
    <style>
        /* CSS styles for the invoice */
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
        }

        header {
            background-color: #f5f5f5;
            padding: 20px;
            text-align: center;
        }

        h1 {
            margin: 0;
            font-size: 24px;
        }

        section {
            margin: 20px;
        }

        h2 {
            font-size: 18px;
            margin-bottom: 10px;
        }

        table {
            width: 100%;
            border-collapse: collapse;
        }

        th,
        td {
            padding: 8px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }

        footer {
            background-color: #f5f5f5;
            padding: 20px;
            text-align: right;
        }

        #total-books,
        #total-amount {
            font-weight: bold;
        }
    </style>
</head>

<body>
    <%
        Bill bill = (Bill) request.getAttribute("bill");
    %>
    <header>
        <h1>HÓA ĐƠN MƯỢN SÁCH</h1>
        <p>Ngày: <span id="invoice-date"><%=bill.getTimeStart()%></span></p>
    </header>

    <section>
        <h2>Thông tin người mượn</h2>
        <p>Tên người mượn: <span id="customer-name"><%=bill.getNameBorrower()%></span></p>
        <p>ID người muượn: <span><%=bill.getIdBorrower()%></span></p>
        <p>Địa chỉ: <span id="customer-address">Loading...</span></p>
        <!-- Add more customer information fields as needed -->
    </section>

    <section>
        <h2>Thông tin sách mượn</h2>
        <table>
            <thead>
                <tr>
                    <th>Tên sách</th>
                    <th>ID sách</th>
                    <th>Ngày mượn</th>
                    <th>Ngày trả</th>
                    <th>Trạng thái</th>
                    <!-- Add more book information columns as needed -->
                </tr>
            </thead>
            <tbody>
                <td><%=bill.getNameBook()%></td>
                <td><%=bill.getIdBook()%></td>
                <td><%=bill.getTimeStart()%></td>
                <td><%=bill.getTimeEnd()%></td>
                <%
                    String status = "Đã trả";
                    if (bill.getStatus() == 0) {
                        status = "Chưa trả";
                    }
                %>
                <td><%=status%></td>
            </tbody>
        </table>
    </section>

    <footer>
        <p>Tổng số sách mượn: <span id="total-books">1</span></p>
        <p>Tổng số tiền phải trả: <span id="total-amount">0</span></p>
    </footer>

    <script>
        // JavaScript code to populate the invoice data dynamically
        // ...
    </script>
</body>

</html>