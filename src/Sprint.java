import java.util.Scanner;

public class Sprint {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //Possiveis baterias
        String b10 = "▌■□□□□□□□□□▐ ",b20 = "▌■■□□□□□□□□▐ ",b30 = "▌■■■□□□□□□□▐ ",b40 ="▌■■■■□□□□□□▐ ",
                b50 = "▌■■■■■□□□□□▐ ", b60 = "▌■■■■■■□□□□▐ ",b70 = "▌■■■■■■■□□□▐ ",b80 = "▌■■■■■■■■□□▐ ",
                b90 = "▌■■■■■■■■■□▐ ",b100 = "▌■■■■■■■■■■▐ ",b0 ="▌□□□□□□□□□□▐ " ;
        char direcao;
        int passos;
        char reiniciar;
        String direcaoInteira = "";
        //'do while' englobando todo o programa
        do {
        int contErros=0;
            System.out.println("""
                    *********************************************************************
                    | Bem Vindo ao jogo do robô no labirinto!! Tente acertar o caminho! |
                    *********************************************************************
                    [REGRAS]
                    Primeiramente você vai precisar digitar quantos porcento está a bateria do robô para começar o percurso.
                    Pense bem, pois por cada erro você gasta 2 porcento de bateria, e por cada acerto você gasta 2 por passo dado!!
                    Depois será perguntado que direção você quer testar e quantos passos quer dar.
                    Se errar fique tranquilo, você receberá dicas e poderá testar valores enquanto tiver bateria suficiente!!
                    Quando acertar as 6 duplas de comando chegará ao prêmio!
                    Caso acabe sua bateria, saiba que poderá jogar novamente sabendo que os comandos sempre são os mesmos.
                    Lembre se que o robô não dá dois comandos de direção iguais em seguida, e leia com ateção as dicas durante o jogo!
                    O jogo somente começa se o robô tiver mais de 66% de bateria!!
                    **********************************************************************************************************""");
            System.out.println("Informe quanto de bateria você quer colocar no robô (digite sem o símbolo de porcentagem):");
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
            if (bateria <= 75) {
                System.out.println(b70 + bateria + "%");
            } else if (bateria <= 85) {
                System.out.println(b80 + bateria + "%");
            } else if (bateria <= 95) {
                System.out.println(b90 + bateria + "%");
            } else if (bateria <= 100) {
                System.out.println(b100 + bateria + "%");
            }
            System.out.println("************************");
            //Obtenção da direção e de quantos passos o usuario digitar
            System.out.print("Digite a direção (direta, esquerda, frente ou trás): ");
            direcao = sc.next().toUpperCase().charAt(0);
            //loop para obrigar o usuario a escrever somente os dados aceitaveis
            while (direcao != 'D' && direcao != 'E' && direcao != 'F' && direcao != 'T') {
                System.out.println("Digite somente direções aceitas (direita, esquerda, frente e trás):");
                direcao = sc.next().toUpperCase().charAt(0);
            }
            System.out.print("Digite quantos passos (de 1 até 8): ");
            passos = sc.nextInt();
            //loop para obrigar o usuario de novo
            while (passos < 1 || passos > 8) {
                System.out.println("Digite somente valores entre 1 e 8 : ");
                passos = sc.nextInt();
            }
            //Loop para se o usuario errar qualquer um dos comandos, tentar acertar enquanto tiver bateria suficiente
            //Se ele erra ele perde 2 de bateria, se acertar ele perde 12 (nesse caso)
            //Se ele errar somente um dos comandos ele perde so 1 de bateria
            while (direcao != 'D' || passos != 6) {
                System.out.println("Comando incorreto!");
                //Estrutura de seleção para falar se ele acertou pelo menos um dos comandos
                if ((direcao == 'D' || passos == 6) && bateria >= 67) {
                    System.out.println("Você acertou somente um dos comandos!!");
                    while ((direcao == 'D' && passos != 6) && bateria >= 67) {
                        contErros++;
                        bateria -= 1;
                        System.out.println(String.format("O robô viu que o caminho é para a direita, mas não pode dar %d passos.", passos));
                        if (passos > 6) {
                            System.out.println(String.format("Se ele der %d passos ele bate na parede, tente um valor mais baixo (de 1 até %d)",passos, passos));
                        } else if (passos < 6) {
                            System.out.println(String.format("Se ele der %d passos o robô não chegaria até a proxima virada, tente um valor mais alto (de %d até 8)",passos,passos));
                        }
                        System.out.println("Por você ter errado somente um dos comandos, você perdeu 1 porcento de bateria!");
                        if (bateria <= 75) {
                            System.out.println(b70 + bateria + "%");
                        } else if (bateria <= 85) {
                            System.out.println(b80 + bateria + "%");
                        } else if (bateria <= 95) {
                            System.out.println(b90 + bateria + "%");
                        } else if (bateria <= 100) {
                            System.out.println(b100 + bateria + "%");
                        }
                        System.out.println("Digite um novo valor de passos:");
                        passos = sc.nextInt();
                        while (passos < 1 || passos > 8) {
                            System.out.println("Digite somente valores entre 1 e 8 : ");
                            passos = sc.nextInt();
                        }
                    }
                    while ((passos == 6 && direcao != 'D') && bateria >= 67) {
                        contErros++;
                        bateria -= 1;
                        switch (direcao) {
                            case 'D':
                                direcaoInteira="direita";
                                break;
                            case 'E':
                                direcaoInteira="esquerda";
                                break;
                            case 'F':
                                direcaoInteira="frente";
                                break;
                            case 'T':
                                direcaoInteira="trás";
                        }
                        System.out.println(String.format("O robô viu que pode dar %d passos, mas não para %s.", passos, direcaoInteira));
                        System.out.println("Por você ter errado somente um dos comandos, você perdeu 1 porcento de bateria!");
                        if (bateria <= 75) {
                            System.out.println(b70 + bateria + "%");
                        } else if (bateria <= 85) {
                            System.out.println(b80 + bateria + "%");
                        } else if (bateria <= 95) {
                            System.out.println(b90 + bateria + "%");
                        } else if (bateria <= 100) {
                            System.out.println(b100 + bateria + "%");
                        }
                        System.out.println("Tente outra direção:");
                        direcao = sc.next().toUpperCase().charAt(0);
                        while (direcao != 'D' && direcao != 'E' && direcao != 'F' && direcao != 'T') {
                            System.out.println("Digite somente direções aceitas (direita, esquerda, frente e trás):");
                            direcao = sc.next().toUpperCase().charAt(0);
                        }
                    }
                } else if (direcao != 'D' && passos != 6 && bateria >= 68) {
                    contErros++;
                    bateria -= 2;
                    System.out.println("Você errou ambos os comandos.");
                    //Para ver se o usuario digitou o passo acima ou abaixo do esperado
                    if (passos > 6) {
                        System.out.println("O robô deu mais passos do que precisava!!");
                    } else if (passos < 6) {
                        System.out.println("O robô deu menos passos do que precisava!!");
                    }
                    System.out.println("E foi gasto 2% de bateria ao errar o caminho! O robô precisa ter no mínimo 66% para continuar!");
                    //Estrutura de seleção para definir qual imagem da bateria é impressa
                    if (bateria <= 75) {
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
                    while (direcao != 'D' && direcao != 'E' && direcao != 'F' && direcao != 'T') {
                        System.out.println("Digite somente direções aceitas (direita, esquerda, frente e trás):");
                        direcao = sc.next().toUpperCase().charAt(0);
                    }
                    System.out.print("Digite quantos passos (de 1 até 8): ");
                    passos = sc.nextInt();
                    while (passos < 1 || passos > 8) {
                        System.out.println("Digite somente valores entre 1 e 8 : ");
                        passos = sc.nextInt();
                    }
                } else {
                    break;
                }
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
                } else if (bateria <= 88) {
                    System.out.println(b90 + bateria + "%");
                }
                System.out.println("************************");
                System.out.print("Digite a direção (direta, esquerda, frente ou trás): ");
                direcao = sc.next().toUpperCase().charAt(0);
                while (direcao != 'D' && direcao != 'E' && direcao != 'F' && direcao != 'T') {
                    System.out.println("Digite somente direções aceitas (direita, esquerda, frente e trás):");
                    direcao = sc.next().toUpperCase().charAt(0);
                }
                System.out.print("Digite quantos passos (de 1 até 8): ");
                passos = sc.nextInt();
                while (passos < 1 || passos > 8) {
                    System.out.println("Digite somente valores entre 1 e 8 : ");
                    passos = sc.nextInt();
                }
                while (direcao != 'T' || passos != 3)  {
                    System.out.println("Comando incorreto!");
                    if ((direcao == 'T' || passos == 3) && bateria >=55) {
                        System.out.println("Você acertou somente um dos comandos!!");
                        while ((direcao == 'T' && passos != 3) && bateria >=55) {
                            contErros++;
                            bateria -= 1;
                            System.out.println(String.format("O robô viu que o caminho é para a trás, mas não pode dar %d passos.", passos));
                            if (passos > 3) {
                                System.out.println(String.format("Se ele der %d passos ele bate na parede, tente um valor mais baixo (de 1 até %d)",passos, passos));
                            } else if (passos < 3) {
                                System.out.println(String.format("Se ele der %d passos o robô não chegaria até a proxima virada, tente um valor mais alto (de %d até 8)",passos,passos));
                            }
                            System.out.println("Por você ter errado somente um dos comandos, você perdeu 1 porcento de bateria!");
                            if (bateria <= 55) {
                                System.out.println(b50 + bateria + "%");
                            } else if (bateria <= 65) {
                                System.out.println(b60 + bateria + "%");
                            } else if (bateria <= 75) {
                                System.out.println(b70 + bateria + "%");
                            } else if (bateria <= 85) {
                                System.out.println(b80 + bateria + "%");
                            } else if (bateria <= 88) {
                                System.out.println(b90 + bateria + "%");
                            }
                            System.out.println("Digite um novo valor de passos:");
                            passos = sc.nextInt();
                            while (passos < 1 || passos > 8) {
                                System.out.println("Digite somente valores entre 1 e 8 : ");
                                passos = sc.nextInt();
                            }
                        }
                        while ((passos == 3 && direcao != 'T') && bateria >=55) {
                            contErros++;
                            bateria -= 1;
                            switch (direcao) {
                                case 'D':
                                    direcaoInteira="direita";
                                    break;
                                case 'E':
                                    direcaoInteira="esquerda";
                                    break;
                                case 'F':
                                    direcaoInteira="frente";
                                    break;
                                case 'T':
                                    direcaoInteira="trás";
                            }
                            System.out.println(String.format("O robô viu que pode dar %d passos, mas não para %s.", passos, direcaoInteira));
                            System.out.println("Por você ter errado somente um dos comandos, você perdeu 1 porcento de bateria!");
                            if (bateria <= 55) {
                                System.out.println(b50 + bateria + "%");
                            } else if (bateria <= 65) {
                                System.out.println(b60 + bateria + "%");
                            } else if (bateria <= 75) {
                                System.out.println(b70 + bateria + "%");
                            } else if (bateria <= 85) {
                                System.out.println(b80 + bateria + "%");
                            } else if (bateria <= 88) {
                                System.out.println(b90 + bateria + "%");
                            }
                            System.out.println("Tente outra direção:");
                            direcao = sc.next().toUpperCase().charAt(0);
                            while (direcao != 'D' && direcao != 'E' && direcao != 'F' && direcao != 'T') {
                                System.out.println("Digite somente direções aceitas (direita, esquerda, frente e trás):");
                                direcao = sc.next().toUpperCase().charAt(0);
                            }
                        }
                    } else if (direcao != 'T' && passos != 3 && bateria >= 56) {
                        contErros++;
                        bateria -= 2;
                        System.out.println("Você errou ambos os comandos.");
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
                        System.out.println("E foi gasto 2% de bateria ao errar o caminho! O robô precisa ter no mínimo 54% para continuar!");
                        if (bateria <= 55) {
                            System.out.println(b50 + bateria + "%");
                        } else if (bateria <= 65) {
                            System.out.println(b60 + bateria + "%");
                        } else if (bateria <= 75) {
                            System.out.println(b70 + bateria + "%");
                        } else if (bateria <= 85) {
                            System.out.println(b80 + bateria + "%");
                        } else if (bateria <= 88) {
                            System.out.println(b90 + bateria + "%");
                        }
                        System.out.println("************************");
                        System.out.print("Digite a direção (direta, esquerda, frente ou trás): ");
                        direcao = sc.next().toUpperCase().charAt(0);
                        while (direcao != 'D' && direcao != 'E' && direcao != 'F' && direcao != 'T') {
                            System.out.println("Digite somente direções aceitas (direita, esquerda, frente e trás):");
                            direcao = sc.next().toUpperCase().charAt(0);
                        }
                        System.out.print("Digite quantos passos (de 1 até 8): ");
                        passos = sc.nextInt();
                        while (passos < 1 || passos > 8) {
                            System.out.println("Digite somente valores entre 1 e 8 : ");
                            passos = sc.nextInt();
                        }
                    } else {
                        break;
                    }
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
                    if (bateria <= 55) {
                        System.out.println(b50 + bateria + "%");
                    } else if (bateria <= 65) {
                        System.out.println(b60 + bateria + "%");
                    } else if (bateria <= 75) {
                        System.out.println(b70 + bateria + "%");
                    } else if (bateria <= 82) {
                        System.out.println(b80 + bateria + "%");
                    }
                    System.out.println("************************");
                    System.out.print("Digite a direção (direta, esquerda, frente ou trás): ");
                    direcao = sc.next().toUpperCase().charAt(0);
                    while (direcao != 'D' && direcao != 'E' && direcao != 'F' && direcao != 'T') {
                        System.out.println("Digite somente direções aceitas (direita, esquerda, frente e trás):");
                        direcao = sc.next().toUpperCase().charAt(0);
                    }
                    System.out.print("Digite quantos passos (de 1 até 8): ");
                    passos = sc.nextInt();
                    while (passos < 1 || passos > 8) {
                        System.out.println("Digite somente valores entre 1 e 8 : ");
                        passos = sc.nextInt();
                    }
                    while (direcao != 'D' || passos != 4) {
                        System.out.println("Comando incorreto!");
                        if ((direcao == 'D' || passos == 4) && bateria>=49) {
                            System.out.println("Você acertou somente um dos comandos!!");
                            while ((direcao == 'D' && passos != 4) && bateria>=49) {
                                contErros++;
                                bateria -= 1;
                                System.out.println(String.format("O robô viu que o caminho é para a direita, mas não pode dar %d passos.", passos));
                                if (passos > 4) {
                                    System.out.println(String.format("Se ele der %d passos ele bate na parede, tente um valor mais baixo (de 1 até %d)", passos, passos));
                                } else if (passos < 4) {
                                    System.out.println(String.format("Se ele der %d passos o robô não chegaria até a proxima virada, tente um valor mais alto (de %d até 8)", passos, passos));
                                }
                                System.out.println("Por você ter errado somente um dos comandos, você perdeu 1 porcento de bateria!");
                                if (bateria <= 55) {
                                    System.out.println(b50 + bateria + "%");
                                } else if (bateria <= 65) {
                                    System.out.println(b60 + bateria + "%");
                                } else if (bateria <= 75) {
                                    System.out.println(b70 + bateria + "%");
                                } else if (bateria <= 82) {
                                    System.out.println(b80 + bateria + "%");
                                }
                                System.out.println("Digite um novo valor de passos:");
                                passos = sc.nextInt();
                                while (passos < 1 || passos > 8) {
                                    System.out.println("Digite somente valores entre 1 e 8 : ");
                                    passos = sc.nextInt();
                                }
                            }
                            while ((passos == 4 && direcao != 'D') && bateria>=49) {
                                contErros++;
                                bateria -= 1;
                                switch (direcao) {
                                    case 'D':
                                        direcaoInteira = "direita";
                                        break;
                                    case 'E':
                                        direcaoInteira = "esquerda";
                                        break;
                                    case 'F':
                                        direcaoInteira = "frente";
                                        break;
                                    case 'T':
                                        direcaoInteira = "trás";
                                }
                                System.out.println(String.format("O robô viu que pode dar %d passos, mas não para %s.", passos, direcaoInteira));
                                System.out.println("Por você ter errado somente um dos comandos, você perdeu 1 porcento de bateria!");
                                if (bateria <= 55) {
                                    System.out.println(b50 + bateria + "%");
                                } else if (bateria <= 65) {
                                    System.out.println(b60 + bateria + "%");
                                } else if (bateria <= 75) {
                                    System.out.println(b70 + bateria + "%");
                                } else if (bateria <= 82) {
                                    System.out.println(b80 + bateria + "%");
                                }
                                System.out.println("Tente outra direção:");
                                direcao = sc.next().toUpperCase().charAt(0);
                                while (direcao != 'D' && direcao != 'E' && direcao != 'F' && direcao != 'T') {
                                    System.out.println("Digite somente direções aceitas (direita, esquerda, frente e trás):");
                                    direcao = sc.next().toUpperCase().charAt(0);
                                }
                            }
                        } else if (direcao != 'D' && passos != 4 && bateria >= 50) {
                            contErros++;
                            bateria -= 2;
                            System.out.println("Você errou ambos os comandos.");
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
                            System.out.println("E foi gasto 2% de bateria ao errar o caminho! O robô precisa ter no mínimo 48% para continuar!");
                            if (bateria <= 55) {
                                System.out.println(b50 + bateria + "%");
                            } else if (bateria <= 65) {
                                System.out.println(b60 + bateria + "%");
                            } else if (bateria <= 75) {
                                System.out.println(b70 + bateria + "%");
                            } else if (bateria <= 82) {
                                System.out.println(b80 + bateria + "%");
                            }
                            System.out.println("************************");
                            System.out.print("Digite a direção (direta, esquerda, frente ou trás): ");
                            direcao = sc.next().toUpperCase().charAt(0);
                            while (direcao != 'D' && direcao != 'E' && direcao != 'F' && direcao != 'T') {
                                System.out.println("Digite somente direções aceitas (direita, esquerda, frente e trás):");
                                direcao = sc.next().toUpperCase().charAt(0);
                            }
                            System.out.print("Digite quantos passos (de 1 até 8): ");
                            passos = sc.nextInt();
                            while (passos < 1 || passos > 8) {
                                System.out.println("Digite somente valores entre 1 e 8 : ");
                                passos = sc.nextInt();
                            }
                        } else {
                            break;
                        }
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
                        if (bateria <= 45) {
                            System.out.println(b40 + bateria + "%");
                        } else if (bateria <= 55) {
                            System.out.println(b50 + bateria + "%");
                        } else if (bateria <= 60) {
                            System.out.println(b60 + bateria + "%");
                        } else if (bateria <= 74) {
                            System.out.println(b70 + bateria + "%");
                        }
                        System.out.println("************************");
                        System.out.print("Digite a direção (direta, esquerda, frente ou trás): ");
                        direcao = sc.next().toUpperCase().charAt(0);
                        while (direcao != 'D' && direcao != 'E' && direcao != 'F' && direcao != 'T') {
                            System.out.println("Digite somente direções aceitas (direita, esquerda, frente e trás):");
                            direcao = sc.next().toUpperCase().charAt(0);
                        }
                        System.out.print("Digite quantos passos (de 1 até 8): ");
                        passos = sc.nextInt();
                        while (passos < 1 || passos > 8) {
                            System.out.println("Digite somente valores entre 1 e 8 : ");
                            passos = sc.nextInt();
                        }
                        while (direcao != 'F' || passos != 8) {
                            System.out.println("Comando incorreto!");
                            if ((direcao == 'F' || passos == 8) && bateria>=41) {
                                System.out.println("Você acertou somente um dos comandos!!");
                                while ((direcao == 'F' && passos != 8) && bateria>=41) {
                                    contErros++;
                                    bateria -= 1;
                                    System.out.println(String.format("O robô viu que o caminho é para a frente, mas não pode dar %d passos.", passos));
                                    if (passos > 8) {
                                        System.out.println(String.format("Se ele der %d passos ele bate na parede, tente um valor mais baixo (de 1 até %d)", passos, passos));
                                    } else if (passos < 8) {
                                        System.out.println(String.format("Se ele der %d passos o robô não chegaria até a proxima virada, tente um valor mais alto (de %d até 8)", passos, passos));
                                    }
                                    System.out.println("Por você ter errado somente um dos comandos, você perdeu 1 porcento de bateria!");
                                    if (bateria <= 45) {
                                        System.out.println(b40 + bateria + "%");
                                    } else if (bateria <= 55) {
                                        System.out.println(b50 + bateria + "%");
                                    } else if (bateria <= 60) {
                                        System.out.println(b60 + bateria + "%");
                                    } else if (bateria <= 74) {
                                        System.out.println(b70 + bateria + "%");
                                    }
                                    System.out.println("Digite um novo valor de passos:");
                                    passos = sc.nextInt();
                                    while (passos < 1 || passos > 8) {
                                        System.out.println("Digite somente valores entre 1 e 8 : ");
                                        passos = sc.nextInt();
                                    }
                                }
                                while ((passos == 8 && direcao != 'F') && bateria>=41) {
                                    contErros++;
                                    bateria -= 1;
                                    switch (direcao) {
                                        case 'D':
                                            direcaoInteira = "direita";
                                            break;
                                        case 'E':
                                            direcaoInteira = "esquerda";
                                            break;
                                        case 'F':
                                            direcaoInteira = "frente";
                                            break;
                                        case 'T':
                                            direcaoInteira = "trás";
                                    }
                                    System.out.println(String.format("O robô viu que pode dar %d passos, mas não para %s.", passos, direcaoInteira));
                                    System.out.println("Por você ter errado somente um dos comandos, você perdeu 1 porcento de bateria!");
                                    if (bateria <= 45) {
                                        System.out.println(b40 + bateria + "%");
                                    } else if (bateria <= 55) {
                                        System.out.println(b50 + bateria + "%");
                                    } else if (bateria <= 60) {
                                        System.out.println(b60 + bateria + "%");
                                    } else if (bateria <= 74) {
                                        System.out.println(b70 + bateria + "%");
                                    }
                                    System.out.println("Tente outra direção:");
                                    direcao = sc.next().toUpperCase().charAt(0);
                                    while (direcao != 'D' && direcao != 'E' && direcao != 'F' && direcao != 'T') {
                                        System.out.println("Digite somente direções aceitas (direita, esquerda, frente e trás):");
                                        direcao = sc.next().toUpperCase().charAt(0);
                                    }
                                }
                            } else if (direcao != 'F' && passos != 8 && bateria >= 42) {
                                contErros++;
                                bateria -= 2;
                                System.out.println("Você errou ambos os comandos.");
                                if (direcao == 'F') {
                                    System.out.println("Você acertou a direção, mas errou os passos");
                                } else if (passos == 8) {
                                    System.out.println("Você acertou os passos, mas errou a direção");
                                }
                                if (passos > 8) {
                                    System.out.println("O robô deu mais passos do que precisava!!");
                                } else if (passos < 8) {
                                    System.out.println("O robô deu menos passos do que precisava!!");
                                }
                                System.out.println("E foi gasto 2% de bateria ao errar o caminho! O robô precisa ter no mínimo 40% para continuar!");
                                if (bateria <= 45) {
                                    System.out.println(b40 + bateria + "%");
                                } else if (bateria <= 55) {
                                    System.out.println(b50 + bateria + "%");
                                } else if (bateria <= 65) {
                                    System.out.println(b60 + bateria + "%");
                                } else if (bateria <= 74) {
                                    System.out.println(b70 + bateria + "%");
                                }
                                System.out.println("************************");
                                System.out.print("Digite a direção (direta, esquerda, frente ou trás): ");
                                direcao = sc.next().toUpperCase().charAt(0);
                                while (direcao != 'D' && direcao != 'E' && direcao != 'F' && direcao != 'T') {
                                    System.out.println("Digite somente direções aceitas (direita, esquerda, frente e trás):");
                                    direcao = sc.next().toUpperCase().charAt(0);
                                }
                                System.out.print("Digite quantos passos (de 1 até 8): ");
                                passos = sc.nextInt();
                                while (passos < 1 || passos > 8) {
                                    System.out.println("Digite somente valores entre 1 e 8 : ");
                                    passos = sc.nextInt();
                                }
                            } else {
                                break;
                            }
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
                            } else if (bateria <= 58) {
                                System.out.println(b60 + bateria + "%");
                            }
                            System.out.println("************************");
                            System.out.print("Digite a direção (direta, esquerda, frente ou trás): ");
                            direcao = sc.next().toUpperCase().charAt(0);
                            while (direcao != 'D' && direcao != 'E' && direcao != 'F' && direcao != 'T') {
                                System.out.println("Digite somente direções aceitas (direita, esquerda, frente e trás):");
                                direcao = sc.next().toUpperCase().charAt(0);
                            }
                            System.out.print("Digite quantos passos (de 1 até 8): ");
                            passos = sc.nextInt();
                            while (passos < 1 || passos > 8) {
                                System.out.println("Digite somente valores entre 1 e 8 : ");
                                passos = sc.nextInt();
                            }
                            while (direcao != 'D' || passos != 5) {
                                System.out.println("Comando incorreto!");
                                if ((direcao == 'D' || passos == 5) && bateria>=25) {
                                    System.out.println("Você acertou somente um dos comandos!!");
                                    while ((direcao == 'D' && passos != 5) && bateria>=25) {
                                        contErros++;
                                        bateria -= 1;
                                        System.out.println(String.format("O robô viu que o caminho é para a direita, mas não pode dar %d passos.", passos));
                                        if (passos > 5) {
                                            System.out.println(String.format("Se ele der %d passos ele bate na parede, tente um valor mais baixo (de 1 até %d)", passos, passos));
                                        } else if (passos < 5) {
                                            System.out.println(String.format("Se ele der %d passos o robô não chegaria até a proxima virada, tente um valor mais alto (de %d até 8)", passos, passos));
                                        }
                                        System.out.println("Por você ter errado somente um dos comandos, você perdeu 1 porcento de bateria!");
                                        if (bateria <= 25) {
                                            System.out.println(b20 + bateria + "%");
                                        } else if (bateria <= 35) {
                                            System.out.println(b30 + bateria + "%");
                                        } else if (bateria <= 45) {
                                            System.out.println(b40 + bateria + "%");
                                        } else if (bateria <= 55) {
                                            System.out.println(b50 + bateria + "%");
                                        } else if (bateria <= 58) {
                                            System.out.println(b60 + bateria + "%");
                                        }
                                        System.out.println("Digite um novo valor de passos:");
                                        passos = sc.nextInt();
                                        while (passos < 1 || passos > 8) {
                                            System.out.println("Digite somente valores entre 1 e 8 : ");
                                            passos = sc.nextInt();
                                        }
                                    }
                                    while ((passos == 5 && direcao != 'D') && bateria>=25) {
                                        contErros++;
                                        bateria -= 1;
                                        switch (direcao) {
                                            case 'D':
                                                direcaoInteira = "direita";
                                                break;
                                            case 'E':
                                                direcaoInteira = "esquerda";
                                                break;
                                            case 'F':
                                                direcaoInteira = "frente";
                                                break;
                                            case 'T':
                                                direcaoInteira = "trás";
                                        }
                                        System.out.println(String.format("O robô viu que pode dar %d passos, mas não para %s.", passos, direcaoInteira));
                                        System.out.println("Por você ter errado somente um dos comandos, você perdeu 1 porcento de bateria!");
                                        if (bateria <= 25) {
                                            System.out.println(b20 + bateria + "%");
                                        } else if (bateria <= 35) {
                                            System.out.println(b30 + bateria + "%");
                                        } else if (bateria <= 45) {
                                            System.out.println(b40 + bateria + "%");
                                        } else if (bateria <= 55) {
                                            System.out.println(b50 + bateria + "%");
                                        } else if (bateria <= 58) {
                                            System.out.println(b60 + bateria + "%");
                                        }
                                        System.out.println("Tente outra direção:");
                                        direcao = sc.next().toUpperCase().charAt(0);
                                        while (direcao != 'D' && direcao != 'E' && direcao != 'F' && direcao != 'T') {
                                            System.out.println("Digite somente direções aceitas (direita, esquerda, frente e trás):");
                                            direcao = sc.next().toUpperCase().charAt(0);
                                        }
                                    }
                                } else if (direcao != 'D' && passos != 5 && bateria >= 26){
                                    contErros++;
                                    bateria -= 2;
                                    System.out.println("Você errou ambos os comandos.");
                                    if (direcao == 'D') {
                                        System.out.println("Você acertou a direção, mas errou os passos");
                                    } else if (passos == 5) {
                                        System.out.println("Você acertou os passos, mas errou a direção");
                                    }
                                    if (passos > 5) {
                                        System.out.println("O robô deu mais passos do que precisava!!");
                                    } else if (passos < 5) {
                                        System.out.println("O robô deu menos passos do que precisava!!");
                                    }
                                    System.out.println("E foi gasto 2% de bateria ao errar o caminho! O robô precisa ter no mínimo 24% para continuar!");
                                    if (bateria <= 25) {
                                        System.out.println(b20 + bateria + "%");
                                    } else if (bateria <= 35) {
                                        System.out.println(b30 + bateria + "%");
                                    } else if (bateria <= 45) {
                                        System.out.println(b40 + bateria + "%");
                                    } else if (bateria <= 55) {
                                        System.out.println(b50 + bateria + "%");
                                    } else if (bateria <= 58) {
                                        System.out.println(b60 + bateria + "%");
                                    }
                                    System.out.println("************************");
                                    System.out.print("Digite a direção (direta, esquerda, frente ou trás): ");
                                    direcao = sc.next().toUpperCase().charAt(0);
                                    while (direcao != 'D' && direcao != 'E' && direcao != 'F' && direcao != 'T') {
                                        System.out.println("Digite somente direções aceitas (direita, esquerda, frente e trás):");
                                        direcao = sc.next().toUpperCase().charAt(0);
                                    }
                                    System.out.print("Digite quantos passos (de 1 até 8): ");
                                    passos = sc.nextInt();
                                    while (passos < 1 || passos > 8) {
                                        System.out.println("Digite somente valores entre 1 e 8 : ");
                                        passos = sc.nextInt();
                                    }
                                } else {
                                    break;
                                }
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
                                } else if (bateria <= 48) {
                                    System.out.println(b50 + bateria + "%");
                                }
                                System.out.println("************************");
                                System.out.print("Digite a direção (direta, esquerda, frente ou trás): ");
                                direcao = sc.next().toUpperCase().charAt(0);
                                while (direcao != 'D' && direcao != 'E' && direcao != 'F' && direcao != 'T') {
                                    System.out.println("Digite somente direções aceitas (direita, esquerda, frente e trás):");
                                    direcao = sc.next().toUpperCase().charAt(0);
                                }
                                System.out.print("Digite quantos passos (de 1 até 8): ");
                                passos = sc.nextInt();
                                while (passos < 1 || passos > 8) {
                                    System.out.println("Digite somente valores entre 1 e 8 : ");
                                    passos = sc.nextInt();
                                }
                                while (direcao != 'T' || passos != 7) {
                                    System.out.println("Comando incorreto!");
                                    if ((direcao == 'T' || passos == 7) && bateria>=15) {
                                        System.out.println("Você acertou somente um dos comandos!!");
                                        while ((direcao == 'T' && passos != 7) && bateria>=15) {
                                            contErros++;
                                            bateria -= 1;
                                            System.out.println(String.format("O robô viu que o caminho é para a trás, mas não pode dar %d passos.", passos));
                                            if (passos > 7) {
                                                System.out.println(String.format("Se ele der %d passos ele bate na parede, tente um valor mais baixo (de 1 até %d)", passos, passos));
                                            } else if (passos < 7) {
                                                System.out.println(String.format("Se ele der %d passos o robô não chegaria até a proxima virada, tente um valor mais alto (de %d até 8)", passos, passos));
                                            }
                                            System.out.println("Por você ter errado somente um dos comandos, você perdeu 1 porcento de bateria!");
                                            if (bateria <= 15) {
                                                System.out.println(b10 + bateria + "%");
                                            } else if (bateria <= 25) {
                                                System.out.println(b20 + bateria + "%");
                                            } else if (bateria <= 35) {
                                                System.out.println(b30 + bateria + "%");
                                            } else if (bateria <= 45) {
                                                System.out.println(b40 + bateria + "%");
                                            } else if (bateria <= 48) {
                                                System.out.println(b50 + bateria + "%");
                                            }
                                            System.out.println("Digite um novo valor de passos:");
                                            passos = sc.nextInt();
                                            while (passos < 1 || passos > 8) {
                                                System.out.println("Digite somente valores entre 1 e 8 : ");
                                                passos = sc.nextInt();
                                            }
                                        }
                                        while ((passos == 7 && direcao != 'T') && bateria>=15) {
                                            contErros++;
                                            bateria -= 1;
                                            switch (direcao) {
                                                case 'D':
                                                    direcaoInteira = "direita";
                                                    break;
                                                case 'E':
                                                    direcaoInteira = "esquerda";
                                                    break;
                                                case 'F':
                                                    direcaoInteira = "frente";
                                                    break;
                                                case 'T':
                                                    direcaoInteira = "trás";
                                            }
                                            System.out.println(String.format("O robô viu que pode dar %d passos, mas não para %s.", passos, direcaoInteira));
                                            System.out.println("Por você ter errado somente um dos comandos, você perdeu 1 porcento de bateria!");
                                            if (bateria <= 15) {
                                                System.out.println(b10 + bateria + "%");
                                            } else if (bateria <= 25) {
                                                System.out.println(b20 + bateria + "%");
                                            } else if (bateria <= 35) {
                                                System.out.println(b30 + bateria + "%");
                                            } else if (bateria <= 45) {
                                                System.out.println(b40 + bateria + "%");
                                            } else if (bateria <= 48) {
                                                System.out.println(b50 + bateria + "%");
                                            }
                                            System.out.println("Tente outra direção:");
                                            direcao = sc.next().toUpperCase().charAt(0);
                                            while (direcao != 'D' && direcao != 'E' && direcao != 'F' && direcao != 'T') {
                                                System.out.println("Digite somente direções aceitas (direita, esquerda, frente e trás):");
                                                direcao = sc.next().toUpperCase().charAt(0);
                                            }
                                        }
                                    } else if (direcao != 'T' && passos != 7 && bateria >= 16) {
                                        contErros++;
                                        bateria -= 2;
                                        System.out.println("Você errou ambos os comandos.");
                                        if (direcao == 'T') {
                                            System.out.println("Você acertou a direção, mas errou os passos");
                                        } else if (passos == 7) {
                                            System.out.println("Você acertou os passos, mas errou a direção");
                                        }
                                        if (passos > 7) {
                                            System.out.println("O robô deu mais passos do que precisava!!");
                                        } else if (passos < 7) {
                                            System.out.println("O robô deu menos passos do que precisava!!");
                                        }
                                        System.out.println("E foi gasto 2% de bateria ao errar o caminho! O robô precisa ter no mínimo 14% para continuar!");
                                        if (bateria <= 15) {
                                            System.out.println(b10 + bateria + "%");
                                        } else if (bateria <= 25) {
                                            System.out.println(b20 + bateria + "%");
                                        } else if (bateria <= 35) {
                                            System.out.println(b30 + bateria + "%");
                                        } else if (bateria <= 45) {
                                            System.out.println(b40 + bateria + "%");
                                        } else if (bateria <= 48) {
                                            System.out.println(b50 + bateria + "%");
                                        }
                                        System.out.println("************************");
                                        System.out.print("Digite a direção (direta, esquerda, frente ou trás): ");
                                        direcao = sc.next().toUpperCase().charAt(0);
                                        while (direcao != 'D' && direcao != 'E' && direcao != 'F' && direcao != 'T') {
                                            System.out.println("Digite somente direções aceitas (direita, esquerda, frente e trás):");
                                            direcao = sc.next().toUpperCase().charAt(0);
                                        }
                                        System.out.print("Digite quantos passos (de 1 até 8): ");
                                        passos = sc.nextInt();
                                        while (passos < 1 || passos > 8) {
                                            System.out.println("Digite somente valores entre 1 e 8 : ");
                                            passos = sc.nextInt();
                                        }
                                    }
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
                                    } else if (bateria <= 34) {
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