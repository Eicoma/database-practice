package eicoma.com.github.jdbc.Demo2;

import javax.xml.crypto.Data;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UDPReceiveDemo1 {
    public static void main(String[] args) throws IOException {
        //创建接收端的DatagramSocket对象
        DatagramSocket ds = new DatagramSocket(10086);
        //通过死循环来接收数据
        while(true){
            //创建一个数据包，用于接收数据
            byte[] byteArray = new byte[1024];
            DatagramPacket dp = new DatagramPacket(byteArray,byteArray.length);
            //通过DatagramSocket中的方法接收数据
            ds.receive(dp);
            //解析数据包，并输出数据
            System.out.println("数据是" + new String(dp.getData(),0,dp.getLength()));
        }
    }
}
