package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Inventory;

@WebServlet(name = "LoadInventory", urlPatterns = {"/LoadInventory"})
public class LoadInventory extends HttpServlet {

    public static ArrayList<Inventory> inventoryList;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet LoadInventory</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LoadInventory at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        loadInventory();
        RequestDispatcher reqDispatch = request.getRequestDispatcher("ViewInventory");
        reqDispatch.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private void loadInventory() {
        inventoryList = new ArrayList<Inventory>();
        Inventory item1 = new Inventory("20932K3150XC", "VMS000457", 10, 5, 5);
        Inventory item2 = new Inventory("20832K1450", "VMS000337", 2, 0, 2);
        Inventory item3 = new Inventory("20832K1460", "VMS000265", 2, 11, 11);
        Inventory item4 = new Inventory("20932K3160XC", "VMS000493", 50, 25, 25);
        Inventory item5 = new Inventory("20932K3160XC", "VMS000495", 10, 10, 0);
        Inventory item6 = new Inventory("2A732K1110XC", "VMS000508", 10, 0, 10);
        Inventory item7 = new Inventory("2A732K1110XC", "VMS000567", 163, 60, 3);
        Inventory item8 = new Inventory("20832K1430", "VMS000481", 25, 25, 0);
        Inventory item9 = new Inventory("20832K1430", "VMS000482", 45, 40, 5);
        Inventory item10 = new Inventory("20932K3160XC", "VMS000488", 800, 400, 400);
        Inventory item11 = new Inventory("20932K3160XC", "VMS000489", 26, 22, 4);
        Inventory item12 = new Inventory("20932K3160XC", "VMS000490", 25, 25, 0);
        Inventory item13 = new Inventory("20932K3160XC", "VMS000555", 25, 0, 25);
        Inventory item14 = new Inventory("20932K3160XC", "VMS000486", 44, 22, 22);
        Inventory item15 = new Inventory("20932K3160XC", "VMS000487", 10, 10, 0);

        inventoryList.add(item1);
        inventoryList.add(item2);
        inventoryList.add(item3);
        inventoryList.add(item4);
        inventoryList.add(item5);
        inventoryList.add(item6);
        inventoryList.add(item7);
        inventoryList.add(item8);
        inventoryList.add(item9);
        inventoryList.add(item10);
        inventoryList.add(item11);
        inventoryList.add(item12);
        inventoryList.add(item13);
        inventoryList.add(item14);
        inventoryList.add(item15);
    }
}
