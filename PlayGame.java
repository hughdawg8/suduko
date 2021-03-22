import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.*;
import java.lang.*;
import java.awt.Font;

public class PlayGame extends JFrame 
{   //declare variables
    private static final int WIDTH = 320;
    private static final int HEIGHT = 200;
    
    public PlayGame()
    {
        InitiateSuduko();
    }

    public void InitiateSuduko()
    {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //close application if x is clicked
        setSize(WIDTH, HEIGHT); //set window size
        JPanel homePanel = new JPanel(); //creates panel
        JFrame homeFrame = new JFrame(); //creates frame
        setTitle("Sudoku Game"); //title at top of window
        setContentPane(homePanel); //sets panel to contain labels, buttons etc.
        homePanel.setBackground(Color.decode("#dbd7cd")); //set background color
        setLocationRelativeTo(null); //set window center screen
        homePanel.setLayout(null); //no set layout

        title = new JLabel("Sudoku"); //creates label
        title.setFont(new Font("Impact", Font.BOLD, Font.ITALIC)); //set label's font
        title.setBounds(85, 20, 250, 100); //location in window of label
        title.setForeground(Color.gray); //font color
        title.setFont(title.getFont().deriveFont(45.0f)); //font size
        add(title); //adds label to panel

        JButton enter = new JButton("Start Game"); //creates button
        enter.setForeground(Color.black); 
        enter.addActionListener(new ActionListener() //add action for when button is clicked
        {
            public void actionPerformed(ActionEvent e)
            {
                setVisible(false); //hides current window when opening next window
                 //makes sudukoGrid window visible
                suduko game = new suduko();
                game.setVisible(true);
                sudukoGrid play = new sudukoGrid(); //opens new sudukoGrid window
                play.setVisible(true);
            }
        });
        enter.setBounds(100, 115, 120, 25); 
        add(enter);

        
    }

    public static void main(String[] args) //main function to run game
    {
        PlayGame runApp = new PlayGame(); //opens intial window
        runApp.setVisible(true); //makes window visible
    }
}
