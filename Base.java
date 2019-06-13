package negocio;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;

import negocio.ConexaoMySQL;
import persistencia.Personagem; 
import negocio.Luta;

public class Base{
		
		ArrayLutas = new ArrayList<Luta>();
		
		try{
			
		Connection conexao = new ConexaoMySQL().getConexaoMySQL();
		
		ResultSet result = conexao.prepareStatement("select * from Lutas;").executeQuery();
		
		Luta Luta;
		Personagem Nome;
		
		while (result.next()) {
			
			Luta=  new Luta();
			
			Personagem.setContadorLuta(result.getContadorLuta(""));
		    Personagem.setnome( result.getNome("Nome"));
		    ArrayLutas.add(Luta);
		}
		
		conexao.close();
		
		}
		
		catch( SQLException e){
			e.printStackTrace();
		}
		
		return ArraYAlunos;
	}
	
	public Luta selecionar(){
		
		Luta luta = new Luta();
		
		try{
			Connection conexao = new ConexaoMySQL().getConexaoMySQL();
			
			ResultSet result = conexao.prepareStatement("select * from Luta where contadorLuta="+lp.getcontadorLuta() ).executeQuery();
			
			while(result.next()){
				
			Luta.setcontadorLuta(result.getInt(""));
			Luta.setNome( result.getString(""));
			}
			    conexao.close();
			    
			}
			catch( SQLException e)
				{e.printStackTrace();}
			
		return;
	}
	
}

