package br.com.cabal.goodpraticesrest.controller;

import br.com.cabal.goodpraticesrest.enums.GenderEnum;
import br.com.cabal.goodpraticesrest.service.PokemonService;
import br.com.cabal.goodpraticesrest.vo.CreatePokemonVO;
import br.com.cabal.goodpraticesrest.vo.UpdatePokemonVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/pokemons", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
@Api(value="Pokemons Service", description="Serviços relacionados a api de Pokemons")
public class PokemonController extends BaseController{

    @Autowired
    private PokemonService pokemonService;

    @GetMapping("/{id}")
    @ApiOperation(value = "Find Pokemon by ID")
    public ResponseEntity<?> getId(@PathVariable("id") Long id){
        return buildResponseEntity(pokemonService.getOne(id));
    }

    @GetMapping
    @ApiOperation(value = "Find Pokemons")
    public ResponseEntity<?> getAll(@RequestParam( value = "name",      required = false) String name,
                                    @RequestParam( value = "type",      required = false) String type,
                                    @RequestParam( value = "gender",    required = false) GenderEnum gender,
                                    @RequestParam( value = "page",      required = true) int page,
                                    @RequestParam( value = "size",      required = true) int size){

        return buildResponseEntity(pokemonService.getAllPageable(name, type, gender, page, size));
    }

    @PostMapping
    @ApiOperation(value = "Create Pokemon")
    public ResponseEntity<?> createPokemon(@RequestBody @Valid CreatePokemonVO request){
        return buildResponseEntity(pokemonService.createPokemon(request), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Update a Pokemon")
    public ResponseEntity<?> updatePokemon(@RequestBody @Valid UpdatePokemonVo request, @RequestParam("id") Long id){
        return buildResponseEntity(pokemonService.updatePokemon(request, id));
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete a Pokemon")
    public ResponseEntity<?> updatePokemon(@RequestParam("id") Long id){
        pokemonService.deletePokemon(id);
        return buildResponseEntity(HttpStatus.OK);
    }

}
