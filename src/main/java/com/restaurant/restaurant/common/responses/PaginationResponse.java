package com.restaurant.restaurant.common.responses;

import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PaginationResponse {
    private Boolean first;
    private Boolean last;
    private Integer totalPages;
    private Long totalElements;
    private Integer pageNumber;
    private Integer numberOfElements;
}
