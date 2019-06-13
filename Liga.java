package negocio;

import persistencia.Jiu_jitsu;
import persistencia.Karate;
import persistencia.Muay_thai;
import persistencia.Personagem;
import persistencia.Wrestling;

import java.util.ArrayList;

import apresentacao.TextFile;
import negocio.Luta;

public class Liga{
	
	ArrayList<TextFile> jogador01 = new ArrayList<TextFile>();
	ArrayList<TextFile> Luta = new ArrayList<TextFile>();


	
	//Metodo que vai iniciar a liga
	public void IniciarLiga() {
		
		//Inicia a primeira luta, chamando o método startLuta
		//Onde temos método criarAção e CompararAções
		Luta.startLuta(vDados);
		
		for(int i=0;i< Personagem.getContadorLuta(); i++){
			
			if(jogador01.contadorLutas() == i) {			
				VerificarHabilidade (jogador01);
				Luta.startLuta(boot02,jogador01);
				jogador01.ganharPontos();
			}
			
		}
		System.out.println(jogador01.getNome()+ " = " + jogador01.getPontosLiga() + " pontos");
		
		//Condição para verificar o ganhador
		if (jogador01.contadorLutas()== null) {
			System.out.println(jogador01.getNome()+":"+" Ganhou a liga!");
		}
		else {
			System.out.println(jogador01.getNome()+":"+"\tNao chegou ao final da liga!");
		}
	}

	// Método para implementar uma nova habilidade, caso ele tenha os pontos e queira comprar
	// habilidades
	private void VerificarHabilidade(Personagem jogador01) {
		if (jogador01.getPontosLiga() >= 1000 && jogador01.getQuantidadeHabilidades()==1) {
			jogador01.addHabilidade(new Jiu_jitsu());
		}
		else if (jogador01.getPontosLiga() >= 2000 && jogador01.getQuantidadeHabilidades()==2) {
			jogador01.addHabilidade(new Muay_thai());
		}
		else if(jogador01.getPontosLiga() >= 3000 && jogador01.getQuantidadeHabilidades()==3) {
			jogador01.addHabilidade(new Wrestling());
		}
		else if (jogador01.getPontosLiga() >= 4000 && jogador01.getQuantidadeHabilidades()==4) {
			jogador01.addHabilidade(new Karate());
		}
	}
}
