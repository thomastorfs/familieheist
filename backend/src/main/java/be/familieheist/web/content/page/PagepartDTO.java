package be.familieheist.web.content.page;

import lombok.Builder;

@Builder
public record PagepartDTO(
    String id,
    String title,
    String description,
    PagepartType type,
    Integer position
) implements Comparable<PagepartDTO> {
    @Override
    public int compareTo(PagepartDTO pagepartDTO) {
        return position.compareTo(pagepartDTO.position);
    }
}
