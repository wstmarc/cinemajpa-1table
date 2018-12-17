package fr.laerce.cinema.model;

import java.util.Objects;

public class Role {
    private Film film;
    private Personne acteur;
    private String alias;
    private Integer odre;

    public Role(Film film, Personne acteur, String alias, Integer odre) {
        this.film = film;
        this.acteur = acteur;
        this.alias = alias;
        this.odre = odre;
    }

    public Role() {

    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public Personne getActeur() {
        return acteur;
    }

    public void setActeur(Personne acteur) {
        this.acteur = acteur;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public Integer getOdre() {
        return odre;
    }

    public void setOdre(Integer odre) {
        this.odre = odre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Role)) return false;
        Role role = (Role) o;
        return Objects.equals(getFilm(), role.getFilm()) &&
                Objects.equals(getActeur(), role.getActeur()) &&
                Objects.equals(getAlias(), role.getAlias()) &&
                Objects.equals(getOdre(), role.getOdre());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFilm(), getActeur(), getAlias(), getOdre());
    }
}
