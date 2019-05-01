<%-- 
    Document   : Autenticar
    Created on : 27/03/2019, 15:21:28
    Author     : 80119050
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
      
        <h1>Página de Login: desenvolvida por Marco Sena</h1>
        <h2>Login: </h2>
        <form action="autenticar" method="post">
        Nome  : <input type="text" name="nome"> <br>
        Senha : <input type="password" name="senha"> 
        <input type="submit" name="login" value="Acessar"/> <br>
        </form><br><br>

        
        <%
            
            Object obj = request.getAttribute("autenticado");
            
            if(obj != null){
            
            Boolean resultado = (Boolean) obj;
            
                if(!resultado){%>
                <hr>
                <input type="text" size="100" value="<% out.println("Verifique seu login ou senha, pois você não foi autenticado!");%>">
                
                <%}
                
            }%>
       
    </body>
</html>
