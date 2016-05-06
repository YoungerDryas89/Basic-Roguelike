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

import java.io.*;

public class Main
{
	public static void main(String[] args)
	{
		Level l = new Level("Test");
		l.InitializeLevel("Map 1", 10, 10);
		l.InitPlayer(1,1);
		
		boolean running;
		running = true;
		Console c =  System.console();
		
		while(running == true)
		{
			System.out.println("Player x: " + l.player.x);
			System.out.println("Player y: " + l.player.y);
			System.out.println(running);
			l.Update();
			String w = c.readLine();
			if(w == "Quit") running = false;
			//if(w == "N") l.player.Move(0, 1, l.level_map.tile_map, l.level_map.obj_map);
			switch(w)
			{
				case "Quit":
					running = false;
				case "N":
					l.player.Move(1, 0, l.level_map.tile_map, l.level_map.obj_map);
				case "W":
					l.player.Move(-1, 0, l.level_map.tile_map, l.level_map.obj_map);
				case "E":
					l.player.Move(1, 0, l.level_map.tile_map, l.level_map.obj_map);
				case "S":
					l.player.Move(0, -1, l.level_map.tile_map, l.level_map.obj_map);
				default:
					//none
			}
			if(running == false) break;
		}
		
		l.Clean();
		l = null;
		
	}
	
}
