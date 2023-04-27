const Authors = ({authors}: {authors: Author[]}) => {
    return (
        <div>
            <h1>Authors</h1>
            <ul>
                {authors.map((author) => {
                    return <li key={author.id}>
                        {`${author.name} ${author.surname} (${author.id})`}
                    </li>
                })}
            </ul>
        </div>
    );
}

export default Authors;