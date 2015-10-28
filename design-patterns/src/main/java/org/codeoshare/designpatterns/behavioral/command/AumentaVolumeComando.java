package org.codeoshare.designpatterns.behavioral.command;

public class AumentaVolumeComando implements Comando {
    private Player player;
    private int levels;
    
	public AumentaVolumeComando(Player player, int levels) {
		this.player = player;
		this.levels = levels;
	}

	public void execute() {
		this.player.increaseVolume(this.levels);
	}
}
