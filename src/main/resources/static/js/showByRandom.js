function reset()
{
    const selectBox = document.querySelector('#selectBox');
    location.href = "/anime/random?genre=" + selectBox.value;
}

function goInfo(title)
{
    location.href = "/anime/info?title=" + title;
}