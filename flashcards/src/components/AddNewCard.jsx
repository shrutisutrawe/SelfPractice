import { useState } from 'react';


function AddNewCard ({addFlashcard,errorStatus, successStatus}) {

  const [newQuestion, setNewQuestion] = useState('');
  const [newAnswer, setNewAnswer] = useState('');
  const [newCategory, setNewCategory] = useState('');
  const [isAddDisabled, setIsAddDisabled] = useState(true);
  const [isQuestionDisabled, setIsQuestionDisabled] = useState(true);
  const [isAnswerDisabled, setIsAnswerDisabled] = useState(true);
  
  function handleCategoryChange(e){
      setNewCategory(e.target.value);
      if(newCategory){
        setIsQuestionDisabled(false);
      }else{
        setIsQuestionDisabled(false);
      }
  }

  function handleQuestionChange(e){
    setNewQuestion(e.target.value);
    if(newQuestion){
      setIsAnswerDisabled(false);
    }else{
      setIsAnswerDisabled(false);
    }
  }

  function handleAnswerChange(e){
    setNewAnswer(e.target.value);
    if(newAnswer){
      setIsAddDisabled(false);
    }else{
      setIsAddDisabled(false);
    }
  }

  function onClickAdd(e){
    if(!newCategory || !newQuestion || !newAnswer){
        return;
    }
    setNewQuestion('');
    setNewAnswer('');
    setNewCategory('');
    setIsAddDisabled(true);
    setIsAnswerDisabled(true);
    setIsQuestionDisabled(true);
    addFlashcard(newCategory,newQuestion,newAnswer);
  }

  
  return(
    <div className="new-card-container">
      <h3>
            Create a Flash Card
      </h3>
      {errorStatus && <div className="error-panel">{errorStatus}</div>}
      {successStatus && <div className="success-status-panel">Flashcard successfully created!</div>}
      <form className="new-card-form" onSubmit={(e) => e.preventDefault()}>
          <input
            type="text"
            value={newCategory}
            onChange={handleCategoryChange}
            name="category"
            className="form-control"
            placeholder="Enter Subject"
            required
          />
          <input
            type="text"
            value={newQuestion}
            onChange={handleQuestionChange}
            name="question"
            className="form-control"
            placeholder="Enter Question"
            disabled={isQuestionDisabled}
            required
          />
          <input
            type="text"
            value={newAnswer}
            onChange={handleAnswerChange}
            name="answer"
            className="form-control"
            placeholder="Enter Answer"
            disabled={isAnswerDisabled}
            required
          />
        <button type="submit" className="btn-save-card btn btn-success" disabled={isAddDisabled} onClick={onClickAdd}>
            Save
        </button>
      </form>
    </div>
  );
};

export default AddNewCard;