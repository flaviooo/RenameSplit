package it.ccse.rename;
import java.io.File;
import java.util.Iterator;
import java.util.TreeMap;

import it.ccse.rename.utilities.FileExtensionFilter;

public class Rename2 {

	public static void main(String[] args) {
		int numProtocolloDiPartenza = 12797;
		String pathFileOriginali = "c://temp//nomeCartellaa//";
		String percorsoFileExport = pathFileOriginali+ File.separator+"export";
		renameFile(numProtocolloDiPartenza, pathFileOriginali,percorsoFileExport);
	}

	private static void renameFile(int couter, String percorsoFileOriginali,String percorsoFileExport) {
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
		  String percorsonuovoFile = percorsoFileExport+ File.separator+nomeNuovoFile+".pdf";
		  sortedHashMap.get(key).renameTo(new File(percorsonuovoFile));
		  couter++;
		//	System.out.println("nome da cambiare " + mappa.get(key)+  " >> "+nomeNuovoFile);
		}
	}
}
