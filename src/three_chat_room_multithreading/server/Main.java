package three_chat_room_multithreading.server;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    private static int portNumber = 5000;

    public static void main(String[] args) {
        //using serversocket as argument to automatically close the socket
        //the port number is unique for each server


        // Create Thread Pool
        //ExecutorService threadPool = Executors.newFixedThreadPool(10);
        ExecutorService threadPool = Executors.newVirtualThreadPerTaskExecutor();

        //list to add all the clients thread
        ArrayList<ServerThread> threadList = new ArrayList<>();
        try (ServerSocket serversocket = new ServerSocket(portNumber)){
            while(true) {
                Socket socket = serversocket.accept();
                ServerThread serverThread = new ServerThread(socket, threadList);
                //starting the thread
                threadList.add(serverThread);
                threadPool.execute(serverThread);

                //get all the list of currently running thread

            }
        } catch (Exception e) {
            System.out.println("Error occured in main: " + e.getStackTrace());
        }
    }
}