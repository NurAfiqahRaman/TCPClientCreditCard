import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientCardValidationApplication {

	public static void main(String[] args) throws UnknownHostException, IOException {
		// Launch client-side frame
				ClientCardValidationFrame clientCardValidationFrame = new ClientCardValidationFrame();
				clientCardValidationFrame.setVisible(true);
				
				// Connect to the server @ localhost, port 1123
				Socket socket = new Socket(InetAddress.getLocalHost(), 1123);
				
				// Update the status of the connection
				clientCardValidationFrame.updateConnectionStatus(socket.isConnected());
				
				// Read from network
				BufferedReader bufferedReader = new BufferedReader(
						new InputStreamReader(socket.getInputStream()));
				
				// Display the current date
				String message = bufferedReader.readLine();
				clientCardValidationFrame.updateServerMessage(message);
				
				// Close everything
				bufferedReader.close();
				socket.close();

	}

}
