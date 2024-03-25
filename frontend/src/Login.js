import React from 'react';

function App() {
  // Generate options for the dropdown list
  const apartmentOptions = [];
  for (let i = 1; i <= 25; i++) {
    const formattedNumber = i < 10 ? `0${i}` : `${i}`; // Add leading zero if number is single-digit
    apartmentOptions.push(<option key={i} value={`apartment${formattedNumber}`}>Apartment {formattedNumber}</option>);
  }

  return (
    <div className="App">
      <header className="App-header">
        <h2>Login</h2>
        <form>
          <div className="form-group">
            <label htmlFor="username">Username:</label>
            <select id="username" name="username">
              {apartmentOptions}
            </select>
          </div>
          <div className="form-group">
            <label htmlFor="password">Password:</label>
            <input type="password" id="password" name="password" required />
          </div>
          <div className="form-group">
            <button type="submit">Login</button>
          </div>
        </form>
      </header>
    </div>
  );
}

export default App;