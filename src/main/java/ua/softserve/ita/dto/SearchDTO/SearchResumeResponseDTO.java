package ua.softserve.ita.dto.SearchDTO;

import lombok.*;

import java.math.BigInteger;
import java.util.List;

@Builder
@Data
public class SearchResumeResponseDTO {

    private BigInteger count;

    private List<SearchResumeDTO> searchResumeDTOS;
}
