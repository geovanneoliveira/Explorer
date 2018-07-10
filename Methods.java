import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.nio.file.Files;
import java.nio.file.attribute.BasicFileAttributes;


public class Methods {

	public File[] listarRoot() {
		
		File[] roots;
		roots = File.listRoots();
	
		return roots;
	}
	
	
	public ArrayList<File> ListarTodosArquivos(String caminho) {
		
		File[] list = null;
		ArrayList<File> res = new ArrayList<File>();
		
		try {
			File origin = new File(caminho);
			
			list = origin.listFiles();
			
			for( File i : list) {
				
				res.add(i); 
	
				if(i.isDirectory()) {
					res.addAll(ListarTodosArquivos(i.getAbsolutePath()));
				}
			}
		}catch(Exception e) {
			
		}
		return res;
	}
	
	
	public File[] filtro(String dir,String name) {
		
		ArrayList<File> arrayFile = ListarTodosArquivos(dir);
		File[] list = arrayFile.toArray(new File[arrayFile.size()]);
		
		ArrayList<File> res= new ArrayList<File>(); 
		
		for(File i : list) {
			
			if(i.getName().contains(name)) {
				
				res.add(i);
			}
		}
		
		return res.toArray(new File[res.size()]);
		
	}
	
	public ArrayList<File> ListarDiretorio(String caminho) {
		
		File[] list = null;
		ArrayList<File> res = new ArrayList<File>();
		
		try {
			File origin = new File(caminho);
			
			list = origin.listFiles();
			
			for( File i : list) {
				
				res.add(i); 
			}
		}catch(Exception e) {
			
		}
		return res;
	}
	

	public boolean deletarArquivo(String caminho) {
		
		File file = new File(caminho);
		
		if(file.exists() && file.delete()) {
			
			return true;
		}else {
			
			return false;
		}
	}
	
	
	
	public String listarAtributos(String caminho) throws IOException {
		
		int count_file = 0, count_dir = 0;
		String res;
		File file = new File(caminho);
		BasicFileAttributes fileAttributes = Files.readAttributes(file.toPath(), BasicFileAttributes.class);
		
		if(file.exists()) {
			
			if(file.isFile()) {
				res = ("\n name : " + file.getName() + "\n");
				res += ("Folder : " + file.getParent() + "\n");
				res += ("size : " + fileAttributes.size() + " bytes\n");
				res += ("Created in : " + fileAttributes.creationTime() + "\n");
				res += ("Modified in : " + fileAttributes.lastModifiedTime() + "\n");
				res += ("accessed in : " + fileAttributes.lastAccessTime() + "\n");

			}else {
				res = ("\n name : " + file.getName() + "\n");
				res += (file.getParent() + "\n");
				res += (fileAttributes.creationTime() + "\n");
				res += (fileAttributes.lastModifiedTime() + "\n");
				res += (fileAttributes.lastAccessTime() + "\n");
				
				for( File i : ListarDiretorio(caminho)) {
					if(i.isDirectory()){ count_dir++;} else { count_file++;}
				}
				
				res+= "\n#" + caminho + " found >>> \n\t\t files : " + count_file +"\n\t\t Directory : " + count_dir;

			}
				
		}else {
			 res = " *** error encountering file ***\n";
		}
		
		return res;
	}
	
	
	public void copiarArquivo(File origin, File exit) throws IOException {
		
		InputStream in = new FileInputStream(origin);
		OutputStream out = new FileOutputStream(exit);
		
		byte[] buffer = new byte[1024];
		
		int transfer;
		
		while((transfer = in.read(buffer)) > 0) {
			
			out.write(buffer, 0, transfer);
		}
		
		in.close();
		out.close();
	}
	
	
}
