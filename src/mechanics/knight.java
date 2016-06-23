package mechanics;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

public class knight extends unit {
	public knight() throws SlickException{
		this.setBaseRange(1);
		this.setBaseHealth(115);
		this.setBaseAttack(15);
		this.setBaseMoves(3);
		this.setCurrentAttack(this.getBaseAttack());
		this.setCurrentHealth(this.getBaseHealth());
		this.setCurrentMoves(this.getBaseMoves());
		this.setSheet(new SpriteSheet("/res/orcknight.png", 16,16));
		this.setPrice(100);
		this.setUpkeep(2);
		
	}
	public knight(int x) throws SlickException{
		this.setFactionType(x);
		
		
		
		
		this.setBaseRange(1);
		this.setBaseHealth(150);
		this.setBaseAttack(20);
		this.setBaseMoves(2);
		this.setCurrentAttack(this.getBaseAttack());
		this.setPrice(100);
		this.setCurrentHealth(this.getBaseHealth());
		this.setCurrentMoves(this.getBaseMoves());
		
		
		if(x==1)this.setSheet(new SpriteSheet("/res/horse.png", 16,16));
		if(x==2)this.setSheet(new SpriteSheet("/res/elfhorse.png", 16,16));
		if(x==3)this.setSheet(new SpriteSheet("/res/dwarfhorse.png", 16,16));
		if(x==4)this.setSheet(new SpriteSheet("/res/orchorse.png", 16,16));
		
		
		
		this.setUpkeep(2);
	}
}
