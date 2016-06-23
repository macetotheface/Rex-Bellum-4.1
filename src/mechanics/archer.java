package mechanics;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

//unfinished
public class archer extends unit {
//private SpriteSheet = new SpriteSheet("/res/archer.png", 16,16);	
public archer() throws SlickException{
	this.setBaseRange(2);
	this.setBaseHealth(100);
	this.setBaseAttack(5);
	this.setBaseMoves(2);
	this.setCurrentAttack(this.getBaseAttack());
	this.setSheet(new SpriteSheet("/res/archer.png", 16,16));
	this.setPrice(100);
	this.setUpkeep(2);
}
}
