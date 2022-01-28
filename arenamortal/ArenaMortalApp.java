package com.israelandradedev.arenamortal;

public class ArenaMortalApp {
    public static void main(String[] args) {

        String[] armas = new String[5];
        armas[0] = "Adaga"; // Dado de Dano: 1d4
        armas[1] = "Espada-Curta"; // Dado de Dano: 1d6
        armas[2] = "Espada-Longa"; // Dado de Dano: 1d8
        armas[3] = "Alabarda"; // Dado de Dano: 1d10
        armas[4] = "Machado-De-Batalha"; // Dado de Dano: 1d12

        Gladiador glad1 = new Gladiador("Krum", "o Destruidor", 1, 3, 2, 6, armas[4], 12);
        Gladiador glad2 = new Gladiador("Artus", "o Habilidoso", 2, 6, 4, 3, armas[2], 9);

        System.out.println("");

        System.out.println("Bem-vindos à Arena Mortal! Onde os maiores lutadores colocam suas vidas em jogo!");
        System.out.println("Saindo da jaula à esquerda, temos " + glad1.getNome() + ", " + glad1.getTitulo() + "!");
        System.out.println("E da jaula à direita, vemos sair " + glad2.getNome() + ", " + glad2.getTitulo() + "!");
        System.out.println("Esta é uma batalha até a morte. Que vença o melhor!");

        System.out.println("");
        System.out.println("O sinal é dado e os lutadores se preparam para atacar...");

        while (glad1.getPontosDeVida() > 0 && glad2.getPontosDeVida() > 0) {
            int iniciativaglad1 = glad1.rolarD20() + glad1.getIniciativa();
            int iniciativaglad2 = glad2.rolarD20() + glad2.getIniciativa();

            System.out.println("");
            System.out.println("Iniciativa " + glad1.getNome() + ": " + iniciativaglad1);
            System.out.println("Iniciativa " + glad2.getNome() + ": " + iniciativaglad2);

            if (iniciativaglad1 > iniciativaglad2) {
                int ataqueTotalGlad1 = glad1.getAtaque() + glad1.rolarD20();
                int defesaTotalGlad2 = glad2.getDefesa() + glad2.rolarD20();

                if (ataqueTotalGlad1 >= defesaTotalGlad2) {
                    glad1.rolarDano();
                    glad2.reduzirPontosDeVida(glad1.getDanoTotal());

                    System.out.println("");

                    System.out.println(glad1.getNome() + " " + glad1.getTitulo() + " ataca! (Valor do Ataque de " + glad1.getNome() + ": " + ataqueTotalGlad1 + " Valor da Defesa de " + glad2.getNome() + ": " + defesaTotalGlad2 + ")");
                    System.out.println("E ele acerta seu oponente com seu " + glad1.getArmaCorpoACorpo() + "!");
                    System.out.println("(Rolando 1d" + glad1.definirDadoDano() + ", resultando em " + glad1.getDanoRolado() + " mais " + glad1.getDanoBase() + " de dano base, totalizando: " + glad1.getDanoTotal() + " de dano total)");
                    System.out.println("(" + glad2.getNome() + " fica com " + glad2.getPontosDeVida() + " pontos de vida)");
                    if(glad2.getPontosDeVida() <= 0){
                        System.out.println("Golpe brutal! Parece que é o fim de " + glad2.getNome() + ".");
                    } else {
                        System.out.println("E o sangue jorra pela arena! Que golpe violento!");
                    }
                } else {
                    System.out.println("");

                    System.out.println(glad1.getNome() + " " + glad1.getTitulo() + " tenta acertar seu oponente com o seu " + glad1.getArmaCorpoACorpo() + "! (Valor do Ataque de " + glad1.getNome() + ": " + ataqueTotalGlad1 + " Valor da Defesa de " + glad2.getNome() + ": " + defesaTotalGlad2 + ")");
                    System.out.println("Mas " + glad2.getNome() + " se esquiva.");
                }
            } else {
                int ataqueTotalGlad2 = glad2.getAtaque() + glad2.rolarD20();
                int defesaTotalGlad1 = glad1.getDefesa() + glad1.rolarD20();

                if (ataqueTotalGlad2 >= defesaTotalGlad1) {
                    glad2.rolarDano();
                    glad1.reduzirPontosDeVida(glad2.getDanoTotal());

                    System.out.println("");

                    System.out.println(glad2.getNome() + " " + glad2.getTitulo() + " ataca! (Valor do Ataque de " + glad2.getNome() + ": " + ataqueTotalGlad2 + " Valor da Defesa de " + glad1.getNome() + ": " + defesaTotalGlad1 + ")");
                    System.out.println("E ele acerta seu oponente com sua " + glad2.getArmaCorpoACorpo() + "!");

                    System.out.println("(Rolando 1d" + glad2.definirDadoDano() + ", resultando em " + glad2.getDanoRolado() + " mais " + glad2.getDanoBase() + " de dano base, totalizando: " + glad2.getDanoTotal() + " de dano total)");
                    System.out.println("(" + glad1.getNome() + " fica com " + glad1.getPontosDeVida() + " pontos de vida)");

                    if(glad2.getPontosDeVida() <= 0){
                        System.out.println("Golpe preciso! Parece que é o fim de " + glad1.getNome() + ".");
                    } else {
                        System.out.println("E o sangue voa junto à trajetória da arma! Que golpe preciso!");
                    }
                } else {
                    System.out.println("");

                    System.out.println(glad2.getNome() + " " + glad2.getTitulo() + " tenta acertar seu oponente com a sua " + glad2.getArmaCorpoACorpo() + "! (Valor do Ataque de " + glad2.getNome() + ": " + ataqueTotalGlad2 + " Valor da Defesa de " + glad1.getNome() + ": " + defesaTotalGlad1 + ")");
                    System.out.println("Mas " + glad1.getNome() + " se defende.");
                }
            }
        }
        if(glad1.getPontosDeVida() > glad2.getPontosDeVida()){
            System.out.println("");

            System.out.println("E o combate chega ao final! " + glad1.getNome() + " " + glad1.getTitulo() + " desferiu um golpe mortal em " + glad2.getNome() + "!");
            System.out.println("A platéia vai ao delírio e o lutador vive mais um dia para enfrentar outro oponente.");
        } else {
            System.out.println("");

            System.out.println("E o combate chega ao final! " + glad2.getNome() + " " + glad2.getTitulo() + " desfere um golpe mortal em " + glad1.getNome() + "!");
            System.out.println("A platéia vai ao delírio e o vencedor vive mais um dia para enfrentar outro oponente na Arena Mortal!");
        }
        System.out.println("");
        System.out.println("FIM.");
    }
}