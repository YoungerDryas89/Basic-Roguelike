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


import java.util.*;

public class Map
{
	public String map_name;
	public int x;
	public int y;
	public Tile[][] tile_map;
	public Object[][] obj_map;

	
	public boolean IsBlocked(Tile t)
	{
		if(t.Blocked == true)
		{
			return true;
		} else {
			return false;
		}
	}
	
	public void DrawAssets(Tile[] tassets, Object[] oassets)
	{
		for(int i = 0; i<tassets.length; i++)
		{
			this.SetTile(tassets[i]);
			//this.SetObj(oassets[i]);
		}
		
		for(int j = 0; j<oassets.length; j++)
		{
			this.SetObj(oassets[j]);
		}
	}
	
	public void InitMaps()
	{
		System.out.println("Initializing Maps..\n");
		this.tile_map = new Tile[this.x][this.y];
		this.obj_map = new Object[this.x][this.y];
		
		//Arrays.fill(this.tile_map, null);
		//Arrays.fill(this.obj_map, null);
		
		for(int y = 0; y<this.y; y++)
		{
			for(int x = 0; x<this.x; x++)
			{

				Arrays.fill(this.tile_map[x], null);
				Arrays.fill(this.obj_map[x], null);
			}
		}
	}
	
	public void UpdateMaps()
	{
		for(int y = 0; y<this.y; y++)
		{
			for(int x = 0; x<this.x; x++)
			{

				Arrays.fill(this.tile_map[x], null);
				Arrays.fill(this.obj_map[x], null);
			}
		}
	}
	
	public Map(String map_name, int x, int y)
	{
		this.map_name = map_name;
		this.x = x;
		this.y = y;
	}
	
	public String[][] RenderMap()
	{
		//System.out.println("Rendering maps...\n");
		String[][] rendered_map = new String[this.x][this.y];
		
		//First do the tile maps
		for(int ty = 0; ty<this.y; ty++)
		{
			for(int tx = 0; tx<this.x; tx++)
			{
				if(this.tile_map[tx][ty] != null)
				{
					rendered_map[tx][ty] = "!";
				} 
				if (this.tile_map[tx][ty] == null) {
					rendered_map[tx][ty] = "#";
				}
			}
		}
		
		for(int oy = 0; oy<this.y; oy++)
		{
			for(int ox = 0; ox<this.x; ox++)
			{
				if(this.obj_map[ox][oy] != null)
				{
					rendered_map[ox][oy] = this.obj_map[ox][oy].ascii;
				}
			}
		}
		return rendered_map;
	}
	
	public String[] ConvertMap(String[][] t)
	{
		//System.out.println("Converting maps to displayable format..\n");
		String[] cmap;
		cmap = new String[this.y];
		
		String temp;
		temp = "";
		
		for(int y1 = 0; y1<this.y; y1++)
		{
			for(int x1 = 0; x1<this.x; x1++)
			{
				temp += t[y1][x1];
			}
			cmap[y1] = temp;
			//reset temp
			temp = "";
		}
		
		return cmap;
	}
	
	public void SetTile(Tile t)
	{
		this.tile_map[t.x][t.y] = t;
	}
	
	public void SetObj(Object o)
	{
		this.obj_map[o.x][o.y] =  o;
	}
}
