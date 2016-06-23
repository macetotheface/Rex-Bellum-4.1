package mechanics;

import org.newdawn.slick.SlickException;

public class faction {

	private int manpower;			//Holds the manpower of the faction
	private int gold;				//Holds the gold of the faction
	private int happiness;			//Holds the happiness of the faction
	private int income;				//Holds the change in gold of the faction
	private int manpowerIncome;		//Holds the change in manpower of the faction
	private int numOfUnits;			//Holds the number of units for the faction
	private int factionType;		//Holds which faction type it is (1-human, 2-elf, 3-dwarf, 4-orc)
	private barracks barrackStats;	//Holds the stats of the barracks buildings
	private farm farmStats;			//Holds the stats of the farm buildings
	private market marketStats;		//Holds the stats of the market buildings
	private boolean isPlayer;		//Holds whether or not the faction is controlled by the player
	private tile [][] tileArray;	//Holds the map of tiles
	private int [] capitalLocation;	//Holds the location of the factions capital
	
	public faction(boolean isPlayerBool, int factionNum, tile [][] tileArrayTemp) {
		//Gives starting values
		this.numOfUnits = 0;
		this.gold = 300;
		this.manpower = 150;
		this.income = 10;
		this.manpowerIncome = 25;
		this.isPlayer = isPlayerBool;
		this.factionType = factionNum;
		this.capitalLocation = new int [2];
		this.tileArray = tileArrayTemp;
				
		//Sets the capital depending 
		if(this.factionType == 1){
			
		}
		else if(this.factionType == 2){
			
		}
		else if(this.factionType == 3){
			
		}
		else{
			
		}
	}

	// Goes through and builds a few markets/barracks/farms at the start to get
	// it all going (FOR AI FACTIONS)
	
	public void decision(tile[][] tileArrayTemp) throws SlickException {
		swordsman newSword = new swordsman();
		int preferedX = 0;
		int preferedY = 0;
		
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
			
			switch(factionType){
			case 1:
				//Humans
				for (int i = 0; i < this.tileArray.length; i++){
					for (int j = 0; j < this.tileArray[0].length; j++){
						//Reached the border on top, send unit to border
						if (this.tileArray[i][j].getFaction() != factionType && this.tileArray[i][j - 1].isHasUnit() == false && this.tileArray[i][j - 1].getTerrainOnTile().isPassable() == true){
							preferedX = i;
							preferedY = j - 1;
							j = tileArray[0].length;
							i = tileArray.length;
						}
						//Reached the border on the right 
						else if (this.tileArray[i][j].getFaction() != factionType && this.tileArray[i - 1][j].isHasUnit() == false && this.tileArray[i - 1][j].getTerrainOnTile().isPassable() == true){
							preferedX = i - 1;
							preferedY = j;
							j = tileArray[0].length;
							i = tileArray.length;
						}
					}
				}
				//The borders are covered, so go back and find a random tile on the other side of the border
				for (int i = 0; i < this.tileArray.length; i++){
					for (int j = 0; j < this.tileArray[0].length; j++){
						if (this.tileArray[i][j].getFaction() != this.factionType && this.tileArray[i][j].isHasUnit() == false && this.tileArray[i][j].getTerrainOnTile().isPassable() == true){
							preferedX = i;
							preferedY = j;
						}
					}
				}
				
				break;
			case 2:
				//Elves
				for (int i = 0; i < this.tileArray.length; i++){
					for (int j = 35; j < this.tileArray[0].length; j--){
						//Reached the border on bottom, send unit to border
						if (this.tileArray[i][j].getFaction() != factionType && this.tileArray[i][j + 1].isHasUnit() == false && this.tileArray[i][j + 1].getTerrainOnTile().isPassable() == true){
							preferedX = i;
							preferedY = j + 1;
							j = tileArray[0].length;
							i = tileArray.length;
						}
						//Reached the border on the right 
						else if (this.tileArray[i][j].getFaction() != factionType && this.tileArray[i - 1][j].isHasUnit() == false && this.tileArray[i - 1][j].getTerrainOnTile().isPassable() == true){
							preferedX = i - 1;
							preferedY = j;
							j = tileArray[0].length;
							i = tileArray.length;
						}
					}
				}
				//The borders are covered, so go back and find a random tile on the other side of the border
				for (int i = 0; i < this.tileArray.length; i++){
					for (int j = 0; j < this.tileArray[0].length; j++){
						if (this.tileArray[i][j].getFaction() != this.factionType && this.tileArray[i][j].isHasUnit() == false && this.tileArray[i][j].getTerrainOnTile().isPassable() == true){
							preferedX = i;
							preferedY = j;
						}
					}
				}
				break;
			case 3:
				//Dwarves
				for (int i = 35; i < this.tileArray.length; i--){
					for (int j = 35; j < this.tileArray[0].length; j--){
						//Reached the border on bottom, send unit to border
						if (this.tileArray[i][j].getFaction() != factionType && this.tileArray[i][j + 1].isHasUnit() == false && this.tileArray[i][j + 1].getTerrainOnTile().isPassable() == true){
							preferedX = i;
							preferedY = j + 1;
							j = tileArray[0].length;
							i = tileArray.length;
						}
						//Reached the border on the left 
						else if (this.tileArray[i][j].getFaction() != factionType && this.tileArray[i + 1][j].isHasUnit() == false && this.tileArray[i + 1][j].getTerrainOnTile().isPassable() == true){
							preferedX = i + 1;
							preferedY = j;
							j = tileArray[0].length;
							i = tileArray.length;
						}
					}
				}
				//The borders are covered, so go back and find a random tile on the other side of the border
				for (int i = 0; i < this.tileArray.length; i++){
					for (int j = 0; j < this.tileArray[0].length; j++){
						if (this.tileArray[i][j].getFaction() != this.factionType && this.tileArray[i][j].isHasUnit() == false && this.tileArray[i][j].getTerrainOnTile().isPassable() == true){
							preferedX = i;
							preferedY = j;
						}
					}
				}
				break;
			case 4:
				//Orcs
				for (int i = 35; i < this.tileArray.length; i--){
					for (int j = 0; j < this.tileArray[0].length; j++){
						//Reached the border on top, send unit to border
						if (this.tileArray[i][j].getFaction() != factionType && this.tileArray[i][j - 1].isHasUnit() == false && this.tileArray[i][j - 1].getTerrainOnTile().isPassable() == true){
							preferedX = i;
							preferedY = j - 1;
							j = tileArray[0].length;
							i = tileArray.length;
						}
						//Reached the border on the left
						else if (this.tileArray[i][j].getFaction() != factionType && this.tileArray[i + 1][j].isHasUnit() == false && this.tileArray[i + 1][j].getTerrainOnTile().isPassable() == true){
							preferedX = i + 1;
							preferedY = j;
							j = tileArray[0].length;
							i = tileArray.length;
						}
					}
				}
				//The borders are covered, so go back and find a random tile on the other side of the border
				for (int i = 0; i < this.tileArray.length; i++){
					for (int j = 0; j < this.tileArray[0].length; j++){
						if (this.tileArray[i][j].getFaction() != this.factionType && this.tileArray[i][j].isHasUnit() == false && this.tileArray[i][j].getTerrainOnTile().isPassable() == true){
							preferedX = i;
							preferedY = j;
						}
					}
				}
				break;
			}
			
			//Build units
			if (this.tileArray[capitalLocation[0]][capitalLocation[1]].isHasUnit() == false){
				this.numOfUnits ++;
				this.income -= newSword.getUpkeep();
				this.tileArray[capitalLocation[0]][capitalLocation[1]].setHasUnit(true);
				this.tileArray[capitalLocation[0]][capitalLocation[1]].setUnitOnTile(newSword);
				this.manpower -= newSword.getBaseHealth();
				this.gold -= newSword.getPrice();
				this.tileArray[capitalLocation[0]][capitalLocation[1]].getUnitOnTile().setPreferedX(preferedX);
				this.tileArray[capitalLocation[0]][capitalLocation[1]].getUnitOnTile().setPreferedY(preferedY);
				//Update GUI
			}
		}
		
		
		
		//Move units
		for (int i = 0; i < tileArray.length; i++){
			for (int j = 0; j < tileArray.length; j++){
				if (this.tileArray[i][j].getUnitOnTile().getPreferedX() < i && this.tileArray[i][j].getUnitOnTile().getPreferedY() < j){
					moveDown(i, j);
					moveLeft(i, j);
				}
				else if(this.tileArray[i][j].getUnitOnTile().getPreferedX() > i && this.tileArray[i][j].getUnitOnTile().getPreferedY() < j){
					moveDown(i, j);
					moveRight(i, j);
				}
				else if(this.tileArray[i][j].getUnitOnTile().getPreferedX() < i && this.tileArray[i][j].getUnitOnTile().getPreferedY() > j){
					moveUp(i, j);
					moveLeft(i, j);
				}
				else if(this.tileArray[i][j].getUnitOnTile().getPreferedX() > i && this.tileArray[i][j].getUnitOnTile().getPreferedY() > j){
					moveUp(i, j);
					moveRight(i, j);
				}
			}
		}
	}

	public void moveUp(int x, int y){
		if (this.tileArray[x][y + 1].getTerrainOnTile().isPassable() == true && this.tileArray[x][y + 1].isHasUnit() == false && this.tileArray[x][y + 1].getTerrainOnTile().getCrossPenalty() < this.tileArray[x][y].getUnitOnTile().getCurrentMoves()){
			this.tileArray[x][y].setHasUnit(false);
			this.tileArray[x][y + 1].setHasUnit(true);
			this.tileArray[x][y].getUnitOnTile().lowerMoves(this.tileArray[x][y + 1].getTerrainOnTile().getCrossPenalty());
			this.tileArray[x][y + 1].setUnitOnTile(this.tileArray[x][y].getUnitOnTile());
			this.tileArray[x][y].setUnitOnTile(null);
			//Update GUI
		}
	}
	
	public void moveDown(int x, int y){
		if (this.tileArray[x][y - 1].getTerrainOnTile().isPassable() == true && this.tileArray[x][y - 1].isHasUnit() == false && this.tileArray[x][y - 1].getTerrainOnTile().getCrossPenalty() < this.tileArray[x][y].getUnitOnTile().getCurrentMoves()){
			this.tileArray[x][y].setHasUnit(false);
			this.tileArray[x][y - 1].setHasUnit(true);
			this.tileArray[x][y].getUnitOnTile().lowerMoves(this.tileArray[x][y - 1].getTerrainOnTile().getCrossPenalty());
			this.tileArray[x][y - 1].setUnitOnTile(this.tileArray[x][y].getUnitOnTile());
			this.tileArray[x][y].setUnitOnTile(null);
			//Update GUI
		}
	}
	
	public void moveLeft(int x, int y){
		if (this.tileArray[x - 1][y].getTerrainOnTile().isPassable() == true && this.tileArray[x - 1][y].isHasUnit() == false && this.tileArray[x - 1][y].getTerrainOnTile().getCrossPenalty() < this.tileArray[x][y].getUnitOnTile().getCurrentMoves()){
			this.tileArray[x][y].setHasUnit(false);
			this.tileArray[x - 1][y].setHasUnit(true);
			this.tileArray[x][y].getUnitOnTile().lowerMoves(this.tileArray[x - 1][y].getTerrainOnTile().getCrossPenalty());
			this.tileArray[x - 1][y].setUnitOnTile(this.tileArray[x][y].getUnitOnTile());
			this.tileArray[x][y].setUnitOnTile(null);
			//Update GUI
		}
	}
	
	public void moveRight(int x, int y){
		if (this.tileArray[x + 1][y].getTerrainOnTile().isPassable() == true && this.tileArray[x + 1][y].isHasUnit() == false && this.tileArray[x + 1][y].getTerrainOnTile().getCrossPenalty() < this.tileArray[x][y].getUnitOnTile().getCurrentMoves()){
			this.tileArray[x][y].setHasUnit(false);
			this.tileArray[x + 1][y].setHasUnit(true);
			this.tileArray[x][y].getUnitOnTile().lowerMoves(this.tileArray[x + 1][y].getTerrainOnTile().getCrossPenalty());
			this.tileArray[x + 1][y].setUnitOnTile(this.tileArray[x][y].getUnitOnTile());
			this.tileArray[x][y].setUnitOnTile(null);
			//Update GUI
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

	//Checking to make sure player move is valid and making changes
	public void movePlayer(int x, int y, int newX, int newY){
		combatMechanics fighting;
		if (Math.abs(newX - x) == 1 && Math.abs(newY - y) == 1 && tileArray[newX][newY].getTerrainOnTile().isPassable() == true){
			if (this.tileArray[newX][newY].isHasUnit() == true){
				//Fight enemy unit
				if (this.tileArray[newX][newY].getUnitOnTile().getFactionType() != factionType){
					fighting = new combatMechanics (this.tileArray[x][y].getUnitOnTile(), this.tileArray[newX][newY].getUnitOnTile(),this.tileArray[newX][newY].getTerrainOnTile());
					this.tileArray[x][y].setUnitOnTile(fighting.getAttacker());
					this.tileArray[newX][newY].setUnitOnTile(fighting.getDefender());
					if (this.tileArray[x][y].getUnitOnTile().getCurrentHealth() <= 0){
						this.tileArray[x][y].setUnitOnTile(null);
						this.tileArray[x][y].setHasUnit(false);
						//Update GUI
					}
					else if(this.tileArray[newX][newY].getUnitOnTile().getCurrentHealth() <= 0){
						this.tileArray[newX][newY].setUnitOnTile(this.tileArray[x][y].getUnitOnTile());
						this.tileArray[x][y].setUnitOnTile(null);
						this.tileArray[x][y].setHasUnit(false);
						//Update GUI
					}
				}
				//Can't move into friendly unit
			}
			else{
				//Move the unit
				this.tileArray[x][y].setHasUnit(false);
				this.tileArray[newX][newY].setHasUnit(true);
				this.tileArray[x][y].getUnitOnTile().lowerMoves(this.tileArray[newX][newY].getTerrainOnTile().getCrossPenalty());
				this.tileArray[newX][newY].setUnitOnTile(this.tileArray[x][y].getUnitOnTile());
				this.tileArray[x][y].setUnitOnTile(null);
				//Update GUI
			}
		}
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
