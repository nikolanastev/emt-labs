const Genres = ({genres}: {genres: string[]}) => {
    return (
        <div>
            <h1>Genres</h1>
            <ul>
                {genres.map((genre) => {
                    return <li key={genre}>{genre}</li>
                })}
            </ul>
        </div>
    );
}

export default Genres;