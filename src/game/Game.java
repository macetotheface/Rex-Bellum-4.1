package game;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class Game extends StateBasedGame{

	public static final String gamename = "Rex Bellum";
	//sets the game name to Rex Bellum
	public static final int menu = 0;
	//sets the int for the menu state to 0
	public static final int play = 1;
	//sets the int for the play state to 1
	public static final int choosefaction = 2;
	//sets the int for the choosefaction state to 2
	
	public Game(String gamename) throws SlickException{
		super(gamename);
		this.addState(new Menu(menu));
		this.addState(new Play(play));
		this.addState(new chooseFaction(choosefaction));
	}	
	public void initStatesList(GameContainer gc) throws SlickException {
		this.getState(menu).init(gc,this);
		this.getState(play).init(gc,this);
		this.getState(choosefaction).init(gc,this);
		this.enterState(menu);
	}
	public static void main(String[] args) {

		AppGameContainer appgc;
		
		try{
			appgc = new AppGameContainer(new Game(gamename));
			appgc.setDisplayMode(720,600, false);
			//starts the display 720 by 600
			appgc.setShowFPS(false);
			//no fps counter
			appgc.start();
		}catch(SlickException e){
			e.printStackTrace();
		}

	}

}
