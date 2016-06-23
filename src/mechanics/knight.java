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
		this.setSheet(new SpriteSheet("/res/orcknight.png", 16,16));
		this.setPrice(100);
		this.setUpkeep(2);
	}
}
