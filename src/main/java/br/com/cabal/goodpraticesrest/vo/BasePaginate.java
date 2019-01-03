package br.com.cabal.goodpraticesrest.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.domain.Page;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BasePaginate <T>{

    private List<T> content;
    private Integer pageSize;
    private Integer pageNumber;
    private Long totalElements;
    private Integer totalPages;

    public BasePaginate(Page page){
        this.content = page.getContent();
        this.pageSize = page.getPageable().getPageSize();
        this.pageNumber = page.getPageable().getPageNumber();
        this.totalElements = page.getTotalElements();
        this.totalPages = page.getTotalPages();
    }
}
