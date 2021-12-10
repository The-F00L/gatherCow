package main.java;
public class Util extends ConsoleColors{
    private static OS os = null;


    /**
     * getOS
     * @return OS (WINDOWS,LINUX,MAC,SOLARIS)
     */
    public static OS getOS() {
        if (os == null) {
            String operSys = System.getProperty("os.name").toLowerCase();
            if (operSys.contains("win")) {
                os = OS.WINDOWS;
            } else if (operSys.contains("nix") || operSys.contains("nux")|| operSys.contains("aix")) {
                os = OS.LINUX;
            } else if (operSys.contains("mac")) {
                os = OS.MAC;
            } else if (operSys.contains("sunos")) {
                os = OS.SOLARIS;
            }
        }
        return os;
    }

    public static String getOsVersion(){
        return System.getProperty("os.version");
    }

    public static String getOsArch(){
        return System.getProperty("os.arch");
    }

    public static String getName(){
        return System.getProperty("user.name");
    }
    public static String getHome(){
        return System.getProperty("user.home");
    }
    public static String getPathSeparator(){
        return System.getProperty("path.separator");
    }

    /**
     *ConsoleOut
     *@param consoleColor set console color font color
     *@param data check data not null
     */
    public static void ConsoleOut(String consoleColor,String name,String data){
        if(data!=null){
            System.out.println(consoleColor+"[+]"+name+": \n"+data+RESET);
        }else{
            System.out.println(RED+"[+]Not found "+name+RESET);
        }
    }


}