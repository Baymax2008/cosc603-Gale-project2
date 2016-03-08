package edu.towson.cis.cosc603.project2.monopoly.gui;


import javax.swing.JButton;
import java.io.Serializable;

public class PlayerPanelProduct implements Serializable {
	private JButton btnEndTurn;

	public JButton getBtnEndTurn() {
		return btnEndTurn;
	}

	public void setBtnEndTurn(JButton btnEndTurn) {
		this.btnEndTurn = btnEndTurn;
	}

	public boolean isEndTurnButtonEnabled() {
		return btnEndTurn.isEnabled();
	}

	public void setEndTurnEnabled(boolean enabled) {
		btnEndTurn.setEnabled(enabled);
	}
}