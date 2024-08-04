function navigateTo(page) {
    if (page === 'books') {
        document.getElementById('content').innerHTML = `
            <h1>Books</h1>
            <button onclick="getAllBooks()">Get All Books</button>
            <div id="booksList"></div>
        `;
    } else if (page === 'authors') {
        document.getElementById('content').innerHTML = `
            <h1>Authors</h1>
            <button onclick="getAllAuthors()">Get All Authors</button>
            <div id="authorsList"></div>
        `;
    }
}

function getAllBooks() {
    fetch('/books')
        .then(response => response.json())
        .then(data => {
            const booksList = document.getElementById('booksList');
            booksList.innerHTML = '<ul>' + data.map(book => `<li>${book.title}</li>`).join('') + '</ul>';
        });
}

function addNewBook(book) {
    fetch('/books', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(book)
    })
        .then(response => response.json())
        .then(data => {
            console.log('Book added:', data);
            getAllBooks();
        });
}

function updateBook(id, book) {
    fetch(`/books/${id}`, {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(book)
    })
        .then(response => response.json())
        .then(data => {
            console.log('Book updated:', data);
            getAllBooks();
        });
}

function deleteBook(name) {
    fetch(`/books?name=${name}`, {
        method: 'DELETE'
    })
        .then(() => {
            console.log('Book deleted');
            getAllBooks();
        });
}

function sortBooks(criteria) {
    fetch(`/books/list?sortCriteria=${criteria}`, {
        method: 'POST'
    })
        .then(response => response.json())
        .then(data => {
            const booksList = document.getElementById('booksList');
            booksList.innerHTML = '<ul>' + data.map(book => `<li>${book.title}</li>`).join('') + '</ul>';
        });
}

