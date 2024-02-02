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
            String quequanStr = request.getParameter("quequan");
            String luongcobanStr = request.getParameter("luongcoban");
            String hesoluongStr = request.getParameter("hesoluong");
            String sotietStr =request.getParameter("sotiet");
            String sogioStr =request.getParameter("sogio");
            String kieugiaovienStr = request.getParameter("kieugiaovien");
            String giolamStr = request.getParameter("giolam"); 
            String diadiemStr = request.getParameter("diadiem"); 
            String quangduongStr = request.getParameter("quangduong"); 
            if (hotenStr == null || ngaysinhStr == null || quequanStr == null || luongcobanStr == null || hesoluongStr == null || sotietStr == null || sogioStr == null
                    || kieugiaovienStr == null || giolamStr == null || diadiemStr == null || quangduongStr == null ) {
                out.println("<html><body><p>Nhap thong tin</p></body></html>");
                return;
            }
            
            try {
                // Chuyển đổi dữ liệu sang kiểu số
                double luongcoban = Double.parseDouble(luongcobanStr);
                double hesoluong = Double.parseDouble(hesoluongStr);
                double sotiet = Double.parseDouble(sotietStr);
                double sogio = Double.parseDouble(sogioStr);
                 double quangduong = Double.parseDouble(quangduongStr);

                // Tính toán kết quả
                double result = 0;

                switch (kieugiaovienStr) {
                    case "thinhgiang":
                        switch(giolamStr){
                            case "trongio":
                                switch (diadiemStr){
                                    case "trongtinh":
                                        result = sogio * sotiet; break;
                                    case "ngoaitinh":
                                        if (quangduong > 30){
                                        result = sogio * sotiet + 150000;
                                    }
                                        else if (quangduong >10 & quangduong <30){
                                        result = sogio * sotiet +70000;
                                                }
                                        else {
                                        result =sogio * sotiet;
                                        return;
                                        }
                                        break;
                                } break;
                                
                            case "ngoaigio":
                                switch (diadiemStr){
                                    case "trongtinh":
                                        result = (sogio * sotiet) * 15 / 100; 
                                        break;
                                    case "ngoaitinh":
                                        if (quangduong > 30){
                                        result = (sogio * sotiet + 150000)* 15 / 100 ;
                                    }
                                        else if (quangduong >10 & quangduong <30){
                                        result = (sogio * sotiet +70000)* 15 / 100;
                                                }
                                        else {
                                        result =(sogio * sotiet)* 15 / 100 ;
                                        return;
                                        }
                                        break;
                                }
                                
                        }
                        
                        break;
                        
                        
                        
                        
                    case "cohuu":
                        
                        switch(giolamStr){
                            case "trongio":
                                switch (diadiemStr){
                                    case "trong tinh":
                                        if(sogio > 32){
                                        result= luongcoban * hesoluong +1000000;
                                        } else if (sogio < 32 & sogio >20){
                                        result = luongcoban * hesoluong +500000;}
                                        else {
                                            result= luongcoban *hesoluong;
                                        } break;       
                                        
                                    case "ngoaitinh":                                     
                                       if(sogio > 32){
                                           if(quangduong > 30){
                                                result= luongcoban * hesoluong +1000000 + 150000;
                                           }
                                           else if (quangduong <30 & quangduong > 10){
                                               result= luongcoban * hesoluong +1000000 + 70000;
                                           } else {
                                               result= luongcoban * hesoluong +1000000;
                                           }
                                       
                                        }
                                       else if (sogio < 32 & sogio >20){
                                             if(quangduong > 30){
                                                result= luongcoban * hesoluong +500000 + 150000;
                                           }
                                           else if (quangduong <30 & quangduong > 10){
                                               result= luongcoban * hesoluong + 500000 + 70000;
                                           } else {
                                               result= luongcoban * hesoluong + 500000;
                                           }
                                       
                                        }
                                        else {
                                            result= luongcoban *hesoluong;
                                        } break;  
                                } break;
                                
                            case "ngoaigio":
                               switch (diadiemStr){
                                    case "trong tinh":
                                        if(sogio > 32){
                                        result= (luongcoban * hesoluong +1000000) *15/ 100;
                                        } else if (sogio < 32 & sogio >20){
                                        result = (luongcoban * hesoluong +500000)*15/ 100;}
                                        else {
                                            result= (luongcoban *hesoluong)*15/ 100;
                                        } break;       
                                        
                                    case "ngoaitinh":                                     
                                       if(sogio > 32){
                                           if(quangduong > 30){
                                                result= (luongcoban * hesoluong +1000000 + 150000)*15/ 100;
                                           }
                                           else if (quangduong <30 & quangduong > 10){
                                               result= (luongcoban * hesoluong +1000000 + 70000)*15/ 100;
                                           } else {
                                               result= (luongcoban * hesoluong +1000000)*15/ 100;
                                           }
                                       
                                        }
                                       else if (sogio < 32 & sogio >20){
                                             if(quangduong > 30){
                                                result= (luongcoban * hesoluong +500000 + 150000)*15/ 100;
                                           }
                                           else if (quangduong <30 & quangduong > 10){
                                               result= (luongcoban * hesoluong + 500000 + 70000)*15/ 100;
                                           } else {
                                               result= (luongcoban * hesoluong + 500000)*15/ 100;
                                           }
                                       
                                        }
                                        else {
                                            result= (luongcoban *hesoluong)*15/ 100;
                                        } break;  
                                } break;
                                
                                    
                                
                        } break;
                                
                            
                                 
                       
                         }
                
                          out.println("<html><body><p>So luong la " + result + "</p></body></html>");
               
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