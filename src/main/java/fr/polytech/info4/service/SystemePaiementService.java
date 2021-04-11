package fr.polytech.info4.service;

import fr.polytech.info4.service.dto.SystemePaiementDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing {@link fr.polytech.info4.domain.SystemePaiement}.
 */
public interface SystemePaiementService {

    /**
     * Save a systemePaiement.
     *
     * @param systemePaiementDTO the entity to save.
     * @return the persisted entity.
     */
    SystemePaiementDTO save(SystemePaiementDTO systemePaiementDTO);

    /**
     * Get all the systemePaiements.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<SystemePaiementDTO> findAll(Pageable pageable);

    /**
     * Get all the systemePaiements with eager load of many-to-many relationships.
     *
     * @return the list of entities.
     */
    Page<SystemePaiementDTO> findAllWithEagerRelationships(Pageable pageable);


    /**
     * Get the "id" systemePaiement.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<SystemePaiementDTO> findOne(Long id);

    /**
     * Delete the "id" systemePaiement.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
