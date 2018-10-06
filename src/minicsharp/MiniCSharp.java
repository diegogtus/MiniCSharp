/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minicsharp;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author diego
 */
public class MiniCSharp {

    private static void GenerarLexer(String path) {
        File file= new File(path);
        jflex.Main.generate(file);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static void GenerarCup(String path){
        File output = new File(path);
        String[] asintactico = { "-parser","Sintact", path};
        try
        {
            java_cup.Main.main(asintactico);
        }
        catch (Exception ex)
        {
            Logger.getLogger(MiniCSharp.class.getName()).log(Level.SEVERE, null, ex);
        }
        /* Los archivos se generan en la carpeta raiz del proyecto, por lo que hay que moverlos para que funcionen correctamente*/
        moveFile("Sintact.java");
        moveFile("sym.java");
    }
    
    public static boolean moveFile(String fileName)
    {
        boolean fileMoved = false;
        File file =  new File(fileName);
        if (file.exists())
        {
            System.out.println("moving cup generated files to the correct path");
            Path currentRelativePath = Paths.get("");
            String newDir = currentRelativePath.toAbsolutePath().toString()
                    + File.separator + "src" + File.separator
                    + "Lexic" + File.separator + file.getName();
            if (file.renameTo(new File(newDir)))
            {
                System.out.println("the cup generated file has been moved successfully.");
                fileMoved = true;
            }
            else
            {
                System.out.println("ERROR, the file could not be moved.");                
            }
        }
        else
        {
            System.out.println("File could not be found!");
        }
        return fileMoved;
    }
    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        String path="/home/diego/Desktop/MiniCSharp-master (copy)/MiniCSharp/src/minicsharp/Lexer.flex";
        String path2="/home/diego/Desktop/MiniCSharp-master (copy)/MiniCSharp/src/minicsharp/Sintact.cup";
        GenerarLexer(path);
        GenerarCup(path2);
    }
    
}
