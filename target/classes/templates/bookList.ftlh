<#import "common.ftlh" as c>
<@c.page>
<!-- Modal -->
<div class="modal fade" id="staticBackdrop" data-backdrop="static" data-keyboard="false" tabindex="-1" role="dialog" aria-labelledby="staticBackdropLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="staticBackdropLabel">Загрузка данных в формате csv</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <form method="post" action="/books/addCSV" id="modal-details" enctype="multipart/form-data">
                    <div class="form-group row mx-sm-3 mb-2">
                        <input type="file" name="file">
                    </div>
                </form>
            </div>
            <div class="modal-footer">
            <button type="submit" class="btn btn-primary" form="modal-details">Сохранить</button>
            <button type="button" class="btn btn-secondary" data-dismiss="modal">Закрыть</button>
            </div>
        </div>
    </div>
</div>


<h3 align="center" >Книги</h3>
<div class="row justify-content-md-center">
    <div class="col-4 mb-3 mt-3">
        <button type="button" class="btn btn-primary btn-sm" data-toggle="modal" data-target="#staticBackdrop">
            Добавить книги в формате csv
        </button>
    </div>
    <div class="col-4 mb-3 mt-3">
        <a class="btn btn-primary btn-sm" href="/books/add" role="button">Добавить новую книгу</a>
    </div>
</div>

<table class="table table-striped" id="info-table">
    <thead class="thead-dark">
    <tr>
        <th scope="col">Название книги</th>
        <th scope="col">Автор</th>
        <th scope="col">Год издания</th>
        <th scope="col">Жанр</th>
        <th scope="col">Главные персонажи</th>
        <th scope="col"> </th>
        <th scope="col"> </th>
    </tr>
    </thead>
    <tbody>
    <#list books as book>
    <tr>
        <td>${book.bookName}</td>
        <td>${(book.author)!}</td>
        <td>${(book.year)!}</td>
        <td>${(book.genre)!}</td>
        <td>${(book.mainCharacters)!}</td>
        <td> <a href="/books/edit/${book.id}">&#10000;</a></td>
        <td> <a href="/books/delete/${book.id}">&#9984;</a></td>
    </tr>
    </#list>
    </tbody>
</table>
</@c.page>


