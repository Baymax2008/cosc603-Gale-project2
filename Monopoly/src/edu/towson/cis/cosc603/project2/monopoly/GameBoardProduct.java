package edu.towson.cis.cosc603.project2.monopoly;


import java.util.ArrayList;
import java.util.Hashtable;

public class GameBoardProduct {
	private ArrayList<Cell> cells = new ArrayList<Cell>();
	private Hashtable<String, Integer> colorGroups = new Hashtable<String, Integer>();

	public ArrayList<Cell> getCells() {
		return cells;
	}

	/**
	 * Gets the cell.
	 * @param newIndex  the new index
	 * @return  the cell
	 */
	public Cell getCell(int newIndex) {
		return (Cell) cells.get(newIndex);
	}

	/**
	 * Gets the cell number.
	 * @return  the cell number
	 */
	public int getCellNumber() {
		return cells.size();
	}

	/**
	 * Query cell.
	 * @param string  the string
	 * @return  the cell
	 */
	public Cell queryCell(String string) {
		for (int i = 0; i < cells.size(); i++) {
			Cell temp = (Cell) cells.get(i);
			if (temp.getName().equals(string)) {
				return temp;
			}
		}
		return null;
	}

	/**
	 * Query cell index.
	 * @param string  the string
	 * @return  the int
	 */
	public int queryCellIndex(String string) {
		for (int i = 0; i < cells.size(); i++) {
			Cell temp = (Cell) cells.get(i);
			if (temp.getName().equals(string)) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * Move player.
	 * @param player   the player
	 * @param diceValue   the dice value
	 * @param gui
	 * @param gameMaster
	 */
	public void movePlayer(Player player, int diceValue, MonopolyGUI gui,
			GameMaster gameMaster) {
		Cell currentPosition = player.getPosition();
		int positionIndex = queryCellIndex(currentPosition.getName());
		int newIndex = (positionIndex + diceValue) % getCellNumber();
		if (newIndex <= positionIndex || diceValue > getCellNumber()) {
			player.setMoney(player.getMoney() + 200);
		}
		player.setPosition(getCell(newIndex));
		gui.movePlayer(gameMaster.getPlayerIndex(player), positionIndex,
				newIndex);
		gameMaster.playerMoved(player);
		gameMaster.updateGUI();
	}

	/**
	 * Gets the property number for color.
	 * @param name  the name
	 * @return  the property number for color
	 */
	public int getPropertyNumberForColor(String name) {
		Integer number = (Integer) colorGroups.get(name);
		if (number != null) {
			return number.intValue();
		}
		return 0;
	}

	/**
	 * Adds the cell.
	 * @param cell  the cell
	 */
	public void addCell(PropertyCell cell) {
		String colorGroup = cell.getColorGroup();
		int propertyNumber = getPropertyNumberForColor(colorGroup);
		colorGroups.put(colorGroup, new Integer(propertyNumber + 1));
		cells.add(cell);
	}

	/**
	 * Gets the properties in monopoly.
	 * @param color  the color
	 * @return  the properties in monopoly
	 */
	public PropertyCell[] getPropertiesInMonopoly(String color) {
		PropertyCell[] monopolyCells = new PropertyCell[getPropertyNumberForColor(color)];
		int counter = 0;
		for (int i = 0; i < getCellNumber(); i++) {
			IOwnable c = getCell(i);
			if (c instanceof PropertyCell) {
				PropertyCell pc = (PropertyCell) c;
				if (pc.getColorGroup().equals(color)) {
					monopolyCells[counter] = pc;
					counter++;
				}
			}
		}
		return monopolyCells;
	}
}