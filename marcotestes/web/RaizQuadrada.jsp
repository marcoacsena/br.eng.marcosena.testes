<%-- 
    Document   : PaginaPrincipal
    Created on : 15/03/2019, 18:16:53
    Author     : Marco
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Programação JavaScript</title>
    </head>
    
    <body>
        <h1>Digite um número a seguir:</h1>
        
        
       <input id="numero"><br><br>
            
        <button type="button" onclick="calcularRaiz()">Calcular Raiz</button>
            
        <p id="raiz"></p> 
        
        <script>

                
            function calcularRaiz(){
                var raiz;
                
                 raiz = Math.sqrt(document.getElementById("numero").value);
                 document.getElementById("raiz").innerHTML = raiz;   
                }              
                
        </script>      
        
    </body>
</html>
