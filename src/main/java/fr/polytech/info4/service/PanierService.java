package fr.polytech.info4.service;

import fr.polytech.info4.service.dto.PanierDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing {@link fr.polytech.info4.domain.Panier}.
 */
public interface PanierService {

    /**
     * Save a panier.
     *
     * @param panierDTO the entity to save.
     * @return the persisted entity.
     */
    PanierDTO save(PanierDTO panierDTO);

    /**
     * Get all the paniers.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<PanierDTO> findAll(Pageable pageable);

    /**
     * Get all the paniers with eager load of many-to-many relationships.
     *
     * @return the list of entities.
     */
    Page<PanierDTO> findAllWithEagerRelationships(Pageable pageable);


    /**
     * Get the "id" panier.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<PanierDTO> findOne(Long id);

    /**
     * Delete the "id" panier.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
