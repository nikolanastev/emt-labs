import { Link } from "react-router-dom";

const Book = ({book}: {book: Book}) => {
    return (
        <div>
            <h2>{book.name}</h2>
            <p>Genre: {book.genre}</p>
            <p>
                Author: {book.author.name} {book.author.surname}
            </p>
            <p>Available Copies: {book.availableCopies}</p>
            <Link to={`/books/edit/${book.id}`}> Edit </Link>
            <Link to={`/books/delete/${book.id}`}> Delete </Link>
            <Link
                to={`/books/mark/${book.id}`}
                state={{ availableCopies: book.availableCopies }}
            > Mark </Link>
        </div>
    )
}

export default Book;