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
        String[] asinta = { "-parser","Sintact", path};
        try
        {
            java_cup.Main.main(asinta);
        }
        catch (Exception ex)
        {
            Logger.getLogger(MiniCSharp.class.getName()).log(Level.SEVERE, null, ex);
        }
        /* Los archivos se generan en la carpeta raiz del proyecto, por lo que hay que moverlos para que funcionen correctamente*/
        corregirRuta("Sintact.java");
        corregirRuta("sym.java");
    }
    
    public static boolean corregirRuta(String fileName)
    {
        boolean fileMoved = false;
        File file =  new File(fileName);
        if (file.exists())
        {
            System.out.println("tratando de mover los archivos a la ruta correcta");
            Path currentRelativePath = Paths.get("");
            String newDir = currentRelativePath.toAbsolutePath().toString()
                    + File.separator + "src" + File.separator
                    + "minicsharp" + File.separator + file.getName();
            if (file.renameTo(new File(newDir)))
            {
                System.out.println("archivo movido con exito.");
                fileMoved = true;
            }
            else
            {
                System.out.println("No se pudo mover el archivo.");                
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
