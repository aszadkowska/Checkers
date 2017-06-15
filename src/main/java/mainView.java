import io.socket.client.IO;
import io.socket.client.Socket;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Image;
import java.net.URISyntaxException;

public class mainView {

    public static String textContainer;
    public static JPanel panel;
    public static JFrame f;
    public static JButton b;
    public static JTextField textField;
    public static Client client;
    public static class Start {
        Gui gui;
            Gui.Board game = new Gui.Board();
            public void setGame(Gui.Board test){
                game = test;
            }
            public Start(){
                mainView.client = new Client();
             }

            public void run() {
                panel = new JPanel(new GridLayout(0,1,10,10));
                panel.setBorder(new EmptyBorder(200,30,20,30));

/*
                panel.add(new JLabel(new ImageIcon("Downloads/unnamed.png")));
*/

                JLabel label1 = new JLabel("Enter Server address :", JLabel.LEFT);
                panel.add(label1);

                textField = new JTextField();


                textField.setColumns(20);
                panel.add(textField);
                Insets margin = new Insets(10,150,10,150);
                b = new JButton("Start");
                b.setMargin(margin);
                b.setBackground(new Color(19, 80, 62));
                b.setForeground(Color.WHITE);
                panel.add(b);

                f = new JFrame("Checkers visualisation");
                f.add(panel);
                f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                f.setLocationByPlatform(true);
                f.pack();
                f.setMinimumSize(f.getSize());

                f.setVisible(true);
                System.out.println(b.getSize());

                b.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent arg0) {
                        mainView.textContainer = textField.getText();
                        System.out.println(mainView.textContainer);

                        if(!mainView.textContainer.equals("")){
                            try{
                                mainView.client.openSocket();
                            }catch(URISyntaxException e){

                            }
                        }
                        panel.setVisible(false);
                        f.setVisible(false);
                        game.setVisible(true);
                    }
                });


            }

    }

    /*public static void main(String[] args) {
        Start st= new Start();
        st.run();
    }*/

}