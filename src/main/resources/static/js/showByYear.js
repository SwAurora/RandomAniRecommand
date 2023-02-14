const pages = document.querySelector('#pages');
const nav2 = document.querySelector('.nav2');

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

    for(let i = first; i <= last; i++)
    {
        if(nowPage === i)
        {
            pages.innerHTML += "<a id='now' href=\"/anime/year/" + nowYear + "/" + i + "\">" + i + "</a>";
        }
        else
        {
            pages.innerHTML += "<a href=\"/anime/year/" + nowYear + "/" + i + "\">" + i + "</a>";
        }
    }

    const nowPageButton = document.querySelector('#now');
    nowPageButton.style.backgroundColor = '#6b8771';

    for(let i = 2023; i >= 2011; i--)
    {
        if(nowYear === i)
        {
            nav2.innerHTML += "<a id='nowYear' href=\"/anime/year/" + i + "/1\">" + i + "</a>";
        }
        else
        {
            nav2.innerHTML += "<a href=\"/anime/year/" + i + "/1\">" + i + "</a>";
        }
    }
})