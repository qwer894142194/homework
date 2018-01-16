package servlet;

import domain.Book;
import domain.PageBean;
import service.BookService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "BookServlet",urlPatterns = "/book")
public class BookServlet extends HttpServlet {
    private BookService bs = new BookService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pc = request.getParameter("pc");
        PageBean pageBean = new PageBean();
        if(pc == null){
            pc="1";
        }
        int p = Integer.parseInt(pc);

        int begin = (p - 1) * pageBean.getPageSize();
        int end = p * pageBean.getPageSize();

        StringBuilder sb = new StringBuilder();
        List<String> pl = new ArrayList<>();
        sb.append("select * from book");


        String bookName = request.getParameter("bookName");
        String author = request.getParameter("author");
        String price = request.getParameter("price");
        String category = request.getParameter("category");

        String[] ps = {"bookName","author","price","category"};
        String[] pv = {bookName,author,price,category};

        String params = "";
        for (int i = 0; i < pv.length; i++) {
            if(pv[i] != null){
                params +="&"+ps[i]+"="+pv[i];
            }
        }
        pageBean.setParams(params);

            if(bookName != null || author != null || price!=null || category!= null){

                sb.append(" where ");
                boolean shouldAnd = false;
                for (int i = 0; i < ps.length; i++) {
                    System.out.println(pv[i]);

                    if(!pv[i].equals("")){
                        //       System.out.println(pv[i].equals(null));
                        if(shouldAnd){
                            sb.append(" and ");
                        }
                        sb.append(ps[i]+"='"+pv[i]+"'");
                        shouldAnd = true;
                        pl.add(ps[i]);
                    }
                }


        }
        String sql1 = sb.toString();
        sb.append(" limit "+begin+",10");
        String sql = sb.toString();
       System.out.println(sql);
        List<Book> books = bs.findAll(sql);
        List<Book> all1 = bs.findAll1(sql1);
       pageBean.setTotalData(all1.size());
        pageBean.setBooks(books);
        pageBean.setPageCode(p);
        request.setAttribute("pageBean", pageBean);
        request.getRequestDispatcher(
                "index.jsp"
        ).forward(request, response);


    }
}
