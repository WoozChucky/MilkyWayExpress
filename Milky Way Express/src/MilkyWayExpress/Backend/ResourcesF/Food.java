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
package MilkyWayExpress.Backend.ResourcesF;

import java.awt.image.BufferedImage;
import java.io.Serializable;

/**
 *
 * @author woozlinux
 */
public class Food extends Resources implements Serializable {
    
    public Food()
    {
        name = "Food";
        resource = Resource.FOOD;
        count = 0;
        img = null;
    }
    
    @Override
    public String getName()
    {
        return name;
    }
    @Override
    public void setName(String x)
    {
        name = x;
    }
    
    @Override
    public void setCount(int x)
    {
        count = x;
    }
    @Override
    public int getCount()
    {
        return count;
    }
    
    @Override
    public void setResource(Resource x)
    {
        resource = x;
    }
    @Override
    public Resource getResource()
    {
        return resource;
    }
    
    @Override
    public BufferedImage getImage()
    {
        return img;
    }
    @Override
    public void setImage(BufferedImage x)
    {
        img = x;
    }
    
}