package br.com.cabal.goodpraticesrest.service;

import br.com.cabal.goodpraticesrest.entity.Pokemon;
import br.com.cabal.goodpraticesrest.enums.GenderEnum;
import br.com.cabal.goodpraticesrest.exception.NotFoundException;
import br.com.cabal.goodpraticesrest.repository.PokemonRepository;
import br.com.cabal.goodpraticesrest.vo.BasePaginate;
import br.com.cabal.goodpraticesrest.vo.CreatePokemonVO;
import br.com.cabal.goodpraticesrest.vo.UpdatePokemonVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.print.DocFlavor;
import java.util.List;
import java.util.Optional;

@Service
public class PokemonService {

    @Autowired
    private PokemonRepository pokemonRepository;

    public void deletePokemon(Long id){

        Optional<Pokemon> a = pokemonRepository.findById(id);
        if(!a.isPresent())
            throw new NotFoundException("Pokemon não encontrado");

        pokemonRepository.delete(a.get());

    }

    public Pokemon updatePokemon(UpdatePokemonVo pokemonVo, Long id){

        Optional<Pokemon> a = pokemonRepository.findById(id);
        if(!a.isPresent())
            throw new NotFoundException("Pokemon não encontrado");

        if(pokemonVo.getName() != null)
            a.get().setName(pokemonVo.getName());

        if(pokemonVo.getNickname() != null)
            a.get().setNickname(pokemonVo.getNickname());

        if(pokemonVo.getType() != null)
            a.get().setType(pokemonVo.getType());

        if(pokemonVo.getGender() != null)
            a.get().setGender(pokemonVo.getGender().name());

        return pokemonRepository.save(a.get());
    }

    public Pokemon createPokemon(CreatePokemonVO pokemon){
        Pokemon v = new Pokemon();
        v.setType(pokemon.getType());
        v.setNickname(pokemon.getNickname());
        v.setName(pokemon.getName());
        v.setGender(pokemon.getGenderEnum().name());

        return pokemonRepository.save(v);
    }

    public Pokemon getOne(Long id){

        Optional<Pokemon> a = pokemonRepository.findById(id);
        if(!a.isPresent())
            throw new NotFoundException("Pokemon não encontrado");

        return a.get();
    }

    public BasePaginate<Pokemon> getAllPageable(String name, String type, GenderEnum gender, int page, int size){
        Page<Pokemon> bySearchTerm = pokemonRepository.findBySearchTerm(name, type, gender == null ? null : gender.name(), new PageRequest(page, size));
        return new BasePaginate(bySearchTerm);
    }


}
