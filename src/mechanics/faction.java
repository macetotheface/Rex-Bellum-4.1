package mechanics;

public class faction {

	private int manpower;
	private int gold;
	private int happiness;
	private int income;
	private int manpowerIncome;
	private int numOfUnits;
	private int factionType;
	private barracks barrackStats;
	private farm farmStats;
	private market marketStats;
	private boolean isPlayer;
	private tile [][] tileArray;

	public faction(boolean isPlayerBool, int factionNum) {
		//Gives starting values
		this.numOfUnits = 0;
		this.gold = 300;
		this.manpower = 150;
		this.income = 10;
		this.manpowerIncome = 25;
		this.isPlayer = isPlayerBool;
		this.factionType = factionNum;
	}

	// Goes through and builds a few markets/barracks/farms at the start to get
	// it all going (FOR AI FACTIONS)
	
	public void decision(tile[][] tileArrayTemp) {
		this.tileArray = tileArrayTemp;
		//choosing what to buy
		if (this.income < 4 && this.manpowerIncome < 40) {
			//Build farms
			if (this.farmStats.getPrice() < this.gold) {
				aiBuildFarms(2);
			}
		} else if (this.manpowerIncome < 80) {
			//Build barracks
			if (this.barrackStats.getPrice() < this.gold) {
				aiBuildBarracks(2);
			}
		} else if (this.income < 8) {
			//Build a market
			if (this.marketStats.getPrice() < this.gold) {
				aiBuildMarkets(2);
			}
		} else {
			//Build units
			
		}
	}

	public void endTurn() {
		this.gold += this.income;
		this.manpower += this.manpowerIncome;
	}

	public void factionTest(tile[][] tileArrayTemp){
		this.tileArray = tileArrayTemp;
		System.out.println(tileArray[0][0].getFaction() + " test1");
		tileArray[0][0].setFaction(3);
	}
	
	//The ai goes through and decides where to build a market
	private void aiBuildMarkets(int check) {
		boolean built = false;
		for(int i = 0; i < this.tileArray.length; i++){
			for(int j = 0; j < this.tileArray[0].length; j++){
				if (this.tileArray[i][j].getTerrainOnTile().getBonusMarket() > check && this.tileArray[i][j].getFaction() == this.factionType && this.tileArray[i][j].isHasmarket() == false){
					buildMarket(i,j);
					built = true;
				}
			}
		}
		
		if (built == false && check > 0){
			check--;
			aiBuildMarkets(check);
		}
		
		//Maybe do something if run out of available spots to build
	}
	
	//Changes stats to account for a new market
	private void buildMarket(int r, int c){
		this.income+= this.marketStats.getGoldPerTurn() + this.tileArray[r][c].getTerrainOnTile().getBonusMarket();
		this.tileArray[r][c].setHasmarket(true);
		this.gold -= this.marketStats.getPrice();
	}
	
	private void aiBuildFarms(int check) {
		boolean built = false;
		for(int i = 0; i < this.tileArray.length; i++){
			for(int j = 0; j < this.tileArray[0].length; j++){
				if (this.tileArray[i][j].getTerrainOnTile().getBonusFarm() > check && this.tileArray[i][j].getFaction() == this.factionType && this.tileArray[i][j].isHasFarm() == false){
					buildFarm(i,j);
					built = true;
				}
			}
		}
		
		if (built == false && check > 0){
			check--;
			aiBuildMarkets(check);
		}

		//Maybe do something if run out of available spots to build
	}

	//Changes stats to account for a new market
	private void buildFarm(int r, int c){
		this.income+= this.farmStats.getGoldPerTurn() + this.tileArray[r][c].getTerrainOnTile().getBonusFarm();
		this.manpowerIncome += this.farmStats.getMenPerTurn() + (this.tileArray[r][c].getTerrainOnTile().getBonusFarm()*10);
		this.tileArray[r][c].setHasmarket(true);
		this.gold -= this.farmStats.getPrice();
	}

	private void aiBuildBarracks(int check) {
		boolean built = false;
		for(int i = 0; i < this.tileArray.length; i++){
			for(int j = 0; j < this.tileArray[0].length; j++){
				if (this.tileArray[i][j].getTerrainOnTile().getBonusBarracks() > check && this.tileArray[i][j].getFaction() == this.factionType && this.tileArray[i][j].isHasBarracks() == false){
					buildBarracks(i,j);
					built = true;
				}
			}
		}

		if (built == false && check > 0){
			check--;
			aiBuildBarracks(check);
		}

		//Maybe do something if run out of available spots to build
	}

	//Changes stats to account for a new market
	private void buildBarracks(int r, int c){
		this.manpowerIncome += this.barrackStats.getMenPerTurn() + (this.tileArray[r][c].getTerrainOnTile().getBonusBarracks()*10);
		this.tileArray[r][c].setHasBarracks(true);
		this.gold -= this.barrackStats.getPrice();
	}

	public boolean isPlayer() {
		return isPlayer;
	}

	public void setPlayer(boolean isPlayer) {
		this.isPlayer = isPlayer;
	}

	public int getManpower() {
		return manpower;
	}

	public void setManpower(int manpower) {
		this.manpower = manpower;
	}

	public int getGold() {
		return gold;
	}

	public void setGold(int gold) {
		this.gold = gold;
	}

	public int getHappiness() {
		return happiness;
	}

	public void setHappiness(int happiness) {
		this.happiness = happiness;
	}

	public int getIncome() {
		return income;
	}

	public void setIncome(int income) {
		this.income = income;
	}

	public int getManpowerIncome() {
		return manpowerIncome;
	}

	public void setManpowerIncome(int manpowerIncome) {
		this.manpowerIncome = manpowerIncome;
	}

	public int getNumOfUnits() {
		return numOfUnits;
	}

	public void setNumOfUnits(int numOfUnits) {
		this.numOfUnits = numOfUnits;
	}

}
