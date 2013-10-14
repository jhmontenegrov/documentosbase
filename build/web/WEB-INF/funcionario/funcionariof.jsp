<%-- 
    Document   : funcionariof
    Created on : 1/10/2013, 07:50:04 AM
    Author     : 201
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src=""></script>
        <script src="../../../../js/libs/jquery-validate-1.10.0/jquery.validate.min.jsp"></script>
        
        <style>
            .error{
                color: red;
                
            }
            input.error{
                background-color: crimson;
            }
            
        </style>
    </head>
    <body>
        <h1>Formulario</h1>
        <form id="form1" name="formulario" method="post" action="../../../src/java/controladores/CFuncionario.java">
            nombres <input type="text" name="nombre"><br>
            Primer Apellido <input type="text" name="Apellido1"><br>
            Segundo Apellido <input type="text" name="apellido2"><br>
            Ingrese número de cedula<input type="text" name="cedula"><br>
            Ingrese una clave <input type="password" name="clave"><br>
            <input type="submit" value="Aceptar">
            <input type="hidden" name="a" value="guardar">
        </form>
    <script>
             $("#form1").validate(                
        
        {
    errorLabelContainer:"#messagebox",
    wrapper:"li",
         rules:
                 {
                  nombre:
             {
         required: true
             
            },
             apellido1:
                     {
                 required: true,
                 
            },
            apellido2:
                     {
                 required: true,
                 
            },
                     cedula:
                             {
                         required: true
                         },
             
        clave:{
            required:true
        }         
        },
                 messages:
                         {
                     nombre:{
                         required: "por favor digite su nombre",
                         
            },
                     apellido1:
                             {
                         required:"porfavor digite su primer apellido"
                             },
                             apellido2:
                             {
                         required:"porfavor digite su segundo apellido"
                             },
                             cedula:
                             {
                         required: "por favor digite el número de su documeto"
                         },
                         clave:
                             {
                         required: "por favor ingrese una clave"
                         },         
                     
                     }                         
                         }
           );          
        </script>
    </body>
</html>
