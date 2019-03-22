import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    static ArrayList<BinaryTree> myTree = new ArrayList<BinaryTree>();

    public static void whereToPutIt(BinaryTree tree){
        if (myTree.size() == 0){
            myTree.add(tree);
        }else{
            if (tree.getEnglish().compareTo())
        }
    }

    public static void main(String [] args){
        //se lee el archivo


        File file = new File("C:\\Users\\garoz\\Desktop\\2019\\Estructura de datos\\hdt7\\src\\Traducciones.txt");
        String[] twoParts = new String[2];
        String cleanString1 = "";
        String cleanString2 = "";
        String cleanString3 = "";
        try{
            BufferedReader br = new BufferedReader(new FileReader(file));

            String st;
            while ((st = br.readLine()) != null)
                cleanString1 = st.replaceFirst("\\(", "");
                cleanString2 = cleanString1.replace(")","");
                cleanString3 = cleanString2.replace(" ","");

                twoParts = cleanString3.split(",");

                BinaryTree<String> newTree = new BinaryTree<>(twoParts[0], twoParts[1]);


        }catch (FileNotFoundException e){
            System.out.println("No pudimos encontrar el archivo");

        }catch (IOException e){

        }

    }
}
