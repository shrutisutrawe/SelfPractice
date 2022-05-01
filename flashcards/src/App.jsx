import './css/App.css';
import './css/newCardStyle.css';
import './css/homePageStyle.css';
import './css/practiceCardsStyle.css';
import './css/viewFlashcardsStyle.css';
import { fetchAddFlashcard, fetchDeleteFlashcard, fetchUpdateFlashcard, fetchFlashcard, fetchSession,fetchLogin, fetchLogout} from './services';
import { useState, useEffect } from 'react';
import Nav from './components/Nav';
import FlashCards  from './components/ViewAllFlashCards';
import AddNewCard from './components/AddNewCard';
import PracticeCards from './components/PracticeCards';
import HomePage from './components/HomePage';

function App() {

  const[page, setPage] = useState(document.location.hash || "#");
  const [isLoggedIn, setIsLoggedIn] = useState(false);
  const [username, setUsername] = useState('');
  const [password, setPassword] = useState('');
  const [errorStatus, setErrorStatus] = useState('');
  const [successStatus, setSuccessStatus] = useState(false);
  const [cardData, setCardData] = useState({});
  const [isPasswordDisabled, setIsPasswordDisabled] = useState(true);
  const [isLoginDisabled,setIsLoginDisabled] = useState(true);

  useEffect(() => {
    if(isLoggedIn){
      fetchSession()
        .then((userInfo) => {
          populateFlashcards()
        })
    }
  }, [isLoggedIn]);

  const displayErrorMessages = {
    networkError: 'Trouble connecting to the network.  Please try again',
    default: 'Something went wrong.  Please try again',
    authMissing: 'UnAuthorized! Please login again',
    authInsufficient: 'Invalid username. Please try some other',
    requiredUsername: 'Username required. Please enter username.',
    requiredPassword: 'Password required. Please enter username and password again.',
  };

  function checkSession(){
    fetchSession()
    .then((userInfo) => {
      populateFlashcards();
      setErrorStatus('');
    })
    .catch( error => {
      renderStatus(error);
      setUsername('');
      setPassword('');
    });
  }
  function populateFlashcards() {
    fetchFlashcard()
    .then( flashcards => {
      setCardData(flashcards);
      setErrorStatus('');
    })
    .catch( error => {
      renderStatus(error);
    });
  }

const onUsernameChange = (e) => {
    setUsername(e.target.value);
};

const onPasswordChange = (e) => {
  setPassword(e.target.value);

}
function renderOnLogin(flashcards){
  setCardData(flashcards);
  setIsLoggedIn(true);
  setErrorStatus('');
}
function onLogin() {
    fetchLogin({username,password})
        .then(userinfo => {
            renderOnLogin(userinfo);
            
        })
        .catch(err => {
            renderStatus(err);
        });
};

const onLogout = () => {
    fetchLogout()
    .then(()=> {
      setIsLoggedIn(false)
      setUsername('');
      setPassword('');
      setErrorStatus('');
    })
    .catch(error => {
      renderStatus(error);
      setIsLoggedIn(false);
    })
};

function renderStatus(message) {
  if( !message ) {
    setErrorStatus('');
    return;
  }
  const key = message?.error ? message.error : 'default';
  const msg = displayErrorMessages[key] || displayErrorMessages.default;
  setErrorStatus(msg);
  setIsLoggedIn(false);
  setPage('#');
}

function addFlashcard(category, question, answer) {

  fetchAddFlashcard(category.toLowerCase(), question,answer)
  .then(flashcard => {
    populateFlashcards();
    setErrorStatus('');
    setSuccessStatus(true);
  })
  .catch(error => {
    renderStatus(error);
    setUsername('');
    setPassword('');
  })
};


function updateCard (index,question,answer) {
  const tempData = {question,answer};
  fetchUpdateFlashcard(index, tempData)
  .then( flashcard => {
    populateFlashcards();
    setErrorStatus('');
  })
  .catch(error => {
    renderStatus(error);
    setUsername('');
    setPassword('');
  })

};

function removeCard(index){
  fetchDeleteFlashcard(index)
  .then( populateFlashcards())
  .catch(error => {
    renderStatus(error);
    setUsername('');
    setPassword('');
  })

};


  return(
    <div className="flashcards-app">
          <Nav page={page} setPage={setPage} onLogout={onLogout} isLoggedIn={isLoggedIn} onUsernameChange={onUsernameChange} onPasswordChange={onPasswordChange} onLogin={onLogin} errorStatus={errorStatus} setSuccessStatus={setSuccessStatus}/>
          { page === '#Home' && <HomePage username={username}/> }
          { page === '#Cards' && <FlashCards cardData={cardData} updateCard={updateCard} removeCard={removeCard} errorStatus={errorStatus} checkSession={checkSession}/> }
          { page === '#New' && <AddNewCard addFlashcard={addFlashcard} errorStatus={errorStatus} successStatus={successStatus}/> }
          { page === '#Practice' && <PracticeCards cardData={cardData} errorStatus={errorStatus} checkSession={checkSession}/> }
      </div>
  );
}

export default App;