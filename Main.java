import java.util.Scanner;

public class Main {

	
	public static void main(String[] args) {
		
		Explorer explorer = new Explorer();
		
		while(true) {
			
			System.out.print("$");
			Scanner in = new Scanner(System.in);
			if(in.hasNext()) {
				
				String option = in.next(); 
						
				if(option.equals("1") || option.equals("roots")) {
					
					explorer.roots();
					
					
				}else if(option.equals("2") || option.equals("lsroots")) {
					
					explorer.lsroots();
					
				}else if(option.equals("3") || option.equals("search")){
					
					explorer.search(in.next(),in.next());
					
				}else if(option.equals("4") || option.equals("ls")) {
					
					explorer.ls(in.next());
				
				}else if(option.equals("5") || option.equals("rm")) {
					
					explorer.rm(in.next());
					
				}else if(option.equals("6") || option.equals("attr")) {
					
					explorer.attr(in.next());
					
				}else if(option.equals("7") || option.equals("cp")) {
					
					explorer.cp(in.next(),in.next());
					
				}else if(option.equals("help")) {
					
					System.out.println("# Every option has a different set of functions:");
					System.out.println("\n\n Option '1' or 'roots': List all roots/disk units");
					System.out.println("\n\n Option '2' or 'lsroots': List all folders and files in all roots/disk units");
					System.out.println("\n\n Option '3' or 'search': Search for a especific file. User need to type the desired file name, and the desired directory.");  /***TODO If no directory is especified, it will search the file in the 1st root/disk unit***/
					System.out.println("\n\n Option '4' or 'ls': List the content of a directory especified by the user");
					System.out.println("\n\n Option '5' or 'rm': Deletes a file/directory. User needs to type the desired file/directory to delete and where it is located");
					System.out.println("\n\n Option '6' or 'attr': Show the attributes of a file/directory especified by the user");
					System.out.println("\n\n Option '7' or 'cp': Copy a file/directory especified by the user to a location also specified by the user.");
					System.out.println("\n\n Option 'help': to describe the system's functionalities");
					System.out.println("\n\n Option 'exit': to close application");
					
				}else if(option.equals("exit")) {
					
					System.out.println("# Are you going? All right then! \nGoodbye!!");
					System.out.println("#Manufactured by Geovanne and Jeférson!");
					break;
					
				}else {
					
					System.err.println("Option " + option + " doesn't exist");
				}
				
			}

		}
		
	}
}
