package com.locadora.funcionarioapi.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageResponse<T> {
    private List<T> content;
    private Integer page;
    private Integer size;
    private Integer totalpages;
    private Long  totalElementes;

    public PageResponse(final Page<T> page){
        this.content = page.getContent();
        this.page = page.getNumber();
        this.size = page.getSize();
        this.totalpages = page.getTotalPages();
        this.totalElementes = page.getTotalElements();
    }
}
