package br.com.helpdev.quaklog.usecase;

import br.com.helpdev.quaklog.entity.Game;
import br.com.helpdev.quaklog.entity.vo.GameUUID;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface GameGetterUseCase {

    List<Game> getGamesByDate(LocalDate date);

    Optional<Game> getGameByUUID(GameUUID gameUUID);

}
