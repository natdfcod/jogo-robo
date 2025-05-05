import java.util.Scanner;

public class Sprint {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //Possiveis baterias
        String b10 = "▌■□□□□□□□□□▐ ",b20 = "▌■■□□□□□□□□▐ ",b30 = "▌■■■□□□□□□□▐ ",b40 ="▌■■■■□□□□□□▐ ",
                b50 = "▌■■■■■□□□□□▐ ", b60 = "▌■■■■■■□□□□▐ ",b70 = "▌■■■■■■■□□□▐ ",b80 = "▌■■■■■■■■□□▐ ",
                b90 = "▌■■■■■■■■■□▐ ",b100 = "▌■■■■■■■■■■▐ ",b0 ="▌□□□□□□□□□□▐ " ;
        char reiniciar;
        //'do while' englobando todo o programa
        do {
        int contErros=0;
            System.out.println("""
                    ************************
                    Bem Vindo jogo do robô no labirinto!! Tente acertar o caminho!
                    Mas antes, digite quantos porcento está a bateria do robô para começar o percurso
                    Pense bem, pois por cada erro você gasta 5 porcento de bateria, e por cada acerto você gasta 10!!
                    (digite sem o simbulo de porcentagem):""");
            int bateria = sc.nextInt();
            //Loop para obrigar a colocar um valor acima de 60
            while (bateria < 60) {
                System.out.println("Bateria baixa!! Digite uma bateria mais carregada:");
                bateria = sc.nextInt();
            }
            System.out.println("""
                    robô ligado!!
                     _______
                    |   O   |
                    |  <|>  |
                    |__|_|__|""");
            //Estrutura de seleção para definir qual imagem da bateria é impressa
            if (bateria <= 65) {
                System.out.println(b60 + bateria + "%");
            } else if (bateria <= 75) {
                System.out.println(b70 + bateria + "%");
            } else if (bateria <= 85) {
                System.out.println(b80 + bateria + "%");
            } else if (bateria <= 95) {
                System.out.println(b90 + bateria + "%");
            } else if (bateria <= 100) {
                System.out.println(b100 + bateria + "%");
            }
            System.out.println("************************");
            //Obtenção da direção e de quantos passos o usuario digitou
            System.out.print(" Digite a direção (direta, esquerda, frente ou trás) (direta, esquerda, frente ou trás): ");
            char direcao = sc.next().toUpperCase().charAt(0);
            System.out.print("Digite quantos passos (de 1 até 6): ");
            int passos = sc.nextInt();
            //Loop para se o usuario errar qualquer um dos comandos, tentar acertar enquanto tiver bateria suficiente
            //Se ele erra ele perde 5 de bateria, se acertar ele perde 10
            while ((direcao != 'T' || passos != 4) && bateria >= 65) {
                contErros++;
                bateria += -5;
                System.out.println("Comando incorreto, tente novamente!");
                //Estrutura de seleção para falar se ele acertou pelo menos um dos comandos
                if (direcao == 'T') {
                    System.out.println("Você acertou a direção, mas errou os passos");
                } else if (passos == 4) {
                    System.out.println("Você acertou os passos, mas errou a direção");
                //Para ver se o usuario digitou o passo acima ou abaixo do esperado
                }
                if (passos > 4) {
                    System.out.println("O robô deu mais passos do que precisava!!");
                } else if (passos < 4) {
                    System.out.println("O robô deu menos passos do que precisava!!");
                }
                System.out.println("E foi gasto 5% de bateria ao errar o caminho! O robô precisa ter no mínimo 60% para continuar!");
                //Estrutura de seleção para definir qual imagem da bateria é impressa
                if (bateria <= 65) {
                    System.out.println(b60 + bateria + "%");
                } else if (bateria <= 75) {
                    System.out.println(b70 + bateria + "%");
                } else if (bateria <= 85) {
                    System.out.println(b80 + bateria + "%");
                } else if (bateria <= 95) {
                    System.out.println(b90 + bateria + "%");
                } else if (bateria <= 100) {
                    System.out.println(b100 + bateria + "%");
                }
                System.out.println("************************");
                System.out.print(" Digite a direção (direta, esquerda, frente ou trás): ");
                direcao = sc.next().toUpperCase().charAt(0);
                System.out.print("Digite quantos passos (de 1 até 6): ");
                passos = sc.nextInt();
            }
            //if para confirmar se ele acertou ou não
            if (direcao == 'T' && passos == 4) {
                bateria += -10;
                System.out.println("Correto!! O robô esta andando!");
                System.out.println("""
                         _______
                        |       |
                        |       |
                        |       |
                        |   O   |
                        |  <|>  |
                        |__|_|__|""");
                if (bateria <= 55) {
                    System.out.println(b50 + bateria + "%");
                } else if (bateria <= 65) {
                    System.out.println(b60 + bateria + "%");
                } else if (bateria <= 75) {
                    System.out.println(b70 + bateria + "%");
                } else if (bateria <= 85) {
                    System.out.println(b80 + bateria + "%");
                } else if (bateria <= 90) {
                    System.out.println(b90 + bateria + "%");
                }
                System.out.println("************************");
                System.out.print(" Digite a direção (direta, esquerda, frente ou trás): ");
                direcao = sc.next().toUpperCase().charAt(0);
                System.out.print("Digite quantos passos (de 1 até 6): ");
                passos = sc.nextInt();
                while ((direcao != 'D' || passos != 3) && bateria >= 55) {
                    contErros++;
                    bateria += -5;
                    System.out.println("Comando incorreto, tente novamente!");
                    if (direcao == 'D') {
                        System.out.println("Você acertou a direção, mas errou os passos");
                    } else if (passos == 3) {
                        System.out.println("Você acertou os passos, mas errou a direção");
                    }
                    if (passos > 3) {
                        System.out.println("O robô deu mais passos do que precisava!!");
                    } else if (passos < 3) {
                        System.out.println("O robô deu menos passos do que precisava!!");
                    }
                    System.out.println("E foi gasto 5% de bateria ao errar o caminho! O robô precisa ter no mínimo 50% para continuar!");
                    if (bateria <= 55) {
                        System.out.println(b50 + bateria + "%");
                    } else if (bateria <= 65) {
                        System.out.println(b60 + bateria + "%");
                    } else if (bateria <= 75) {
                        System.out.println(b70 + bateria + "%");
                    } else if (bateria <= 85) {
                        System.out.println(b80 + bateria + "%");
                    } else if (bateria <= 90) {
                        System.out.println(b90 + bateria + "%");
                    }
                    System.out.println("************************");
                    System.out.print(" Digite a direção (direta, esquerda, frente ou trás): ");
                    direcao = sc.next().toUpperCase().charAt(0);
                    System.out.print("Digite quantos passos (de 1 até 6): ");
                    passos = sc.nextInt();
                }
                if (direcao == 'D' && passos == 3) {
                    bateria += -10;
                    System.out.println("Correto!! Está no cominha certo!");
                    System.out.println("""
                             _______
                            |       |
                            |       |
                            |       |_______
                            |            O  |
                            |           <|> |
                            |___________|_|_|""");
                    if (bateria <= 45) {
                        System.out.println(b40 + bateria + "%");
                    } else if (bateria <= 55) {
                        System.out.println(b50 + bateria + "%");
                    } else if (bateria <= 65) {
                        System.out.println(b60 + bateria + "%");
                    } else if (bateria <= 75) {
                        System.out.println(b70 + bateria + "%");
                    } else if (bateria <= 80) {
                        System.out.println(b80 + bateria + "%");
                    }
                    System.out.println("************************");
                    System.out.print(" Digite a direção (direta, esquerda, frente ou trás): ");
                    direcao = sc.next().toUpperCase().charAt(0);
                    System.out.print("Digite quantos passos (de 1 até 6): ");
                    passos = sc.nextInt();
                    while ((direcao != 'T' || passos != 3) && bateria >= 45) {
                        contErros++;
                        bateria += -5;
                        System.out.println("Comando incorreto, tente novamente!");
                        if (direcao == 'T') {
                            System.out.println("Você acertou a direção, mas errou os passos");
                        } else if (passos == 3) {
                            System.out.println("Você acertou os passos, mas errou a direção");
                        }
                        if (passos > 3) {
                            System.out.println("O robô deu mais passos do que precisava!!");
                        } else if (passos < 3) {
                            System.out.println("O robô deu menos passos do que precisava!!");
                        }
                        System.out.println("E foi gasto 5% de bateria ao errar o caminho! O robô precisa ter no mínimo 40% para continuar!");
                        if (bateria <= 45) {
                            System.out.println(b40 + bateria + "%");
                        } else if (bateria <= 55) {
                            System.out.println(b50 + bateria + "%");
                        } else if (bateria <= 65) {
                            System.out.println(b60 + bateria + "%");
                        } else if (bateria <= 75) {
                            System.out.println(b70 + bateria + "%");
                        } else if (bateria <= 80) {
                            System.out.println(b80 + bateria + "%");
                        }
                        System.out.println("************************");
                        System.out.print(" Digite a direção (direta, esquerda, frente ou trás): ");
                        direcao = sc.next().toUpperCase().charAt(0);
                        System.out.print("Digite quantos passos (de 1 até 6): ");
                        passos = sc.nextInt();
                    }
                    if (direcao == 'T' && passos == 3) {
                        bateria += -10;
                        System.out.println("Correto!! Continue assim!");
                        System.out.println("""
                                 _______
                                |       |
                                |       |
                                |       |_______
                                |               |
                                |               |
                                |_______        |
                                        |   O   |
                                        |  <|>  |
                                        |__|_|__|""");
                        if (bateria <= 35) {
                            System.out.println(b30 + bateria + "%");
                        } else if (bateria <= 45) {
                            System.out.println(b40 + bateria + "%");
                        } else if (bateria <= 55) {
                            System.out.println(b50 + bateria + "%");
                        } else if (bateria <= 65) {
                            System.out.println(b60 + bateria + "%");
                        } else if (bateria <= 70) {
                            System.out.println(b70 + bateria + "%");
                        }
                        System.out.println("************************");
                        System.out.print(" Digite a direção (direta, esquerda, frente ou trás): ");
                        direcao = sc.next().toUpperCase().charAt(0);
                        System.out.print("Digite quantos passos (de 1 até 6): ");
                        passos = sc.nextInt();
                        while ((direcao != 'D' || passos != 6) && bateria >= 35) {
                            contErros++;
                            bateria += -5;
                            System.out.println("Comando incorreto, tente novamente!");
                            if (direcao == 'D') {
                                System.out.println("Você acertou a direção, mas errou os passos");
                            } else if (passos == 6) {
                                System.out.println("Você acertou os passos, mas errou a direção");
                            }
                            if (passos > 6) {
                                System.out.println("O robô deu mais passos do que precisava!!");
                            } else if (passos < 6) {
                                System.out.println("O robô deu menos passos do que precisava!!");
                            }
                            System.out.println("E foi gasto 5% de bateria ao errar o caminho! O robô precisa ter no mínimo 30% para continuar!");
                            if (bateria <= 35) {
                                System.out.println(b30 + bateria + "%");
                            } else if (bateria <= 45) {
                                System.out.println(b40 + bateria + "%");
                            } else if (bateria <= 55) {
                                System.out.println(b50 + bateria + "%");
                            } else if (bateria <= 65) {
                                System.out.println(b60 + bateria + "%");
                            } else if (bateria <= 70) {
                                System.out.println(b70 + bateria + "%");
                            }
                            System.out.println("************************");
                            System.out.print(" Digite a direção (direta, esquerda, frente ou trás): ");
                            direcao = sc.next().toUpperCase().charAt(0);
                            System.out.print("Digite quantos passos (de 1 até 6): ");
                            passos = sc.nextInt();
                        }
                        if (direcao == 'D' && passos == 6) {
                            bateria += -10;
                            System.out.println("Correto!! Está indo muito bem!");
                            System.out.println("""
                                     _______
                                    |       |
                                    |       |
                                    |       |_______
                                    |               |
                                    |               |
                                    |_______        |_____________
                                            |                 O   |
                                            |                <|>  |
                                            |________________|_|__|""");
                            if (bateria <= 25) {
                                System.out.println(b20 + bateria + "%");
                            } else if (bateria <= 35) {
                                System.out.println(b30 + bateria + "%");
                            } else if (bateria <= 45) {
                                System.out.println(b40 + bateria + "%");
                            } else if (bateria <= 55) {
                                System.out.println(b50 + bateria + "%");
                            } else if (bateria <= 60) {
                                System.out.println(b60 + bateria + "%");
                            }
                            System.out.println("************************");
                            System.out.print(" Digite a direção (direta, esquerda, frente ou trás): ");
                            direcao = sc.next().toUpperCase().charAt(0);
                            System.out.print("Digite quantos passos (de 1 até 6): ");
                            passos = sc.nextInt();
                            while ((direcao != 'F' || passos != 6) && bateria >= 25) {
                                contErros++;
                                bateria += -5;
                                System.out.println("Comando incorreto, tente novamente!");
                                if (direcao == 'F') {
                                    System.out.println("Você acertou a direção, mas errou os passos");
                                } else if (passos == 6) {
                                    System.out.println("Você acertou os passos, mas errou a direção");
                                }
                                if (passos > 6) {
                                    System.out.println("O robô deu mais passos do que precisava!!");
                                } else if (passos < 6) {
                                    System.out.println("O robô deu menos passos do que precisava!!");
                                }
                                System.out.println("E foi gasto 5% de bateria ao errar o caminho! O robô precisa ter no mínimo 20% para continuar!");
                                if (bateria <= 25) {
                                    System.out.println(b20 + bateria + "%");
                                } else if (bateria <= 35) {
                                    System.out.println(b30 + bateria + "%");
                                } else if (bateria <= 45) {
                                    System.out.println(b40 + bateria + "%");
                                } else if (bateria <= 55) {
                                    System.out.println(b50 + bateria + "%");
                                } else if (bateria <= 60) {
                                    System.out.println(b60 + bateria + "%");
                                }
                                System.out.println("************************");
                                System.out.print(" Digite a direção (direta, esquerda, frente ou trás): ");
                                direcao = sc.next().toUpperCase().charAt(0);
                                System.out.print("Digite quantos passos (de 1 até 6): ");
                                passos = sc.nextInt();
                            }
                            if (direcao == 'F' && passos == 6) {
                                bateria += -10;
                                System.out.println("Correto!! Você é muito bom nisso!");
                                System.out.println("""
                                        
                                         _______               _______
                                        |       |             |   O   |
                                        |       |             |  <|>  |
                                        |       |_______      |  | |  |
                                        |               |     |       |
                                        |               |     |       |
                                        |_______        |_____|       |
                                                |                     |
                                                |                     |
                                                |_____________________|""");
                                if (bateria <= 15) {
                                    System.out.println(b10 + bateria + "%");
                                } else if (bateria <= 25) {
                                    System.out.println(b20 + bateria + "%");
                                } else if (bateria <= 35) {
                                    System.out.println(b30 + bateria + "%");
                                } else if (bateria <= 45) {
                                    System.out.println(b40 + bateria + "%");
                                } else if (bateria <= 50) {
                                    System.out.println(b50 + bateria + "%");
                                }
                                System.out.println("************************");
                                System.out.print(" Digite a direção (direta, esquerda, frente ou trás): ");
                                direcao = sc.next().toUpperCase().charAt(0);
                                System.out.print("Digite quantos passos (de 1 até 6): ");
                                passos = sc.nextInt();
                                while ((direcao != 'D' || passos != 4) && bateria >= 15) {
                                    contErros++;
                                    bateria += -5;
                                    System.out.println("Comando incorreto, tente novamente!");
                                    if (direcao == 'D') {
                                        System.out.println("Você acertou a direção, mas errou os passos");
                                    } else if (passos == 4) {
                                        System.out.println("Você acertou os passos, mas errou a direção");
                                    }
                                    if (passos > 4) {
                                        System.out.println("O robô deu mais passos do que precisava!!");
                                    } else if (passos < 4) {
                                        System.out.println("O robô deu menos passos do que precisava!!");
                                    }
                                    System.out.println("E foi gasto 5% de bateria ao errar o caminho! O robô precisa ter no mínimo 10% para continuar!");
                                    if (bateria <= 15) {
                                        System.out.println(b10 + bateria + "%");
                                    } else if (bateria <= 25) {
                                        System.out.println(b20 + bateria + "%");
                                    } else if (bateria <= 35) {
                                        System.out.println(b30 + bateria + "%");
                                    } else if (bateria <= 45) {
                                        System.out.println(b40 + bateria + "%");
                                    } else if (bateria <= 50) {
                                        System.out.println(b50 + bateria + "%");
                                    }
                                    System.out.println("************************");
                                    System.out.print(" Digite a direção (direta, esquerda, frente ou trás): ");
                                    direcao = sc.next().toUpperCase().charAt(0);
                                    System.out.print("Digite quantos passos (de 1 até 6): ");
                                    passos = sc.nextInt();
                                }
                                if (direcao == 'D' && passos == 4) {
                                    bateria += -10;
                                    System.out.println("Parabéns!! Você chegou ao prêmio ");
                                    System.out.println("""
                                             _______               ____________________
                                            |       |             |             O  { } |
                                            |       |             |            <|--_|_ |
                                            |       |_______      |        ____|_|_____|
                                            |               |     |       |
                                            |               |     |       |
                                            |_______        |_____|       |
                                                    |                     |
                                                    |                     |
                                                    |_____________________|""");
                                    if (bateria <= 5) {
                                        System.out.println(b0 + bateria + "%");
                                    } else if (bateria <= 15) {
                                        System.out.println(b10 + bateria + "%");
                                    } else if (bateria <= 25) {
                                        System.out.println(b20 + bateria + "%");
                                    } else if (bateria <= 35) {
                                        System.out.println(b30 + bateria + "%");
                                    } else if (bateria <= 40) {
                                        System.out.println(b40 + bateria + "%");
                                    }
                                //Se o usuario não passar pelo if de confirmação ele vem para esses 'else's
                                } else {
                                    System.out.println("Bateria acabou!!");
                                    contErros++;
                                }
                            } else {
                                System.out.println("Bateria acabou!!");
                                contErros++;
                            }
                        } else {
                            System.out.println("Bateria acabou!!");
                            contErros++;
                        }
                    } else {
                        System.out.println("Bateria acabou!!");
                        contErros++;
                    }
                } else {
                    System.out.println("Bateria acabou!!");
                    contErros++;
                }
            } else {
                System.out.println("Bateria acabou!!");
                contErros++;
            }
            //if para definir quantas vezes o usuario errou o caminho
            if (contErros==1) {
                System.out.println("Você errou o caminho somente uma vez");
            } else if (contErros>1) {
            System.out.println("Você errou o caminho "+contErros+" vezes");
            } else {
                System.out.println("Você acertou o caminho de primeria!! Impressionante!");
            }
            //Pergunta se o usuario quer jogar de novo para entrar no loop do 'do while'
            System.out.println("Quer jogar de novo? (S/N):");
            reiniciar = sc.next().toUpperCase().charAt(0);
        } while (reiniciar =='S');
        System.out.println("Fim do programa!");
    }
}