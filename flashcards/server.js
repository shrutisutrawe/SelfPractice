const express = require('express');
const cookieParser = require('cookie-parser');

const app = express();
const PORT = 4000;

const flashcards = require('./questionBank');

const sessions = require('./sessions');
const users = require('./users');

app.use(cookieParser());
app.use(express.static('./build'));
app.use(express.json());

// Sessions
app.get('/api/session', (req, res) => {
  const sid = req.cookies.sid;
  const username = sid ? sessions.getSessionUser(sid) : '';
  const password = sid ? sessions.getSessionPassword(sid) : '';
  if(!sid || !username) {
    res.status(401).json({ error: 'authMissing' });
    return;
  }
  res.json({ username, password });
});

app.post('/api/session', (req, res) => {
  const  username  = req.body.username;
  const  password  = req.body.password;
  if(!username) {
    res.status(400).json({ error: 'requiredUsername' });
    return;
  }
  if(!password) {
    res.status(400).json({ error: 'requiredPassword' });
    return;
  }
  if(username.toLowerCase() === 'dog') {
    res.status(403).json({ error: 'authInsufficient' });
    return;
  }
  const sid = sessions.addSession(username, password);
  const existingUserData = users.getUserData(username);
  if(!existingUserData) {
    users.addUserData(username, flashcards.makeFlashcards());
  }
  res.cookie('sid', sid);
  res.json(users.getUserData(username).getUserFlashcards());
});

app.delete('/api/session', (req, res) => {
  const sid = req.cookies.sid;
  const username = sid ? sessions.getSessionUser(sid) : '';
  if(sid) {
    res.clearCookie('sid');
  }
  if(username) {
    // Delete the session, but not the user data
    sessions.deleteSession(sid);
  }
  res.json({ username });
});

app.get('/api/flashcards', (req, res) => {
  const sid = req.cookies.sid;
  const username = sid ? sessions.getSessionUser(sid) : '';
  if(!sid || !username) {
    res.status(401).json({ error: 'authMissing' });
    return;
  }
  res.json(users.getUserData(username).getUserFlashcards());
});

app.post('/api/flashcards', (req, res) => {
  const sid = req.cookies.sid;
  const username = sid ? sessions.getSessionUser(sid) : '';
  if(!sid || !username) {
    res.status(401).json({ error: 'authMissing' });
    return;
  }
  const question = req.body.question;
  const answer = req.body.answer;
  const category = req.body.category;

  if(!question) {
    res.status(400).json({ error: 'requiredQuestion' });
    return;
  }
  if(!answer) {
    res.status(400).json({ error: 'requiredAnswer' });
    return;
  }
  const userFlashcards = users.getUserData(username);
  const id = userFlashcards.addFlashcard(category,question,answer);
  res.json(userFlashcards.getFlashcard(id));
});

app.get('/api/flashcards/:id', (req, res) => {
  const sid = req.cookies.sid;
  const username = sid ? sessions.getSessionUser(sid) : '';
  if(!sid || !username) {
    res.status(401).json({ error: 'authMissing' });
    return;
  }
  const userFlashcards = users.getUserData(username);
  const { id } = req.params;
  if(!userFlashcards.contains(id)) {
    res.status(404).json({ error: `noSuchId`, message: `No todo with id ${id}` });
    return;
  }
  res.json(userFlashcards.getFlashcard(id));
});


app.patch('/api/flashcards/:id', (req, res) => {
  const sid = req.cookies.sid;
  const username = sid ? sessions.getSessionUser(sid) : '';
  if(!sid || !username) {
    res.status(401).json({ error: 'authMissing' });
    return;
  }
  const { id } = req.params;
  const { question, answer } = req.body;
  const userFlashcards = users.getUserData(username);
  if(!userFlashcards.contains(id)) {
    res.status(404).json({ error: `noSuchId`, message: `No todo with id ${id}` });
    return;
  }
  userFlashcards.updateFlashcard(id, { question, answer });
  res.json(userFlashcards.getFlashcard(id));
});

app.delete('/api/flashcards/:id', (req, res) => {
  const sid = req.cookies.sid;
  const username = sid ? sessions.getSessionUser(sid) : '';
  if(!sid || !username) {
    res.status(401).json({ error: 'auth-missing' });
    return;
  }
  const { id } = req.params;
  const userFlashcards = users.getUserData(username);
  const exists = userFlashcards.contains(id);
  if(exists) {
    userFlashcards.deleteFlashcard(id);
  }
  res.json({ message: exists ? `todo ${id} deleted` : `todo ${id} did not exist` });
});

app.listen(PORT, () => console.log(`http://localhost:${PORT}`));

