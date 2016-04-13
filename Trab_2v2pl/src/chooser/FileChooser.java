package chooser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class FileChooser {
	static {
		try {
			// Mudar aparencia da janela.
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			System.err.println("Não foi possível alterar o LookAndFeel");
			e.printStackTrace();
		}
	}
	static BufferedReader in = new BufferedReader(new InputStreamReader(
			System.in));
	static File arquivo = null;
	static JFileChooser fc;
	static List<String> vetor = new ArrayList<String>();

	// Faz o seletor de arquivos escolher só arquivos .txt
	private class FiltroArquivo extends javax.swing.filechooser.FileFilter {

		@Override
		public boolean accept(File file) {
			if (file.isDirectory()) {
				return true;
			}
			String filename = file.getName();
			return filename.endsWith(".txt");
		}

		@Override
		public String getDescription() {
			return "*.txt";
		}
	}

	public static List<String> arquivoVetor() {
		try {
			arquivo = abrirArquivo();
			if (arquivo != null) {
				return lerVetor();

			}

		} catch (VectorInvalidException e) {
			JOptionPane.showMessageDialog(null, "Arquivo com vetor inválido",
					"Erro", JOptionPane.ERROR_MESSAGE);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Arquivo com vetor inválido",
					"Erro", JOptionPane.ERROR_MESSAGE);
		}catch (java.lang.NullPointerException e) {
			JOptionPane.showMessageDialog(null, "Nenhum arquivo foi carregado!");
		}
		return null;

	}

	// abre o arquivo texto
	private static File abrirArquivo() {
		fc = new JFileChooser();
		 fc.removeChoosableFileFilter(fc.getAcceptAllFileFilter());

		 fc.addChoosableFileFilter(new FileChooser().new
		 FiltroArquivo());//Filtro de busca pela estensão
		int retorno = fc.showOpenDialog(null);

		if (retorno == JFileChooser.APPROVE_OPTION) {
			File file = fc.getSelectedFile();

			return file;

		} else {
			return null;
		}
	}

	private static List<String> lerVetor() throws FileNotFoundException,
			IOException, VectorInvalidException, NumberFormatException {

		FileReader fr = new FileReader(arquivo);
		BufferedReader br = new BufferedReader(fr);
		String linha = null;
		while ((linha = br.readLine()) != null) {
			String[] valores = linha.split(";");// SEPARADOR DE LINHAS NO VETOR
			// Customizar

			for (int i = 0; i < valores.length; i++) {
				vetor.add(valores[i]);
			}
		}

		br.close();
		fr.close();

		return vetor;

	}

	public static String fileName(){
		return arquivo.getName();
	}

}