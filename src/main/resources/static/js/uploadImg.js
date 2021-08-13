var curFiles = [];
function multiCheckImage(obj) {
    var files = obj.files;
    console.log(files.length);
    if(files){

        if(files.length <= 3) {
            for (var i = 0; i < files.length; i++) {
                var item = files.item(i);
                var size = item.size;
                if (size / 1000 < 100) {
                    curFiles.push(item);
                }
                else {
                    alert("picture NO." + (i + 1) + "is too big");
                }
            }
        }
        else{
            $("#filename").val("");
            alert("Upload up to 3 pictures at a time");
        }
    }
    else {
        $("#filename").val("");
        alert("Please select upload file");
    }

    for (var i = 0; i < curFiles.length - 1; i++) {
        for (var j = 1; j < curFiles.length; j++) {
            if (i != j) {
                if (curFiles[i].name == curFiles[j].name) {
                    curFiles.splice(j, 1)
                }
            }
        }
    }


    for(var i = 0; i < curFiles.length; i++){
        var size = curFiles[i].size;
        if(size/1000>100){
            curFiles.splice(i, 1);
        }

    }

    console.log(curFiles);

    onLoadImage();
}


function onLoadImage() {
    $("#onLoadImage").html("");
    for(var i = 0; i < curFiles.length; i++){
        (function(i){
            var file = curFiles[i];
            var reader = new FileReader();
            reader.readAsDataURL(file);
            reader.onload = function(){
                $('#onLoadImage').append("<img src='"+reader.result+"'/><span><span>"+file.name+"</span><button id='"+i+"' onclick='del(this.id)'>删除</button></span><br>");
            }
        })(i)
    }
}

function del(id) {
    var name = $("#"+id).prev().text();
    console.log(name);
    curFiles = curFiles.filter(function(file) {
        return file.name !== name;
    });
    console.log(curFiles);
    onLoadImage();
}

function multiCheckSubmit() {
    if(curFiles.length>0){
        var formdata =  new FormData($('#form')[0]);
        for (var i = 0; i<curFiles.length; i++) {
            formdata.append('uploadFiles', curFiles[i]);
        }
        console.log(formdata);
        $.ajax({
            url: 'multipleImageUpload',
            type: 'post',
            data: formdata,
            processData: false,
            contentType: false,
            success: function(data) {
                alert(data.length+"pictures");
                for(var k in data){
                    var num=Number(k)+1;
                    alert("No."+num+"upload result："+data[k].result_msg);
                    if(data[k].hasOwnProperty("relativePath"))
                        alert("No."+num+"path："+data[k].relativePath);
                }
            },
            error: function(err) {
                alert("failed");
            }
        });
    }
    else{
        alert("Please select file and upload");
    }
}

