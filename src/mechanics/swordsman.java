package mechanics;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

public class swordsman extends unit {
	public swordsman() throws SlickException{
	
		this.setBaseRange(1);
		this.setBaseHealth(150);
		this.setBaseAttack(20);
		this.setBaseMoves(2);
		this.setCurrentAttack(this.getBaseAttack());
		this.setPrice(100);
		this.setCurrentHealth(this.getBaseHealth());
		this.setCurrentMoves(this.getBaseMoves());
		this.setSheet(new SpriteSheet("/res/elfknight.png", 16,16));
		this.setUpkeep(2);
	}
	public swordsman(int x) throws SlickException{
		this.setFactionType(x);
		
		
		
		
		this.setBaseRange(1);
		this.setBaseHealth(150);
		this.setBaseAttack(20);
		this.setBaseMoves(2);
		this.setCurrentAttack(this.getBaseAttack());
		this.setPrice(100);
		this.setCurrentHealth(this.getBaseHealth());
		this.setCurrentMoves(this.getBaseMoves());
		
		
		if(x==1)this.setSheet(new SpriteSheet("/res/knight.png", 16,16));
		if(x==2)this.setSheet(new SpriteSheet("/res/elfknight.png", 16,16));
		if(x==3)this.setSheet(new SpriteSheet("/res/dwarfknight.png", 16,16));
		if(x==4)this.setSheet(new SpriteSheet("/res/orcknight.png", 16,16));
		
		
		
		this.setUpkeep(2);
	}
}
