package apresentacao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class TextFile{

    private String sBody;
    private String Caminho;
    private FileInputStream Arquivo;
    private BufferedReader LinhaArquivo;
    private BufferedWriter sFilePath;
   

    public TextFile() {
    	TextFile arquivo = new TextFile("/home/daltonpjunior/Área de Trabalho/Trabalho/liga2010.txt");

    	try {

    	arquivo.openTextFile();
    	while (arquivo.next()) {
    	    String Linha = arquivo.readLine();
    	    
    	    //quebrando a linha por caracter ';'
    	   String[] vDados = Linha.split("[;]");
    	    
    	    //mostrando cada campo separado sem aspas !
    	    for(int i=0;i < 23;i++) {
    	    	System.out.println(vDados[i].replace("\"", ""));
    	  
    	   }
    	}

    	} catch (IOException e) {
    	       System.out.println("ERRO: " + e);
    	}

    }

    public TextFile(String Caminho) {
        this.Caminho = Caminho;
    }

    public void openTextFile() throws IOException {
        Arquivo = new FileInputStream(this.Caminho);
        LinhaArquivo = new BufferedReader(new InputStreamReader(Arquivo));
    }

    public void openTextFileWriter() throws IOException {
        Arquivo = new FileInputStream(this.Caminho);
        LinhaArquivo = new BufferedReader(new InputStreamReader(Arquivo));
        sBody = getContent();
        System.out.println(sBody);
    }

    public void openBuffered() throws IOException {
        sFilePath = new BufferedWriter(new FileWriter(Caminho));
    }

    public boolean next() throws IOException {
        return LinhaArquivo.ready();
    }

    public final String readLine() throws IOException {
        return LinhaArquivo.readLine();
    }

    public void closeTextFile() throws IOException {
        LinhaArquivo.close();
    }

    public void closeBuffered() throws IOException {
        sFilePath.flush();  // Valida o fluxo
        sFilePath.close();
    }

    public String getContent() throws IOException {
        String sContent="";
        while(LinhaArquivo.ready()){
            sContent += LinhaArquivo.readLine()+"\r\n";
        }
        return sContent;
    }

    public void Writeln(String Texto) throws IOException {

            sBody += Texto + "\r\n";
    }
        public void append(String Texto) throws IOException {

            sBody = Texto ;
    }

    public void Write(String Destino, String Texto) throws IOException {

            sFilePath = new BufferedWriter(new FileWriter(Destino));
            sFilePath.write(Texto);
            sFilePath.flush();  // Valida o fluxo
            sFilePath.close();
    }

    public void WriteBuffered(String Texto) throws IOException {
        sFilePath.write(Texto);
    }

    public void WritelnBuffered(String Texto) throws IOException {
        sFilePath.write(Texto+"\r\n");
    }

    public void Write(String Destino) throws IOException {

        sFilePath = new BufferedWriter(new FileWriter(Destino));
        sFilePath.write(sBody);
        sFilePath.flush();  // Valida o fluxo
        sFilePath.close();
    }

}