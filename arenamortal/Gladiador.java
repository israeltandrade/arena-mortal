package com.israelandradedev.arenamortal;

import java.util.Random;

public class Gladiador {

    private String  nome;
    private String  titulo;
    private int     iniciativa;
    private int     ataque;
    private int     defesa;
    private int     danoBase;
    private String  armaCorpoACorpo;
    private int     pontosDeVida;
    private int     danoRolado;
    private int     danoTotal;

    public Gladiador(String nome, String titulo, int iniciativa, int ataque, int defesa, int danoBase, String armaCorpoACorpo, int pontosDeVida) {
        this.nome = nome;
        this.titulo = titulo;
        this.iniciativa = iniciativa;
        this.ataque = ataque;
        this.defesa = defesa;
        this.danoBase = danoBase;
        this.armaCorpoACorpo = armaCorpoACorpo;
        this.pontosDeVida = pontosDeVida;
    }

    public int definirDadoDano () {
        int dadoDano;
        
        switch (armaCorpoACorpo) {
            case "Adaga":
                dadoDano = 4;
                break;
            case "Espada-Curta":
                dadoDano = 6;
                break;

            case "Espada-Longa":
                dadoDano = 8;
                break;

            case "Alabarda":
                dadoDano = 10;
                break;

            case "Machado-De-Batalha":
                dadoDano = 12;
                break;
            default:
                dadoDano = 4;
        }
        return dadoDano;
    }

    public String getNome() {
        return nome;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getIniciativa() {
        return iniciativa;
    }

    public int getAtaque() {
        return ataque;
    }

    public int getDefesa() {
        return defesa;
    }

    public int getDanoBase() {
        return danoBase;
    }

    public String getArmaCorpoACorpo() {
        return armaCorpoACorpo;
    }

    public int getPontosDeVida() {
        return pontosDeVida;
    }

    public int getDanoRolado() {
        return danoRolado;
    }

    public int getDanoTotal() {
        return  danoTotal;
    }

    public int rolarD20() {
        Random  rolagemD20 = new Random();
        int     d20Rolado = rolagemD20.nextInt(20)+1;
        return  d20Rolado;
    }



    public void rolarDano() {
        Random rolagemDano = new Random();

        switch (armaCorpoACorpo) {
            case "Adaga":
                danoRolado = rolagemDano.nextInt(4) + 1;
                break;
            case "Espada-Curta":
                danoRolado = rolagemDano.nextInt(6) + 1;
                break;
            case "Espada-Longa":
                danoRolado = rolagemDano.nextInt(8) + 1;
                break;
            case "Alabarda":
                danoRolado = rolagemDano.nextInt(10) + 1;
                break;
            case "Machado-De-Batalha":
                danoRolado = rolagemDano.nextInt(12) + 1;
                break;
            default:
                danoRolado = rolagemDano.nextInt(6) + 1;
        }
        danoTotal = danoRolado + danoBase;
    }

    public void reduzirPontosDeVida(int danoRecebido) {
        this.pontosDeVida -= danoRecebido;
    }
}