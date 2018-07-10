import java.io.File;


public class Explorer {
	
	
	Methods methods = new Methods();
	
	
	public void roots() {
		System.out.println("#Root :");
		
		for(File i : methods.listarRoot()) {
			System.out.println("+\t" + i.getPath());
		}
	}
	
	public void lsroots() {
		
		for(File i : methods.listarRoot()) {
			int file = 0;
			int dir = 0;
			
			for( File j : methods.ListarTodosArquivos(i.getAbsolutePath())) {
				System.out.println(j.getAbsolutePath());
				
				if(j.isDirectory()){ dir++;} else { file++;}
			}

			System.out.println("#" + i.getAbsolutePath() + " contains >>> \n\t files : " + file +"\n\t Directory : " + dir);
		}
	}
	
	public void search(String name, String dir) {
		
		if(name == null || dir == null) {
			System.err.println(" *** Missing parameter ***");
			return;
		}
		
		int count_dir = 0;
		int count_file = 0;
				
		System.out.println(" *** Search in directory : " + dir + " ***\n");
		
		for(File i : methods.filtro(dir, name)) {
			System.out.println(i.getAbsolutePath());
			
			if(i.isDirectory()){ ++count_dir;} else { ++count_file;}
		}
		
		System.out.println("\n#" + name + " found >>> \n\t\t files : " + count_file +"\n\t\t Directory : " + count_dir);
	}
	
	public void ls(String dir) {
		
		int count_dir = 0;
		int count_file = 0;
		
		for(File i : methods.ListarDiretorio(dir)) {
			System.out.println(i.getAbsolutePath());
			
			if(i.isDirectory()){ ++count_dir;} else { ++count_file;}
		}
		
		System.out.println("\n#" + dir + " found >>> \n\t\t files : " + count_file +"\n\t\t Directory : " + count_dir);
	}
	
	public void rm(String dir) {
		
		if(methods.deletarArquivo(dir)) {
			
			System.out.println(dir + " deleted successfully");
		}else {
			
			System.out.println("failed to delete " + dir);
		}
	}
	
	public void attr(String dir) {
		
		try {
			
			System.out.println(methods.listarAtributos(dir));
			
		}catch(Exception e) {
			System.err.println(" *** error encountering file ***\n");
			System.out.println("\n");
		}
		
	}
	
	public void cp(String origin, String exit) {
		
		try {
			File originFile = new File(origin);
			File exitFile = new File(exit);
			
			methods.copiarArquivo(originFile, exitFile);
			System.out.println("Successfully copied >>> \n+\t\t"+ origin + " copied to " + exit );
		}catch(Exception e) {
			System.err.println(" *** failed to copy ***");
			System.out.println("\n");
		}
	}
}
