package game;

import java.util.ArrayList; 
import java.util.ArrayList;
import java.util.List;
import org.lwjgl.*;
import org.lwjgl.input.Mouse;
import mechanics.*;
import org.lwjgl.opengl.Display;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;
import org.newdawn.slick.tiled.*;

public class Play extends BasicGameState{
	private Animation archerani;
	private Animation horseani;
	private Animation knightani;
	
	//private boolean mousePressed;
	
	//private Input input;
	private int archerx = 200;
	private int archery = 200;
	private int xpos = 200;
	private int ypos = 200;
	private int tileID;
	//private Image holder;
	private TiledMap map;
	//private boolean quit = false;
	//private int[] duration = {200,200};
	//private float positionX = 0;
	//private float positionY = 0;
	
	private int playerFactionType = 4;
	private Image factionCrest = null;
	private String factionKing = null;
	private faction playerFaction = new faction(true);
	private faction aiFaction1 = new faction(false);
	private faction aiFaction2 = new faction(false);
	private faction aiFaction3 = new faction(false);
	private barracks barracksStats = new barracks();
	private farm farmStats = new farm();
	private market marketStats = new market();
	private tile[][] tileArray = new tile [35][35];
	private int fuckGithub;
	private int killNiggers;
	public Play(int state) throws SlickException{
		//
	}
	
	public String mouse = "no input yet";
	public void init(GameContainer gc, StateBasedGame sbg)throws SlickException{	
		archer archerunit = new archer();
		knight horseunit = new knight();
		swordsman knightunit = new swordsman();
		archerani = new Animation(archerunit.getSheet(), 250);
		horseani = new Animation(horseunit.getSheet(), 250);
		knightani = new Animation(knightunit.getSheet(), 250);
		map = new TiledMap("res/map.tmx");
		
		
		//holder = new Image("res/placeholder.png");
	}
	
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)throws SlickException{
		factionCrest = getImage(playerFactionType);
		factionKing = getKing(playerFactionType);
		//g.scale(1f, 1f);
		//g.scale(Display.getWidth()/720, Display.getHeight()/600);
		map.render(0,0,0,-3,720,600);
		//holder.draw(100,100,32,32);
		//g.draw()
		g.drawString(mouse, 50, 50);
		g.drawRect(560, 0, 158, 47);
		g.drawRect(560, 48, 158, 551);
		g.drawRect(0, 0, 559, 47);
		g.drawRect(560, 48, 158, 100);
		g.drawRect(560, 149, 158, 25);
		g.drawRect(560, 174, 75, 75);
		g.drawRect(560, 174, 158, 250);
		archerani.draw(archerx,archery);
		horseani.draw(100,100);
		knightani.draw(300,300);
		
	
	}
	public void update(GameContainer gc, StateBasedGame sbg, int delta)throws SlickException{
		
		//input = gc.getInput();
		int Water = map.getLayerIndex("bridge");
		xpos = Mouse.getX();
		ypos = Mouse.getY();
		mouse = "Mouse position x:" + xpos + "y" + ypos; 
		boolean isMouseClicked = gc.getInput().isMousePressed(Input.MOUSE_LEFT_BUTTON);
		int tileLocationX = Math.round(xpos)/map.getTileWidth();
		int tileLocationY = Math.round(600-ypos)/(map.getTileHeight()+3);
		if(isMouseClicked == true && ypos<560 && ypos>0 && xpos>0 && xpos<560) {
			tileID = map.getTileId(tileLocationX,tileLocationY,Water);
			//gc.sleep(16);
			System.out.println(tileID);
		}
		if(isMouseClicked == true && xpos==(archerx) && (600-ypos)==(archery)){
			System.out.println("hi");
			//if(isMouseClicked == true){
				//System.out.println("hello");
				//archerx=xpos;
				//archery=(600-ypos);
			}
		//}
	}
	
	public Image getImage(int x) throws SlickException {
		Image y = null;

		switch (x) {
		case 1:
			// Human
			y = new Image("/res/Human_Faction_Crest.png");
			break;
		case 2:
			// Elf
			y = new Image("/res/Elf_Faction_Crest.png");
			break;
		case 3:
			// Dwarf
			y = new Image("/res/Dwarf_Faction_Crest.png");
			break;
		case 4:// Orc
			y = new Image("/res/Orc_Faction_Crest.png");
			break;
		}
		return y;
	}
	
	public String getKing(int x) throws SlickException{
		String y = null;
		
		switch(x){
		case 1:
			//Human
			y = "King";
			break;
		case 2:
			//Elf
			y ="Tarostar";
			break;
		case 3:
			//Dwarf
			y = "Ra' Dawi";
			break;
		case 4://Orc
			y = "Kri-krisur";
			break;
	}
		return y;
	}
	
	//Created Methods
		private void endTurn(){
			playerFaction.endTurn();
			aiFaction1.endTurn();
			aiFaction2.endTurn();
			aiFaction3.endTurn();
			
			aiFaction1.decision();
			aiFaction2.decision();
			aiFaction3.decision();
		}
		
	public int getID() {
		return 1;
	}
}
