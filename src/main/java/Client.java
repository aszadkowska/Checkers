import io.socket.client.IO;
import io.socket.client.Socket;
import io.socket.emitter.Emitter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;


public class Client {


    public static void main(String [] args) throws URISyntaxException {

        final Gui.Board game= new Gui.Board();
        final mainView.Start st= new mainView.Start();
        st.setGame(game);
        st.run();

        final Socket socket = IO.socket("http://192.168.0.102:3000");
        socket.on(Socket.EVENT_CONNECT, new Emitter.Listener() {

            public void call(Object... args) {
socket.emit("chat message", "hi");
                //socket.disconnect();

            }

        }).on("message", new Emitter.Listener() {

            public void call(Object... args) {
                String data = (String) args[0];
                System.out.println(data);
                game.repaint(8,8,data.split(","));
                game.add(data);
                game.moves();
            }
        }).on(Socket.EVENT_DISCONNECT, new Emitter.Listener() {

            public void call(Object... args) {
String data = (String) args[0];
                System.out.println(data);

            }
        });
        socket.connect();
    }

}
