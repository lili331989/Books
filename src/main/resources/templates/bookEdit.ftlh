<#import "common.ftlh" as c>
<@c.page>
<h5 align="center">Редактирование записи</h5>
<form method="post" action="/books/edit" id="modal-details">
    <div class="form-group row">
        <label  class="col-sm-6 col-form-label">Название книги</label>
        <div class="col-sm-10">
            <input type="text" value="${book.bookName}" class="form-control" name="bookName" required>
        </div>
    </div>
    <div class="form-group row">
        <label class="col-sm-6 col-form-label">Автор</label>
        <div class="col-sm-10">
            <input type="text" value="${book.author}" class="form-control" name="author">
        </div>
    </div>
    <div class="form-group row">
        <label  class="col-sm-6 col-form-label">Год выпуска</label>
        <div class="col-sm-10">
            <input type="text"  value="${book.year}" class="form-control" name="year" pattern="[0-9]{4}" title="Введите год выпуска в формате xxxx">
        </div>
    </div>

    <div class="form-group row">
        <label  class="col-sm-6 col-form-label">Жанр</label>
        <div class="col-sm-10">
            <input type="text"  value="${book.genre}" class="form-control" name="genre">
        </div>
    </div>

    <div class="form-group row">
        <label  class="col-sm-6 col-form-label">Главные герои</label>
        <div class="col-sm-10">
            <input type="text" value="${book.mainCharacters}" class="form-control" name="mainCharacters">
        </div>
    </div>
    <input type="hidden" name="bookId" value="${book.id}">
    <button type="submit" class="btn btn-primary" form="modal-details">Сохранить</button>
</form>

</@c.page>