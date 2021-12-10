package main.java;

public class App{

    static Util OS = new Util();
    public static void main(String[] args) throws Exception {
        System.out.println("\033[0;35m"); // set Purple
        System.out.println("[+]Detected OS: "+Util.getOS());
        System.out.println("[+]Detected OS version: "+Util.getOsVersion());
        System.out.println("[+]Detected OS architecture: "+Util.getOsArch());
        System.out.println("[+]Detected User account name: "+Util.getName());
        System.out.println("[+]Detected User home directory: "+Util.getHome());
        System.out.println("\033[0;32m[+]PATH: ");
        getPath(OS);
        System.out.println("\033[0m"); // reset color
        String os=Util.getOS().toString();
        if(os.equals("LINUX")){
            GatherLinux gLinux = new GatherLinux();
            GatherLinux.controll();
        }
        else if(os.equals("WINDOWS")){
            System.out.println("WINDOWS");
        }
        else if(os.equals("MAC")){
            System.out.println("MAC");
        }
        else if(os.equals("SOLARIS")){
            System.out.println("[+]SOLARIS");
        }
    }

    private static void getPath(Util os){
        String[] path=Command.getCommandExecution(os.getOS(),"echo $PATH").split(os.getPathSeparator());
        for(String p : path){
            System.out.println("\t"+p);
        }

    }





}

