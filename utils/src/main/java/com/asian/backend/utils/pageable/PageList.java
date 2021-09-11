package com.asian.backend.utils.pageable;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PageList<T> {
    int currentPage;
    int pageSize;
    long total;
    boolean success;
    List<T> list ;
}
