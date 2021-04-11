package fr.polytech.info4.service.dto;

import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * A DTO for the {@link fr.polytech.info4.domain.Panier} entity.
 */
public class PanierDTO implements Serializable {
    
    private Long id;

    @NotNull
    private Integer nbElements;

    @NotNull
    private Integer price;

    private Set<RestaurantDTO> restaurants = new HashSet<>();
    private Set<ProduitDTO> produits = new HashSet<>();

    private Long compteId;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNbElements() {
        return nbElements;
    }

    public void setNbElements(Integer nbElements) {
        this.nbElements = nbElements;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Set<RestaurantDTO> getRestaurants() {
        return restaurants;
    }

    public void setRestaurants(Set<RestaurantDTO> restaurants) {
        this.restaurants = restaurants;
    }

    public Set<ProduitDTO> getProduits() {
        return produits;
    }

    public void setProduits(Set<ProduitDTO> produits) {
        this.produits = produits;
    }

    public Long getCompteId() {
        return compteId;
    }

    public void setCompteId(Long compteId) {
        this.compteId = compteId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof PanierDTO)) {
            return false;
        }

        return id != null && id.equals(((PanierDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "PanierDTO{" +
            "id=" + getId() +
            ", nbElements=" + getNbElements() +
            ", price=" + getPrice() +
            ", restaurants='" + getRestaurants() + "'" +
            ", produits='" + getProduits() + "'" +
            ", compteId=" + getCompteId() +
            "}";
    }
}
