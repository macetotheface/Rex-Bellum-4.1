package mechanics;
public class combatMechanics {

	private unit attacker;			//The unit that attacks
	private unit defender;			//The unit that is defending
	private terrain defGround;		//The terrain the defending unit is standing on
	private terrain atkGround;		//The terrain the attacking unit is attacking from
	
	//If it is a melee unit attacking
	combatMechanics(unit attackerUnit, unit defenderUnit, terrain defGroundTerrain){
		this.attacker = attackerUnit;
		this.defender = defenderUnit;
		this.defGround = defGroundTerrain;
		this.atkGround = null;
		meleeAttack();			
	}
	
	//If it is an archer attacking from range
	combatMechanics(unit attackerUnit, unit defenderUnit, terrain defGroundTerrain, terrain atkGroundTerrain){
		this.attacker = attackerUnit;
		this.defender = defenderUnit;
		this.defGround = defGroundTerrain;
		this.atkGround = atkGroundTerrain;
		archerAttack();
	}
	//When a melee unit attacks 
	private void meleeAttack(){
		this.attacker.setCurrentHealth((int) ((int) defender.getCurrentAttack() * defGround.getDefenderMod()));
		this.defender.setCurrentHealth((int) (attacker.getCurrentAttack() * attacker.getFlankMod()));
	}

	private void archerAttack(){
		this.defender.setCurrentHealth((int) ((int)attacker.getCurrentAttack() * atkGround.getArcherMod() * 4));
		if (this.getDefender().getCurrentHealth() <= 0){
			
		}
	}
	
	public unit getAttacker() {
		return attacker;
	}

	public void setAttacker(unit attacker) {
		this.attacker = attacker;
	}

	public unit getDefender() {
		return defender;
	}

	public void setDefender(unit defender) {
		this.defender = defender;
	}

	public terrain getDefGround() {
		return defGround;
	}

	public void setDefGround(terrain defGround) {
		this.defGround = defGround;
	}

	public terrain getAtkGround() {
		return atkGround;
	}

	public void setAtkGround(terrain atkGround) {
		this.atkGround = atkGround;
	}

}
