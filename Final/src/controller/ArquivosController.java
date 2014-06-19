package controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;

import estruturas.Vector;

public class ArquivosController {
    private String nome;
    
    public ArquivosController(String nome) {
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
    public String[] getRegistros() {
        BufferedReader arquivo = null;         
        Vector<String> registros = new Vector<String>();
        try {
            arquivo = new BufferedReader(new FileReader(this.nome));
            String linha;
            while ((linha = arquivo.readLine()) != null) {
                registros.append(linha);
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
        String[] retorno = new String[registros.getSize()];
        for(int i = 0; i < registros.getSize();i++) {
            retorno[i] = registros.getValueOf(i);
        }
        return retorno;
    }
}
