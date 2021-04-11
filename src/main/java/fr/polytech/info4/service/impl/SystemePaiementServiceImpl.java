package fr.polytech.info4.service.impl;

import fr.polytech.info4.service.SystemePaiementService;
import fr.polytech.info4.domain.SystemePaiement;
import fr.polytech.info4.repository.SystemePaiementRepository;
import fr.polytech.info4.service.dto.SystemePaiementDTO;
import fr.polytech.info4.service.mapper.SystemePaiementMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link SystemePaiement}.
 */
@Service
@Transactional
public class SystemePaiementServiceImpl implements SystemePaiementService {

    private final Logger log = LoggerFactory.getLogger(SystemePaiementServiceImpl.class);

    private final SystemePaiementRepository systemePaiementRepository;

    private final SystemePaiementMapper systemePaiementMapper;

    public SystemePaiementServiceImpl(SystemePaiementRepository systemePaiementRepository, SystemePaiementMapper systemePaiementMapper) {
        this.systemePaiementRepository = systemePaiementRepository;
        this.systemePaiementMapper = systemePaiementMapper;
    }

    @Override
    public SystemePaiementDTO save(SystemePaiementDTO systemePaiementDTO) {
        log.debug("Request to save SystemePaiement : {}", systemePaiementDTO);
        SystemePaiement systemePaiement = systemePaiementMapper.toEntity(systemePaiementDTO);
        systemePaiement = systemePaiementRepository.save(systemePaiement);
        return systemePaiementMapper.toDto(systemePaiement);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<SystemePaiementDTO> findAll(Pageable pageable) {
        log.debug("Request to get all SystemePaiements");
        return systemePaiementRepository.findAll(pageable)
            .map(systemePaiementMapper::toDto);
    }


    public Page<SystemePaiementDTO> findAllWithEagerRelationships(Pageable pageable) {
        return systemePaiementRepository.findAllWithEagerRelationships(pageable).map(systemePaiementMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<SystemePaiementDTO> findOne(Long id) {
        log.debug("Request to get SystemePaiement : {}", id);
        return systemePaiementRepository.findOneWithEagerRelationships(id)
            .map(systemePaiementMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete SystemePaiement : {}", id);
        systemePaiementRepository.deleteById(id);
    }
}
