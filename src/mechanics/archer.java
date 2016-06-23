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
	this.setCurrentHealth(this.getBaseHealth());
	this.setCurrentMoves(this.getBaseMoves());
	this.setSheet(new SpriteSheet("/res/archer.png", 16,16));
	this.setPrice(100);
	this.setUpkeep(2);
}
public archer(int x) throws SlickException{
	this.setFactionType(x);
	
	
	
	
	this.setBaseRange(1);
	this.setBaseHealth(150);
	this.setBaseAttack(20);
	this.setBaseMoves(2);
	this.setCurrentAttack(this.getBaseAttack());
	this.setPrice(100);
	this.setCurrentHealth(this.getBaseHealth());
	this.setCurrentMoves(this.getBaseMoves());
	
	
	if(x==1)this.setSheet(new SpriteSheet("/res/archer.png", 16,16));
	if(x==2)this.setSheet(new SpriteSheet("/res/elfarcher.png", 16,16));
	if(x==3)this.setSheet(new SpriteSheet("/res/dwarfarcher.png", 16,16));
	if(x==4)this.setSheet(new SpriteSheet("/res/orcarcher.png", 16,16));
	
	
	
	this.setUpkeep(2);
}
}
