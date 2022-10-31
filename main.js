function showMitute() {
    document.getElementById("now-time").innerHTML = (new SuperDate()).getStrUntilMinute();
    window.setTimeout("showMitute()" , 60000);
}