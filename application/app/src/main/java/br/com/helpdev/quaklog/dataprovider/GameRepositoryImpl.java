package br.com.helpdev.quaklog.dataprovider;

import br.com.helpdev.quaklog.dataprovider.entity.GameEntity;
import br.com.helpdev.quaklog.dataprovider.mapper.GameRepositoryMapper;
import br.com.helpdev.quaklog.entity.Game;
import br.com.helpdev.quaklog.entity.vo.GameUUID;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
class GameRepositoryImpl implements GameRepository {

    private final GameRepositoryMongo mongo;

    @Autowired
    GameRepositoryImpl(GameRepositoryMongo mongo) {
        this.mongo = mongo;
    }

    @Override
    public void save(Game game) {
        GameEntity gameEntity = GameRepositoryMapper.toDatabaseEntity(game);
        mongo.save(gameEntity);
    }

    @Override
    public List<Game> getAllByDate(LocalDate localDate) {
        val entities = mongo.findAllByDate(localDate);
        return entities.stream().map(GameRepositoryMapper::toDomainEntity).collect(Collectors.toList());
    }

    @Override
    @Cacheable(value = "getByUUID", key = "#gameUUID", unless = "#result==null")
    public Game getByUUID(GameUUID gameUUID) {
        Optional<GameEntity> gameEntity = mongo.findById(gameUUID.toString());
        return gameEntity.map(GameRepositoryMapper::toDomainEntity).orElse(null);
    }
}