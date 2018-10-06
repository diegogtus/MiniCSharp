package minicsharp;
import java.io.*;
import java_cup.runtime.*;
%%

%public

%class Yylex

%unicode

%line

%column

%cup

%type Symbol

MULTILINE_COMMENT = "/*" [^*] ~"*/" | "/*" "*"+ "/"

UNFINISHED_COMMENT = "/*" [^*]+

SINGLELINE_COMMENT = "//" [^\r\n]* [\r|\n|\r\n]?

L=[a-b]
D=[0-9]
white=[ ,\r]

LineTerminator = \r|\r\n
InputCharacter = [^\r\n]
WhiteSpace     = {LineTerminator} | [ \t\f]
/* comments */
Comment = {TraditionalComment} | {EndOfLineComment} | {DocumentationComment}
TraditionalComment   = "/*" [^*] ~"*/" | "/*" "*"+ "/"
// Comment can be the last line of the file, without line terminator.
EndOfLineComment     = "//" {InputCharacter}* {LineTerminator}?
DocumentationComment = "/**" {CommentContent} "*"+ "/"
CommentContent       = ( [^*] | \*+ [^/*] )*

IntConstant = [0-9]* | "0x"[0-9a-fA-F]+ |"0X"[0-9a-fA-F]+ 

/*BoolConstant = "true" | "false"*/

Identifier = [:jletter:] [:jletterdigit:]*




/*Reserved = "void" |"int"|"double"|"bool"|"string"|"class"|"interface"|"null"|
    "this"|"extends"|"implements"|"for"|"while"|"if"|"else"|"return"|
    "break"|"New"|"NewArray"*/

/*Puntuaction="+"| "-"| "*"| "/"| "%"| "<"| "<="| ">"| ">="| "="| "=="| "!="| 
        "&&"| "||"| "!"| ";"| ","| "."| "["| "]"| "("| ")"| "{"| "}"| "[]"| 
        "()"| "{}"*/

%{
	public String lexeme;
        
        private Symbol symbol(int type){
        return new Symbol(type, yyline, yycolumn);
    }

    private Symbol symbol(int type, Object value){
        return new Symbol(type, yyline, yycolumn, value);
    }
%}
%%

"+" { return symbol(sym.ADD, new String(yytext()));}
"-" { return symbol(sym.SUBSTRACTION, new String(yytext()));}
"*" { return symbol(sym.MULT, new String(yytext()));}
"/" { return symbol(sym.DIV, new String(yytext()));}
"%" { return symbol(sym.MOD, new String(yytext()));}
"<" { return symbol(sym.MINUS, new String(yytext()));}
"<=" { return symbol(sym.MINUS_EQUAL, new String(yytext()));}
">" { return symbol(sym.GREATER, new String(yytext()));}
">=" { return symbol(sym.GREATER_EQUAL, new String(yytext()));}
"="  { return symbol(sym.ASSIGN, new String(yytext()));}
"==" { return symbol(sym.EQUAL, new String(yytext()));}
"!="  { return symbol(sym.DIFFERENT, new String(yytext()));}
"&&"  { return symbol(sym.AND, new String(yytext()));}
"||" { return symbol(sym.OR, new String(yytext()));}
"!"  { return symbol(sym.NOT, new String(yytext()));}
";"  { return symbol(sym.SEMI_COLON, new String(yytext()));}
","  { return symbol(sym.COMA, new String(yytext()));}
"." { return symbol(sym.POINT, new String(yytext()));}
"["  {return symbol(sym.SB_LEFT, new String(yytext()));}
"]"  { return symbol(sym.SB_RIGHT, new String(yytext()));}
"(" { return symbol(sym.PAR_LEFT, new String(yytext()));}
")" { return symbol(sym.PAR_RIGHT, new String(yytext()));}
"{" { return symbol(sym.BRACKET_LEFT, new String(yytext()));}
"}" { return symbol(sym.BRACKET_RIGHT, new String(yytext()));}
"[]" { return symbol(sym.SBCHETES, new String(yytext()));}
/*"()" { return symbol(sym.PARENTHESIS, new String(yytext()));}*/
"{}"   { return symbol(sym.BRACKETS, new String(yytext()));}

// STRINGs
\"[^\r\n]+\"  { 
                                                                        /*return "STRING: " + yytext() + " in line: " + (yyline + 1) + " columns: " + (yycolumn + 1) + " - " + ((yycolumn + 1) + yylength() - 1);*/
                                                                        return symbol(sym.STRING, new String(yytext()));
                                                                     }

// BOOLEANs
"true" | "TRUE"                                                      { 
                                                                        /*return "BOOLEAN: " + yytext() + " in line: " + (yyline + 1) + " columns: " + (yycolumn + 1) + " - " + ((yycolumn + 1) + yylength() - 1);*/ 
                                                                        return symbol(sym.TRUE, new String(yytext()));
                                                                    }

"false" | "FALSE"                                                      { 
                                                                        /*return "BOOLEAN: " + yytext() + " in line: " + (yyline + 1) + " columns: " + (yycolumn + 1) + " - " + ((yycolumn + 1) + yylength() - 1);*/ 
                                                                        return symbol(sym.FALSE, new String(yytext()));
                                                                    }

// RESERVED_WORDs
/*{RESERVED_WORDS}                                                   { return "RESERVED WORD: " + yytext() + " in line: " + (yyline + 1) + " columns: " + (yycolumn + 1) + " - " + ((yycolumn + 1) + yylength() - 1); }*/

"void"  { return symbol(sym.VOID, new String(yytext())); }

"int" { return symbol(sym.INT, new String(yytext())); } 

"double"  { return symbol(sym.DOUBLE, new String(yytext())); }

"bool" { return symbol(sym.BOOL, new String(yytext())); }

"string" { return symbol(sym.STRING, new String(yytext())); }

"class" { return symbol(sym.CLASS, new String(yytext())); }

"interface"  { return symbol(sym.INTERFACE, new String(yytext())); }

"null" { return symbol(sym.NULL, new String(yytext())); }

"this" { return symbol(sym.THIS, new String(yytext())); }

"extends" { return symbol(sym.EXTENDS, new String(yytext())); }

"implements" { return symbol(sym.IMPLEMENTS, new String(yytext())); }

"for" { return symbol(sym.FOR, new String(yytext())); }

"while" { return symbol(sym.WHILE, new String(yytext())); }

"if" { return symbol(sym.IF, new String(yytext())); }

"else" { return symbol(sym.ELSE, new String(yytext())); }

"return" { return symbol(sym.RETURN, new String(yytext())); }

"break" { return symbol(sym.BREAK, new String(yytext())); }

"new" { return symbol(sym.NEW, new String(yytext())); }

"newarray" { return symbol(sym.NEWARRAY, new String(yytext())); }

"print" { return symbol(sym.PRINT, new String(yytext())); }

"readinteger" { return symbol(sym.READINTEGER, new String(yytext())); }

"readline" { return symbol(sym.READLINE, new String(yytext())); }

"malloc"  { return symbol(sym.MALLOC, new String(yytext())); }

"GetByte" { return symbol(sym.GETBYTE, new String(yytext())); }

"SetByte" { return symbol(sym.SETBYTE, new String(yytext())); }

// IDENTIFIERs
{L}({L}|{D})*                                                    { 
                                                                    if(yylength() > 31)
                                                                    {
                                                                        String aux = yytext().substring(0,31);
                                                                        
                                                                        //return "IDENTIFIER: " + aux + " in line: " + (yyline + 1) + " columns: " + (yycolumn + 1) + " - " + ((yycolumn + 1) + yylength() - 1) + " exceeded the max limit length. Identifier truncated.";                                                                       
                                                                        return symbol(sym.IDENT, new String(aux));
                                                                    }
                                                                    else 
                                                                    {
                                                                        //return "IDENTIFIER: " + yytext() + " in line: " + (yyline + 1) + " columns: " + (yycolumn + 1) + " - " + ((yycolumn + 1) + yylength() - 1); 
                                                                        return symbol(sym.IDENT, new String("IDENTIFIER: " + yytext()));
                                                                    }
                                                                 }
// INTs
{D}+	                                                        { 
                                                                    //return "INTEGER: " + yytext() + " in line: " + (yyline + 1) + " columns: " + (yycolumn + 1) + " - " + ((yycolumn + 1) + yylength() - 1); 
                                                                    return symbol(sym.INTCONSTANT, new Integer(yytext()));
                                                                }

// HEXADECIMALs
0[xX][0-9a-fA-F]+                                           { 
                                                                //return "INTEGER HEXADECIMAL: " + yytext() + " in line: " + yyline + " columns: " + (yycolumn + 1) + " - " + ((yycolumn + 1) + yylength() - 1); 
                                                                return symbol(sym.HEXADECIMAL, new String(yytext()));
                                                            }

// DOUBLEs
[-+]?[0-9]+"."|[-+]?[0-9]+"."([0-9]+|("E"|"e")[-+]?[0-9]+|[0-9]+("E"|"e")[-+]?[0-9]+)   {
                                                                                            //return "DOUBLE: " + yytext() + " in line: " + (yyline + 1) + " columns: " + (yycolumn + 1) + " - " + ((yycolumn + 1) + yylength() - 1); 
                                                                                            return symbol(sym.DOUBLECONSTANT, new String("DOUBLE: " + yytext()));
                                                                                        }  

// LINE COUNTER
[ \n]                                                            { /*lleva la cuenta de lineas*/ }

// WHITESPACEs TABs BRAKELINEs NEWLINEs
[\s]+                                                            { /*se ignoran los espacios y tabuladores*/ }

//UNFINISHED COMMENTs
{UNFINISHED_COMMENT}                                            { 
                                                                    //return "Unfinished comment " + yytext() + " found in line: " + (yyline + 1) + " columns: " + (yycolumn + 1) + " - " + ((yycolumn + 1) + yylength() - 1); 
                                                                    System.out.print("Unfinished comment " + yytext() + " found in line: " + (yyline + 1) + " columns: " + (yycolumn + 1) + " - " + ((yycolumn + 1) + yylength() - 1));
}

//MULTILINE COMMENTs
{MULTILINE_COMMENT}                                              { /*se ignoran los comentarios de bloque*/ }

//SINGLELINE COMMENTs
{SINGLELINE_COMMENT}                                             { /*se ignoran los comentarios de linea*/ }

// ERRORs
.	                                                         { 
                                                                    lexeme = yytext(); line = (yyline + 1); column = (yycolumn + 1); length = yylength(); 
                                                                    System.out.print("Lexical error: invalid token "); 
                                                                }

