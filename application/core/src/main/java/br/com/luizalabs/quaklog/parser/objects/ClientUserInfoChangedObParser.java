package br.com.luizalabs.quaklog.parser.objects;

import br.com.luizalabs.quaklog.parser.ParseObject;
import lombok.*;

import java.util.Map;

@Builder
@Getter
@Setter
@ToString
public class ClientUserInfoChangedObParser implements ParseObject {
    @NonNull
    private String gameTime;
    @NonNull
    private int id;
    @NonNull
    private String name;
    @NonNull
    private Map<String, String> arguments;
}