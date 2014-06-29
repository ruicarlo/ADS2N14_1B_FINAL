package estruturas;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Arquivos {
    private String nome;
    
    public Arquivos(String nome) {
        this.nome = nome;
    }
    
    private void apagarArquivo() {
        File file = new File(this.nome);
        file.delete();
    }

    public boolean verificarSeExiste() {
        return new File(this.nome).exists();
    }

    public void escrever(String[] conteudos, boolean sobrescrever) {
        if(sobrescrever) {
            this.apagarArquivo();
        }
        
        BufferedWriter arquivo = null;
        try {
            arquivo = new BufferedWriter(
                        new OutputStreamWriter(
                            new FileOutputStream(this.nome, true)
                        , "UTF-8"
            ));

            for(String conteudo : conteudos) {
                arquivo.write(conteudo + "\n");
            }
        } catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {
            if (arquivo != null) {
                try {
                    arquivo.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public Vector<String> getRegistros() {
        BufferedReader arquivo = null;         
        Vector<String> registros = new Vector<String>();
        try {
            if(this.verificarSeExiste()){
	        	arquivo = new BufferedReader(new FileReader(this.nome));
	            String linha;
	            while ((linha = arquivo.readLine()) != null) {
	                registros.append(linha);
	            }
            }
        } catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {
            if (arquivo != null) {
                try {
                    arquivo.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return registros;
    }

	public String[] explodirLinhaDoArquivo(String linhaArquivo) {
		String[] linha = linhaArquivo.split("##");
		return linha;
	}
}