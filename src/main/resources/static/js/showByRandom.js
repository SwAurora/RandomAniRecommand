function reset()
{
    const selectBox = document.querySelector('#selectBox');
    location.href = "/anime/random?genre=" + selectBox.value;
}

function goInfo(title)
{
    title = title.replace('\`', '%60');
    title = title.replace('\&', '%26');
    location.href = "/anime/info?title=" + title;
}