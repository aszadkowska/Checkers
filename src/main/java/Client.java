import io.socket.client.IO;
import io.socket.client.Socket;
import io.socket.emitter.Emitter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.lang.NullPointerException;


public class Client {

    public void openSocket() throws URISyntaxException, NullPointerException{
        final Gui.Board game= new Gui.Board();
        final Game gameEngine = new Game();
        System.out.println(mainView.textContainer);

        final Socket socket = IO.socket(mainView.textContainer);
        socket.on("message", new Emitter.Listener() {

            public void call(Object... args) {
                String data = (String) args[0];
                System.out.println(data);

                String lastMove = game.getLastMove();
                String move = Parser.parse(lastMove,data);
                System.out.println(move);
                if  ((move.length() == 5) && (gameEngine.move(move))){
                    game.repaint(8,8,data.split(","));
                    game.add(data);
                    game.moves();
                } else {
                    game.showError("Bad move : (");
                }

            }
        });
        socket.connect();

    }

}
