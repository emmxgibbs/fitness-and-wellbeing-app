function deleteFile() {
    var message = "Please confirm whether to delete";
    if (confirm(message) == true){
        return true;
    }else {
        return false;
    }
}

function upload1(){
    document.form1.action="uploadFile";
    document.form1.submit();
}

function search1(){
    document.form1.action="search";
    document.form1.submit();
}
