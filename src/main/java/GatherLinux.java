package main.java;


public class GatherLinux extends Util{

    static Command commandExec = new Command();
    static ProgressBarRotating pb = new ProgressBarRotating();

    public static void controll(){

        pb.start();
        osInfo();
        envInfo();
        badSUID();
        usefulSoftware();
        bashRC();
        network();
        ports();
        passwd();
    }

    /**
     * osInfo
     * /proc/version and uname -a
     */
    public static void osInfo(){
        String osinfo = Command.getCommandExecution(OS.LINUX, "(cat /proc/version || uname -a ) 2>/dev/null");
        ConsoleOut(BLUE, "OS information", osinfo);
        pb.showProgress=false;
    }

    /**
     * envInfo
     * Envirement info
     */
    public static void envInfo(){
        pb.showProgress=true;
        String osinfo = Command.getCommandExecution(OS.LINUX, "(env || set) 2>/dev/null");
        ConsoleOut(YELLOW,"Env Info",osinfo);
        pb.showProgress=false;
    }

    /**
     * usefulSoftware
     * list of available useful software
     */
    public static void usefulSoftware(){
        pb.showProgress=true;
        String[] softs="nmap aws nc ncat netcat nc.traditional wget curl ping gcc g++ make gdb base64 socat python python2 python3 python2.7 python2.6 python3.6 python3.7 perl php ruby xterm doas sudo fetch docker lxc ctr runc rkt kubectl".split(" ");
        String usefulSoft="";
        for (String s : softs) {
            String tmp=Command.getCommandExecution(OS.LINUX, "which "+s);
            if(tmp!=null){
                usefulSoft+="\t"+tmp;
            }
        }
        ConsoleOut(BLUE, "Useful Softwares", usefulSoft);
        pb.showProgress=false;
    }

    /**
     * bashRC
     * print out bashrc
     */
    public static void bashRC(){
        pb.showProgress=true;
        String rootBashrc= Command.getCommandExecution(OS.LINUX, "cat /home/.bashrc");
        ConsoleOut(CYAN, "root .bashrc", rootBashrc);
        pb.showProgress=false;
        pb.showProgress=true;
        String userBashrc= Command.getCommandExecution(OS.LINUX, "cat "+System.getProperty("user.home")+"/.bashrc");
        ConsoleOut(CYAN, "root .bashrc", userBashrc);
        pb.showProgress=false;
    }

    /**
     * network
     * list network data
     */
    public static void network(){
        pb.showProgress=true;
        String network= Command.getCommandExecution(OS.LINUX, "cat /etc/hostname /etc/hosts /etc/resolv.conf");
        ConsoleOut(YELLOW,"Hostname, hosts and DNS data", network);
        pb.showProgress=false;
        pb.showProgress=true;
        String inet= Command.getCommandExecution(OS.LINUX, "cat /etc/inetd.conf /etc/xinetd.conf");
        ConsoleOut(YELLOW,"Content of /etc/inetd.conf & /etc/xinetd.conf", inet);
        pb.showProgress=false;
        pb.showProgress=true;
        String interfaces= Command.getCommandExecution(OS.LINUX, "cat /etc/networks");
        ConsoleOut(YELLOW,"Interfaces", interfaces);
        pb.showProgress=false;
        pb.showProgress=true;
        String arp= Command.getCommandExecution(OS.LINUX, "arp");
        ConsoleOut(YELLOW,"Arp table", arp);
        pb.showProgress=false;
        pb.showProgress=true;
        String usedNet= Command.getCommandExecution(OS.LINUX, "lsof -i");
        ConsoleOut(YELLOW,"Files used by network services", usedNet);
        pb.showProgress=false;
    }

    /**
     * ports
     * list ports
     */
    public static void ports(){
        pb.showProgress=true;
        String p= Command.getCommandExecution(OS.LINUX, "netstat");
        ConsoleOut(GREEN,"Files used by network services", p);
        pb.showProgress=false;
    }

    /**
     * passwd
     * print out passwd
    */
    public static void passwd(){
        pb.showProgress=true;
        String pwd = Command.getCommandExecution(OS.LINUX, "cat /etc/passwd");
        ConsoleOut(PURPLE,"/etc/passwd", pwd);
        pb.showProgress=false;
    }

    /**
     * interestingFiles
     * print out interesting files
     */
    public static void interestingFiles(){
        pb.showProgress=true;
        String profile= Command.getCommandExecution(OS.LINUX, "ls -l /etc/profile /etc/profile.d/");
        ConsoleOut(CYAN,"/etc/profile", profile);
    }


    /**
     * badSUID
     * misconfigured binaries
     */
    public static void badSUID(){
        pb.showProgress=true;
        String suids = Command.getCommandExecution(OS.LINUX, "find / -perm -u=s -type f 2>/dev/null");
        // String suids = commandExec.getCommandExecution(OS.LINUX, "find / -user ubuntu -perm -4000 -print 2>/dev/null");
        ConsoleOut(GREEN,"SUID bin", suids);
        pb.showProgress=false;
    }


}
