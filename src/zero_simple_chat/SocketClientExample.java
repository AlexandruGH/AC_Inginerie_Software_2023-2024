package zero_simple_chat;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * This class implements java socket client
 * @author pankaj
 *
 */
public class SocketClientExample {

    public static void main(String[] args) throws UnknownHostException, IOException, ClassNotFoundException, InterruptedException {
        //get the localhost IP address, if server is running on some other IP, you need to use that
        InetAddress host = InetAddress.getLocalHost();
        Socket socket = null;
        ObjectOutputStream objectOutputStream = null;
        ObjectInputStream objectInputStream = null;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your message for the server");
        while (true) {
            //establish socket connection to server
            socket = new Socket(host.getHostName(), 8080);

            String clientMessage = scanner.nextLine();

            //write to socket using ObjectOutputStream
            objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            System.out.println("Sending request to Socket Server");

            if (clientMessage.equalsIgnoreCase("#exit")) {
                objectOutputStream.writeObject("exit");
            } else {
                objectOutputStream.writeObject(clientMessage);
            }
            //read the server response message
            objectInputStream = new ObjectInputStream(socket.getInputStream());
            String message = (String) objectInputStream.readObject();
            System.out.println("Message: " + message);
            //close resources
            objectInputStream.close();
            objectOutputStream.close();
            Thread.sleep(100);
        }
    }
}