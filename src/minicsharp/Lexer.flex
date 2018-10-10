package minicsharp;
import static minicsharp.Token.*;
%% 
%class Lexer
%type Token
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

BoolConstant = "true" | "false"

Identifier = [:jletter:] [:jletterdigit:]*




Reserved = "void" |"int"|"double"|"bool"|"string"|"class"|"interface"|"null"|
    "this"|"extends"|"implements"|"for"|"while"|"if"|"else"|"return"|
    "break"|"New"|"NewArray"

Puntuaction="+"| "-"| "*"| "/"| "%"| "<"| "<="| ">"| ">="| "="| "=="| "!="| 
        "&&"| "||"| "!"| ";"| ","| "."| "["| "]"| "("| ")"| "{"| "}"| "[]"| 
        "()"| "{}"

%{
	public String lexeme;
%}
%%

{Comment}                      { /* ignore */ }
{WhiteSpace}                   { /* ignore */ }

[\n] {return salto;}
"false" {return CONSTANTE_BOOLEANA;}
"true" {return CONSTANTE_BOOLEANA;}
{Reserved} {return RESERVADA;}
{Identifier} {return IDENTIFICADOR;}
{Puntuaction} {return PUNTUACION;}


{IntConstant} {return CONSTANTE_ENTERA;}

[-+]?[0-9]+"."|[-+]?[0-9]+"."([0-9]+|("E"|"e")[-+]?[0-9]+|[0-9]+("E"|"e")[-+]?[0-9]+) { return CONSTANTE_DOUBLE;}
\"[^\r\n]+\" { return STRING;}

[^]   {return ERROR;}

