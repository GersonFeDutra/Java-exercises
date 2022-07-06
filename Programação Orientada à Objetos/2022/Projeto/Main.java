import java.util.Scanner;
import facade.*;

// Nota: Os exercícios principais podem ser encontrados na função "auto" da classe facade.CLI
// Esta classe Main apenas inicializa a interface apropriadamente.
/**
 * Main
 *                                .         .-==+++*****######*=-.                           
 *                               #%=.:=+*#%%%#**++++++++====++*#%%%*=:                       
 *                             :=@%#%@@%#***++++*******#####****++*##%%*-                    
 *                        .=*#%%#@%#**##%%%%%%%#####%%%@%#*++***#####**#%@#+.                
 *                     -+%%#*++*#%%#********************##%%###***++*#%%**#@%=               
 *                  -*%#*+=+*#%%#*******************#############%%%%#**##**#@#.             
 *               :+%%*++*#%%%#****************##########%%##%%########%%**#***%%:            
 *             -#%#++%%##*************%****##########%%#**+==+*#%%######%**%***%%.           
 *           =#%*====*%##***********#%***##########%%#**+=------=*%%#####%**#**#@#           
 *         -%%*=======#%############%**#########%%#*++=------------=*%%###%*%###@@###-       
 *       :#@#+=====+++*%%##########%**#######%%#*+=---=+++++=--------=#@###@@%#*+++%%        
 *      =%%*====++******#%%#######%#*####%%%#*=-----=*%%@@@%%*+-:---:--%###%*::=*=*%.        
 *     *@#+=+++***********#%@%%#%%%%%%@@@@@%*=----=*%@@@@@@@@@#+-------#%*#%%*%*=+%:         
 *   -%%+++****************##%%#**#@@@@@@@@@#+----+#@@@@@@@@@@%+=------%%*##@=#+-%#          
 *  +@#++******************#%%*=+*%@@@@@@@@@#=---=*%@@@@@@@@@@@+------=@#*#%@+--*@-          
 * =@#*####%%%@@@%%%%####***%%+-+*%@@@@@@@@@*=---=*@@@@@@@@@@@%=------#@#*#%@*+*@%           
 * =**###*++=-::--=++*#@@@%%@@+-+*#@@@@@@@@#=-----*%@@@@@@@@@@+=-----#@%**#%@@@@@*           
 *             -*#%%#*- .:-+#@+--+*#@@@@@%*=------=+#%@@@@@@#+=-----%@#***#%@#*@@:           
 *            *%*=---%@=   -%@*---+==+**+==---------==+***+==-------%@****#@@*%@+            
 *           #@=...:=@@-   #%%%=------------------------------------*@#**##@%%@+             
 *           %@-::--+@@    #%*%*=-------------====----------------===%%**%@##@=              
 *           =@%##*++@@.   -@*#@+==---------+#%@@%%*=-------=========#@*%@@%%:               
 *        .=#@@%%%%@@@@+.   *%%#%+====-----+#@@@@@@@*---=============#@@%@%+                 
 *       =@%*=::----=++#@#- ..  =%#+========*#%@@@@%+=============+#%@%*%#                   
 *      :@@=...:-======-#@*      :*%%*+======++***+=============*#@%#%@@*                    
 *      #@*....:-++++*#%%@*        .=%@%#*+=================+*#@@%####%@:                    
 *     .@@-....:--------+%%.          :=+*%%%##*********#%%%#*%@@#*+++==:                    
 *     :@#.....:=+**###*++@:       .:=+*####%@@@**###***+==---=#@@%@%#=.                     
 *     .@#.....-------=+*%%       *@%%##*****@#-.::---------=+*%#****#%@%*=:                 
 *     *@@:....::--===---+@-.-=*#%%@+=======#@##########*##%%%#*********##%%@#*=.            
 *     @@@*......:++**###%@%%*+=--*@+=======%%-:::::::-*%%#******************#%@%            
 *    .@+%%-.....-------+@%=-::::-+@+++=====#%-::::-=#@%#*******************#%%@@=           
 *    .@#+@%=::.:--*#=-=%%=:------*@+%+=====*@+::-+%%#+=++++++++*********#%@#+=+%@+          
 *     @#:=#@#+=--=%%##%#=---=====*@%*======+@#-+%%*+++++++++**********#%%*==--:-#@#.        
 *     %#::-=*#%@%%#+--@%#========*@%+=======%%%%********************#%%*======-:-*@%=       
 *     ##:--=======-::-%@%======--+@*=====++*#%#*********************%%=========---+%@*      
 *     +@=-========-:::*#+=----=+*%%==+++****************************%@*-========--:=%@%:    
 *     :%#-========---=*=-=+#%@@%@@#=+*******************************#@@+-========--:-#@%-   
 *      -@%+=======-=+*#%%@%*+-..@@++*********************************%@@=-========--:-*@@=  
 *       :=*#%%%###%%#*=-.      +@%+***********************************%@%+=========--:-+@@= 
 *             .:-=:            #@#*************************************@@%+==========--:+@@:
 *                             .@@#*************************************@@#@*==========---%@+
 *                             -@@**************************************@@--%%+=========--#@*
 *                             =@@**************************************@@- .%@+==========#@#
 *                             =@@**************************************@@=  =@#==========%@*
 *                             -@@**************************************@@*  *@#==========@@-
 *                 ....        .                              .x+=:.                             
 *              .x88" `^x~  xH(`                             z`    ^%                            
 *             X888   x8 ` 8888h                 .u    .        .   <k        u.      u.    u.   
 *            88888  888.  %8888        .u     .d88B :@8c     .@8Ned8"  ...ue888b   x@88k u@88c. 
 *           <8888X X8888   X8?      ud8888.  ="8888f8888r  .@^%8888"   888R Y888r ^"8888""8888" 
 *           X8888> 488888>"8888x  :888'8888.   4888>'88"  x88:  `)8b.  888R I888>   8888  888R  
 *           X8888>  888888 '8888L d888 '88%"   4888> '    8888N=*8888  888R I888>   8888  888R  
 *           ?8888X   ?8888>'8888X 8888.+"      4888>       %8"    R88  888R I888>   8888  888R  
 *            8888X h  8888 '8888~ 8888L       .d888L .+     @8Wou 9%  u8888cJ888    8888  888R  
 *             ?888  -:8*"  <888"  '8888c. .+  ^"8888*"    .888888P`    "*888*P"    "*88*" 8888" 
 *              `*88.      :88%     "88888%       "Y"      `   ^"F        'Y"         ""   'Y"   
 *                 ^"~====""`         "YP'                                                       
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean enableCLIMode = false;
        boolean enableAutoRun = false;
        boolean enableSkip = false;

        // Verifica os argumentos passados na inicialização para
        // personalizar a executar a aplicação.
        if (args.length > 0)
            for (String arg : args)
                if (arg.startsWith("-"))
                    for (char opt : arg.substring(1).toCharArray())
                        switch (opt) {
                            case 'a': enableAutoRun = true; break; // auto
                            case 's': enableSkip = true; break; // skip
                            case 'm': enableCLIMode = true; break; // manual
                            case 'h': {
                                System.out.println(
                                        "Following options are available to run this project:");
                                System.out.println("-a : auto");
                                System.out.println("    Auto running mode.");
                                System.out.println("    Runs automatically all operations pointed by the exercise.");
                                System.out.println("-s : skip");
                                System.out.println("    Skips pauses in auto-mode. Also won't ask for manual mode when used.");
                                System.out.println("    Must be used with the option -a.");
                                System.out.println("-m : manual");
                                System.out.println("    Manual running mode.");
                                System.out.println("    Runs operations from the Command Line Interface (CLI).");
                                System.out.println("    using prompts each step/ action.");
                                System.out.println("-h : help");
                                System.out.println("    Shows those infos.");
                                System.out.println("* Note: you can combine options, eg.: -as to skip in auto mode.");
                            }; return;
                        }

        if (!enableAutoRun) {
            System.out.printf("Auto-run? (Y/n) ");
            enableAutoRun = promptEnable(scanner);
            System.out.println("Skip pauses? (Y/n) ");
            enableSkip = promptEnable(scanner);
        }

        if (enableAutoRun)
            CLI.auto(enableSkip);
        else
            enableCLIMode = true;

        if (!enableCLIMode && !enableSkip) {
            System.out.printf("Change to manual mode? (Y/n) ");
            enableCLIMode = promptEnable(scanner);
        }

        if (enableCLIMode)
            CLI.manual(scanner);

        if (scanner != null)
            scanner.close();
    }

    /*
    * Scans a "boolean".
    * Prioritizes true (that is, only check for N/n to be falsy.)
    */
    public static boolean promptEnable(Scanner scanner) {
        return !scanner.nextLine().toLowerCase().startsWith("n");
    }

}
