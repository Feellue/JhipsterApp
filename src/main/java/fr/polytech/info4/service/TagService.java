package fr.polytech.info4.service;

import fr.polytech.info4.service.dto.TagDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing {@link fr.polytech.info4.domain.Tag}.
 */
public interface TagService {

    /**
     * Save a tag.
     *
     * @param tagDTO the entity to save.
     * @return the persisted entity.
     */
    TagDTO save(TagDTO tagDTO);

    /**
     * Get all the tags.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<TagDTO> findAll(Pageable pageable);


    /**
     * Get the "id" tag.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<TagDTO> findOne(Long id);

    /**
     * Delete the "id" tag.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
