<%@page import="model.Inventory"%>
<%@page import="java.util.ArrayList"%>
<%@include file="header.jsp" %>
<title>Student Details</title>
<div class="container">
    <center>
        <br><br><br><br><br>
        <%if (request.getAttribute("inventoryList") == null) {%>
        <p style="color: red">Inventory list is empty</p>
        <%} else {%>
        <h1>Inventory Details</h1>
        <table class="table table-striped table-bordered table-hover">
            <thead>
                <tr>
                    <th scope="col">Part Number</th>
                    <th scope="col">Serial Number</th>
                    <th scope="col">Inventory Quantity</th>
                    <th scope="col">Available Quantity</th>
                    <th scope="col">Allocated Quantity</th>
                </tr>
            </thead>
            <tbody>
                <%ArrayList<Inventory> inventoryList = (ArrayList<Inventory>) request.getAttribute("inventoryList");
                    for (Inventory inventory : inventoryList) {%>
                <tr>
                    <td><%=inventory.getPartNumber()%></td>
                    <td><%=inventory.getSerialNumber()%></td>
                    <td><%=inventory.getInventoryQty()%></td>
                    <td><%=inventory.getAvailableQty()%></td>
                    <td><%=inventory.getAllocatedQty()%></td>
                </tr>
                <%}%>
            </tbody>
        </table>
        <%}%>
    </center>
</div>
<br><br><br>
</body>
<%@include file="footer.jsp" %>
</html>
