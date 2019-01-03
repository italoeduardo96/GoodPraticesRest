package br.com.cabal.goodpraticesrest.vo;

import br.com.cabal.goodpraticesrest.entity.Pokemon;
import br.com.cabal.goodpraticesrest.enums.GenderEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.Random;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreatePokemonVO {

    private GenderEnum genderEnum;

    @NotNull
    private String name;
    @NotNull
    private String nickname;
    @NotNull
    private String type;

}
