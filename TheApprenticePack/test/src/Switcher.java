public class Switcher {
    private static boolean b;

    public static void main(String[] args){
        switch(Integer.parseInt(args[1]))  //1
        {
            case 0 :
                var b = false; //2     Note: 'var' here is the same as 'boolean' i.e. boolean b = false;
                break;
            case 1 :
                break;
        }
        if(b) System.out.println(args[2]); //4
    }
}
