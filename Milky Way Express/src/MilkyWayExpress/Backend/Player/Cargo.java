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
package MilkyWayExpress.Backend.Player;
import MilkyWayExpress.Backend.ResourcesF.*;
import java.io.Serializable;

/**
 *
 * @author woozlinux
 */
public class Cargo implements Serializable {
    private Resources resource01;
    private Resources resource02;
    private Resources resource03;
    
    private boolean res03Unlocked;
    
    public Cargo()
    {
        resource01 = new Empty();
        resource02 = new Empty();
        resource03 = null;
        
        res03Unlocked = false;
    }
    
    public Resources getResource01()
    {
        return resource01;
    }
    public Resources getResource02()
    {
        return resource02;
    }
    public Resources getResource03()
    {
        return resource03;
    }
    
    public boolean isUnlocked()
    {
        if(resource03 == null)
            return false;
        else
            return res03Unlocked;
    }
    
    public void unlockResource03()
    {
        res03Unlocked = true;
        resource03 = new Empty();
    }
}
