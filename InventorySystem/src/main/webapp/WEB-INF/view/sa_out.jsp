<%@include file="header.jsp" %>
<title>Reduce Available Quantity</title>
<div class="container">
    <h1>Reduce Available Quantity</h1>
    <div class="add-product-design">
        <form class = 'card p-3' action="SA-OUT" method="post">   
            <h1>Reduce Available Product</h1>
            <% if (request.getAttribute("successMsg") != null) {%>
            <div class="form-group">
                <p style="color: green"><%= request.getAttribute("successMsg")%> </p>
            </div>
            <%}%>
            <% if (request.getAttribute("errorMsg") != null) {%>
            <div class="form-group">
                <p style="color: red"><%= request.getAttribute("errorMsg")%> </p>
            </div>
            <%}%>
            <div class="form-group">
                <label for="partNumber">Part Number</label>
                <input type="text" class="form-control" placeholder="Enter Part Number" name="partNumber" required>
            </div>
            <div class="form-group">
                <label for="serialNumber">Serial Number</label>
                <input type="text" class="form-control" placeholder="Enter Serial Number" name="serialNumber" required>
            </div>
            <div class="form-group">
                <label for="availQty">Reduce Available Quantity</label>
                <input type="number" class="form-control" placeholder="Enter Quantity to reduce" name="availQty" required>
            </div>
            <div class="form-group text-center">
                <button type="submit" class="btn btn-primary form-button">Reduce</button>
            </div>
        </form>
    </div>
</div>
<br><br><br>
</body>
<%@include file="footer.jsp" %>
</html>
