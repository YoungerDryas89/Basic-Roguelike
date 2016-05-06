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
class Level
{
	public String name;
	private List<Tile> tile_assets;
	private List<Object> object_assets;
	public Map level_map;
	public Object player;
	
	public Level(String name)
	{
		this.name = name;
	}
	
	public void InitPlayer(int x, int y)
	{
		player = new Object("@", x, y);
	}
	
	public void InitializeLevel(String mapName, int x, int y)
	{
		//Initialize the map
		level_map = new Map(mapName, x, y);
		level_map.InitMaps();
		tile_assets = new ArrayList<Tile>();
		object_assets = new ArrayList<Object>();
	}
	
	public void Update()
	{
		level_map.UpdateMaps();
		Tile[] t = new Tile[this.tile_assets.size()];
		Object[] o = new Object[this.object_assets.size()];
		
		t = this.tile_assets.toArray(t);
		o = this.object_assets.toArray(o);
		
		this.level_map.DrawAssets(t, o);
		this.level_map.SetObj(this.player);
		String[] cmap = level_map.ConvertMap(level_map.RenderMap());
		for(int y = 0; y<level_map.y; y++)
		{
			System.out.println(cmap[y]);
		}
	}
	
	public void Clean()
	{
		this.tile_assets.clear();
		this.object_assets.clear();
	}
	
	public void AddTile(Tile t)
	{
		this.tile_assets.add(t);
	}
}
