package br.com.cabal.goodpraticesrest.vo;

import br.com.cabal.goodpraticesrest.enums.GenderEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdatePokemonVo {

    private String name;
    private GenderEnum gender;
    private String nickname;
    private String type;

}
