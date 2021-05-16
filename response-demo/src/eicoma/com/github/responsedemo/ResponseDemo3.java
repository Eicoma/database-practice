package eicoma.com.github.responsedemo;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 响应图片
 */

@WebServlet("/responseDemo3")
public class ResponseDemo3 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //通过图片文件的相对路径获取绝对路径
        String realPath = getServletContext().getRealPath("/img/封面完成.png");
        System.out.println(realPath);

       //1.创建字节输入流对象，关联图片路径
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(realPath));

        //2.通过响应对象获取字节输出流对象
        ServletOutputStream os = resp.getOutputStream();

        //3.循环读写
        byte[] arr = new byte[1024];
        int len;
        while((len = bis.read(arr)) != -1){
            os.write(arr,0,len);
        }
        //4.释放资源
        //仅释放输入流对象即可
        bis.close();

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
