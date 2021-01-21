
import java.awt.event.ActionEvent;
import java.io.*;
import java.net.ConnectException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public class Client {

    private Socket Client;
    private String userName;
    private String ipAddress;
    private java.net.Socket socket = null;

    public static void main(String[] args) {

        try {
            String line = System.in.toString();
            if (line.equals("quit")) {
                try {
                    Socket socket = new Socket();
                    throw new Exception();
                } catch (UnknownHostException e) {
                    System.out.println("Podany adres nie istnieje");
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("Nie można nawiązać połączenia (serwer wyłączony, nieprawidłowy port, serwer nie akceptuje połączeń)");
                } catch (Exception e) {
                    System.out.println("Inny błąd");
                }

            }
        }
        finally {

        }
    }

    //Wysyłanie wiadomości do serwera
    public void  SendButton_Click(ActionEvent e)
    {
        String sendMessage = "hi \n";
        try {
            sendMessageToServer(Client,sendMessage);  //wysyłanie wiad. do serwera
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        System.out.println("Wiadomość wysłana do serwera : "+sendMessage);
    }

    private void sendMessageToServer(Socket socket,String message) throws IOException {
        BufferedWriter writer = new BufferedWriter(new
                OutputStreamWriter(socket.getOutputStream()));

        writer.write(message);
        writer.flush();
    }
}
