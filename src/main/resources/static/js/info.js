function goBack()
{
    history.back();
}

function commentCheck()
{
    let comment = document.querySelector('#commentInput');
    if(comment.value === '')
    {
        alert("내용을 입력해주세요.");
    }
    else
    {
        const form = document.getElementById('commentForm');
        form.submit();
    }
}