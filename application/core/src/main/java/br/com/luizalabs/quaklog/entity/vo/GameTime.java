package br.com.luizalabs.quaklog.entity.vo;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@EqualsAndHashCode
public class GameTime {

    public static GameTime of(String time) {
        return new GameTime(time);
    }

    private final String time;

    @Override
    public String toString() {
        return time;
    }
}
