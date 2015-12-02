package it.ccse.rename;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeMap;

import it.ccse.rename.utilities.FileExtensionFilter;

public class Rename2 {

	public static void main(String[] args) {
		int couter = 12797;
		String percorsoFileOriginali = "c://temp//nomeCartellaa//";
		File files = new File(percorsoFileOriginali);
		File[] lista = files.listFiles(new FileExtensionFilter("pdf"));
		TreeMap<Integer, File> sortedHashMap = new TreeMap<>();
		for (int i = 0; i < lista.length; i++) {
			//a_Part_24.pdf
			String temp = lista[i].getName().substring(0,lista[i].getName().length()-4);;
			String[] tmp = temp.split("_");
			String parteNumerica = tmp[2];
		//System.out.println(parteNumerica + " " +lista[i]);
			sortedHashMap.put(Integer.parseInt(parteNumerica), lista[i].getAbsoluteFile());
		}

		Iterator<Integer> keySetIterator = sortedHashMap.keySet().iterator();
		
		while(keySetIterator.hasNext()){
		  Integer key = keySetIterator.next();
		  System.out.println("key: " + key + " value: " + sortedHashMap.get(key)+" protocollo: "+ couter);
		  String nomeNuovoFile = String.valueOf(couter);
		  String percorsonuovoFile = percorsoFileOriginali+File.separator+"export//"+nomeNuovoFile+".pdf";
		  sortedHashMap.get(key).renameTo(new File(percorsonuovoFile));
		  couter++;
		//	System.out.println("nome da cambiare " + mappa.get(key)+  " >> "+nomeNuovoFile);
		}
	}
}
