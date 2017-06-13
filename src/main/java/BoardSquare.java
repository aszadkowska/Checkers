import javax.swing.*;
import java.awt.*;

/**
 * Created by ada on 07.06.17.
 */
public class BoardSquare extends JComponent
{
    private static final long serialVersionUID = 1L;
    private int x; //x position of the rectangle measured from top left corner
    private int y; //y position of the rectangle measured from top left corner

    private boolean isBlack = false;
    private boolean isWhite = false;

    public static int width = 60;
    public static int height = 60;

    public static String type_BLANK = "BLANK";
    public static String type_WHITE = "WHITE";
    public static String type_BLACK = "BLACK";

    public BoardSquare(int p, int q, String type)
    {
        //this.setBorder(new LineBorder(Color.CYAN, 2));
        this.setPreferredSize(new Dimension(width, height));

        x = p;
        y = q;

        if (type.equals(type_BLACK))
        {
            isBlack = true;
            isWhite = false;
        }
        else if (type.equals(type_WHITE))
        {
            isWhite = true;
            isBlack = false;
        }
        else if (type.equals(type_BLANK))
        {
            isBlack = false;
            isWhite = false;

        }

    }
    public void paintComponent(Graphics g)
    {
        int numRows = 8;
        int numCols = 8;
        Graphics2D g2 = (Graphics2D) g;
        Graphics2D g3 = (Graphics2D) g;
        Rectangle box = new Rectangle(x,y,width,height);
        g2.draw(box);
        g2.setPaint(Color.LIGHT_GRAY);
        g2.fill(box);

        g3.draw(box);
        g3.fill(box);

        int ovalWidth = width - 25;
        int ovalHeight = height- 25;


        if(isBlack)
        {
            g2.setColor(Color.black);
            g2.fillOval(x + (width - 25) / 4, y + (width - 25) / 8, ovalWidth, ovalHeight);
            g2.drawOval(x + (width - 25) / 4, y + (width - 25) / 8, ovalWidth, ovalHeight) ;

            g3.setColor(Color.darkGray);
            g3.fillOval(x + (width - 25) / 4, y + (width - 25) / 4, ovalWidth, ovalHeight);
            g3.drawOval(x + (width - 25) / 4, y + (width - 25) / 4, ovalWidth, ovalHeight) ;
        }

        else if(isWhite)
        {
            g3.setColor(Color.darkGray);
            g3.fillOval(x + (width - 25) / 4, y + (width - 25) / 8, ovalWidth, ovalHeight);
            g3.drawOval(x + (width - 25) / 4, y + (width - 25) / 8, ovalWidth, ovalHeight) ;
            g2.setColor(Color.white);
            g2.fillOval(x + (width - 25) / 4, y + (width - 25) / 4, ovalWidth, ovalHeight);
            g2.drawOval(x + (width - 25) / 4, y + (width - 25) / 4, ovalWidth, ovalHeight);

        }


    }
}
