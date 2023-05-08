/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lojainformatica.model;

/**
 *
 * @author alexs 3.1)Adicione os atributos: marca, HD e processador 3.1.1)
 * Defina o atributo marca como estático E insira seu nome como padrão da marca
 * - Ex: JoaoSilva 3.2.2) Crie os getters e setters para os atributos e um
 * construtor vazio para a classe.
 *
 */
public class Computador {

    private final static String marcaPadrao = "AlexsandroLopes";
    private String HD;
    private String marca;
    private String precessador;
    int numeroDoComputador;

    public int getNumeroDoComputador() {
        return numeroDoComputador;
    }

    public void setNumeroDoComputador(int numeroDoComputador) {
        this.numeroDoComputador = numeroDoComputador;
    }
   public Computador() {
    }

    public static String getMarcaPadrao() {
        return marcaPadrao;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getHD() {
        return HD;
    }

    public void setHD(String HD) {
        this.HD = HD;
    }

    public String getPrecessador() {
        return precessador;
    }

    public void setPrecessador(String precessador) {
        this.precessador = precessador;
    }

}
