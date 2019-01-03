package br.com.cabal.goodpraticesrest.entity;

import br.com.cabal.goodpraticesrest.enums.GenderEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

@Entity
@SequenceGenerator(name="seq", initialValue=1, allocationSize=100)
public class Pokemon {

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq")
    private Long id;
    private String name;
    private String gender;
    private String nickname;
    private String type;
}
