package fr.laerce.cinema.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "persons")
public class Personne {

    private long id;
    private String nom;
    private String prenom;
    private Integer naissance;
    private String photoPath;
//    private List<Film> filmRealises;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "surname", nullable = false, length = 60)
    public String getNom() {
        return nom;
    }

    public void setNom(String surname) {
        this.nom = surname;
    }

    @Basic
    @Column(name = "givenname", nullable = true, length = 40)
    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String givenname) {
        this.prenom = givenname;
    }

    @Basic
    @Column(name = "birth_year", nullable = true)
    public Integer getNaissance() {
        return naissance;
    }

    public void setNaissance(Integer birthYear) {
        this.naissance = birthYear;
    }

    @Basic
    @Column(name = "image_path", nullable = true, length = 80)
    public String getPhotoPath() {
        return photoPath;
    }

    public void setPhotoPath(String imagePath) {
        this.photoPath = imagePath;
    }

   /* @OneToMany(mappedBy = "realisateur")
    public List<Film> getFilmsRealises(){
        return filmRealises;
    }

    public void setFilmsRealises(List<Film> films){
        this.filmRealises = films;
    }*/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Personne persons = (Personne) o;

        if (id != persons.id) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "Personne{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", naissance=" + naissance +
                ", photoPath='" + photoPath + '\'' +
                '}';
    }
}
