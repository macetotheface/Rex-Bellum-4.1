package game;

import java.awt.Font;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.newdawn.slick.*;
import org.newdawn.slick.font.effects.ColorEffect;
import org.newdawn.slick.state.*;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

public class chooseFaction extends BasicGameState{

	public String mouse = "no input yet";
	Image humancity;
	Image elfcity;
	Image orccity;
	Image dwarfcity;
	Font font;
	TrueTypeFont ttf;
	TrueTypeFont ttf2;
	
	
	public chooseFaction(int state){
		
	}
	
	public void init(GameContainer gc, StateBasedGame sbg)throws SlickException{
		humancity = new Image("/res/Humancity.jpg");
		elfcity = new Image("/res/Elfcity.jpg");
		dwarfcity = new Image("/res/Dwarfcity.jpg");
		orccity = new Image("/res/Orccity.jpg");
		Font afont = new Font("Verdana",Font.BOLD, 24);
		Font bfont = new Font("verdana", Font.ROMAN_BASELINE, 30);
		//afont.setColor(Color.red);
		ttf = new TrueTypeFont(afont, false);
		ttf2 = new TrueTypeFont(bfont, false);
		//font = ("Verdana", Font.BOLD, 32);
		//ttf = (font, true);
	}
	
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)throws SlickException{
		//g.drawImage(castle, 0,0,1.2f);
		humancity.draw(0,0,360,300);
		elfcity.draw(0,300,360,300);
		dwarfcity.draw(360, 0, 360, 300);
		orccity.draw(360, 300, 360, 300);
		g.drawString(mouse, 50, 50);
		//g.drawString("play humans", 100, 150);
		ttf.drawString(260, 280, "Choose Faction", Color.white);
		ttf2.drawString(120, 140, "Humans", Color.cyan);
		ttf2.drawString(490, 140, "Dwarves", Color.lightGray);
		ttf2.drawString(140, 460, "Elves", Color.green);
		ttf2.drawString(510, 460, "Orcs", Color.red);
		//g.drawRect(0, 0, 360, 300);
		//g.drawRect(0, 300, 360, 300);
		//g.drawRect(360, 0, 360, 300);
		//g.drawRect(360, 300, 360, 300);
		//g.drawRect(50, 100, 200, 20);
		//g.drawString("Play Game!", 100, 100);

	}
	public void update(GameContainer gc, StateBasedGame sbg, int delta)throws SlickException{
		Input input = gc.getInput();
		int xpos = Mouse.getX();
		int ypos = Mouse.getY();
		mouse = "Mouse position x:" + xpos + "y" + ypos; 
		
		
		if((xpos > 0 && xpos < 360) && (ypos > 0 && ypos < 300)){
			if(input.isMouseButtonDown(0)){
				//set faction elf
				sbg.enterState(1, new FadeOutTransition(), new FadeInTransition());
			}
		}
		if((xpos > 360 && xpos < 720) && (ypos > 0 && ypos < 300)){
			if(input.isMouseButtonDown(0)){
				//set faction orc
				sbg.enterState(1, new FadeOutTransition(), new FadeInTransition());
			}
		}
		if((xpos > 0 && xpos < 360) && (ypos > 300 && ypos < 600)){
			if(input.isMouseButtonDown(0)){
				//set faction human
				sbg.enterState(1, new FadeOutTransition(), new FadeInTransition());
			}
		}
		if((xpos > 360 && xpos < 720) && (ypos > 300 && ypos < 600)){
			if(input.isMouseButtonDown(0)){
				//set faction dwarf
				sbg.enterState(1, new FadeOutTransition(), new FadeInTransition());
			}
		}
		
		
	}
	public int getID() {
		return 2;
	}
}
