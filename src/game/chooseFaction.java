package game;

import java.awt.Font;
import org.lwjgl.input.Mouse;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

public class chooseFaction extends BasicGameState{

	Image humancity;
	//Create the humancity variable to store the texture
	Image elfcity;
	//Create the elfcity variable to store the texture
	Image orccity;
	//Create the orccity variable to store the texture
	Image dwarfcity;
	//Create the dwarfcity variable to store the texture
	Font font;
	//Create a new font variable named font
	TrueTypeFont ttf;
	//Create a new truetypefont named ttf
	TrueTypeFont ttf2;
	//Create a new truetypefont named ttf2
	
	public chooseFaction(int state){
		
	}
	
	public void init(GameContainer gc, StateBasedGame sbg)throws SlickException{
		humancity = new Image("/res/Humancity.jpg");
		//initialize humancity
		elfcity = new Image("/res/Elfcity.jpg");
		//initialize elfcity
		dwarfcity = new Image("/res/Dwarfcity.jpg");
		//initialize dwarfcity
		orccity = new Image("/res/Orccity.jpg");
		//initialize orccity
		Font afont = new Font("Verdana",Font.BOLD, 24);
		//Initialize afont with the font Verdana and bold size 24
		Font bfont = new Font("verdana", Font.ROMAN_BASELINE, 30);
		//Initialize bfont withe the font Verdana and Roman Baseline size 30
		ttf = new TrueTypeFont(afont, false);
		//Initialize ttf to afont
		ttf2 = new TrueTypeFont(bfont, false);
		//Initialize ttf2 to bfont
	}
	
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)throws SlickException{
		humancity.draw(0,0,360,300);
		//draws the humancity to the screen at 0,0 size 360 by 300
		elfcity.draw(0,300,360,300);
		//draws the elfcity to the screen at 0,300 size 360 by 300
		dwarfcity.draw(360, 0, 360, 300);
		//draws the dwarfcity to the screen at 360,0 size 360 by 300
		orccity.draw(360, 300, 360, 300);
		//draws the orccity to the screen at 360,300 size 360 by 300
		ttf.drawString(260, 280, "Choose Faction", Color.white);
		//draws a string saying Choose Faction to the screen at 260,280 colored white
		ttf2.drawString(120, 140, "Humans", Color.cyan);
		//draws a string saying Humans to the screen at 120,140 colored cyan
		ttf2.drawString(490, 140, "Dwarves", Color.lightGray);
		//draws a string saying Dwarves to the screen at 490, 140 colored lightGray
		ttf2.drawString(140, 460, "Elves", Color.green);
		//draws a string saying Elves to the screen at 140, 460 colored green
		ttf2.drawString(510, 460, "Orcs", Color.red);
		//draws a string saying Orcs to the screen at 510, 460 colored red
	}
	public void update(GameContainer gc, StateBasedGame sbg, int delta)throws SlickException{
		Input input = gc.getInput();
		//Initializes input and sets it equal to the gc input
		int xpos = Mouse.getX();
		//Initializes xpos and sets it equal to the mouses x position
		int ypos = Mouse.getY();
		//Initializes xpos and sets it equal to the mouses y position
		if((xpos > 0 && xpos < 360) && (ypos > 0 && ypos < 300)){
			if(input.isMouseButtonDown(0)){
				//set faction elf
				sbg.enterState(1, new FadeOutTransition(), new FadeInTransition());
				//enters the play class with transition
			}
		}
		if((xpos > 360 && xpos < 720) && (ypos > 0 && ypos < 300)){
			if(input.isMouseButtonDown(0)){
				//set faction orc
				sbg.enterState(1, new FadeOutTransition(), new FadeInTransition());
				//enters the play class with transition
			}
		}
		if((xpos > 0 && xpos < 360) && (ypos > 300 && ypos < 600)){
			if(input.isMouseButtonDown(0)){
				//set faction human
				sbg.enterState(1, new FadeOutTransition(), new FadeInTransition());
				//enters the play class with transition
			}
		}
		if((xpos > 360 && xpos < 720) && (ypos > 300 && ypos < 600)){
			if(input.isMouseButtonDown(0)){
				//set faction dwarf
				sbg.enterState(1, new FadeOutTransition(), new FadeInTransition());
				//enters the play class with transition
			}
		}
		
		
	}
	public int getID() {
		return 2;
	}
}
