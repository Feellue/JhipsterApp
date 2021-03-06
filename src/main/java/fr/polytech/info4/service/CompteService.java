package fr.polytech.info4.service;

import fr.polytech.info4.service.dto.CompteDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing {@link fr.polytech.info4.domain.Compte}.
 */
public interface CompteService {

    /**
     * Save a compte.
     *
     * @param compteDTO the entity to save.
     * @return the persisted entity.
     */
    CompteDTO save(CompteDTO compteDTO);

    /**
     * Get all the comptes.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<CompteDTO> findAll(Pageable pageable);
    /**
     * Get all the CompteDTO where Restaurant is {@code null}.
     *
     * @return the {@link List} of entities.
     */
    List<CompteDTO> findAllWhereRestaurantIsNull();


    /**
     * Get the "id" compte.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<CompteDTO> findOne(Long id);

    /**
     * Delete the "id" compte.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
