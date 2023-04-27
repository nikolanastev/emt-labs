const backendUrl = "http://localhost:8080";

export const getBooks = async (): Promise<Book[]> => {
    const url = `${backendUrl}/api/books/list`;
    return await (await fetch(url,{mode:"cors"})).json();
}

export const getCategories = async (): Promise<string[]> => {
    const url = `${backendUrl}/api/categories`;
    return await ( await fetch(url, {mode:"cors"})).json();
}

export const getAuthors = async (): Promise<Author[]> => {
    const url = `${backendUrl}/api/authors`;
    return await (await fetch(url, {mode:"cors"})).json();
}

export const getBooksPyPage = async (page: number): Promise<Book[]> => {
    const url = `${backendUrl}/api/books?page=${page}&size=5`;
    return await (await fetch(url, {mode:"cors"})).json();
}

export const getBookById = async (id: number): Promise<Book> => {
    const url = `${backendUrl}/api/books/${id}`;
    return await (await fetch(url)).json();
}

export const addBook = async (
    book: Omit<Partial<Book>, "author"> & {author: number}
    )  : Promise<Book> => {
    const url = `${backendUrl}/api/books/add`;
    console.log(JSON.stringify(book));
    return await (
        await fetch(url, {
            method: "POST",
            mode:"cors",
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify(book),
        })).json();
}

export const editBook = async (
    book: Omit<Book, "author"> & { author: number }
): Promise<Book> => {
    const url = `${backendUrl}/api/books/edit/${book.id}`;
    console.log(JSON.stringify(book));
    return await (
        await fetch(url, {
            method: "PUT",
            mode:"cors",
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify(book),
        })
    ).json();
}

export async function deleteBook(id: number): Promise<Book> {
    const url = `${backendUrl}/api/books/delete/${id}`;
    return await (
        await fetch(url, {
            method: "DELETE",
            mode:"cors",
        })
    ).json();
}

export async function markBook(id: number): Promise<Book> {
    const url = `${backendUrl}/api/books/mark/${id}`;
    return await (
        await fetch(url, {
            method: "PUT",
            mode:"cors",
        })
    ).json();
}
