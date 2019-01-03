package br.com.cabal.goodpraticesrest.repository;

        import br.com.cabal.goodpraticesrest.entity.Pokemon;
        import br.com.cabal.goodpraticesrest.enums.GenderEnum;
        import org.springframework.data.domain.Page;
        import org.springframework.data.domain.Pageable;
        import org.springframework.data.jpa.repository.JpaRepository;
        import org.springframework.data.jpa.repository.Query;
        import org.springframework.data.repository.PagingAndSortingRepository;
        import org.springframework.data.repository.query.Param;
        import org.springframework.stereotype.Repository;

@Repository
public interface PokemonRepository extends PagingAndSortingRepository<Pokemon, Long> {

    @Query( " SELECT p FROM Pokemon p WHERE " +
            " ( :name        is null OR p.name   like %:name%      )   AND " +
            " ( :pokeType    is null OR p.type   like %:pokeType%  )   AND " +
            " ( :gender      is null OR p.gender like :gender    )       ")
    Page<Pokemon> findBySearchTerm(@Param("name") String name, @Param("pokeType") String pokeType, @Param("gender") String gender, Pageable pageRequest);
}
