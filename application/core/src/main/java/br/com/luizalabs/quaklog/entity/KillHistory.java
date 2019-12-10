package br.com.luizalabs.quaklog.entity;

import br.com.luizalabs.quaklog.entity.vo.GameTime;
import br.com.luizalabs.quaklog.entity.vo.KillMode;
import br.com.luizalabs.quaklog.entity.vo.Mod;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class KillHistory {

    private final GameTime gameTime;
    private final KillMode killMode;
    private final Player player;
    private final Mod mod;

    private KillHistory(GameTime gameTime, KillMode killMode, Player player, Mod mod) {
        this.gameTime = gameTime;
        this.killMode = killMode;
        this.player = player;
        this.mod = mod;
    }

    static KillHistory killed(GameTime gameTime, Player player, Mod mod) {
        return new KillHistory(gameTime, KillMode.KILL, player, mod);
    }

    static KillHistory deadBy(GameTime gameTime, Player player, Mod mod) {
        return new KillHistory(gameTime, KillMode.DEAD, player, mod);
    }
}