package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Inventory;

@WebServlet(name = "SA-OUT", urlPatterns = {"/SA-OUT"})
public class SA_OUT extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet SA_IN</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SA_IN at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher reqDispatch = request.getRequestDispatcher("WEB-INF/view/sa_out.jsp");
        reqDispatch.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String partNumber = request.getParameter("partNumber");
        String serialNumber = request.getParameter("serialNumber");
        int availQuantity = Integer.parseInt(request.getParameter("availQty"));
        boolean isNegative = true, isPartNumber = false, isSerialNumber = false, isAvailQuantity = false, isRemove = false;
        Inventory removeInventory = new Inventory();

        if (availQuantity > 0) {
            isNegative = false;
            for (Inventory inventory : LoadInventory.inventoryList) {
                if (inventory.getPartNumber().equals(partNumber)) {
                    isPartNumber = true;
                    if (inventory.getSerialNumber().equals(serialNumber)) {
                        isSerialNumber = true;
                        if (inventory.getAvailableQty() >= availQuantity) {
                            isAvailQuantity = true;
                            inventory.setAvailableQty(inventory.getAvailableQty() - availQuantity);
                            inventory.setAllocatedQty(inventory.getAllocatedQty() + availQuantity);
                            inventory.setInventoryQty(inventory.getAvailableQty() + inventory.getAllocatedQty());
                            request.setAttribute("successMsg", "Available quantity updated successfully");

                            if (inventory.getAvailableQty() == 0) {
                                removeInventory = inventory;
                                isRemove = true;
                            }
                        }
                    }
                }
            }
        }

        if (isRemove) {
            LoadInventory.inventoryList.remove(removeInventory);
        }

        if (isNegative) {
            request.setAttribute("errorMsg", "Available quantity cannot be negative");
        } else if (isPartNumber == false) {
            request.setAttribute("errorMsg", "Part Number is not available");
        } else if (isSerialNumber == false) {
            request.setAttribute("errorMsg", "Serial Number is not available");
        } else if (isAvailQuantity == false) {
            request.setAttribute("errorMsg", "Available Quantity is lower than entered");
        }
        RequestDispatcher reqDispatch = request.getRequestDispatcher("WEB-INF/view/sa_out.jsp");
        reqDispatch.forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
