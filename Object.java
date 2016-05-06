/*
#The MIT License (MIT)
#
#Copyright (c) 2016 saberman888
#Permission is hereby granted, free of charge, to any person obtaining a copy
#of this software and associated documentation files (the "Software"), to deal
#in the Software without restriction, including without limitation the rights
#to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
#copies of the Software, and to permit persons to whom the Software is
#furnished to do so, subject to the following conditions:
#
#The above copyright notice and this permission notice shall be included in all
#copies or substantial portions of the Software.
#
#THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
#IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
#FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
#AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
#LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
#OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
*/


public class Object 
{
	public String ascii;
	public int x;
	public int y;
	Object(String ascii, int x, int y)
	{
		this.ascii = ascii;
		this.x = x;
		this.y = y;
	}
	
	public void Move(int dx, int dy, Tile[][] tmap, Object[][] omap)
	{
		if(tmap[dx+this.x][dy+this.y] == null)
		{
			
			System.out.println("a.out");
			if(omap[dx+this.x][dy+this.y] == null)
			{
				System.out.println("a.out2");
				this.x += dx;
				this.y += dy;
			} else {
		
				System.out.println("Object at ["+this.x+dx+"]["+this.y+dy+"] has blocked properties\n");
			}
		}
	}
}
