package mechanics;

public class tile {
	private boolean hasUnit;
	private boolean hasmarket;
	private boolean hasFarm;
	private boolean hasBarracks;
	private int faction;
	private terrain terrainOnTile;
	private unit unitOnTile;
	
	public tile(int factionNumber, int terrainType){
		this.hasUnit = false;
		this.hasmarket = false;
		this.hasBarracks = false;
		this.hasFarm = false;
		this.faction = factionNumber;
		this.terrainOnTile = new terrain(terrainType);
		this.unitOnTile = null;
	}

	/**
	 * @return the hasUnit
	 */
	public boolean isHasUnit() {
		return hasUnit;
	}

	/**
	 * @param hasUnit the hasUnit to set
	 */
	public void setHasUnit(boolean hasUnit) {
		this.hasUnit = hasUnit;
	}

	/**
	 * @return the hasmarket
	 */
	public boolean isHasmarket() {
		return hasmarket;
	}

	/**
	 * @param hasmarket the hasmarket to set
	 */
	public void setHasmarket(boolean hasmarket) {
		this.hasmarket = hasmarket;
	}

	/**
	 * @return the hasFarm
	 */
	public boolean isHasFarm() {
		return hasFarm;
	}

	/**
	 * @param hasFarm the hasFarm to set
	 */
	public void setHasFarm(boolean hasFarm) {
		this.hasFarm = hasFarm;
	}

	/**
	 * @return the hasBarracks
	 */
	public boolean isHasBarracks() {
		return hasBarracks;
	}

	/**
	 * @param hasBarracks the hasBarracks to set
	 */
	public void setHasBarracks(boolean hasBarracks) {
		this.hasBarracks = hasBarracks;
	}

	/**
	 * @return the faction
	 */
	public int getFaction() {
		return faction;
	}

	/**
	 * @param faction the faction to set
	 */
	public void setFaction(int faction) {
		this.faction = faction;
	}

	/**
	 * @return the terrainOnTile
	 */
	public terrain getTerrainOnTile() {
		return terrainOnTile;
	}

	/**
	 * @param terrainOnTile the terrainOnTile to set
	 */
	public void setTerrainOnTile(terrain terrainOnTile) {
		this.terrainOnTile = terrainOnTile;
	}

	/**
	 * @return the unitOnTile
	 */
	public unit getUnitOnTile() {
		return unitOnTile;
	}

	/**
	 * @param unitOnTile the unitOnTile to set
	 */
	public void setUnitOnTile(unit unitOnTile) {
		this.unitOnTile = unitOnTile;
	}
	
	
}
