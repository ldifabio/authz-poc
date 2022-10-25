package ldifabio.recursosapi;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString @EqualsAndHashCode
public class Usuario {
    @Getter @Setter private Long userId;
    @Getter @Setter private String userName;

    public Usuario(Long userId){
        this.userId = userId;
    }
}
