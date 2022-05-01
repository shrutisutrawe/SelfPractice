import FlashCard from './ViewFlashCard';
import {useState} from 'react';

function FlashCards ({ cardData, updateCard, removeCard, errorStatus, checkSession}) {

  let cardDataLength = Object.keys(cardData).length;

  let categoriesList = ["select subject"];
  const [selectedOption, setSelectedOption] = useState('');

  const handleChange = (e) => {
    checkSession();
    setSelectedOption(e.target.value);
  }
  function addNewCategory(newCategory){
      if(!categoriesList.includes(newCategory)){
        categoriesList.push(newCategory);
      }
  }

  return (
    <div>
    { !cardDataLength && <div className='empty-flashcards'>
        <h4>You have no flash cards!<br/>Create a "New" one.</h4>
      </div>}
    {cardDataLength > 0 && <div className="card-container">
      <h2>All the Flashcards</h2>
      {errorStatus && <div className="error-panel">{errorStatus}</div>}
      { Object.entries(cardData).map(([key,value]) => (
          addNewCategory(value.category.toLowerCase())        
      )
      )}
      <select value={selectedOption} onChange={handleChange} >
          {categoriesList.map((category) => (
          <option value={category} >{category}</option>
          ))}
      </select>
      {selectedOption && selectedOption !== "select" && 
      Object.values(cardData).map(flashcard => (
        (flashcard.category === selectedOption && 
        <FlashCard
          index={flashcard.id}
          updateCard={updateCard}
          key={flashcard.id}
          removeCard={removeCard}
          question={flashcard.question}
          answer={flashcard.answer}
         />)
      ))
      }
    </div>}

    </div>
  );
}

export default FlashCards;