import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;

@WebServlet("/requestDemo2")
public class RequestDemo2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.根据名称获取数据 getParameter()
        String username = req.getParameter("username");
        System.out.println(username);
        String password = req.getParameter("password");
        System.out.println(password);
        System.out.println("****************************");

        //2.根据名称获取所有数据 getParameterValues()
        String[] hobbies = req.getParameterValues("hobby");
        for(String hobby : hobbies){
            System.out.println(hobby + " ");
        }
        System.out.println("****************************");

        //3.获取所有名称 getParameterNames()
        Enumeration<String> parameterNames = req.getParameterNames();
        while(parameterNames.hasMoreElements()){
            String name = parameterNames.nextElement();
            System.out.print(name + " ");
        }
        System.out.println();
        System.out.println("****************************");

        //4.获取所有参数的键值对 getParameterMap()
        Map<String, String[]> parameterMap = req.getParameterMap();
        for (String key : parameterMap.keySet()){
            String[] values = parameterMap.get(key);
            System.out.print(key + ":");
            for (String value : values){
                System.out.print(value);
            }
            System.out.println();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
