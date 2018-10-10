/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minicsharp;

import java.io.File;

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

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        String path="/home/diego/Desktop/MiniCSharp-master/MiniCSharp/src/minicsharp/Lexer.flex";
        GenerarLexer(path);
    }
    
}
