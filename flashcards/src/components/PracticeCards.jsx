import {  useState } from 'react';

 function PracticeCards ({cardData, errorStatus, checkSession}){

  const [showAnswer, setShowAnswer] = useState(false);
  const[activeIndex,setActiveIndex] = useState(0);
  const [selectedOption, setSelectedOption] = useState('');
  let categoriesList = ["select subject"];
  let categoryBasedCards = {};
  let lastIndex = 0;
  
  
  Object.values(cardData).map(cards =>{
    categoryBasedCards[cards.category] = categoryBasedCards[cards.category] || []
    categoryBasedCards[cards.category].push({id:categoryBasedCards[cards.category].length, question:cards.question, answer:cards.answer})
    // lastIndex = categoryBasedCards[cards.category].length
    
  });

  
  
  const nextCard = () =>{
      checkSession();
      lastIndex = categoryBasedCards[selectedOption].length; 
      setActiveIndex(activeIndex === lastIndex - 1 ? 0 : activeIndex + 1);
      setShowAnswer(false);
  };
  const prevCard = () =>{
      checkSession();
      lastIndex = categoryBasedCards[selectedOption].length;
      setActiveIndex(activeIndex === 0 ? lastIndex - 1 : activeIndex - 1);
      setShowAnswer(false);
  };
  
  let cardDataLength = Object.keys(cardData).length;
  const cardFlip = () =>{
    checkSession();
    setShowAnswer(!showAnswer);
  }

  const handleChange = (e) => {
    checkSession();
    setSelectedOption(e.target.value);
    setShowAnswer(false);
  }
  function addNewCategory(newCategory){
      if(!categoriesList.includes(newCategory)){
        categoriesList.push(newCategory);
      }
  }

  return(
    <div className='practice-card-page'>
      { !cardDataLength && <div className='empty-flashcards'>
        <h4>You have no flash cards!<br/>Create a "New" one.</h4>
      </div>}
      { cardDataLength > 0 && 
      <div className = "practice-card-container">
        <h2>Let's Practice!</h2>
        { Object.values(cardData).map(card => (
            addNewCategory(card.category.toLowerCase())        
          )
        )}
        <select onChange={handleChange} >
          {categoriesList.map((category) => (
          <option value={category} >{category}</option>
          ))}
        </select>
        {selectedOption && selectedOption !== "select subject" && 
        <div className = "practice-card-content">
          <button className="prev-card" onClick={prevCard}>
          &#9111;
          </button>
          <div className="practice-flashcard">
            {Object.values(categoryBasedCards[selectedOption]).map(card => {
              return (<div className={card.id === activeIndex ? 'slide active' : 'slide'}  key=
                    {card.id}>
                        {card.id === activeIndex && (
                        <div className="flip-card">
                          { !showAnswer && <div className="card-question">
                              <h4>{card.question}</h4>
                              <button onClick={cardFlip}>Show Answer</button>
                            </div>
                          }

                          {showAnswer && <div className="card-answer">
                              <h4>{card.answer}</h4>
                              <button onClick={cardFlip}>Back To Question</button>
                            </div>
                          }
                        </div>
                      )}
                      
                </div>
              );
          })}
          </div>
          <button className="next-card" onClick={nextCard}>
          &#9112;
          </button>      
          </div>
        }
      </div>}
      </div>
  );
    
  };

export default PracticeCards;