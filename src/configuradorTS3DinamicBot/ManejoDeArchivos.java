package configuradorTS3DinamicBot;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ManejoDeArchivos {
	private String archivoCanales="canales.txt";
	private String archivoConfig="config.txt";
	private String archivoEspeciales="especiales.txt";
	
	public void guardarCanales(ArrayList<String> modelo) {
		File f=new File(archivoCanales);

		if(f.exists()){
			f.delete();
		}
		try {
			f.createNewFile();
		} catch (IOException e) {
		}
		
		try {
			FileWriter fw=new FileWriter(f);
			
			for(int i=0;i<modelo.size();i++){
				fw.write(modelo.get(i));
				fw.write(System.lineSeparator());
			}
			
			fw.close();
			
			
		} catch (IOException e) {
		}
		
		
	}

	public void guardarEspeciales(ArrayList<String> modelo) {
		File f=new File(archivoEspeciales);

		if(f.exists()){
			f.delete();
		}
		try {
			f.createNewFile();
		} catch (IOException e) {
		}
		
		try {
			FileWriter fw=new FileWriter(f);
			
			for(int i=0;i<modelo.size();i++){
				fw.write(modelo.get(i));
				fw.write(System.lineSeparator());
			}
			
			fw.close();
			
			
		} catch (IOException e) {
		}
		
		
	}
	
	public ArrayList<String> cargarCanales(){
		File f=new File(archivoCanales);
		ArrayList<String> canales=new ArrayList<String>();

		try {
			if(!f.exists()){
				f.createNewFile();
			}
		} catch (IOException e) {
		}
		
		try {
			FileReader fr=new FileReader(f);
			BufferedReader br=new BufferedReader(fr);
			
			String cad="";
			
			while((cad=br.readLine())!=null){
				canales.add(cad);
			}
			
			br.close();
			fr.close();
			
		} catch (IOException e) {
		}
		
		return canales;
	}

	public void guardarDatos(String direccion, String puerto, String usuario, String contra, String idCanal,
			String nombreBot,String idioma, String idUnica, String idCanalAtendido) {
		File f=new File(archivoConfig);

		if(f.exists()){
			f.delete();
		}
		try {
			f.createNewFile();
		} catch (IOException e) {
		}
		
		try {
			FileWriter fw=new FileWriter(f);
			
			fw.write("canalentrada:"+idCanal);
			fw.write(System.lineSeparator());
			fw.write("direccion:"+direccion);
			fw.write(System.lineSeparator());
			fw.write("puerto:"+puerto);
			fw.write(System.lineSeparator());
			fw.write("usuario:"+usuario);
			fw.write(System.lineSeparator());
			fw.write("contra:"+contra);
			fw.write(System.lineSeparator());
			if(nombreBot!=null && nombreBot.length()>0){
				fw.write("nombrebot:"+nombreBot);
				fw.write(System.lineSeparator());
			}
			if(idCanalAtendido!=null && idCanalAtendido.length()>0){
				if(Integer.parseInt(idCanalAtendido)>=1){
					fw.write("canalatendido:"+idCanalAtendido);
					fw.write(System.lineSeparator());
				}
			}
			if(idUnica!=null && idUnica.length()>0){
				fw.write("admin:"+idUnica);
				fw.write(System.lineSeparator());
			}
			if(idioma!=null && idioma.length()>0){
				fw.write("idioma:"+idioma);
				fw.write(System.lineSeparator());
			}
			fw.close();
			
			
		} catch (IOException e) {
		}
		
	}
}
