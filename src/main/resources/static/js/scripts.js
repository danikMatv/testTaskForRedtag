async function fetchBooks() {
    const response = await fetch('/books');
    const books = await response.json();
    const booksList = document.getElementById('booksList');
    booksList.innerHTML = '';
    books.forEach(book => {
        const bookElement = document.createElement('div');
        bookElement.textContent = `${book.name} by ${book.author.firstName} ${book.author.lastName}`;
        booksList.appendChild(bookElement);
    });
}

async function fetchAuthors() {
    const response = await fetch('/authors');
    const authors = await response.json();
    const authorsList = document.getElementById('authorsList');
    authorsList.innerHTML = '';
    authors.forEach(author => {
        const authorElement = document.createElement('div');
        authorElement.textContent = `${author.firstName} ${author.lastName}`;
        authorsList.appendChild(authorElement);
    });
}
