<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transistional//EN" "http://www.w3c.org/TR/html4/loose.dtd">
    <html>

    <head>
        <meta http-equiv="content-type" content="text/html; charset-UTF-8">
        <title>Insert title here</title>
    </head>

    <body>
        <form action="addAlien">
        	<input type="text" name="aid"><br>
        	<input type="text" name="aname"><br>
        	<input type="text" name="tech"><br>
        	<input type="submit"><br>
        </form>
        
        <form action="getAlien">
        	<input type="text" name="aid"><br>
        	<input type="submit"><br>
        </form>
        <br>
        <h1>Remove the record by Id</h>
        <form action="removeAlien">
        	<input type="text" name="aid"><br>
        	<input type="submit"><br>
        </form>
    </body>

    </html>