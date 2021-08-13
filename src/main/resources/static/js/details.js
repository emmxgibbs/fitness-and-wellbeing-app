
function update_Info(data) {
    $.ajax({
        method:"POST",
        type:"POST",
        url:"/updateInfo",
        data:data,
        success:function (msg) {
            if(msg=="success"){
                dialog("success");
            }else{
                dialog("failed");
            }
        },error:function () {
            dialog("ajax wrong");
        }
    });
}



$(function () {

    // restart button
    $("input[name='restart']").click(function () {
        window.location.href="/DetailsInfo";
    });
    // save button
    $("input[name='save']").click(function () {
        var sex = $("input[name='sex']").val();
        var height = $("input[name='height']").val();
        var weight = $("input[name='weight']").val();
        var level = $("input[name='level']").val();
        var speciality = $("input[name='speciality']").val();
        var qualification = $("input[name='qualification']").val();
        var organisation = $("input[name='organisation']").val();

        if(sex==""||height==""||weight==""||level==""||speciality==""||qualification==""||organisation==""){
            dialog("cannot empty！");
            return;
        }
        var data = {"sex":sex,"height":height,"weight":weight,"level":level,"speciality":speciality,"qualification":qualification,"organisation":organisation};
        update_Info(data);
    });
})

