/**
 * Created by pranavkumar on 4/14/17.
 */
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.awt.image.*;
import javax.imageio.*;

public class StartWindow extends JFrame
{

    public static void main(String[]args)
    {
        StartWindow s = new StartWindow();
        s.buildFrame();

    }

    public void buildFrame()
    {
        InitialPanel i = new InitialPanel();

        setSize(800, 800);
        setTitle("Start");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(i);
        setVisible(true);

    }

    class InitialPanel extends JPanel implements ActionListener
    {
        Image robotRunImage;
        JButton start;
        JLabel robotRunLabel;
        Font font;
        ButtonPanel buttonPanel;

        public InitialPanel()
        {
            setLayout(new BorderLayout());

            font = new Font("Ariel", Font.PLAIN, 60);
            robotRunLabel = new JLabel("Robot Run!");
            buttonPanel = new ButtonPanel();
            robotRunImage = null;

            start.addActionListener(this);

            robotRunLabel.setHorizontalAlignment(SwingConstants.CENTER);
            robotRunLabel.setFont(font);

            start.setSize(100, 100);

            add(robotRunLabel, BorderLayout.NORTH);
            add(buttonPanel, BorderLayout.SOUTH);


        }

        public void getImage()
        {
            try
            {
                robotRunImage = ImageIO.read(new File("src/7f73a0c1100e9f05574c8332b1c3e490.jpg"));
            }

            catch(IOException e)
            {
                System.err.println("Image cannot be found");
                e.printStackTrace();
            }

        }

        public void paintComponent(Graphics g)
        {
            super.paintComponent(g);



            getImage();

            //for(int y = 00; y < 1600; y+=50)
            //{
               // for(int x = 0; x < 1600; x += 50)
                    g.drawImage(robotRunImage, 0, 0, 800, 800 ,this);
            //}



            g.setColor(Color.WHITE);
            g.fillRect(200, 0, 400, 100);
        }

        @Override
        public void actionPerformed(ActionEvent e)
        {
            if(e.getActionCommand().equalsIgnoreCase("start")){
                MiniGame c = new MiniGame();
//                Course.Endless endless;
//                endless = new Course.Endless();
                setContentPane(c);
            }
        }


        class ButtonPanel extends JPanel implements ActionListener
        {
            public ButtonPanel()
            {
                start = new JButton("Start");

                setSize(50, 300);
                add(start);
            }

            public void actionPerformed(ActionEvent e)
            {
                if(e.getActionCommand().equalsIgnoreCase("start")){
                    MiniGame m = new MiniGame();
//                Course.Endless endless;
//                endless = new Course.Endless();
                    setContentPane(m);
                }
            }
        }
    }
}
