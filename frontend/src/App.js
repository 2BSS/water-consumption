import React from 'react';
import { BrowserRouter, Routes, Route, Link } from 'react-router-dom';

import NewEntry from './NewEntry';
import Dashboard from './Dashboard';

function App() {
  return (
    <BrowserRouter>
      <div>
        <nav>
          <ul>
            <li><Link to="/new-entry">New Entry</Link></li>
          </ul>
        </nav>
        <Routes>
          <Route path="/new-entry" element={<NewEntry />} />
        </Routes>
        <Routes>
          <Route path="/dashboard" element={<Dashboard />} />
        </Routes>
      </div>
    </BrowserRouter>
  );
}

export default App;