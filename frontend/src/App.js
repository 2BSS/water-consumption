import React from 'react';
import { BrowserRouter, Routes, Route, Link } from 'react-router-dom';

import NewMeasurement from './NewMeasurement';
import Dashboard from './Dashboard';

function App() {
  return (
    <BrowserRouter>
      <div>
        <nav>
          <ul>
            <li><Link to="/new-measurement">New Entry</Link></li>
          </ul>
        </nav>
        <Routes>
          <Route path="/new-measurement" element={<NewMeasurement />} />
        </Routes>
        <Routes>
          <Route path="/dashboard" element={<Dashboard />} />
        </Routes>
      </div>
    </BrowserRouter>
  );
}

export default App;