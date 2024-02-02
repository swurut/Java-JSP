/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Admin
 */
@WebServlet(urlPatterns = {"/processTinhtoann"})
public class processTinhtoann extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            String hotenStr = request.getParameter("hoten");
            String ngaysinhStr = request.getParameter("ngaysinh");
            String gioitinhStr = request.getParameter("gioitinh");
            String quequanStr = request.getParameter("quequan");
            String sothichStr = request.getParameter("sothich");
            String khunggioStr = request.getParameter("khunggio");
            String sotietStr =request.getParameter("sotiet");
           
            if (hotenStr == null || ngaysinhStr == null || gioitinhStr == null || quequanStr == null || sothichStr == null 
                    || khunggioStr == null || sotietStr == null  ) {
                out.println("<html><body><p>Nhap thong tin</p></body></html>");
                return;
            }
            
            try {
                // Chuyển đổi dữ liệu sang kiểu số
                double sotiet = Double.parseDouble(sotietStr);
                

                // Tính toán kết quả
                double result = 0;

                switch (khunggioStr) {
                    case "sang":
                        result = sotiet * 200000;
                        break;
                                
                            case "chieu":
                               result = sotiet * 200000;
                                        break;
                                
                case "toi":
                result = sotiet * 150000;
                                
                       
                        
                        break;
                        
                }
                        
                        
                    out.println("<html><body><p>Ho ten " + hotenStr + "</p></body></html>");
                    out.println("<html><body><p>Ngay sinh " + ngaysinhStr + "</p></body></html>");
                    out.println("<html><body><p>Gioi tinh " + gioitinhStr + "</p></body></html>");
                    out.println("<html><body><p>Que quan " + quequanStr + "</p></body></html>");
                    out.println("<html><body><p>So thich " + sothichStr + "</p></body></html>");
                    out.println("<html><body><p>khung gio " + khunggioStr + "</p></body></html>");
                    out.println("<html><body><p>So tiet " + sotiet + "</p></body></html>");
                
                          out.println("<html><body><p>So luong  " + result + "</p></body></html>");
               
            }
             catch (NumberFormatException e) {
                out.println("<html><body><p>Nhập số</p></body></html>");
            
        
            
            
        
    }
        }
    }
     @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

    private void and(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}