
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author 隔壁老王
 */
@WebServlet("/likeServlet")
public class LikeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext sc = getServletContext();
        Integer count = (Integer) sc.getAttribute("count");
        if(count == null){
            count = 1;
        }else{
            count++;
        }
        //放回原来的位置
        sc.setAttribute("count",count);
        //将结果响应给客户端
        PrintWriter out = resp.getWriter();
        out.print(count);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }



}
