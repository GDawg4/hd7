import java.io.*;

public class Main {

    public static String[] getWords(){
        File fileTranslate = new File("C:\\Users\\garoz\\Desktop\\2019\\Estructura de datos\\hdt7\\src\\EnglishPhrase.txt");

        String[] words = new String[0];
        try{
            BufferedReader br = new BufferedReader(new FileReader(fileTranslate));

            String st;
            while ((st = br.readLine()) != null){
                //tomado de https://stackoverflow.com/questions/18830813/how-can-i-remove-punctuation-from-input-text-in-java
                words = st.replaceAll("[^a-zA-Z ]", "").toLowerCase().split("\\s+");
                return words;
            }

        }catch (FileNotFoundException e){
            System.out.println("couldnt find it");
            return words;

        }catch (IOException e){

        }
        return words;
    }

    public static void main(String [] args){
        System.out.println("Se incluyen los archivos .txt English Phrase y Traducciones con los que se probó");
        System.out.println("El camino es el usado en mi compu, pero puede ser cambiado en línea 9 y 40");
        BinaryTree mainTree = new BinaryTree();
        mainTree = mainTree.createBinaryTree();

        //extraído de https://www.geeksforgeeks.org/different-ways-reading-text-file-java/
        File fileDatabase = new File("C:\\Users\\garoz\\Desktop\\2019\\Estructura de datos\\hdt7\\src\\Traducciones.txt");
        String cleanString1 = "";
        String cleanString2 = "";
        String cleanString3 = "";
        try{
            BufferedReader br = new BufferedReader(new FileReader(fileDatabase));

            String st;
            while ((st = br.readLine()) != null){
                cleanString1 = st.replaceFirst("\\(", "");
                cleanString2 = cleanString1.replace(")","");
                cleanString3 = cleanString2.replace(" ","");
                String [] twoParts = cleanString3.split(",");
                mainTree.add(twoParts[0], twoParts[1]);
            }

        }catch (FileNotFoundException e){
            System.out.println("No pudimos encontrar el archivo");

        }catch (IOException e){

        }
        System.out.println("Base de datos en modo In Order");
        mainTree.traverseInOrder(mainTree.root);

        String[] wordsToTranslate = getWords();

        if (wordsToTranslate.length == 0){
            System.out.println("Algo salió mal, favor intentar nuevamente");
        }
        else {
            StringBuilder finalString = new StringBuilder();
            for (String i : wordsToTranslate){
                if (mainTree.findInOrder(mainTree.root, i).equals("not found")){
                    finalString.append("*");
                    finalString.append(i);
                    finalString.append("*");
                    finalString.append(" ");

                }else {
                    finalString.append(mainTree.findInOrder(mainTree.root, i));
                    finalString.append(" ");
                }
            }
            finalString.append(".");
            System.out.println("Su traducción");
            System.out.println(finalString);
        }
    }
}
