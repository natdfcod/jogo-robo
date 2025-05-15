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
                    ******************************************************************
                    | Bem Vindo jogo do robô no labirinto!! Tente acertar o caminho! |
                    ******************************************************************
                    [REGRAS]
                    Primeiramente você vai precisar digitar quantos porcento está a bateria do robô para começar o percurso.
                    Pense bem, pois por cada erro você gasta 2 porcento de bateria, e por cada acerto você gasta 2 por passo dado!!
                    Depois será perguntado que direção você quer testar e quantos passos quer dar.
                    Se errar fique tranquilo, você receberá dicas e poderá testar valores enquanto tiver bateria suficiente!!
                    Quando acertar as 6 duplas de comando chegará ao prêmio!
                    Caso acabe sua bateria, saiba que poderá jogar novamente sabendo que os comandos sempre são os mesmos.
                    **********************************************************************************************************""");
            System.out.println("Informe quanto de bateria está o robô (digite sem o simbulo de porcentagem):");
            int bateria = sc.nextInt();
            //Loop para obrigar a colocar um valor acima de 66
            while (bateria < 66) {
                System.out.println("Bateria baixa!! Digite uma bateria mais carregada (é necessário no mínimo 66% para iniciar):");
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
            System.out.print("Digite a direção (direta, esquerda, frente ou trás): ");
            char direcao = sc.next().toUpperCase().charAt(0);
            System.out.print("Digite quantos passos (de 1 até 8): ");
            int passos = sc.nextInt();
            //Loop para se o usuario errar qualquer um dos comandos, tentar acertar enquanto tiver bateria suficiente
            //Se ele erra ele perde 2 de bateria, se acertar ele perde 12 (nesse caso)
            while ((direcao != 'D' || passos != 6) && bateria >= 68) {
                contErros++;
                bateria -= 2;
                System.out.println("Comando incorreto, tente novamente!");
                //Estrutura de seleção para falar se ele acertou pelo menos um dos comandos
                if (direcao == 'D') {
                    System.out.println("Você acertou a direção, mas errou os passos");
                } else if (passos == 6) {
                    System.out.println("Você acertou os passos, mas errou a direção");
                //Para ver se o usuario digitou o passo acima ou abaixo do esperado
                }
                if (passos > 6) {
                    System.out.println("O robô deu mais passos do que precisava!!");
                } else if (passos < 6) {
                    System.out.println("O robô deu menos passos do que precisava!!");
                }
                System.out.println("E foi gasto 2% de bateria ao errar o caminho! O robô precisa ter no mínimo 66% para continuar!");
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
                System.out.print("Digite a direção (direta, esquerda, frente ou trás): ");
                direcao = sc.next().toUpperCase().charAt(0);
                System.out.print("Digite quantos passos (de 1 até 8): ");
                passos = sc.nextInt();
            }
            //if para confirmar se ele acertou ou não
            if (direcao == 'D' && passos == 6) {
                bateria -= 12;
                System.out.println("Correto!! O robô esta andando!");
                System.out.println("""
                         ________________ 
                        |            O   |
                        |           <|>  |
                        |___________|_|__|""");
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
                System.out.print("Digite a direção (direta, esquerda, frente ou trás): ");
                direcao = sc.next().toUpperCase().charAt(0);
                System.out.print("Digite quantos passos (de 1 até 8): ");
                passos = sc.nextInt();
                while ((direcao != 'T' || passos != 3) && bateria >= 56) {
                    contErros++;
                    bateria -= 2;
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
                    System.out.print("Digite a direção (direta, esquerda, frente ou trás): ");
                    direcao = sc.next().toUpperCase().charAt(0);
                    System.out.print("Digite quantos passos (de 1 até 8): ");
                    passos = sc.nextInt();
                }
                if (direcao == 'T' && passos == 3) {
                    bateria -= 6;
                    System.out.println("Correto!! Está no cominha certo!");
                    System.out.println("""
                             ________________
                            |                |
                            |                |
                            |________        |
                                     |   O   |
                                     |  <|>  |
                                     |__|_|__|""");
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
                    System.out.print("Digite a direção (direta, esquerda, frente ou trás): ");
                    direcao = sc.next().toUpperCase().charAt(0);
                    System.out.print("Digite quantos passos (de 1 até 8): ");
                    passos = sc.nextInt();
                    while ((direcao != 'D' || passos != 4) && bateria >= 50) {
                        contErros++;
                        bateria -= 2;
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
                        System.out.print("Digite a direção (direta, esquerda, frente ou trás): ");
                        direcao = sc.next().toUpperCase().charAt(0);
                        System.out.print("Digite quantos passos (de 1 até 8): ");
                        passos = sc.nextInt();
                    }
                    if (direcao == 'D' && passos == 4) {
                        bateria -= 8;
                        System.out.println("Correto!! Continue assim!");
                        System.out.println("""
                                     _________________
                                    |                 |
                                    |                 |
                                    |_________        |___________ 
                                              |               O   |
                                              |              <|>  |
                                              |______________|_|__|""");
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
                        System.out.print("Digite a direção (direta, esquerda, frente ou trás): ");
                        direcao = sc.next().toUpperCase().charAt(0);
                        System.out.print("Digite quantos passos (de 1 até 8): ");
                        passos = sc.nextInt();
                        while ((direcao != 'F' || passos != 8) && bateria >= 42) {
                            contErros++;
                            bateria -= 2;
                            System.out.println("Comando incorreto, tente novamente!");
                            if (direcao == 'D') {
                                System.out.println("Você acertou a direção, mas errou os passos");
                            } else if (passos == 8) {
                                System.out.println("Você acertou os passos, mas errou a direção");
                            }
                            if (passos > 8) {
                                System.out.println("O robô deu mais passos do que precisava!!");
                            } else if (passos < 8) {
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
                            System.out.print("Digite a direção (direta, esquerda, frente ou trás): ");
                            direcao = sc.next().toUpperCase().charAt(0);
                            System.out.print("Digite quantos passos (de 1 até 8): ");
                            passos = sc.nextInt();
                        }
                        if (direcao == 'F' && passos == 8) {
                            bateria -= 16;
                            System.out.println("Correto!! Está indo muito bem!");
                            System.out.println("""                  
                                                           _______
                                                          |   O   |
                                                          |  <|>  |
                                                          |  | |  |
                                                          |       |
                                     _________________    |       |
                                    |                 |   |       |
                                    |                 |   |       |
                                    |_________        |___|       |
                                              |                   |
                                              |                   |
                                              |___________________|""");
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
                            System.out.print("Digite a direção (direta, esquerda, frente ou trás): ");
                            direcao = sc.next().toUpperCase().charAt(0);
                            System.out.print("Digite quantos passos (de 1 até 8): ");
                            passos = sc.nextInt();
                            while ((direcao != 'D' || passos != 5) && bateria >= 26) {
                                contErros++;
                                bateria -= 2;
                                System.out.println("Comando incorreto, tente novamente!");
                                if (direcao == 'F') {
                                    System.out.println("Você acertou a direção, mas errou os passos");
                                } else if (passos == 5) {
                                    System.out.println("Você acertou os passos, mas errou a direção");
                                }
                                if (passos > 5) {
                                    System.out.println("O robô deu mais passos do que precisava!!");
                                } else if (passos < 5) {
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
                                System.out.print("Digite a direção (direta, esquerda, frente ou trás): ");
                                direcao = sc.next().toUpperCase().charAt(0);
                                System.out.print("Digite quantos passos (de 1 até 8): ");
                                passos = sc.nextInt();
                            }
                            if (direcao == 'D' && passos == 5) {
                                bateria -= 10;
                                System.out.println("Correto!! Você é muito bom nisso!");
                                System.out.println("""    
                                                           ____________________
                                                          |                O   |
                                                          |               <|>  |
                                                          |        _______|_|__|
                                                          |       |
                                     _________________    |       |
                                    |                 |   |       |
                                    |                 |   |       |
                                    |_________        |___|       |
                                              |                   |
                                              |                   |
                                              |___________________|""");
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
                                System.out.print("Digite a direção (direta, esquerda, frente ou trás): ");
                                direcao = sc.next().toUpperCase().charAt(0);
                                System.out.print("Digite quantos passos (de 1 até 8): ");
                                passos = sc.nextInt();
                                while ((direcao != 'T' || passos != 7) && bateria >= 16) {
                                    contErros++;
                                    bateria -= 2;
                                    System.out.println("Comando incorreto, tente novamente!");
                                    if (direcao == 'D') {
                                        System.out.println("Você acertou a direção, mas errou os passos");
                                    } else if (passos == 7) {
                                        System.out.println("Você acertou os passos, mas errou a direção");
                                    }
                                    if (passos > 7) {
                                        System.out.println("O robô deu mais passos do que precisava!!");
                                    } else if (passos < 7) {
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
                                    System.out.print("Digite a direção (direta, esquerda, frente ou trás): ");
                                    direcao = sc.next().toUpperCase().charAt(0);
                                    System.out.print("Digite quantos passos (de 1 até 8): ");
                                    passos = sc.nextInt();
                                }
                                if (direcao == 'T' && passos == 7) {
                                    bateria -= 14;
                                    System.out.println("Parabéns!! Você chegou ao prêmio ");
                                    System.out.println("""
                                                           _____________________
                                                          |                     |
                                                          |                     |
                                                          |        _____        |
                                                          |       |     |       |
                                     _________________    |       |     |       |
                                    |                 |   |       |     |       |
                                    |                 |   |       |     |       |
                                    |_________        |___|       |     |   O  { }
                                              |                   |     |  <|--_|_
                                              |                   |     |__|_|__|
                                              |___________________|""");
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