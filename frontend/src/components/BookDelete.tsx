import { useNavigate, useParams } from "react-router-dom";
import { deleteBook } from "../api";

const BookDelete = ({updateState,}: {updateState: (book:number) => void}) => {
    const navigate = useNavigate();
    const book = Number(useParams()["book"]);

    const handleClick = () => {
        deleteBook(book).then(() => {
            updateState(book);
            navigate("/");
        });
    }

    return (
        <div>
            <h1>Delete Book</h1>
            <button type="button" onClick={handleClick}>
                Delete
            </button>
        </div>
    )
}

export default BookDelete;