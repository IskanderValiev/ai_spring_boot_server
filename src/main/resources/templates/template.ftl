<#ftl encoding='UTF-8'>
<head>
    <link href="/css/styles.css" rel="stylesheet"/>
    <script>
        function sendFile(file) {
            var formData = new FormData();
            formData.append("file", file);

            var xhr = new XMLHttpRequest();
            xhr.open("POST", "/upload", true);
            xhr.send(formData);
        }
    </script>
</head>
<body>
<div class="header">
    <div id="inside-header-text">
        DressMeApp
    </div>
</div>
<div class="data">
    <div class="left-half">
        <div id = "file-form">
            <div id="file-form-title">
                Загрузите изображение
            </div>
            <div id="file-form-form">
                <form enctype="multipart/form-data" method="post" action="/upload">
                    <div class="file-form-button">
                        <input type="file" name="file" id="file" accept="image/*"><br>
                    </div>
                    <div class="file-form-button">
                        <button onclick="sendFile(($('#file'))[0]['files'][0])" class="btn">Upload file</button>
                        <#--<input type="submit" value="Отправить"><br>-->
                    </div>
                </form>
            </div>
        </div>
    </div>
    <div class="right-half">
        <#if result??>
            <div id="result">
                <div id="inside-result-text">
                    ${result}
                </div>
            </div>
        </#if>
    </div>
</div>
<div class="footer">
    <div id="inside-footer-text">
        AI Beginners
    </div>
</div>
</body>