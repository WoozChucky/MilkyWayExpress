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
package MilkyWayExpress.Backend.Resources;

import java.awt.image.BufferedImage;
import java.io.Serializable;

/**
 *
 * @author woozlinux
 */
public class Water extends Resource implements Serializable {
    
    /**
     *
     */
    public Water()
    {
        name = "Water";
        resource = ResourceType.WATER;
        count = 0;
        img = null;
    }
    
    /**
     *
     * @return
     */
    @Override
    public String getName()
    {
        return name;
    }

    /**
     *
     * @param x
     */
    @Override
    public void setName(String x)
    {
        name = x;
    }
    
    /**
     *
     * @param x
     */
    @Override
    public void setCount(int x)
    {
        count = x;
    }

    /**
     *
     * @return
     */
    @Override
    public int getCount()
    {
        return count;
    }
    
    /**
     *
     * @param x
     */
    @Override
    public void setResource(ResourceType x)
    {
        resource = x;
    }

    /**
     *
     * @return
     */
    @Override
    public ResourceType getResourceType()
    {
        return resource;
    }
    
    /**
     *
     * @return
     */
    @Override
    public BufferedImage getImage()
    {
        return img;
    }

    /**
     *
     * @param x
     */
    @Override
    public void setImage(BufferedImage x)
    {
        img = x;
    }
    
}