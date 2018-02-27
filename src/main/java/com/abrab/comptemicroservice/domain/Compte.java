package com.abrab.comptemicroservice.domain;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
public class Compte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String rib;
    private Double solde;
    private String cin;
    private Date dateCreation;
    @Transient
    private String port;

    public Compte() {
    }

    public Compte(String rib, Double solde, String cin) {
        this.rib = rib;
        this.solde = solde;
        this.cin = cin;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRib() {
        return rib;
    }

    public void setRib(String rib) {
        this.rib = rib;
    }

    public Double getSolde() {
        return solde;
    }

    public void setSolde(Double solde) {
        this.solde = solde;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Compte compte = (Compte) o;
        return Objects.equals(id, compte.id) &&
                Objects.equals(rib, compte.rib);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, rib);
    }

    @Override
    public String toString() {
        return "Compte{" +
                "rib='" + rib + '\'' +
                ", solde=" + solde +
                ", cin='" + cin + '\'' +
                ", dateCreattion=" + dateCreation +
                '}';
    }
}
