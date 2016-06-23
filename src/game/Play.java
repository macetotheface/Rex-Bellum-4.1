package game;


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
	private int tileID = 23;
	//private Image holder;
	private TiledMap map;
	//private boolean quit = false;
	//private int[] duration = {200,200};
	//private float positionX = 0;
	//private float positionY = 0;
<<<<<<< HEAD
	//chooseFaction faction = new chooseFaction(1);
	
=======

>>>>>>> refs/remotes/origin/master
	private int playerFactionType = 2;
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
	public String mouse = "no input yet";

	public Play(int state) throws SlickException{
	  //playerFactionType = FactionNum;
	}


	
	public void init(GameContainer gc, StateBasedGame sbg)throws SlickException{	
		archer archerunit = new archer();
		knight horseunit = new knight();
		swordsman knightunit = new swordsman();
		archerani = new Animation(archerunit.getSheet(), 250);
		horseani = new Animation(horseunit.getSheet(), 250);
		knightani = new Animation(knightunit.getSheet(), 250);
		map = new TiledMap("res/map.tmx");

		uiElements[0] = new Image("/res/Clock.png");
		uiElements[1] = new Image("/res/Gold.png");
		uiElements[2] = new Image("/res/Wealth.png");
		uiElements[3] = new Image("/res/Troops.png");
		uiElements[4] = new Image("/res/Slaves.png");
		//holder = new Image("res/placeholder.png");
		
		this.playerFaction = new faction(true, 1);
		this.aiFaction1 = new faction(false, 2);
		this.aiFaction2 = new faction(false, 3);
		this.aiFaction3 = new faction(false, 4);
		this.barracksStats = new barracks();
		this.farmStats = new farm();
		this.marketStats = new market();
		this.tileArray = new tile [35][35];

		//start();
		test();
	}

	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)throws SlickException{
		factionCrest = getImage(playerFactionType);
		factionKing = getKing(playerFactionType);

		//g.scale(1f, 1f);
		//g.scale(Display.getWidth()/720, Display.getHeight()/600);
<<<<<<< HEAD
		map.render(0,0,0,-3,560,560);
=======
		map.render(0,0,0,0,720,600);
>>>>>>> refs/remotes/origin/master
		//holder.draw(100,100,32,32);
		//g.draw()
		g.drawString(mouse, 50, 50);

		g.drawRect(560, 0, 158, 47);
		g.drawRect(560, 48, 158, 551);
		g.drawRect(0, 560, 560, 47);
		g.drawRect(560, 48, 158, 100);
		g.drawRect(560, 149, 158, 25);
		g.drawRect(560, 174, 75, 75);
		g.drawRect(560, 174, 158, 175);
		g.drawRect(560, 349, 158, 140);

		factionCrest.draw(567, 0, 45, 45);

		uiElements[0].draw(10,566,35,35);
		uiElements[1].draw(110,567,35,35);
		uiElements[2].draw(225,567,35,35);
		uiElements[3].draw(315,567,35,35);
		uiElements[4].draw(445,567,35,35);
		

		g.drawString(factionKing, 620, 10);

		terrain current = new terrain(tileID);
		printTerrain(current, g);
		printStats(incomeTotal, bank, manpower, troopLimit, troopCount, turnCount, g);

		archerani.draw(archerx,archery);
		horseani.draw(100,100);
		knightani.draw(300,300);


	}

	public void update(GameContainer gc, StateBasedGame sbg, int delta)throws SlickException{


		//input = gc.getInput();
		int terrainInput = map.getLayerIndex("InputLayer");
		xpos = Mouse.getX();
		ypos = Mouse.getY();
		mouse = "Mouse position x:" + xpos + "y" + ypos; 
		boolean isMouseClicked = gc.getInput().isMousePressed(Input.MOUSE_LEFT_BUTTON);
<<<<<<< HEAD
		int tileLocationX = (xpos)/16;
		int tileLocationY = (int) ((600-ypos)/(16));
		//if(tileLocationY > 16) tileLocationY+=2;
			 // if(tileLocationY < 16) tileLocationY--;
		if(isMouseClicked == true) {
			
=======
		int tileLocationX = Math.round(xpos)/map.getTileWidth();
		int tileLocationY = Math.round(600-ypos)/(map.getTileHeight());
		
		if(isMouseClicked == true) {
>>>>>>> refs/remotes/origin/master
			tileID = (map.getTileId(tileLocationX,tileLocationY,terrainInput))-1;
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
	
	public void start(){
		int factionNum;
		int terrainNum;
		for (int i = 0; i < tileArray.length; i++){
			for (int j = 0; j < tileArray.length; j++){
				//Make some way to get the faction number and the terrain from Tiled
				//Get faction number from math
			}
		}
	}

	//Created Methods
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

	private void endTurn(){
		playerFaction.endTurn();
		aiFaction1.endTurn();
		aiFaction2.endTurn();
		aiFaction3.endTurn();

		aiFaction1.decision(tileArray);
		aiFaction2.decision(tileArray);
		aiFaction3.decision(tileArray);
	}
	public void printTerrain(terrain x, Graphics g) throws SlickException{
		try{
			Image z = new Image(x.getImage());
			z.draw(561, 350, 157, 55);
		}catch(NullPointerException npe){

		}
		g.drawString((int)x.getDefenderMod() + " Defender mod", 566, 410);
		g.drawString((int)x.getArcherMod() + " Archer mod", 566, 425);
		g.drawString(x.getBonusBarracks() + " + Barracks", 566, 440);
		g.drawString(x.getBonusMarket() + "  + Markets", 566, 455);
		g.drawString(x.getBonusFarm() + "  + Farms", 566, 470);
	}
	
	public void test(){
		tileArray[0][0] = new tile(1,14);
		aiFaction1.factionTest(tileArray);
		System.out.println(tileArray[0][0].getFaction() + "Test 2");
	}

	public int getID() {
		return 1;
	}
}
