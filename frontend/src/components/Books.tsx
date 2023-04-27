import { useEffect, useState } from "react";
import { getBooks, getBooksPyPage } from "../api";
import Book from "./Book";

const Books = () => {
    const [books, setBooks] = useState<Book[]>();
    const [page, setPage] = useState(0);
    const [pages, setPages] = useState(0);

    useEffect(() => {
        getBooksPyPage(page).then((books) => {
            if (books.length !== 0) {
                setBooks(books);
            }
        });
    }, [page]);

    useEffect(() => {
        getBooks().then((books) => {
          if (books.length !== 0)
              setPages(Math.ceil(books.length / 5));
        });
    }, []);

    const handlePrevious = () => {
        if (page > 0)
            setPage(page - 1);
    }
    const handleNext = () => {
        if (page < pages - 1){
            setPage(page + 1);
        }
    }

    return (
        <div>
            <h1>Books</h1>
            <ul>
                {books?.map((book) => {
                    return <li key={book.id}>
                        <Book book={book}/>
                    </li>
                })}
            </ul>
            <button type="button" onClick={handlePrevious}>Back</button>
            <span>{page + 1} / {pages}</span>
            <button type="button" onClick={handleNext}>Next</button>
        </div>
    )
}

export default Books;