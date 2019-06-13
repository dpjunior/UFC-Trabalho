package negocio;

import java.util.ArrayList;
import apresentacao.TextFile;
import persistencia.Personagem;

public class Luta{ 
	
	ArrayList<TextFile> acao = new ArrayList<TextFile>();
	ArrayList<Personagem> principal_array = new ArrayList<Personagem>();	
	ArrayList<Personagem> boot_array = new ArrayList<Personagem>();	

	
	//Vou alterar todo processo, esta classe é do trabalho anterior
	
	//Inicializa as listas de ações
	public void startLuta(ArrayList<TextFile> vDados){
		criarAcoes();
		comparaAcoes();
	}
		
	//Método para criação das ações
	public void criarAcoes(){
		for (int i=0; i < 23; i++) {
			acao.add(new TextFile());
		}
			
	}
		
	//Metodo que vai comparar as listas de ações
	public void comparaAcoes() {	
		
		//Condições tratadas de acordo com o propósito do jogo
		//Jogo só finaliza se a lista de array == 1000 Ou
		//energia do lutador ou do boot chegar a 0
		
		for (int i=8; i< && principal.getEnergia()>0 && boot.getEnergia()> 0;i++) {
					
			//Condições para satisfazer as ações
			//principal poder == 1 e boot poder==0, principal vence
			if(principal_array.get(i).poder == 1 && boot_array.get(i).defesa==0 ) {
				
				principal.ganharPontos();
			}
			//se o boot lançar poder e o principal não, boot vence
			else if(boot_array.get(i).poder == 1 && principal_array.get(i).poder==0 ) {
				
				principal.ganharPontos();
			}
			//soco contra poder e chute contra poder , boot vence
			 else if(boot_array.get(i).poder == 1 && principal_array.get(i).chute==0 
					|| boot_array.get(i).poder == 1 && principal_array.get(i).soco==1) {
				
				 principal.ganharPontos();
			}
			// se lista jogador soco ou chute == 1 e boot soco ou chute == 0, principal ganha
			 else if(principal_array.get(i).soco == 1 || principal_array.get(i).chute == 1 
					&& boot_array.get(i).soco==0 || boot_array.get(i).chute==0) {
				
				 principal.ganharPontos();
			}
			//Ataque com ataque irá analisar qual tipo (poder ou ataque comum)
			if (boot_array.get(i).ataque==1 && principal_array.get(i).ataque==1){
				
				//Se os 2 ataque for soco e soco ou chute e chute, ganha o que tem mais habilidade 
				if(boot_array.get(i).soco == 1 && principal_array.get(i).soco==1 ||
				   boot_array.get(i).chute == 1 && principal_array.get(i).chute==1) {
					
					//Se o jogador principal tiver mais habilidade do que o boot, boot perde
					if(principal.getQuantidadeHabilidades()> boot.getQuantidadeHabilidades()) {
                                                                                                                                                                                                                                                              						
						principal.ganharPontos();
					}
					
					//Se o boot tiver mais habilidade do que o jogador principal, ele ganha
					else if(boot.getQuantidadeHabilidades()> principal.getQuantidadeHabilidades()) {
						
						principal.ganharPontos();
					}
				}
				
			}	
		}
	}
	
}