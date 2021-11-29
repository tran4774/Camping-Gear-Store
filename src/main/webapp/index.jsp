<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<br/>
<a href="hello-servlet">Hello Servlet</a>
<form>
    <input type="file" id="avatar">
    <input type="button" id="upload" onclick="requestUploadURL()">
</form>

<script>
    function requestUploadURL(){
        const file = document.querySelector('#avatar').files[0];
        const metadata = {
            contentType: file.type
        };
        const name = file.name;
        console.log("upload");
        console.log(name);
        let data = {
            "fileName": name,
            "url": "/"
        };
        $.ajax({
            url: '/upload-image?file-name=123.jpg',
            type: 'post',
            contentType: 'application/json',
            data: JSON.stringify(data),
            dataType: 'json'
        }).then(data => uploadImage(data))
    }
    function uploadImage(data){

        const file = document.querySelector('#avatar').files[0];
        let blob = new Blob([file], {type: 'image/png'})
        $.ajax({
            url: data.url,
            type: 'PUT',
            data: file,
            processData: false,
            contentType: false,
        }).then(data => {
            console.log(data);
            console.log("done");
        })
    }

</script>
</body>
</html>