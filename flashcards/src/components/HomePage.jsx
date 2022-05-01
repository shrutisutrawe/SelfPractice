function HomePage({username}){

    return(
        <div className="home-page-content">
            <h2>Welcome {username} ! </h2>
            <ul>
                Get ready to have your own simple learning tool - Flashcards!<br/> Here you can
                <li><span>&#10133;</span> Create your own flashcards under "New" option</li>
                <li><span>&#128451;</span> Access all your flashcards under "Cards" option</li>
                <li><span>&#128450;</span> Practice and test your knowledge every now and then under "Practice" option</li>
            </ul>
            <h3>Let's get started !!!!</h3>
        </div>
    );
};
export default HomePage;