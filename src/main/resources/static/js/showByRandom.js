function reset()
{
    const selectBox = document.querySelector('#selectBox');
    location.href = "/anime/random?genre=" + selectBox.value;
}

function goInfo(title)
{
    title = title.replace('\`', '%60');
    title = title.replace('\&', '%26');
    title = title.replace('\-', '%2D');
    title = title.replace('\=', '%3D');
    title = title.replace('\[', '%5B');
    title = title.replace('\]', '%5D');
    location.href = "/anime/info?title=" + title;
}