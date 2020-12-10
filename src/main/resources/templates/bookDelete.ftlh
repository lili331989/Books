<#import "common.ftlh" as c>

<@c.page>
<form action="/books/delete" method="post">
    <h6 align="center">Вы действительно хотите удалить книгу?</h6>
    <div class="row justify-content-center">${book.bookName} ${book.author} </div>
    <input type="hidden" name="bookId" value="${book.id}">
    <div class="row justify-content-center"><button type="submit" class="btn btn-primary mt-3">Удалить</button></div>
</form>
</@c.page>