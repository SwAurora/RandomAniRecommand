const pages = document.querySelector('#pages');

document.addEventListener('DOMContentLoaded', () =>
{
    const paging = 10;
    const totalPage = Math.ceil(totalCount / row);
    const pageGroup = Math.ceil(nowPage / paging);

    let last = pageGroup * paging;
    if(last > totalPage)
    {
        last = totalPage;
    }

    let first = last - paging + 1;
    if(pageGroup * paging > totalPage)
    {
        first = (pageGroup - 1) * paging + 1;
    }

    if(nowPage > 1)
    {
        pages.innerHTML = "<a href=\"/anime/all/" + 1 + "\">\<\<</a>";
        pages.innerHTML += "<a href=\"/anime/all/" + (nowPage - 1) + "\">\<</a>";
    }

    for(let i = first; i <= last; i++)
    {
        if(nowPage === i)
        {
            pages.innerHTML += "<a id='now' href=\"/anime/all/" + i + "\">" + i + "</a>";
        }
        else
        {
            pages.innerHTML += "<a href=\"/anime/all/" + i + "\">" + i + "</a>";
        }
    }

    if(totalPage > nowPage)
    {
        pages.innerHTML += "<a href=\"/anime/all/" + (nowPage + 1) + "\">\></a>";
        pages.innerHTML += "<a href=\"/anime/all/" + totalPage + "\">\>\></a>";
    }

    const nowPageButton = document.querySelector('#now');
    nowPageButton.style.backgroundColor = '#6b8771';
})