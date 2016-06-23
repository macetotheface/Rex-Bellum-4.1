package game;


import java.util.List;
import java.util.Scanner;

import org.lwjgl.*;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import mechanics.*;
import org.lwjgl.opengl.Display;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;
import org.newdawn.slick.tiled.*;

public class Play extends BasicGameState{

	//private boolean mousePressed;

	//private Input input;
	private int xpos = 200;
	private int ypos = 200;
	private int tileID = 23;
	//private Image holder;
	private TiledMap map;
	//private boolean quit = false;
	//private int[] duration = {200,200};
	//private float positionX = 0;
	//private float positionY = 0;



	private Image barracks;
	private Image market;
	private Image farm;

	//chooseFaction faction = new chooseFaction(1);

	private int playerFactionType = 1;
	private Image factionCrest = null;
	private String factionKing = null;
	private faction playerFaction;
	private faction aiFaction1;
	private faction aiFaction2;
	private faction aiFaction3;
	private barracks barracksStats;
	private farm farmStats;
	private market marketStats;
	private Image[] uiElements= new Image[5];
	private tile[][] tileArray;
	private int turnCount=0;
	private int troopCount=0;
	private int troopLimit=0;
	private int incomeTotal=0;
	private int bank =0;
	private int manpower = 0;
	private boolean clickedUnit = false;
	private int tileX=0;
	private int tiley =0;
	private int oldX;
	private int oldY;
	private Input input;
	private boolean moved;
	public String mouse = "no input yet";

	public Play(int state) throws SlickException{
	}


	public void init(GameContainer gc, StateBasedGame sbg)throws SlickException{	
		barracks = new Image("/res/barracks.png");
		farm = new Image("/res/farm.png");
		market = new Image("/res/market.png");
		map = new TiledMap("res/map.tmx");

		uiElements[0] = new Image("/res/Clock.png");
		uiElements[1] = new Image("/res/Gold.png");
		uiElements[2] = new Image("/res/Wealth.png");
		uiElements[3] = new Image("/res/Troops.png");
		uiElements[4] = new Image("/res/Slaves.png");
		//holder = new Image("res/placeholder.png");

		this.playerFaction = new faction(true, 1, tileArray);
		this.aiFaction1 = new faction(false, 2, tileArray);
		this.aiFaction2 = new faction(false, 3, tileArray);
		this.aiFaction3 = new faction(false, 4, tileArray);
		this.barracksStats = new barracks();
		this.farmStats = new farm();
		this.marketStats = new market();
		this.tileArray = new tile [35][35];
		oldX = 0;
		oldY = 0;
		moved = false;
		intializeTiles();
		tileArray[19][14].setHasUnit(true);
		swordsman a  = new swordsman(4);
		tileArray[19][14].setUnitOnTile(a);

		tileArray[16][19].setHasUnit(true);
		swordsman b  = new swordsman(1);
		tileArray[16][19].setUnitOnTile(b);

		tileArray[15][15].setHasUnit(true);
		swordsman c  = new swordsman(2);
		tileArray[15][15].setUnitOnTile(c);

	}

	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)throws SlickException{
		factionCrest = getImage(playerFactionType);
		factionKing = getKing(playerFactionType);

		//g.scale(1f, 1f);
		//g.scale(Display.getWidth()/720, Display.getHeight()/600);

		//map.render(0,0,0,-3,560,560);


		map.render(0,0,0,0,720,600);
		//holder.draw(100,100,32,32);
		//g.draw()
		g.drawString(mouse, 50, 50);
		g.drawRect(560, 489, 53, 53);
		market.draw(560,489,53,53);
		g.drawRect(613, 489, 53, 53);
		farm.draw(613,489,53,53);
		g.drawRect(666, 489, 53, 53);
		barracks.draw(666,489,53,53);
		g.drawRect(560, 0, 158, 47);
		g.drawRect(560, 48, 158, 551);
		g.drawRect(0, 560, 560, 47);
		g.drawRect(560, 48, 158, 100);
		g.drawRect(560, 149, 158, 25);
		g.drawRect(560, 174, 75, 75);
		g.drawRect(635, 174, 85, 75);
		g.drawRect(560, 174, 158, 175);
		g.drawRect(560, 349, 158, 140);

		factionCrest.draw(567, 0, 45, 45);

		uiElements[0].draw(10,566,35,35);
		uiElements[1].draw(110,567,35,35);
		uiElements[2].draw(225,567,35,35);
		uiElements[3].draw(315,567,35,35);
		uiElements[4].draw(445,567,35,35);

		g.drawString("Move Unit", 638, 202);
		g.drawString(factionKing, 620, 10);
		g.drawString("End Turn", 605, 560);
		terrain current = new terrain(tileID);
		printTerrain(current, g, tileArray[tileX][tiley]);
		printStats(incomeTotal, bank, manpower, troopLimit, troopCount, turnCount, g);


		try{
			unitUI(tileArray[tileX][tiley].getUnitOnTile(),g);
		}catch(NullPointerException npe){

		}
		try{
			drawUnit(g);
		}catch(NullPointerException npe){

		}
	}

	public void update(GameContainer gc, StateBasedGame sbg, int delta)throws SlickException{

		input = gc.getInput();

		if(input.isKeyPressed(Keyboard.KEY_UP) && moved == true){
			System.out.println("Has unit on old unit:" + tileArray[oldX][oldY].isHasUnit());
			playerFaction.movePlayer(oldX, oldY, oldX, oldY - 1);
			moved = false;
			tileArray = playerFaction.getTileArray();
			System.out.print("Has unit on new unit:" + tileArray[oldX][oldY + 1].isHasUnit());
		}
		else if(input.isKeyPressed(Keyboard.KEY_DOWN) && moved == true){
			playerFaction.movePlayer(oldX, oldY, oldX, oldY + 1);
			moved = false;
			tileArray = playerFaction.getTileArray();
			moved = false;
		}
		else if(input.isKeyPressed(Keyboard.KEY_LEFT) && moved == true){
			playerFaction.movePlayer(oldX, oldY, oldX - 1, oldY);
			moved = false;
			tileArray = playerFaction.getTileArray();
			moved = false;
		}
		else if(input.isKeyPressed(Keyboard.KEY_RIGHT) && moved == true){
			playerFaction.movePlayer(oldX, oldY, oldX + 1, oldY);
			moved = false;
			tileArray = playerFaction.getTileArray();
			moved = false;
		}

		//input = gc.getInput();
		int terrainInput = map.getLayerIndex("InputLayer");
		xpos = Mouse.getX();
		ypos = Mouse.getY();
		mouse = "Mouse position x:" + xpos + "y" + ypos; 
		boolean isMouseClicked = gc.getInput().isMousePressed(Input.MOUSE_LEFT_BUTTON);

		if(isMouseClicked == true) {

			int tileLocationX = Math.round(xpos)/map.getTileWidth();
			int tileLocationY = Math.round(600-ypos)/(map.getTileHeight());

			if(isMouseClicked == true && xpos < 570 && ypos < 560) {

				tileID = (map.getTileId(tileLocationX,tileLocationY,terrainInput))-1;
				tileX =tileLocationX;
				tiley = tileLocationY;
				if(tileArray[tileLocationX ][tileLocationY].isHasUnit()== true){
					tileX =tileLocationX;
					tiley = tileLocationY;
				}
				System.out.println(tileID);
			}
		}
		if(isMouseClicked == true && xpos > 560 && xpos < 613 && 111 > ypos && ypos< 164) {
			//market
			playerFaction.buildMarket(tileX, tiley, tileArray);
			//System.out.println("hey");
		}
		if(isMouseClicked == true && xpos > 613 && xpos < 666 && 111 > ypos && ypos< 164) {
			//farm
			playerFaction.buildFarm(tileX, tiley, tileArray);
			//System.out.println("hoy");
		}
		if(isMouseClicked == true && xpos > 666 && xpos < 720 && 111 > ypos && ypos< 164) {
			//barracks
			playerFaction.buildBarracks(tileX, tiley, tileArray);
			//System.out.println("hiy");
		}
		if(isMouseClicked == true && xpos > 560 && xpos < 720 && ypos > 0 && ypos < 111) {
			//end turn
			endTurn();
			//System.out.println("ended");
		}
		if(isMouseClicked == true && xpos > 635 && xpos < 720 && ypos > 350 && ypos < 526) {
			//move unit
			oldX = tileX;
			oldY = tiley;
			System.out.println("Move");
			moved = true;
		}
	}
	//if(isMouseClicked == true && xpos==(archerx) && (600-ypos)==(archery)){
	//System.out.println("hi");
	//if(isMouseClicked == true){
	//System.out.println("hello");
	//archerx=xpos;
	//archery=(600-ypos);


	//}



	//Created Methods

	private void intializeTiles(){
		int factionNum = 0;
		for (int x = 0; x<35;x++){
			for (int y = 0; y<35;y++){
				if (x <= 16 && y<=21)factionNum = 2;
				if (x > 16 && y <=14)factionNum = 3;
				if (x <= 16 && y>21)factionNum = 1;
				if (x > 16 && y>14)factionNum = 4;

				tileArray[x][y] = new tile (factionNum, map.getTileId(x , y , 0));

			}
		}
	}
	private void unitUI(unit onT,Graphics g){
		Animation unitAni= new Animation (onT.getSheet(),250);
		g.drawString("Health: " + onT.getCurrentHealth(), 565, 250);
		unitAni.draw(562, 175, 70, 70);
		g.drawString("Moves: " + onT.getCurrentMoves(), 565, 270);
		g.drawString("Damage: " + onT.getCurrentAttack(), 565, 290);
		g.drawString("Range: " + onT.getCurrentRange(), 565, 310);
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
	private void printStats(int income, int bank, int manpower, int menCap,int men, int turn,Graphics g ){
		g.drawString("Turn "+Integer.toString(turn), 50, 578);
		g.drawString(Integer.toString(bank) + " Gold", 145, 578);
		g.drawString(Integer.toString(income) + " G/T", 265, 578);
		g.drawString(Integer.toString(manpower) + " ManPwr", 345, 578);
		g.drawString(Integer.toString(men) + "/" + Integer.toString(menCap) , 485, 578);
	}

	private void endTurn() throws SlickException{
		playerFaction.endTurn();
		aiFaction1.endTurn();
		aiFaction2.endTurn();
		aiFaction3.endTurn();

		aiFaction1.decision(tileArray);
		aiFaction2.decision(tileArray);
		aiFaction3.decision(tileArray);
	}

	private void drawUnit(Graphics g){
		for (int x = 0; x<35;x++){
			for (int y = 0; y<35;y++){
				if(tileArray[x][y].isHasUnit() == true){
					g.drawAnimation(new Animation(tileArray[x][y].getUnitOnTile().getSheet(), 250), x*16, y*16);
				}

			}
		}
	}
	public void printTerrain(terrain x, Graphics g,tile t) throws SlickException{
		try{
			Image z = new Image(x.getImage());

			z.draw(561, 350, 157, 55);
			Image b = null;
			if(t.getFaction()== 1) b = new Image("/res/Human_Faction_Crest.png") ;
			if(t.getFaction()== 2) b = new Image("/res/Elf_Faction_Crest.png") ;
			if(t.getFaction()== 3) b = new Image("/res/Dwarf_Faction_Crest.png") ;
			if(t.getFaction()== 4) b = new Image("/res/Orc_Faction_Crest.png") ;

			b.draw(665, 355, 45, 45);
		}catch(NullPointerException npe){

		}
		g.drawString((int)x.getDefenderMod() + " Defender mod", 566, 410);
		g.drawString((int)x.getArcherMod() + " Archer mod", 566, 425);
		g.drawString(x.getBonusBarracks() + " + Barracks", 566, 440);
		g.drawString(x.getBonusMarket() + "  + Markets", 566, 455);
		g.drawString(x.getBonusFarm() + "  + Farms", 566, 470);
	}

	public int getID() {
		return 1;
	}
}
