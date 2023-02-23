package com.team035.pre_project35.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PageInfo {

    private int page;
    private int size;
    private int totalElement;
    private int totalPages;
}
