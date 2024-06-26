package gitlet;

/** Driver class for Gitlet, a subset of the Git version-control system.
 *  @author TODO
 */
public class Main {

    /** Usage: java gitlet.Main ARGS, where ARGS contains
     *  <COMMAND> <OPERAND1> <OPERAND2> ... 
     */
    public static void main(String[] args) {
        // TODO: what if args is empty?
        String firstArg = args[0];
        switch(firstArg) {
            case "init":
                // TODO: handle the `init` command
                CommandInit.init();
                break;
            case "add":
                // TODO: handle the `add [filename]` command
                CommandAdd.add(args[1]);
                break;
            case "commit":
                CommandCommit.commit(args[1]);
                break;
            // TODO: FILL THE REST IN
        }
    }
}
