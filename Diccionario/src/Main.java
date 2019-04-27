import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Stream;
/*
Universidad del Valle de Guatemala
Seccion 10 - Pareja 9
Josue Sagastume - 18173
Mario Perdomo - 18029
Main.java
 */
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String tipo;
        FactoryTree factoryTree = new FactoryTree();
        System.out.println("Ingrese que tipo de Arbol desea utilizar:\n 1. Escriba SPLAY para un splaytree \n 2. Escriba RBT para un RedBlackTree \n ");
        tipo = scan.next();
        Object arbol = factoryTree.getTree(tipo);
        System.out.println("Porfavor, escriba el nombre del diccionario\n");
        String diccionario;
        //Para leer el archivo
        System.out.println("Ingrese el nombre del diccionario");
        diccionario = scan.next();
        ArrayList<String> texto = new ArrayList<>();
        try {
            Stream<String> lines = Files.lines(
                    Paths.get(diccionario + ".txt"),
                    StandardCharsets.UTF_8
            );
            lines.forEach(texto::add);
        } catch (IOException e ){
            System.out.println("Ha ocurrido un error, porfavor verifique el nombre. \n");
        }

        for (String linea : texto) {
            String lineaClean = linea.replaceAll("\t", " ").replaceAll(",", "").replaceAll(";", "");

            String ingles = lineaClean.trim().split("\\s+")[0].toLowerCase();
            String espanol = lineaClean.trim().split("\\s+")[1].toLowerCase();
        }


    }
}
