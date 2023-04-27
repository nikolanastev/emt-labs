import { useEffect, useState } from "react";
import { useNavigate, useParams } from "react-router-dom";
import {addBook, editBook, getBooks} from "../api";


const BookForm = ({
    genres,
    authors,
    editBookFn
}: {
    genres: string[];
    authors: Author[];
    editBookFn: (book: Book) => void;
}) => {
    const bookId = useParams()["book"];
    const [books, setBooks] = useState<Book[]>();
    const book = books?.find((book) => book.id === Number(bookId));
    const navigate = useNavigate();
    const [name, setName] = useState(book?.name ?? "Unnamed Book");
    const [genre, setCategory] = useState(book?.genre ?? genres[0]);
    const [author, setAuthor] = useState(book?.author.id ?? authors[0].id);
    const [availableCopies, setAvailableCopies] = useState(book?.availableCopies ?? 0);

    const [error, setError] = useState("");

    useEffect(() => {
        getBooks().then((books) => setBooks(books));
    }, []);

    useEffect(() => {
        if (book === undefined) {
            setName("Unnamed Book");
            setCategory(genres[0]);
            setAuthor(authors[0]?.id);
            setAvailableCopies(0);
        } else {
            setName(book.name);
            setCategory(book.genre);
            setAuthor(book.author.id);
            setAvailableCopies(book.availableCopies);
        }
    }, [book]);

    const handleClick = () => {
        if (name === "") {
            setError("Please set a name!")
            return;
        }

        if (availableCopies < 0) {
            setError("Available copies must be a positive number!");
            return
        }

        if (book !== undefined) {
            editBook({id: book.id, name,genre, author, availableCopies}).then(
                () => {
                    editBookFn({
                        id: book.id,
                        name,
                        genre,
                        author: authors.find((a) => a.id === author) as Author,
                        availableCopies,
                    });
                    navigate("/");
                }
            );
        } else {
            addBook({name, genre, author, availableCopies}).then(() => {
                navigate('/');
            });
        }
    }
    return (
        <>
            <form>
                <label htmlFor="name"> Name: </label>
                <input
                    type="text"
                    id="name"
                    value={name}
                    onChange={(e) => setName(e.target.value)}
                />
                <label htmlFor="genre"> Genre: </label>
                <select
                    title="genre"
                    value={genre}
                    onChange={(e) => setCategory(e.target.value)}
                >
                    {genres.map((genre) => (
                        <option key={genre} value={genre}>
                            {genre}
                        </option>
                    ))}
                </select>
                <label htmlFor="author"> Author: </label>
                <select
                    title="author"
                    value={author}
                    onChange={(e) => setAuthor(Number(e.target.value))}
                    >
                    {authors.map((author) => {
                        return <option key={author.id} value={author.id}>
                            {`${author.name} ${author.surname}`}
                        </option>
                    })}
                </select>
                <label htmlFor="availableCopie"> Available Copies: </label>
                <input
                    type="number"
                    id="availableCopies"
                    value={availableCopies}
                    onChange={(e) => setAvailableCopies(Number(e.target.value))}
                />
                <button type="button" onClick={handleClick}>
                    Submit
                </button>
            </form>
            {error !== "" && <p>{error}</p>}
        </>
    )
}

export default BookForm;