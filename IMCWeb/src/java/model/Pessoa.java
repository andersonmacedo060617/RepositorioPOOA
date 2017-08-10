/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author aluno
 */
public class Pessoa {
    private String nome;
    private double peso, altura;

    
    public Pessoa(){
        
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }
    
    public double imc(){
        return peso / Math.pow(altura, 2);
    }
    
    public String faixa(){
        double imc = imc();
        if(imc <= 17){
            return "Magreza";
        }else if(imc <= 22){
            return "Magro";
        }else if(imc <= 26){
            return "Normal";
        }else{
            return "Gordo";
        }
    }
    
}
