import { Suspense, useEffect, useState } from "react";
import { Route, Routes } from "react-router-dom";
import { getAuthors, getBooks, getCategories } from "../api";
import Authors from "./Authors";
import BookDelete from "./BookDelete";
import BookMark from "./BookMark";
import BookForm from "./BookForm";
import Header from "./Header";
import Books from "./Books";
import Genres from "./Genres";

const App = () => {

    const [books, setBooks] = useState<Book[]>([]);
    const [genres, setCategories] = useState<string[]>([]);
    const [authors, setAuthors] = useState<Author[]>([]);

    useEffect(() => {
        getBooks().then((books) => setBooks(books));
        getCategories().then((categories) => setCategories(categories));
        getAuthors().then((authors) => setAuthors(authors));
    }, []);

    const deleteBook = (id: number) => {
        setBooks(books.filter((book) => book.id !== id))
    }

    const editBook = (book: Book) => {
        setBooks(books.map((b) => (b.id === book.id ? book: b)));
    }

    return (
        <>
            <Header />
            <Suspense fallback={<div>Loading...</div>}>
                <Routes>
                    <Route path="/" element={<Books/>} />
                    <Route path="/books" element={<Books/>} />
                    <Route path="/categories" element={<Genres genres={genres} />} />
                    <Route path="/authors" element={<Authors authors={authors}/>} />
                    <Route
                        path="/books/add"
                        element={
                            <BookForm
                                genres={genres}
                                authors={authors}
                                editBookFn={editBook}
                            />
                        }
                    />
                    <Route
                        path="/books/edit/:book"
                        element={
                            <BookForm
                                genres={genres}
                                authors={authors}
                                editBookFn={editBook}
                                />
                        }
                    />
                    <Route
                        path="/books/delete/:book"
                        element={<BookDelete updateState={deleteBook} />} />
                    <Route path="/books/mark/:book" element={<BookMark/>} />
                </Routes>
            </Suspense>
        </>
    )
}
export default App;