window.onload = function(){
    var m = 9;
    var s = 59;
    var countdown = document.getElementById("title");
    getCountdown();
    setInterval(function(){ getCountdown() },1000);
    function getCountdown (){
        countdown.innerHTML = "<span>"+m+"</span> ：<span>"+s+"</span>";
        if( m == 0 && s == 0 ){
            alert("Countdown over!");
            m = 9;
            s = 59;
        }else if( m >= 0 ){
            if( s > 0 ){
                s--;
            }else if( s == 0 ){
                m--;
                s = 59;
            }
        }
    }
}



function popWin(){
    document.getElementById('light').style.display='block';
    document.getElementById('fade').style.display='block'
}

function closeWin() {
    document.getElementById('light').style.display = 'none';
    document.getElementById('fade').style.display = 'none'
}

function popWin1(){
    document.getElementById('light1').style.display='block';
    document.getElementById('fade1').style.display='block'
}

function closeWin1() {
    document.getElementById('light1').style.display = 'none';
    document.getElementById('fade1').style.display = 'none'
}
