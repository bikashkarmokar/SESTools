package dlr.ses.peseditor;

import java.awt.*;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.swing.*;

/**
 * <h1>SplashScreen</h1>
 * <p>
 * This class implements the splash screen of the editor. During starting the
 * editor some editor and development related information will be displays for
 * few seconds on a small window and then the main editor window will come.
 * </p>
 * 
 * @author Bikash Chandra Karmokar
 * @version 1.0
 *
 */
public class SplashScreen extends JWindow {
     
    private int duration;
    public static Path path = Paths.get("").toAbsolutePath();	
	public static String repFslas = path.toString().replace("\\", "/");
     
    public SplashScreen(int d) {
        duration = d;
    }
     
    // A simple little method to show a title screen in the center
    // of the screen for the amount of time given in the constructor
    public void showSplash() {
         
        JPanel content = (JPanel)getContentPane();
        content.setBackground(Color.white);
         
        // Set the window's bounds, centering the window
        int width = 500;
        int height =375;
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screen.width-width)/2;
        int y = (screen.height-height)/2;
        setBounds(x,y,width,height);
         
        // Build the splash screen
        JLabel label = new JLabel(new ImageIcon(repFslas+"/src/dlr/resources/images/peseditor.png"));
        JLabel copyrt = new JLabel("Copyright 2019 by German Aerospace Center. All rights reserved.", JLabel.CENTER);
        copyrt.setFont(new Font("Sans-Serif", Font.BOLD, 12));
        content.add(label, BorderLayout.CENTER);
        content.add(copyrt, BorderLayout.SOUTH);
        Color color = new Color(0, 0, 0,  0);
        content.setBorder(BorderFactory.createLineBorder(color, 3));
         
        // Display it
        setVisible(true);
         
        // Wait a little while, maybe while loading resources
        try { Thread.sleep(duration); } catch (Exception e) {}
         
        setVisible(false);
         
    }
     
    public void showSplashAndExit() {
         
        showSplash();        
         
    }
     
}
