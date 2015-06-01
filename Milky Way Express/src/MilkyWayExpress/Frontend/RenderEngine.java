/*
 * The MIT License
 *
 * Copyright 2015 woozlinux.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package MilkyWayExpress.Frontend;

import MilkyWayExpress.Backend.Game;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.Serializable;
import javax.swing.JFrame;

/**
 *
 * @author woozlinux
 */
public class RenderEngine implements Serializable {
    
    private Game game;
    
    public static void centerScreen(JFrame f)
    {
        // Get the size of the screen
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

        // Determine the new location of the window
        int w = f.getSize().width;
        int h = f.getSize().height;
        int x = (dim.width-w)/2;
        int y = (dim.height-h)/2;

        // Move the window
        f.setLocation(x, y);
    }
    
    public static void openForm(JFrame current, JFrame next)
    {
        current.dispose();
        next.setVisible(true);
    }
    
    public static void openTrade(JFrame current, JFrame next)
    {
        current.setVisible(false);
        next.setVisible(true);
    }
    
    public static void openForm(JFrame current, JFrame next, boolean fullscreen)
    {
        current.dispose();
        next.setExtendedState(JFrame.MAXIMIZED_BOTH); 
        next.setVisible(true);
    }
}
