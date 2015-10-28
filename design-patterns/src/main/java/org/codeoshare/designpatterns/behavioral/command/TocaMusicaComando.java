package org.codeoshare.designpatterns.behavioral.command;


public class TocaMusicaComando implements Comando {
	private Player player;
	private String file;

	public TocaMusicaComando(Player player, String file) {
		this.player = player;
		this.file = file;
	}

	public void execute() {
		try {
			this.player.play(this.file);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
