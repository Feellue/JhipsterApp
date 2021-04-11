package fr.polytech.info4.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * A Compte.
 */
@Entity
@Table(name = "compte")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Compte implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @NotNull
    @Column(name = "name", nullable = false)
    private String name;

    @NotNull
    @Column(name = "surname", nullable = false)
    private String surname;

    @NotNull
    @Column(name = "age", nullable = false)
    private Integer age;

    @NotNull
    @Column(name = "address", nullable = false)
    private String address;

    @OneToMany(mappedBy = "compte")
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    private Set<Panier> paniers = new HashSet<>();

    @OneToOne(mappedBy = "compte")
    @JsonIgnore
    private Restaurant restaurant;

    @ManyToMany(mappedBy = "comptes")
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @JsonIgnore
    private Set<SystemePaiement> systemePaiements = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Compte name(String name) {
        this.name = name;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public Compte surname(String surname) {
        this.surname = surname;
        return this;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Integer getAge() {
        return age;
    }

    public Compte age(Integer age) {
        this.age = age;
        return this;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public Compte address(String address) {
        this.address = address;
        return this;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Set<Panier> getPaniers() {
        return paniers;
    }

    public Compte paniers(Set<Panier> paniers) {
        this.paniers = paniers;
        return this;
    }

    public Compte addPanier(Panier panier) {
        this.paniers.add(panier);
        panier.setCompte(this);
        return this;
    }

    public Compte removePanier(Panier panier) {
        this.paniers.remove(panier);
        panier.setCompte(null);
        return this;
    }

    public void setPaniers(Set<Panier> paniers) {
        this.paniers = paniers;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public Compte restaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
        return this;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public Set<SystemePaiement> getSystemePaiements() {
        return systemePaiements;
    }

    public Compte systemePaiements(Set<SystemePaiement> systemePaiements) {
        this.systemePaiements = systemePaiements;
        return this;
    }

    public Compte addSystemePaiement(SystemePaiement systemePaiement) {
        this.systemePaiements.add(systemePaiement);
        systemePaiement.getComptes().add(this);
        return this;
    }

    public Compte removeSystemePaiement(SystemePaiement systemePaiement) {
        this.systemePaiements.remove(systemePaiement);
        systemePaiement.getComptes().remove(this);
        return this;
    }

    public void setSystemePaiements(Set<SystemePaiement> systemePaiements) {
        this.systemePaiements = systemePaiements;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Compte)) {
            return false;
        }
        return id != null && id.equals(((Compte) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Compte{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            ", surname='" + getSurname() + "'" +
            ", age=" + getAge() +
            ", address='" + getAddress() + "'" +
            "}";
    }
}
