package diffsExample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.apache.commons.lang3.ArrayUtils;

public class diffsQuestion {
	
	static String[] array1;
	static String[] array2;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] result = diffs(array1, array2);

	}
	
	static String[] diffs (String[] array1,String[] array2 ){
		String[] arraySelected;	//el arreglo de mayor longitud
		String[] arrayNotSelected;	//el arreglo de mayor longitud
		boolean noEncontrado;
		
		ArrayList<String> arrayDifferentElements = new ArrayList<String>();
		
		if (array1.length >= array2.length){
			arraySelected = array1;
			arrayNotSelected = array2;}
		else{
			arraySelected = array2;
			arrayNotSelected = array1;
		}
	
		for (int x=0; x < arraySelected.length; x++) {
			  noEncontrado = true;
			  int y = 0;
			  while ((noEncontrado) && (y < arrayNotSelected.length)) {
			    if (arraySelected[x] == arrayNotSelected[y]){
			    	noEncontrado = false;
			    	arrayNotSelected = ArrayUtils.remove(arrayNotSelected, y);	//elimino en el 2do array los elem encontrados
			      break;
			      }
			    y++;
			  }
			 
			  if (noEncontrado==true){	//voy guardando en este array los elementos distintos
			    arrayDifferentElements.add(arraySelected[x]);
			  }
		}
		
		/*ahora agrego los elementos del arreglo no seleccionado que quedaron sin encontrar.
		 * Los elementos duplicados fueron eliminados, solo quedan elementos distintos*/
		for (int y=0; y < arrayNotSelected.length; y++) {
			if (arrayNotSelected[y]!= null){
				arrayDifferentElements.add(arrayNotSelected[y]);
			}
		}		
		
		return (String[]) arrayDifferentElements.toArray();
		}

}
