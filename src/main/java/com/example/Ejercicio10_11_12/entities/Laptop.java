package com.example.Ejercicio10_11_12.entities;

import jakarta.persistence.*;


@Entity
@Table(name = "laptops")
public class Laptop {
    // Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String procesador;
    private Integer memoriaRam;
    private String sistemaOperativo;
    private Integer discoDuro;
    private Integer pantalla;



    // Constructor
    public Laptop(){}
    public Laptop(Long id, String procesador, Integer memoriaRam, String sistemaOperativo, Integer discoDuro, Integer pantalla ){
        this.id = id;
        this.procesador = procesador;
        this.memoriaRam = memoriaRam;
        this.sistemaOperativo = sistemaOperativo;
        this.discoDuro = discoDuro;
        this.pantalla = pantalla;
    }


    //getter and setter

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProcesador() {
        return procesador;
    }

    public void setProcesador(String procesador) {
        this.procesador = procesador;
    }

    public Integer getMemoriaRam() {
        return memoriaRam;
    }

    public void setMemoriaRam(Integer memoriaRam) {
        this.memoriaRam = memoriaRam;
    }

    public String getSistemaOperativo() {
        return sistemaOperativo;
    }

    public void setSistemaOperativo(String sistemaOperativo) {
        this.sistemaOperativo = sistemaOperativo;
    }

    public Integer getDiscoDuro() {
        return discoDuro;
    }

    public void setDiscoDuro(Integer discoDuro) {
        this.discoDuro = discoDuro;
    }

    public Integer getPantalla() {
        return pantalla;
    }

    public void setPantalla(Integer pantalla) {
        this.pantalla = pantalla;
    }


    //toString


    @Override
    public String toString() {
        return "Laptop{" +
                "id=" + id +
                ", procesador='" + procesador + '\'' +
                ", memoriaRam=" + memoriaRam +
                ", sistemaOperativo='" + sistemaOperativo + '\'' +
                ", discoDuro=" + discoDuro +
                ", pantalla=" + pantalla +
                '}';
    }
}
