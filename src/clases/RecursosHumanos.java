package clases;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.StringJoiner;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class RecursosHumanos {
	
String codigoRecursosHumanos;
String nombreRecursosHumanos;
String cargoRecursosHumanos;
String espRecursosHumanos;

public String getCodigoRecursosHumanos() {
	return codigoRecursosHumanos;
}
public void setCodigoRecursosHumanos(String codigoRecursosHumanos) {
	this.codigoRecursosHumanos = codigoRecursosHumanos;
}
public String getNombreRecursosHumanos() {
	return nombreRecursosHumanos;
}
public void setNombreRecursosHumanos(String nombreRecursosHumanos) {
	this.nombreRecursosHumanos = nombreRecursosHumanos;
}
public String getCargoRecursosHumanos() {
	return cargoRecursosHumanos;
}
public void setCargoRecursosHumanos(String cargoRecursosHumanos) {
	this.cargoRecursosHumanos = cargoRecursosHumanos;
}

public String getEspRecursosHumanos() {
	return espRecursosHumanos;
}
public void setEspRecursosHumanos(String espRecursosHumanos) {
	this.espRecursosHumanos = espRecursosHumanos;
}

public void crearArchivoRecursosHumanos() {
	try {
		File objetoArchivo = new File("Recursos Humanos.txt");
		if(objetoArchivo.createNewFile()) {
			JOptionPane.showMessageDialog(null,"Se ha creado correctamente el archivo: "+  objetoArchivo.getName());
		}
		else {
			JOptionPane.showMessageDialog(null, "El archivo ya existe");
		}
		
	} catch (Exception e) {
		System.out.println("Ha ocurrido un error al crear el archivo");
		
	}
}
public void agregarRegistrosRecursosHumanos() {
	try {
		FileWriter fw = new FileWriter("Recursos Humanos.txt",true);
		
		
		fw.write(getCodigoRecursosHumanos());
		fw.write(",");
		fw.write(getNombreRecursosHumanos());
		fw.write(",");
		fw.write(getCargoRecursosHumanos());
		fw.write(",");
                fw.write(getEspRecursosHumanos());
		fw.write("\n");
		fw.close();
		
		JOptionPane.showMessageDialog(null,"Se ha registrado correctamente");
	} catch (Exception e) {
		JOptionPane.showMessageDialog(null,"Ha ocurrido un error al registrar" + e.toString());
	}
}

public void MostrarTotalRecursosHumanos(JTable tablaTotalRecursosHumanos) {
	
	String nombreArchivo = "Recursos Humanos.txt";
	
	File file = new File(nombreArchivo);
	
	try {
		
		BufferedReader br = new BufferedReader(new FileReader(file));
		
		String primeraLinea = br.readLine().trim();
		
		DefaultTableModel model = new DefaultTableModel();
		
		model.addColumn("Codigo");
		model.addColumn("NombreRecursosHumanos");
		model.addColumn("CargoRecursosHumanos");
                model.addColumn("EspecialidadRecursosHumanos");
		
		tablaTotalRecursosHumanos.setModel(model);
		
		Object[] tableLines = br.lines().toArray();
		
		for (int i = 0; i < tableLines.length; i++) {
			
			String line = tableLines[i].toString().trim();
			String[] datarow= line.split(",");
			model.addRow(datarow);
			tablaTotalRecursosHumanos.setModel(model);
		}
		
		
	} catch (Exception e) {
		JOptionPane.showMessageDialog(null,"Ha ocurrido un error"+ e.toString());
		
	}
}

public void seleccionarRecursosHumanos(JTable tablaRecursosHumanos) {
	
	try {
		
		int  fila = tablaRecursosHumanos.getSelectedRow();
		
		if (fila>=0) {
			
			setCodigoRecursosHumanos(tablaRecursosHumanos.getValueAt(fila, 0).toString());
			setNombreRecursosHumanos(tablaRecursosHumanos.getValueAt(fila, 1).toString());
			setCargoRecursosHumanos(tablaRecursosHumanos.getValueAt(fila, 2).toString());
                        setEspRecursosHumanos(tablaRecursosHumanos.getValueAt(fila, 3).toString());
		}
		
	} catch (Exception e) {
		JOptionPane.showMessageDialog(null,"Ha ocurrido un error"+ e.toString());
	}
	
}

public void EliminarRecursosHumanos (JTable tablaRecursosHumanos, JTextField codigoRecursosHumanos) {
	
	//Eliminacion visual de la tabla
	DefaultTableModel model = (DefaultTableModel)tablaRecursosHumanos.getModel();
	
	for (int i = 0; i < model.getRowCount(); i++) {
		
		if(((String)model.getValueAt(i, 0)).equals(codigoRecursosHumanos.getText())) {	
			model.removeRow(i);
			break;
			
		}
	}
	//Limpieza del archivo .txt
	
	try {
		PrintWriter writer = new PrintWriter("Recursos Humanos.txt");
		writer.print("");
		writer.close();
	} catch (Exception e) {
		JOptionPane.showMessageDialog(null,"Ha ocurrido un problema"+ e.toString());
	}
	
	//Creacion de los nuevos registros luego de la eliminacion
	
	try (BufferedWriter bw = new BufferedWriter(new FileWriter(new File("Recursos Humanos.txt")))) {
		StringJoiner joiner = new StringJoiner(",");
		
		for (int col = 0; col < tablaRecursosHumanos.getColumnCount(); col++) {
			joiner.add(tablaRecursosHumanos.getColumnName(col));
		}
		
		System.out.println(joiner.toString());
		bw.write(joiner.toString());
		bw.newLine();
		
		for (int row = 0; row < tablaRecursosHumanos.getRowCount(); row++) {
			 joiner = new StringJoiner(",");		
			for (int col = 0; col < tablaRecursosHumanos.getColumnCount(); col++) {
				
				Object obj = tablaRecursosHumanos.getValueAt(row, col);
				String value = obj == null ? "null" :obj.toString();
				joiner.add(value);
				
			}
			
			
			bw.write(joiner.toString());
			bw.newLine();
			JOptionPane.showMessageDialog(null, "Se ha eliminado correctamente");
		}

		
	} catch (Exception e) {
		JOptionPane.showMessageDialog(null, "Ha ocurrido un error");
	}
	
	
	
}

public void EditarRecursosHumanos(JTable tablaRecursosHumanos) {
	
	//Limpieza del archivo .txt
	
		try {
			PrintWriter writer = new PrintWriter("Recursos Humanos.txt");
			writer.print("");
			writer.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,"Ha ocurrido un problema"+ e.toString());
		}
		
		//Creacion de los nuevos registros luego de la eliminacion
		
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(new File("Recursos Humanos.txt")))) {
			StringJoiner joiner = new StringJoiner(",");
			for (int col = 0; col < tablaRecursosHumanos.getColumnCount(); col++) {
				joiner.add(tablaRecursosHumanos.getColumnName(col));
			}
			
			System.out.println(joiner.toString());
			bw.write(joiner.toString());
			bw.newLine();
			
			for (int row = 0; row < tablaRecursosHumanos.getRowCount(); row++) {
				joiner = new StringJoiner(",");
				for (int col = 0; col < tablaRecursosHumanos.getColumnCount(); col++) {
					
					Object obj = tablaRecursosHumanos.getValueAt(row, col);
					String value = obj == null ? "null" :obj.toString();
					joiner.add(value);
					
				}
				
				System.out.println(joiner.toString());
				bw.write(joiner.toString());
				bw.newLine();
				JOptionPane.showMessageDialog(null, "Se ha modificado correctamente");
			}

			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Ha ocurrido un error");
		}
		
}

  

}

