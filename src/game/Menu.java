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
	
	public Menu(int state){
	}
	
	public void init(GameContainer gc, StateBasedGame sbg)throws SlickException{
		castle = new Image("/res/castleScreen.png");
	}
	
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)throws SlickException{
		//g.drawImage(castle, 0,0,1.2f);
		castle.draw(0,0,1.2f);
		g.drawString(mouse, 50, 50);
		g.drawRect(50, 100, 200, 20);
		g.drawString("Play Game!", 110, 100);
		g.drawRect(50, 200, 200, 20);
		g.drawRect(50, 150, 200, 20);
		g.drawString("Lore", 135, 200);
		g.drawString("Instructions",100, 150);

	}
	public void update(GameContainer gc, StateBasedGame sbg, int delta)throws SlickException{
		Input input = gc.getInput();
		int xpos = Mouse.getX();
		int ypos = Mouse.getY();
		mouse = "Mouse position x:" + xpos + "y" + ypos; 
		
		if((xpos > 50 && xpos < 250) && (ypos > 480 && ypos < 500)){
			if(input.isMouseButtonDown(0)){
				sbg.enterState(2, new FadeOutTransition(), new FadeInTransition());
			}
		}
		if((xpos > 50 && xpos < 250) && (ypos > 430 && ypos < 450)){
			if(input.isMouseButtonDown(0)){
			System.out.println("hi");
			}
		}
		if((xpos > 50 && xpos < 250) && (ypos > 380 && ypos < 400)){
			if(input.isMouseButtonDown(0)){
			System.out.println("hey");
			}
		}
		
		
	}
	public int getID() {
		return 0;
	}
}
