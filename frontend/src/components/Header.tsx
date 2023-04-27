import { Link } from "react-router-dom";

const Header = () => {
    return (
        <header>
            <div>Book Store</div>
            <ul>
                <li>
                    <Link to="/books">Books</Link>
                </li>
                <li>
                    <Link to="/categories">Categories</Link>
                </li>
                <li>
                    <Link to="/authors">Authors</Link>
                </li>
                <li>
                    <Link to="/books/add">Add Book</Link>
                </li>
            </ul>
        </header>
    )
}

export default Header;