package game;

import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

public class Menu extends BasicGameState{

	public String mouse = "no input yet";
	Image castle;
	//Image holder for the castle png
	
	public Menu(int state){
	}
	
	public void init(GameContainer gc, StateBasedGame sbg)throws SlickException{
		castle = new Image("/res/castleScreen.png");
		//Initializes the castle
	}
	
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)throws SlickException{
		castle.draw(0,0,1.2f);
		//draws the castle at 0,0 and scaled by 1.2
		g.drawString(mouse, 50, 50);
		g.drawRect(50, 100, 200, 20);
		//draws the play game box
		g.drawString("Play Game!", 110, 100);
		//writes play game in the box
		g.drawRect(50, 200, 200, 20);
		//draws the lore box
		g.drawRect(50, 150, 200, 20);
		//draws the instructions box
		g.drawString("Lore", 135, 200);
		//writes lore in the box
		g.drawString("Instructions",100, 150);
		//writes instructions in the box

	}
	public void update(GameContainer gc, StateBasedGame sbg, int delta)throws SlickException{
		Input input = gc.getInput();
		//Initializes the input to the gc input
		int xpos = Mouse.getX();
		//initializes the xpos to the x of the mouse
		int ypos = Mouse.getY();
		//initializes the ypos to the y of the mouse
		mouse = "Mouse position x:" + xpos + "y" + ypos; 
		
		if((xpos > 50 && xpos < 250) && (ypos > 480 && ypos < 500)){
			if(input.isMouseButtonDown(0)){
				sbg.enterState(2, new FadeOutTransition(), new FadeInTransition());
				//enters the choosefaction state/class
			}
		}
		if((xpos > 50 && xpos < 250) && (ypos > 430 && ypos < 450)){
			if(input.isMouseButtonDown(0)){
				//Instructions
				System.out.println("hi");
			}
		}
		if((xpos > 50 && xpos < 250) && (ypos > 380 && ypos < 400)){
			if(input.isMouseButtonDown(0)){
				//Lore
				System.out.println("hey");
			}
		}
		
		
	}
	public int getID() {
		return 0;
	}
}
