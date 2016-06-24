package mechanics;



public class terrain {
	private int terrainType; //1 - Grasslands, 2 - hills, 3 - mountains, 4 - forests, 5 - river
	private double defenderMod;
	private double archerMod;
	private int bonusMarket;
	private int bonusFarm;
	private int bonusBarracks;
	private boolean passable;
	private int crossPenalty;
	private String image;
	public int getBonusFarm() {
		return bonusFarm;
	}

	public void setBonusFarm(int bonusFarm) {
		this.bonusFarm = bonusFarm;
	}

	public int getBonusBarracks() {
		return bonusBarracks;
	}

	public void setBonusBarracks(int bonusBarracks) {
		this.bonusBarracks = bonusBarracks;
	}


	public terrain(int type){
		this.terrainType = type;
		switch(terrainType){
			case 12:
				//Grasslands
				this.defenderMod = 1;
				this.archerMod = 0;
				this.passable = true;
				this.bonusMarket = 0;
				this.bonusFarm = 2;
				this.bonusBarracks = 0;
				this.image = "/res/Grassland.png";
				this.crossPenalty = 1;
				break;
			case 23:
				//hills
				this.defenderMod = 2;
				this.archerMod = 1;
				this.passable = true;
				this.bonusMarket = 0;
				this.bonusFarm = 0;
				this.bonusBarracks = 0;
				this.image = "/res/Hill.png";
				this.crossPenalty = 2;
				break;
			case 15:
				//mountains
				this.defenderMod = 0;
				this.archerMod = 0;
				this.passable = false;
				this.bonusMarket = 0;
				this.bonusFarm = 0;
				this.bonusBarracks = 0;
				this.image = "/res/Mountains.png";
				this.crossPenalty = 1;
				break;
			case 19:
				//forests
				this.defenderMod = 0;
				this.archerMod = -1;
				this.passable = true;
				this.bonusMarket = 0;
				this.bonusBarracks = 2;
				this.bonusFarm = 0;
				this.image = "/res/Forrest.png";
				this.crossPenalty = 2;
				break;
			case 35:
				//rivers
				this.defenderMod = 2;
				this.archerMod = 0;
				this.passable = true;
				this.bonusMarket = 2;
				this.bonusFarm = 0;
				this.bonusBarracks = 0;
				this.image = "/res/River.png";
				this.crossPenalty = 2;
				break;
			case 25:
				//Bridge
				this.defenderMod = 2;
				this.archerMod = 0;
				this.passable = true;
				this.bonusMarket = 0;
				this.bonusFarm = 0;
				this.bonusBarracks = 0;
				this.image = "/res/Bridge.jpg";
				this.crossPenalty = 1;
				break;
			case 24:
				//Village
				this.defenderMod = 2;
				this.archerMod = 1;
				this.passable = true;
				this.bonusMarket = 1;
				this.bonusFarm = 1;
				this.bonusBarracks = 1;
				this.image = "/res/Village.png";
				this.crossPenalty = 1;
				break;
			case 31:
				//Village
				this.defenderMod = 2;
				this.archerMod = 1;
				this.passable = true;
				this.bonusMarket = 1;
				this.bonusFarm = 1;
				this.bonusBarracks = 1;
				this.image = "/res/Village.png";
				this.crossPenalty = 1;
				break;
			case 20:
				//Keep
				this.defenderMod = 4;
				this.archerMod = 2;
				this.passable = true;
				this.bonusMarket = 0;
				this.bonusFarm = 0;
				this.bonusBarracks = 0;
				this.image = "/res/Keep.jpg";
				this.crossPenalty = 1;
				break;
		}
		
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	/**
	 * @return the terrainType
	 */
	public int getTerrainType() {
		return terrainType;
	}

	/**
	 * @param terrainType the terrainType to set
	 */
	public void setTerrainType(int terrainType) {
		this.terrainType = terrainType;
	}

	/**
	 * @return the defenderMod
	 */
	public double getDefenderMod() {
		return defenderMod;
	}

	/**
	 * @param defenderMod the defenderMod to set
	 */
	public void setDefenderMod(double defenderMod) {
		this.defenderMod = defenderMod;
	}

	/**
	 * @return the archerMod
	 */
	public double getArcherMod() {
		return archerMod;
	}

	/**
	 * @param archerMod the archerMod to set
	 */
	public void setArcherMod(double archerMod) {
		this.archerMod = archerMod;
	}

	/**
	 * @return the bonusMarket
	 */
	public int getBonusMarket() {
		return bonusMarket;
	}

	/**
	 * @param bonusMarket the bonusMarket to set
	 */
	public void setBonusMarket(int bonusMarket) {
		this.bonusMarket = bonusMarket;
	}

	/**
	 * @return the passable
	 */
	public boolean isPassable() {
		return passable;
	}

	/**
	 * @param passable the passable to set
	 */
	public void setPassable(boolean passable) {
		this.passable = passable;
	}

	/**
	 * @return the crossPenalty
	 */
	public int getCrossPenalty() {
		return crossPenalty;
	}

	/**
	 * @param crossPenalty the crossPenalty to set
	 */
	public void setCrossPenalty(int crossPenalty) {
		this.crossPenalty = crossPenalty;
	}
	
	
}
