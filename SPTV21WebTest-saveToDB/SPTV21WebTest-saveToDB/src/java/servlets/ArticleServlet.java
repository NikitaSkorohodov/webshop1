/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import entity.Article;
import entity.Author;
import entity.Client;
import java.io.IOException;
import java.util.GregorianCalendar;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sesion.ArticleFacade;
import sesion.AuthorFacade;
import sesion.ClientFacade;

/**
 *
 * @author user
 */
@WebServlet(name = "ArticleServlet", urlPatterns = {
    
    "/newArticle",
    "/createArticle",
    "/newAuthor",
    "/createAuthor",
    "/listArticles",
    "/article",
    "/newClient",
    "/createClient",
    "/listClients",

})
public class ArticleServlet extends HttpServlet {
    @EJB private ArticleFacade articleFacade;
    @EJB private AuthorFacade authorFacade;
    @EJB private ClientFacade ClientFacade;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String path = request.getServletPath();
        switch (path) {
            case "/listArticles":
                request.setAttribute("listArticles", articleFacade.findAll());
                request.getRequestDispatcher("/listArticles.jsp").forward(request, response);
                break;
            case "/newArticle":
                request.setAttribute("listClients", ClientFacade.findAll());
                request.getRequestDispatcher("/WEB-INF/newArticle.jsp").forward(request, response);
                break;
            case "/createArticle":
                String caption = request.getParameter("caption");
                String text = request.getParameter("text");
                String clientId = request.getParameter("clientId");
                Client client = ClientFacade.find(Long.parseLong(clientId));
                Article article = new Article();
                
                article.setCaption(caption);
                article.setText(text);
                article.setDate(new GregorianCalendar().getTime());
                articleFacade.create(article);
               
                ClientFacade.edit(client);
                break;
             
             case "/listClients":
               request.setAttribute("listClients", ClientFacade.findAll());
                request.getRequestDispatcher("/listClients.jsp").forward(request, response);
                break;
            case "/newClient":
                request.getRequestDispatcher("/WEB-INF/newClient.jsp").forward(request, response);
                break;
             case "/createClient":
                String firstname = request.getParameter("firstname");
                String lastname = request.getParameter("lastname");
                client = new Client();
                client.setFirstname(firstname);
                client.setLastname(lastname);
                ClientFacade.create(client);
                request.getRequestDispatcher("/WEB-INF/newClient.jsp").forward(request, response);
                break;
            
            
            case "/article":
                String articleId = request.getParameter("articleId");
                article = articleFacade.find(Long.parseLong(articleId));
                request.setAttribute("article", article);
                request.getRequestDispatcher("/WEB-INF/article.jsp").forward(request, response);
                break;
            
        }
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
