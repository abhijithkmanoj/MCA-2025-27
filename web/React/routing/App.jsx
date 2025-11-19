import React from 'react';
import { BrowserRouter, Link, Route, Routes } from "react-router-dom";
import Home from './Home';
import Profile from './Profile';
import Contact from './Contact';
import About from './About';

function App() {
  return (
    <BrowserRouter>
      <nav>
        <Link to="/">|      Home      |</Link>
        <Link to="/profile">     Profile      |</Link>
        <Link to="/contact">     Contact      |</Link>
        <Link to="/about">     About      |</Link>
      </nav>

      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/profile" element={<Profile />} />
        <Route path="/contact" element={<Contact />} />
        <Route path="/about" element={<About />} />
      </Routes>
    </BrowserRouter>
  );
}

export default App;
